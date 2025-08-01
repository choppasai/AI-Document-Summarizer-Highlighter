package devSai.ai_doc_summarizer.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class MessageContent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String role;
    @Lob
    private String content;
}
