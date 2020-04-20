package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.models.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long> {
}
