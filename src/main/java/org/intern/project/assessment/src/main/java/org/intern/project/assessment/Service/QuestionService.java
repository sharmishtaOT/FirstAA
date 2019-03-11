package org.intern.project.assessment.Service;

import org.intern.project.assessment.QuestionEntity;
import org.intern.project.assessment.Repository.QuestionRepository;
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

        private List<QuestionEntity> list = new ArrayList<>();


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
//
//        public Optional<QuestionEntity> getQuestionById(BigDecimal sectionId, BigDecimal questionId){
//            return questionRepository.findById(questionId);
//        }
//
        public void deleteById(BigDecimal questionId){
            questionRepository.deleteById(questionId);
            return;
        }
}
