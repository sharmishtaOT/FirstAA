package org.intern.project.assessment.Controller;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;
import org.intern.project.assessment.Service.TemplateService;
import org.intern.project.assessment.TemplateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "localhost:4200")
public class TemplateController {

    @Autowired
    private TemplateService templateService;


    @RequestMapping(method = RequestMethod.POST, value = "/template")
    public boolean postTemplate(@RequestBody TemplateEntity templateEntity){
        return templateService.post(templateEntity);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/template")
    public List<TemplateEntity> getAllTemplates(){
        return templateService.getAllTemplates();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/template/{id}")
    public Optional<TemplateEntity> getTemplateId(@PathVariable Long id){
        return templateService.getTemplateById(id);
    }
}
