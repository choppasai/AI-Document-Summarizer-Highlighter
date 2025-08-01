package devSai.ai_doc_summarizer.DocumentExtractor;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import java.io.InputStream;
@Component
public class DocumentExtractorFactory {
    public DocumentExtractor getDocumentExtractor(String fileName) {
        String fileExtension = fileName.toLowerCase();
        if(fileExtension.endsWith(".pdf")) {
            return new PDFExtractor();
        }
        else if(fileExtension.endsWith(".doc") || fileExtension.endsWith(".docx")) {
            return new DocExtractor();
        }
        else throw new IllegalArgumentException("Unsupported file type: " + fileExtension);

    }
}
