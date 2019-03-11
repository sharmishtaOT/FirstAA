package org.intern.project.assessment.Controller;

import org.intern.project.assessment.Service.TemplateService;
import org.intern.project.assessment.TemplateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import org.intern.project.assessment.dto.Request.*;

import java.math.BigDecimal;

@EnableTransactionManagement
@RestController
@CrossOrigin(origins = "localhost:4200")
@RequestMapping("/templates")
public class TemplateController {

    @Autowired
    private TemplateService templateService;


    @PostMapping
    public ResponseEntity<QuestionController> postTemplate(@RequestBody TemplateEntity templateEntity){
        templateService.post(templateEntity);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<QuestionController> getAllTemplates(){
        return new ResponseEntity(templateService.getAllTemplates(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<QuestionController> getTemplateId(@PathVariable BigDecimal id) {
        return new ResponseEntity(templateService.getTemplateById(id), HttpStatus.OK);
    }


    @PutMapping(value = "/{templateId}/welcometext")
    public ResponseEntity<TemplateController> updateWelcomeText(@RequestBody WelcomeTextUpdateRequest welcomeUpdateRequest, @PathVariable BigDecimal templateId){
        templateService.updateTemplateWelcomeText(templateId, welcomeUpdateRequest);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TemplateController> deleteTemplateById(@PathVariable BigDecimal id){
        templateService.deleteTemplateById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}