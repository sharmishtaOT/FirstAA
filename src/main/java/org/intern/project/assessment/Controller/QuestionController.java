package org.intern.project.assessment.Controller;

import org.intern.project.assessment.QuestionEntity;
import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.Service.QuestionService;
//import org.intern.project.assessment.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {
    @Autowired
    public QuestionService questionService = new QuestionService();


    @RequestMapping(method = RequestMethod.POST, value = "/template/section/question")
    public boolean postSection(@RequestBody QuestionEntity questionEntity){

        return questionService.post(questionEntity);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/template/section/question")
    public List<QuestionEntity> getAllSections(){
        return questionService.getAllSections();
    }

}
