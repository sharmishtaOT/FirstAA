package org.intern.project.assessment.Service;

import org.intern.project.assessment.Repository.SectionRepository;
import org.intern.project.assessment.Repository.TemplateRepository;
import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.TemplateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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


    public SectionEntity post(SectionEntity sectionEntity, BigDecimal templateId){
        Optional<TemplateEntity> templateEntity = templateRepository.findById(templateId);
//        templateEntity.addSection(sectionEntity);
        return sectionRepository.save(sectionEntity);
    }


    public List<SectionEntity> getAllSections(){
            return sectionRepository.findAll();
    }

    public Optional<SectionEntity> getSectionById(BigDecimal templateId, BigDecimal sectionId){
        return sectionRepository.findById(sectionId);
    }


    public SectionEntity addSection(SectionEntity sectionEntity){
        sectionRepository.save(sectionEntity);
        return sectionEntity;
    }


//    public boolean deleteSectionById(BigDecimal sectionId){
//        sectionRepository.deleteById(sectionId);
//        return true;
//    }

    public SectionEntity getAllSectionsById(BigDecimal sectionEntityId){
        return sectionRepository.findById(sectionEntityId).get();
    }
}