package org.intern.project.assessment.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class TemplateSectionPK  implements Serializable {

    @Column(name = "templateId", nullable = false)
    private BigDecimal templateId;

    @Column(name = "sectionId", nullable = false)
    private BigDecimal sectionId;

}
