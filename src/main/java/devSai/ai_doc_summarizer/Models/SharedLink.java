package devSai.ai_doc_summarizer.Models;

import jakarta.persistence.*;
import devSai.ai_doc_summarizer.Models.Enums.Platform;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
public class SharedLink {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Platform platform;
    @OneToOne
    private Summary summary;
    private LocalDateTime sharedAt;
    private LocalDateTime expiryAt;

}
