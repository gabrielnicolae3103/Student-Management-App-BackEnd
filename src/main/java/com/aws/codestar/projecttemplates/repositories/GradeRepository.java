package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findAllByStudentSin(long sin);
    List<Grade> findAllByStudentSinAndClasaYear(long sin, int year);
    Optional<Grade> findByStudentSinAndClasaId(long sin, long classId);
    Boolean existsByStudentSinAndClasaId(long sin, long classId);
}
