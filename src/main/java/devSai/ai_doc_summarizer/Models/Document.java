package devSai.ai_doc_summarizer.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Entity(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne
    private UploadedFile uploadedFile;
    @OneToOne
    private Summary summary;
//    @OneToMany
//    private List<QuestionAndAnswer> questionsAndAnswers;
    private Date processAt;
}
