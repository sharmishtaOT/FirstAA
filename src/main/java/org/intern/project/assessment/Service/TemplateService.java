package org.intern.project.assessment.Service;

import org.intern.project.assessment.Repository.TemplateRepository;
import org.intern.project.assessment.Repository.TemplateSectionRepository;
import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.TemplateEntity;
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

//    public boolean deleteTemplateById(BigDecimal templateId){
//        templateRepository.deleteById(templateId);
//        return true;
//    }

//    public void updateTemplateWelcomeText(BigDecimal templateId, WelcomeTextUpdateRequest welcomeUpdateRequest){
//        Optional<TemplateEntity> templateEntityRepo = templateRepository.findById(templateId);
//        TemplateEntity templateEntity = templateEntityRepo.get();
//        templateEntity.setWelcomeText(welcomeUpdateRequest.getWelcomeText());
//        templateRepository.save(templateEntity);
//    }


    public SectionEntity addSectionToTemplateId(TemplateEntity templateEntity, SectionEntity sectionEntity, BigDecimal templateId){
        TemplateSection templateSection;
        List<TemplateSection> templateSections = templateSectionRepository.findAllByTemplateId(templateEntity.getId());

        //        Integer sequence = (Integer) templateSections.size();

        templateSection = new TemplateSection(templateEntity, sectionEntity, 1);
//        templateSections.add(templateSection);
//        templateSectionRepository.saveAll(templateSections);

        templateSectionRepository.save(templateSection);
        return sectionEntity;
    }

//
//    public List<BigDecimal> getSectionIdsByTemplateIds(BigDecimal templateId){
//         return templateSectionRepository.findSectionIdsByTemplateIds(templateId);
//    }

}
