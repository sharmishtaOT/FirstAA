package org.intern.project.assessment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.intern.project.assessment.EntityEnums.TemplateState;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TemplateEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TemplateEntity {

    @Id
    @GeneratedValue
    private BigDecimal id;

    @Column(name = "TemplateName", unique = true)
    private String templateName;

    @Column(name = "templateDescription")
    private String templateDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "templateState")
    private TemplateState templateState = TemplateState.DRAFT;

    @Column(name = "active")
    private boolean active = true;

    @Column(name = "welcomeText")
    private String welcomeText="Welcome to the template default welcome message";



//    @OneToMany(mappedBy = "templateEntity", targetEntity = SectionEntity.class, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<SectionEntity> sectionEntityList = new ArrayList<>();

}
