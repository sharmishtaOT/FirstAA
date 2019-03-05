package org.intern.project.assessment.Service;

import org.intern.project.assessment.Repository.TemplateRepository;
import org.intern.project.assessment.TemplateEntity;
//import org.intern.project.assessment.TemplateNotFoundException.TemplateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.intern.project.assessment.dto.WelcomeUpdateRequest;


import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class TemplateService {

    @Autowired
    public TemplateRepository templateRepository;


    public boolean post(TemplateEntity templateEntity){
        templateRepository.save(templateEntity);
        return true;
    }

    public List<TemplateEntity> getAllTemplates(){
        return templateRepository.findAll();
    }

    public Optional<TemplateEntity> getTemplateById(Long id){
        return templateRepository.findById(id);
    }

    public boolean deleteTemplateById(Long templateId){
        templateRepository.deleteById(templateId);
        return true;
    }

    public void updateTemplateWelcomeText(Long templateId, WelcomeUpdateRequest welcomeUpdateRequest){
        Optional<TemplateEntity> templateEntityRepo = templateRepository.findById(templateId);
        TemplateEntity templateEntity = templateEntityRepo.get();
        templateEntity.setWelcomeText(welcomeUpdateRequest.getWelcomeText());
        templateRepository.save(templateEntity);
    }

}

