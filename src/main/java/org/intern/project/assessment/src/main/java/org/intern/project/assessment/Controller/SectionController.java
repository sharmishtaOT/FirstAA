package org.intern.project.assessment.Controller;

import org.intern.project.assessment.SectionEntity;
import org.intern.project.assessment.Service.SectionService;
import org.intern.project.assessment.Service.TemplateBuilderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/templates")

public class SectionController {

    @Autowired
    private SectionService sectionService;

    @Autowired
    private TemplateBuilderService templateBuilderService;

    @PostMapping(value = "/{templateId}/sections")
    public ResponseEntity<SectionController> postSection(@PathVariable BigDecimal templateId,
                                                         @RequestBody SectionEntity sectionEntity){
        templateBuilderService.addSection( templateId, sectionEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping(value = "/{templateId}/sections")
    public ResponseEntity<SectionController> getSectionsByTemplateId(@PathVariable BigDecimal templateId){
        List<SectionEntity> sectionEntities = templateBuilderService.getSections(templateId);

        return new ResponseEntity(sectionEntities, HttpStatus.OK);
    }



//    @GetMapping(value = "/{templateId}/sections")
//    public ResponseEntity<SectionController> getAllSections(){
//        return new ResponseEntity(sectionService.getAllSections(), HttpStatus.OK);
//    }

    @GetMapping(value = "/{templateId}/sections/{sectionId}")
    public ResponseEntity<SectionController> getSectionById(@PathVariable BigDecimal templateId, @PathVariable BigDecimal sectionId){
        return new ResponseEntity(sectionService.getSectionById(templateId, sectionId), HttpStatus.OK);
    }

//    @DeleteMapping(value = "/{templateId}/sections/{sectionId}")
//    public ResponseEntity<SectionController> deleteSectionById(@PathVariable BigDecimal sectionId){
//        sectionService.deleteSectionById(sectionId);
//        return new ResponseEntity(HttpStatus.OK);
//    }

}
