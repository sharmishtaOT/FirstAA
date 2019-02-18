package org.intern.project.assessment;

import org.intern.project.assessment.Repository.SectionRepository;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SectionEntity")
public class SectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long sectionId;

    @Column(name = "sectionName")
    String sectionName;

    public TemplateEntity getTemplateEntity() {
        return templateEntity;
    }

    public void setTemplateEntity(TemplateEntity templateEntity) {
        this.templateEntity = templateEntity;
    }

    @ManyToOne(targetEntity = TemplateEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "templateId")
    public TemplateEntity templateEntity;

    @OneToMany(mappedBy = "sectionEntity", targetEntity = QuestionEntity.class, cascade = CascadeType.ALL, orphanRemoval = true)
    public List<QuestionEntity> questionEntities;

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

        public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
