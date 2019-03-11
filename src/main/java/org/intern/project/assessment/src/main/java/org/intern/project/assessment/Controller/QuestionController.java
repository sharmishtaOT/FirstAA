package org.intern.project.assessment.Controller;

import org.intern.project.assessment.QuestionEntity;
import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.Service.QuestionService;
//import org.intern.project.assessment.Service.QuestionService;
import org.intern.project.assessment.Service.TemplateBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

@RestController
@RequestMapping("/templates")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {
    @Autowired
    private QuestionService questionService;



    @Autowired
    private TemplateBuilderService templateBuilderService;


//    @PostMapping(value = "/{templateId}/sections/{sectionId}/questions")
//    public ResponseEntity<QuestionController> postSection(@RequestBody QuestionEntity questionEntity){
//
//        questionService.post(questionEntity);
//        return new ResponseEntity(HttpStatus.OK);
//    }

//    @GetMapping(value = "/{templateId}/sections/{sectionId}/questions")
//    public ResponseEntity<QuestionController> getAllQuestions(){
//        return new ResponseEntity(questionService.getAllQuestions(), HttpStatus.OK);
//    }

    @PostMapping(value = "/{templateId}/sections/{sectionId}/questions")
    public ResponseEntity<QuestionController> createQuestions(@PathVariable BigDecimal templateId, @PathVariable BigDecimal sectionId, @RequestBody QuestionEntity questionEntity){
        return new ResponseEntity(templateBuilderService.addQuestion(templateId, sectionId, questionEntity), HttpStatus.OK);
    }

    @GetMapping(value = "/{templateId}/sections/{sectionId}/questions")
    public ResponseEntity<QuestionController> getQuestions(@PathVariable BigDecimal templateId, @PathVariable BigDecimal sectionId){
        return new ResponseEntity(templateBuilderService.getQuestions(sectionId), HttpStatus.OK);
    }

    @GetMapping(value = "/{templateId}/sections/{sectionId}/questions/{questionId}")
    public ResponseEntity<QuestionEntity> getQuestionById(@PathVariable BigDecimal questionId){
        return new ResponseEntity(questionService.getQuestionById(questionId), HttpStatus.OK);
    }

//    @GetMapping(value = "/{templateId}/sections/{sectionId}/questions/{questionId}")
//    public ResponseEntity<QuestionController> getQuestionById(@PathVariable BigDecimal templateId, @PathVariable BigDecimal sectionId, @PathVariable BigDecimal questionId){
//        return new ResponseEntity(questionService.getQuestionById(sectionId, questionId),HttpStatus.OK);
//    }

//    @DeleteMapping(value = "/{templateId}/sections/{sectionId}/questions/{questionId}")
//    public ResponseEntity<QuestionController> deleteQuestionById(@PathVariable BigDecimal templateId, @PathVariable BigDecimal sectionId, @PathVariable BigDecimal questionId){
//        questionService.deleteQuestionById(templateId, sectionId, questionId);
//        return new ResponseEntity(HttpStatus.OK);
//    }
}
