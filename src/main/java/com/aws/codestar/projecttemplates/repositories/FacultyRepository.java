package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.models.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}
