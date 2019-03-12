package org.intern.project.assessment.Repository;

import org.intern.project.assessment.domain.SectionQuestion;
import org.intern.project.assessment.domain.SectionQuestionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface SectionQuestionRepository extends JpaRepository<SectionQuestion, SectionQuestionPK> {

    @Transactional
    @Query(value = "SELECT * from section_question where section_id= :id" ,nativeQuery = true)
    List<SectionQuestion> findAllBySectionId(@Param("id") BigDecimal id);



    @Transactional
    @Query(value = "SELECT question_id from section_question where section_id = :id", nativeQuery = true)
    List<BigDecimal> findQuestionIdsBySectionId(@Param("id") BigDecimal id);


    @Transactional
    @Query(value = "SELECT section_id from section_question where question_id= :id", nativeQuery = true)
    Optional<BigDecimal> findSectionIdByQuestionId(@Param("id") BigDecimal id);
}
