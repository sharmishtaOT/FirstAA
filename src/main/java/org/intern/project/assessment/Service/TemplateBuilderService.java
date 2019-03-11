package org.intern.project.assessment.Service;

import org.intern.project.assessment.QuestionEntity;
import org.intern.project.assessment.Repository.TemplateRepository;
import org.intern.project.assessment.Repository.TemplateSectionRepository;
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
    private TemplateRepository templateRepository;

    @Autowired
    private TemplateService templateService;

    @Autowired
    private SectionService sectionService;

    public SectionEntity addSection(BigDecimal templateId, SectionEntity sectionEntity){

        TemplateEntity templateEntity = templateRepository.findById(templateId).get();

        sectionService.addSection(sectionEntity);
//        TemplateSectionPK templateSectionPK = new TemplateSectionPK(templateEntity.getTemplateId(), sectionEntity.getSectionId());
        templateService.addSectionToTemplateId(templateEntity, sectionEntity, templateEntity.getId());

        return sectionEntity;
    }


    public List<SectionEntity> getSections(BigDecimal templateId){

        List<SectionEntity> sectionEntities = new ArrayList<>();
        List<BigDecimal> sectionEntityIds = templateSectionRepository.findSectionIdsByTemplateIds(templateId);

        if(CollectionUtils.isEmpty(sectionEntityIds))
            return Collections.emptyList();

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

    public List<QuestionEntity> addQuestion(){

    }

}
