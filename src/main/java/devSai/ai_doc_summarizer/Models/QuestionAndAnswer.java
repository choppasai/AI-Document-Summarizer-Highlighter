package devSai.ai_doc_summarizer.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Entity
public class QuestionAndAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String question;
    @ElementCollection
    private List<String> answers;
}
