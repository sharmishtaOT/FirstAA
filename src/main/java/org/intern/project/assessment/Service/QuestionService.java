package org.intern.project.assessment.Service;

import org.intern.project.assessment.QuestionEntity;
import org.intern.project.assessment.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        public List<QuestionEntity> getAllQuestions(){
            return questionRepository.findAll();
        }
//
//        public Optional<QuestionEntity> getQuestionById(BigDecimal sectionId, BigDecimal questionId){
//            return questionRepository.findById(questionId);
//        }
//
//        public boolean deleteQuestionById(BigDecimal templateId, BigDecimal sectionId, BigDecimal questionId){
//            questionRepository.deleteById(questionId);
//            return true;
//        }
}
