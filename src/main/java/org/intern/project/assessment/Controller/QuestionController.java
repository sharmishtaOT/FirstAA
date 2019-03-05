package org.intern.project.assessment.Controller;

import org.intern.project.assessment.QuestionEntity;
import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.Service.QuestionService;
//import org.intern.project.assessment.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {
    @Autowired
    public QuestionService questionService = new QuestionService();


    @RequestMapping(method = RequestMethod.POST, value = "/template/{templateId}/section/{sectionId}/question")
    public boolean postSection(@RequestBody QuestionEntity questionEntity){

        return questionService.post(questionEntity);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/template/{templateId}/section/{sectionId}/question")
    public List<QuestionEntity> getAllQuestions(){
        return questionService.getAllQuestions();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/template/{templateId}/section/{sectionId}/question/{questionId}")
    public Optional<QuestionEntity> getQuestionById(@PathVariable Long templateId, @PathVariable Long sectionId, @PathVariable Long questionId){
        return questionService.getQuestionById(sectionId, questionId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/template/{templateId}/section/{sectionId}/delete/{questionId}")
    public boolean deleteQuestionById(@PathVariable Long templateId, @PathVariable Long sectionId, @PathVariable Long questionId){
        return questionService.deleteQuestionById(templateId, sectionId, questionId);
    }
}
