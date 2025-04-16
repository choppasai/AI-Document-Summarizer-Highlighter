package devSai.ai_doc_summarizer.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;
    @OneToOne
    private Document document;
    private LocalDateTime viewedAt;
    private boolean pinned;
}
