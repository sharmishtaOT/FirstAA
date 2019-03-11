package org.intern.project.assessment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "SectionEntity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectionEntity{ //extends org.springframework.data.jpa.domain.AbstractPersistable<BigDecimal>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal id;

    @Column(name = "sectionName")
    private String sectionName;


//    private TemplateEntity getTemplateEntity() {
//        return templateEntity;
//    }
//    @ManyToOne(targetEntity = TemplateEntity.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "templateId")
//    private TemplateEntity templateEntity;
//    @OneToMany(mappedBy = "sectionEntity", targetEntity = QuestionEntity.class, cascade = CascadeType.ALL, orphanRemoval = true)


    @Transient
    private List<QuestionEntity> questionEntities;

}
