package devSai.ai_doc_summarizer.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Assistance")
public class UploadFile {
    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file")MultipartFile file){

    }
}
