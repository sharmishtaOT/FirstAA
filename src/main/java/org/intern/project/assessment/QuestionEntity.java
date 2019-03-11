package org.intern.project.assessment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal questionId;

    @Column
    private String type;

    @Column
    private String questionDescription;

    private SectionEntity getSectionEntity() {
        return sectionEntity;
    }

    @ManyToOne(targetEntity = SectionEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name="sectionId")
    private SectionEntity sectionEntity;

}
