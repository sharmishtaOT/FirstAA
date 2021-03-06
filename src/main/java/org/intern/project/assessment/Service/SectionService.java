package org.intern.project.assessment.Service;

import org.intern.project.assessment.Repository.SectionQuestionRepository;
import org.intern.project.assessment.Repository.SectionRepository;
import org.intern.project.assessment.Repository.TemplateRepository;
import org.intern.project.assessment.Repository.TemplateSectionRepository;
import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.TemplateEntity;
import org.intern.project.assessment.Service.QuestionService;
import org.intern.project.assessment.domain.SectionQuestionPK;
import org.intern.project.assessment.domain.TemplateSection;
import org.intern.project.assessment.domain.TemplateSectionPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SectionService {

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private SectionQuestionRepository sectionQuestionRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TemplateSectionRepository templateSectionRepository;

    private List<SectionEntity> list = new ArrayList<>();


    public SectionEntity post(SectionEntity sectionEntity, BigDecimal templateId){
        Optional<TemplateEntity> templateEntity = templateRepository.findById(templateId);
//        templateEntity.addSection(sectionEntity);
        return sectionRepository.save(sectionEntity);
    }


    public List<SectionEntity> getAllSections(){
            return sectionRepository.findAll();
    }

    public Optional<SectionEntity> getSectionById(BigDecimal templateId, BigDecimal sectionId){
        return sectionRepository.findById(sectionId);
    }


    public SectionEntity addSection(SectionEntity sectionEntity){
        sectionRepository.save(sectionEntity);
        return sectionEntity;
    }


    public void deleteSectionsByTemplateId(BigDecimal sectionId){
//        TemplateSection templateSection;

        List<BigDecimal> questionIds = sectionQuestionRepository.findQuestionIdsBySectionId(sectionId);
        for (BigDecimal questionId : questionIds)
            sectionQuestionRepository.deleteById(new SectionQuestionPK(sectionId, questionId));
        for (BigDecimal questionId : questionIds)
            questionService.deleteById(questionId);
        sectionRepository.deleteById(sectionId);
        return;
    }

    public void deleteSectionById(BigDecimal templateId, BigDecimal sectionId){

        List<BigDecimal> sectionIds = templateSectionRepository.findSectionIdsByTemplateIds(templateId);
        for (BigDecimal sectionsId : sectionIds)
            templateSectionRepository.deleteById(new TemplateSectionPK(templateId, sectionsId));

        List<BigDecimal> questionIds = sectionQuestionRepository.findQuestionIdsBySectionId(sectionId);
        for (BigDecimal questionId : questionIds)
            sectionQuestionRepository.deleteById(new SectionQuestionPK(sectionId, questionId));
        for (BigDecimal questionId : questionIds)
            questionService.deleteById(questionId);
        sectionRepository.deleteById(sectionId);
    }

    public SectionEntity getAllSectionsById(BigDecimal sectionEntityId){
        return sectionRepository.findById(sectionEntityId).get();
    }
}