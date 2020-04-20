package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.models.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupaRepository extends JpaRepository<Grupa, Long> {

}
