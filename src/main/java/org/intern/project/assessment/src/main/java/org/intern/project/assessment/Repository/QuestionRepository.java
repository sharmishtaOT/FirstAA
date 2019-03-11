package org.intern.project.assessment.Repository;
import java.math.*;
import org.intern.project.assessment.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface QuestionRepository extends JpaRepository<QuestionEntity, BigDecimal> {
}
