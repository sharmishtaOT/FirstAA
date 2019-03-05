package org.intern.project.assessment.Controller;
import java.util.Optional;
import java.util.List;

import lombok.*;
import org.intern.project.assessment.Service.TemplateService;
import org.intern.project.assessment.TemplateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.intern.project.assessment.dto.WelcomeUpdateRequest;


@RestController
@CrossOrigin(origins = "localhost:4200")
@RequestMapping("/api")

public class TemplateController {

    @Autowired
    private TemplateService templateService = new TemplateService();


    @RequestMapping(method = RequestMethod.POST, value = "/template")
    public boolean postTemplate(@RequestBody TemplateEntity templateEntity){
        return templateService.post(templateEntity);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/template/all")
    public List<TemplateEntity> getAllTemplates(){
        return templateService.getAllTemplates();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/template/{id}")
    public Optional<TemplateEntity> getTemplateId(@PathVariable Long id) {
        return templateService.getTemplateById(id);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/template/{templateId}/welcometext")
    public void updateWelcomeText(@RequestBody WelcomeUpdateRequest welcomeUpdateRequest, @PathVariable Long templateId){
        templateService.updateTemplateWelcomeText(templateId, welcomeUpdateRequest);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/template/{templateId}/delete")
    public boolean deleteTemplateById(@PathVariable Long templateId){
        return templateService.deleteTemplateById(templateId);
    }
}
