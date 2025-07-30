package devSai.ai_doc_summarizer.Models;

import devSai.ai_doc_summarizer.Repositories.SummaryRepo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int index;
    private String finish_reason;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    private MessageContent message;
    @ManyToOne
    @JoinColumn(name = "summary_id")
    private Summary summary;

}
