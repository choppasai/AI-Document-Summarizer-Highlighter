package devSai.ai_doc_summarizer.DocumentExtractor;

import java.io.InputStream;

public interface DocumentExtractor {
    public String extract(InputStream inputStream);
}
