package org.intern.project.assessment.domain;


import lombok.*;
import org.intern.project.assessment.QuestionEntity;
import org.intern.project.assessment.SectionEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "section_question")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SectionQuestion {

    @EmbeddedId
    private SectionQuestionPK sectionQuestionPK;

    @Column(name = "sequence", nullable = false)
    private Integer sequence;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sectionId", nullable = false, insertable = false, updatable = false)
    private SectionEntity sectionEntity;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId", nullable = false, insertable = false, updatable = false)
    private QuestionEntity questionEntity;

    public SectionQuestion(SectionEntity sectionEntity, QuestionEntity questionEntity, Integer sequence){
        this.sectionQuestionPK = new SectionQuestionPK(sectionEntity.getId(), questionEntity.getId());
        this.sectionEntity = sectionEntity;
        this.questionEntity = questionEntity;
        this.sequence = sequence;
    }
}
