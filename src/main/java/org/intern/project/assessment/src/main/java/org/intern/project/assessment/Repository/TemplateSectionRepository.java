package org.intern.project.assessment.Repository;

import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.domain.TemplateSection;
import org.intern.project.assessment.domain.TemplateSectionPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface TemplateSectionRepository extends JpaRepository<TemplateSection, TemplateSectionPK> {

//    public default List<TemplateSection> findByTemplateIdOrderBySequence(@Param("templateId") BigDecimal templateId){
//        return null;
//    };

//   public Optional<TemplateSection> findById(@Param("templateId") BigDecimal templateId);

//    public TemplateSection findByTemplateId(BigDecimal templateId);

//    List<TemplateSection> findByTemplateIdOrderBySequence(@Param("templateId") BigDecimal templateId);

//    void deleteBySectionId(BigDecimal sectionId);

    @Transactional
    @Query(value = "SELECT * FROM template_Section WHERE template_id= :id ",
    nativeQuery = true) // + "ORDER BY ts.sequence")
    List<TemplateSection> findAllByTemplateId (@Param("id") BigDecimal templateId);

    @Transactional
    @Query(value = "SELECT section_id from template_section where template_id= :id",
    nativeQuery = true)
    List<BigDecimal> findSectionIdsByTemplateIds (@Param("id") BigDecimal templateId);
}