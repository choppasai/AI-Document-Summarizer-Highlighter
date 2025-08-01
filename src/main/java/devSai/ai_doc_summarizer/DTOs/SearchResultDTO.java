package devSai.ai_doc_summarizer.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SearchResultDTO {

    private String title;
    private String url;
    private String date;
    @JsonProperty("last_updated")
    private String lastUpdated;
}
