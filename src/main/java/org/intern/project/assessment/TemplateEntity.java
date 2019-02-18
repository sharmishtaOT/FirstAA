package org.intern.project.assessment;

import org.intern.project.assessment.Repository.TemplateRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TemplateEntity")
public class TemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long templateId;

    @Column(name = "TemplateName")
    String templateName;

    @Column(name = "State")
    String state;

    @Column(name = "templateDescription")
    String templateDescription;

    public List<SectionEntity> getSectionEntityList() {
        return sectionEntityList;
    }

    public void setSectionEntityList(List<SectionEntity> sectionEntityList) {
        this.sectionEntityList = sectionEntityList;
    }

    @OneToMany(mappedBy = "templateEntity", targetEntity = SectionEntity.class, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<SectionEntity> sectionEntityList = new ArrayList<>();


    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTemplateDescription() {
        return templateDescription;
    }

    public void setTemplateDescription(String templateDescription) {
        this.templateDescription = templateDescription;
    }
}
