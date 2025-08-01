package devSai.ai_doc_summarizer.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummarizationResponse {
    private UUID id;
    private String model;
    private long created;
    private List<String> citations;
    @JsonProperty("usage")
    private UsageDTO usageDTO;
    @JsonProperty("choices")
    private List<ChoiceDTO> choiceDTOs;
    @JsonProperty("search_results")
    private List<SearchResultDTO> searchResultDTOs;
    private String content;

}
