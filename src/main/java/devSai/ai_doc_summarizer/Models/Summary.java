package devSai.ai_doc_summarizer.Models;

import devSai.ai_doc_summarizer.Models.Enums.SummaryLength;
import devSai.ai_doc_summarizer.Models.Enums.SummaryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private long created;
    @Column(length = 5000)
    private String model;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
    private List<Choice> choices;
    @Lob
    private String content;
    @Enumerated(EnumType.STRING)
    private SummaryLength summaryLength;
    @Enumerated(EnumType.STRING)
    private SummaryType summaryType;
    @OneToMany
    @JoinColumn(name = "result_id")
    private List<SearchResult> searchResults;
    @ElementCollection
    private List<String> citations;

}
