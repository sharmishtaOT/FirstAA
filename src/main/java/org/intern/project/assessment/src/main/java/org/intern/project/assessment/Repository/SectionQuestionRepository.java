package org.intern.project.assessment.Repository;

import org.intern.project.assessment.domain.SectionQuestion;
import org.intern.project.assessment.domain.SectionQuestionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

public interface SectionQuestionRepository extends JpaRepository<SectionQuestion, SectionQuestionPK> {

    @Transactional
    @Query(value = "SELECT * from section_question where section_id= :id" ,nativeQuery = true)
    List<SectionQuestion> findAllBySectionId(@Param("id") BigDecimal sectionId);



    @Transactional
    @Query(value = "SELECT question_id from section_question where section_id = :id", nativeQuery = true)
    List<BigDecimal> findQuestionIdsBySectionId(@Param("id") BigDecimal questionId);
}
