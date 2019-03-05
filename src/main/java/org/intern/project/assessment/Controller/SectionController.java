package org.intern.project.assessment.Controller;

import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.Service.SectionService;
import org.intern.project.assessment.TemplateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")

public class SectionController {

    @Autowired
    public SectionService sectionService;
//    public SectionService sectionService = new SectionService();


    @RequestMapping(method = RequestMethod.POST, value = "/template/{templateId}/section")
    public SectionEntity postSection(@PathVariable("templateId") Long templateId,
                               @RequestBody SectionEntity sectionEntity){
        return sectionService.post(sectionEntity, templateId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/template/section")
    public List<SectionEntity> getAllSections(){
        return sectionService.getAllSections();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/template/{templateId}/section/{sectionId}")
    public Optional<SectionEntity> getSectionById(@PathVariable Long templateId, @PathVariable Long sectionId){
        return sectionService.getSectionById(templateId, sectionId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/template/{templateId}/section/{sectionId}/delete")
    public boolean deleteSectionById(@PathVariable Long sectionId){
        return sectionService.deleteSectionById(sectionId);
    }

}
