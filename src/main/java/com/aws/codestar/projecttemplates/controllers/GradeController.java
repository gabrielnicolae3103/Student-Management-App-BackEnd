package com.aws.codestar.projecttemplates.controllers;

import com.aws.codestar.projecttemplates.models.Grade;
import com.aws.codestar.projecttemplates.repositories.GradeRepository;
import com.aws.codestar.projecttemplates.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    GradeRepository gradeRepository;
    GradeService gradeService;

    @Autowired
    public GradeController(GradeRepository gradeRepository, GradeService gradeService) {
        this.gradeRepository = gradeRepository;
        this.gradeService = gradeService;
    }

    @GetMapping
    List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    @PostMapping
    Grade newGrade(@RequestBody Grade grade) {
        return  gradeRepository.save(grade);
    }

    @GetMapping("/student/{sin}")
    List<Grade> findStudentGrades(@PathVariable(value = "sin") long sin,
                                  @RequestParam(value = "year", required = false) Integer year) {
        if(year == null)
            return gradeRepository.findAllByStudentSin(sin);
        return gradeRepository.findAllByStudentSinAndClasaYear(sin, year);
    }

    @PutMapping("/student/{sin}/class/{classId}")
    ResponseEntity<Grade> modifyGrade(@PathVariable(value = "sin") long sin,
                                      @PathVariable(value = "classId") long classId,
                                      @RequestBody Grade grade) {
        if(!gradeRepository.existsByStudentSinAndClasaId(sin, classId))
            return ResponseEntity.notFound().build();
        Grade grade1 = gradeRepository.findByStudentSinAndClasaId(sin, classId);
        grade1.setGrade(grade.getGrade());
        return ResponseEntity.ok(gradeRepository.save(grade1));
    }
}
