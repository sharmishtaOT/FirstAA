package org.intern.project.assessment.Service;

import org.intern.project.assessment.QuestionEntity;
import org.intern.project.assessment.Repository.SectionQuestionRepository;
import org.intern.project.assessment.Repository.TemplateRepository;
import org.intern.project.assessment.Repository.TemplateSectionRepository;
import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.TemplateEntity;
import org.intern.project.assessment.domain.SectionQuestion;
import org.intern.project.assessment.domain.TemplateSection;
import org.intern.project.assessment.domain.TemplateSectionPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.intern.project.assessment.dto.Request.WelcomeTextUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@EnableTransactionManagement

@Service
public class TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private TemplateSectionRepository templateSectionRepository;

    @Autowired
    private SectionService sectionService;
    @Autowired
    private SectionQuestionRepository sectionQuestionRepository;

    public boolean post(TemplateEntity templateEntity){
        templateRepository.save(templateEntity);
        return true;
    }

    public List<TemplateEntity> getAllTemplates(){
        return templateRepository.findAll();
    }

    public Optional<TemplateEntity> getTemplateById(BigDecimal id){
        return templateRepository.findById(id);
    }

    public void deleteTemplateById(BigDecimal templateId){
        List<BigDecimal> sectionIds = templateSectionRepository.findSectionIdsByTemplateIds(templateId);


        for (BigDecimal sectionId : sectionIds)
            templateSectionRepository.deleteById(new TemplateSectionPK(templateId, sectionId));

        for (BigDecimal sectionId : sectionIds)
            sectionService.deleteSectionById(sectionId);

        templateRepository.deleteById(templateId);
        return;
    }

    public void updateTemplateWelcomeText(BigDecimal templateId, WelcomeTextUpdateRequest welcomeUpdateRequest){
        Optional<TemplateEntity> templateEntityRepo = templateRepository.findById(templateId);
        TemplateEntity templateEntity = templateEntityRepo.get();
        templateEntity.setWelcomeText(welcomeUpdateRequest.getWelcomeText());
        templateRepository.save(templateEntity);
    }


    public SectionEntity addSectionToTemplateId(TemplateEntity templateEntity, SectionEntity sectionEntity, BigDecimal templateId){
        TemplateSection templateSection;
        List<TemplateSection> templateSections = templateSectionRepository.findAllByTemplateId(templateId);

        //        Integer sequence = (Integer) templateSections.size();

        templateSection = new TemplateSection(templateEntity, sectionEntity, 1);
//        templateSections.add(templateSection);
//        templateSectionRepository.saveAll(templateSections);

        templateSectionRepository.save(templateSection);
        return sectionEntity;
    }


    public QuestionEntity addQuestionToSectionId(SectionEntity sectionEntity, QuestionEntity questionEntity, BigDecimal sectionId){

        SectionQuestion sectionQuestion;

        List<SectionQuestion> sectionQuestions = sectionQuestionRepository.findAllBySectionId(sectionId);

        sectionQuestion = new SectionQuestion(sectionEntity, questionEntity, 1);

        sectionQuestionRepository.save(sectionQuestion);

        return questionEntity;
    }


//
//    public List<BigDecimal> getSectionIdsByTemplateIds(BigDecimal templateId){
//         return templateSectionRepository.findSectionIdsByTemplateIds(templateId);
//    }

}
