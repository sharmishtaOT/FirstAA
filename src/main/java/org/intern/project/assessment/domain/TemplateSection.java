package org.intern.project.assessment.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.intern.project.assessment.TemplateEntity;
import org.intern.project.assessment.SectionEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "template_section")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TemplateSection {

    @EmbeddedId
    private TemplateSectionPK templateSectionPK;

    @Column(name = "sequence", nullable = false)
    private Integer sequence;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "templateId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private TemplateEntity templateEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionId", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private SectionEntity sectionEntity;

    public TemplateSection(TemplateEntity templateEntity, SectionEntity sectionEntity, Integer sequence){
        this.templateSectionPK = new TemplateSectionPK(templateEntity.getId(), sectionEntity.getId());
        this.templateEntity = templateEntity;
        this.sectionEntity = sectionEntity;
        this.sequence = sequence;
    }
}
