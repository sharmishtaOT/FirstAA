package org.intern.project.assessment;

import javax.persistence.*;

@Entity
@Table
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long questionId;

    @Column
    String type;

    @Column
    String questionDescription;


    @ManyToOne(targetEntity = SectionEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name="sectionId")
    public SectionEntity sectionEntity;


    public Long getQuestionId() { return questionId; }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }
}
