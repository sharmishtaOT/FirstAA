package org.intern.project.assessment.Repository;

import org.intern.project.assessment.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface SectionRepository extends JpaRepository<SectionEntity, BigDecimal> {

}
