package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.models.Seria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriaRepository extends JpaRepository<Seria, Long> {
}
