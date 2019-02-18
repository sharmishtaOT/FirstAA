package org.intern.project.assessment.Controller;

import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.Service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectionController {

    @Autowired
    public SectionService sectionService = new SectionService();


    @RequestMapping(method = RequestMethod.POST, value = "/template/{templateId}/section")
    public SectionEntity postSection(@PathVariable("templateId") Long templateId,
                               @RequestBody SectionEntity sectionEntity){

        return sectionService.post(sectionEntity, templateId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/template/section")
    public List<SectionEntity> getAllSections(){
        return sectionService.getAllSections();
    }

}
