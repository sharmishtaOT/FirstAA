package org.intern.project.assessment.Service;

import org.intern.project.assessment.QuestionEntity;
import org.intern.project.assessment.Repository.*;
import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.TemplateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@EnableTransactionManagement

@Service
public class TemplateBuilderService {

    @Autowired
    private TemplateSectionRepository templateSectionRepository;

    @Autowired
    private SectionQuestionRepository sectionQuestionRepository;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TemplateService templateService;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private QuestionService questionService;

    public SectionEntity addSection(BigDecimal templateId, SectionEntity sectionEntity){

        TemplateEntity templateEntity = templateRepository.findById(templateId).get();

        sectionService.addSection(sectionEntity);
        templateService.addSectionToTemplateId(templateEntity, sectionEntity, templateEntity.getId());
        return sectionEntity;
    }


    public List<SectionEntity> getSections(BigDecimal templateId){

        List<SectionEntity> sectionEntities = new ArrayList<>();
        List<BigDecimal> sectionEntityIds = templateSectionRepository.findSectionIdsByTemplateIds(templateId);

//        if(CollectionUtils.isEmpty(sectionEntityIds))
//            return Collections.emptyList();

        for (BigDecimal sectionEntityId : sectionEntityIds) {
            sectionEntities.add(sectionService.getAllSectionsById(sectionEntityId));
        }
//        sectionEntityIds
//                .forEach(sectionEntityId -> {
//                    SectionEntity sectionEntity = sectionService.getAllSectionsById(sectionEntityId.BigDecimalValue());
//                    sectionEntities.add(sectionEntity);
//                });
        return sectionEntities;
    }

    public QuestionEntity addQuestion(BigDecimal templateId, BigDecimal sectionId, QuestionEntity questionEntity){
        SectionEntity sectionEntity = sectionRepository.findById(sectionId).get();

        TemplateEntity templateEntity = templateRepository.findById(templateId).get();
        questionService.addQuestion(questionEntity);
        templateService.addQuestionToSectionId(sectionEntity, questionEntity, sectionEntity.getId());
        return questionEntity;
    }


    public List<QuestionEntity> getQuestions(BigDecimal sectionId){
        List<BigDecimal> questionEntityIds = sectionQuestionRepository.findQuestionIdsBySectionId(sectionId);
        List<QuestionEntity> questionEntities = new ArrayList<>();

        for(BigDecimal questionId : questionEntityIds){
            questionEntities.add(questionService.getQuestionById(questionId));
        }
        return questionEntities;
    }
}
