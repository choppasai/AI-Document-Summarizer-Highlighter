package devSai.ai_doc_summarizer.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class SummarizationRequest {
    private String text;
    private String stream;
    private String model;
    private ArrayList<MessageDTO> message;
}

