package org.intern.project.assessment.Service;

import org.intern.project.assessment.QuestionEntity;
import org.intern.project.assessment.Repository.QuestionRepository;
import org.intern.project.assessment.Repository.SectionQuestionRepository;
import org.intern.project.assessment.domain.SectionQuestionPK;
import org.intern.project.assessment.domain.TemplateSectionPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    public QuestionRepository questionRepository;

    @Autowired
    private SectionQuestionRepository sectionQuestionRepository;

//        private List<QuestionEntity> list = new ArrayList<>();

    public boolean post(QuestionEntity questionEntity){
        questionRepository.save(questionEntity);
        return true;
    }

    public QuestionEntity addQuestion(QuestionEntity questionEntity){

            questionRepository.save(questionEntity);
        return questionEntity;
    }

    public List<QuestionEntity> getAllQuestions(){
            return questionRepository.findAll();
        }

    public QuestionEntity getQuestionById(BigDecimal questionId){
            return questionRepository.findById(questionId).get();
    }

    public void deleteById(BigDecimal questionId){

        BigDecimal sectionsId = sectionQuestionRepository.findSectionIdByQuestionId(questionId).get();

        sectionQuestionRepository.deleteById(new SectionQuestionPK(sectionsId, questionId));

//        List<BigDecimal> sectionIds = templateSectionRepository.findSectionIdsByTemplateIds(templateId);
//        for (BigDecimal sectionsId : sectionIds)
//            templateSectionRepository.deleteById(new TemplateSectionPK(templateId, sectionsId));

        questionRepository.deleteById(questionId);
        return;
    }
}
