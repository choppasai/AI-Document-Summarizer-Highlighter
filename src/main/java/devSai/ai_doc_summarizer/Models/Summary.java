package devSai.ai_doc_summarizer.Models;

import devSai.ai_doc_summarizer.Models.Enums.SummaryLength;
import devSai.ai_doc_summarizer.Models.Enums.SummaryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String content;
    @Enumerated(EnumType.STRING)
    private SummaryLength summaryLength;
    @Enumerated(EnumType.STRING)
    private SummaryType summaryType;

}
