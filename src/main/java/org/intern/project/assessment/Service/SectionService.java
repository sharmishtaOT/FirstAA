package org.intern.project.assessment.Service;

import org.intern.project.assessment.Repository.SectionRepository;
import org.intern.project.assessment.Repository.TemplateRepository;
import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.TemplateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SectionService {

    @Autowired
    TemplateRepository templateRepository;

        @Autowired
        public SectionRepository sectionRepository;

    private List<SectionEntity> list = new ArrayList<>();


    public SectionEntity post(SectionEntity sectionEntity, Long templateId){
        Optional<TemplateEntity> templateEntity = templateRepository.findById(templateId);
        return sectionRepository.save(sectionEntity);
    }


    public List<SectionEntity> getAllSections(){
//            return list;
            return sectionRepository.findAll();
    }
}