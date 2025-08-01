package devSai.ai_doc_summarizer.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChoiceDTO {
    private int index;
    @JsonProperty("finish_reason")
    private String finishReason;
    @JsonProperty("message")
    private MessageDTO messageDTO;
}
