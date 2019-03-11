package org.intern.project.assessment.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SectionQuestionPK implements Serializable{

    @Column(name = "sectionId", nullable = false)
    private BigDecimal sectionId;

    @Column(name = "questionId", nullable = false)
    private BigDecimal questionId;
}
