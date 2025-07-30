package devSai.ai_doc_summarizer.Security;

import com.fasterxml.jackson.databind.JsonNode;

import io.netty.channel.ChannelOption;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;

@Service
public class OpenAIService {

    @Value("${apyhub.api.token}")
    private String apiKey;
    @Value(("${apyhub.api.url}"))
    private String apiUrl;

    private WebClient webClient;
    private static final Logger logger = LoggerFactory.getLogger(OpenAIService.class);

    @PostConstruct
    public void creation(){
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10000)
                .responseTimeout(Duration.ofSeconds(120));
        webClient = WebClient.builder()
                .baseUrl(apiUrl)
                .defaultHeader("apy-token", apiKey)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    public String uploadFileToApyHub(MultipartFile multipartFile) throws IOException {
        logger.info("Received file: {}", multipartFile.getOriginalFilename());

        File file = convertToFile(multipartFile);
        logger.debug("Converted MultipartFile to temp file: {}", file.getAbsolutePath());

        FileSystemResource fileResource = new FileSystemResource(file);

        logger.info("Sending file to ApyHub API...");

        try {
            String result = webClient.post()
                    .uri("/ai/summarize-documents/file")
                    .contentType(MediaType.MULTIPART_FORM_DATA)
                    .body(BodyInserters.fromMultipartData("file", fileResource))
                    .retrieve()
                    .bodyToMono(String.class)
                    .doOnSubscribe(sub -> logger.debug("Request sent. Awaiting response..."))
                    .doOnSuccess(res -> logger.info("Response received from ApyHub."))
                    .doOnError(err -> logger.error("Error from ApyHub: {}", err.getMessage()))
                    .block();

            logger.debug("Raw response: {}", result);

            return result;
        } catch (Exception ex) {
            logger.error("Exception while calling ApyHub API: {}", ex.getMessage(), ex);
            throw ex;
        } finally {
            boolean deleted = file.delete();
            logger.debug("Temp file deleted: {}", deleted);
        }
    }


    private File convertToFile(MultipartFile multipartFile) throws IOException {
        File convFile = File.createTempFile("upload-", multipartFile.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convFile)) {
            fos.write(multipartFile.getBytes());
        }
        return convFile;
    }



//    public String summarizeDocument(MultipartFile file) throws IOException {
//        byte[] fileBytes = file.getBytes();
//        String base64File = Base64.getEncoder().encodeToString(fileBytes);
//
//        Map<String, Object> requestBody = Map.of(
//                "content", base64File,
//                "output", "short" // Options: short, medium, long
//        );
//        Mono<String> response = webClient.post()
//                .uri("/ai/summarize-documents/file")
//                .contentType(MediaType.MULTIPART_FORM_DATA)
//                .body(BodyInserters.fromMultipartData("file", new FileSystemResource(String.valueOf(file))))
//                .retrieve()
//                .bodyToMono(String.class);
//
//        response.subscribe(System.out::println, System.err::println);
//
//        return response.block();
//    }


//    private WebClient webClient;

//    HttpClient client = HttpClient.newHttpClient();
//    @PostConstruct
//    private void initWebClient() {
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(apiUrl))
//                .POST(HttpRequest.BodyPublishers.noBody())
//                .setHeader("Content-Type", "multipart/form-data")
//                .setHeader("apy-token", apiKey)
//                .build();
////        this.webClient = WebClient.builder()
////                .baseUrl(apiUrl)
////                .defaultHeader(HttpHeaders.AUTHORIZATION,  apiKey)
////                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
////                .filter(logRequest())
////                .build();
////
////
////        System.out.println("Initialized WebClient with API key: " + apiKey);
//    }
//
//
//
//    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//    private ExchangeFilterFunction logRequest() {
//        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
//            System.out.println("Request Headers: " + clientRequest.headers());
//            return Mono.just(clientRequest);
//        });
//    }
//
//
//    public Mono<String> getSummary(String input) {
//
//        Map<String, String> request = Map.of("inputs", input);
//
//        return webClient.post()
//                .bodyValue(request)
//                .retrieve()
//                .bodyToMono(String.class);
//    }
}
