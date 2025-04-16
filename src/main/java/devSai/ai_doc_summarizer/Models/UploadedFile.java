package devSai.ai_doc_summarizer.Models;

import devSai.ai_doc_summarizer.Models.Enums.FileType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
public class UploadedFile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String fileName;
    private Long fileSize;
    @Enumerated(EnumType.STRING)
    private FileType fileType;
    private String s3Key;
    @OneToOne
    private User uploadedBy;
    private Date uploadedAt;
}
