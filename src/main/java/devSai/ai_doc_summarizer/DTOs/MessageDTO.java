package devSai.ai_doc_summarizer.DTOs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageDTO {
    private String role;
    private String content;
}
