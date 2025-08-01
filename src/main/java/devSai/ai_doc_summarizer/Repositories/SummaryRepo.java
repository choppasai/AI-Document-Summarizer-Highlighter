package devSai.ai_doc_summarizer.Repositories;

import devSai.ai_doc_summarizer.Models.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SummaryRepo extends JpaRepository<Summary, UUID> {
}
