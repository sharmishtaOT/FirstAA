package org.intern.project.assessment.Service;

import org.intern.project.assessment.QuestionEntity;
import org.intern.project.assessment.Repository.QuestionRepository;
import org.intern.project.assessment.SectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

        @Autowired
        public QuestionRepository questionRepository;

        private List<QuestionEntity> list = new ArrayList<>();


        public boolean post(QuestionEntity questionEntity){
            questionRepository.save(questionEntity);
//        list.add(questionEntity);
            return true;
        }

        public List<QuestionEntity> getAllSections(){
//            return list;
            return questionRepository.findAll();
        }

}
