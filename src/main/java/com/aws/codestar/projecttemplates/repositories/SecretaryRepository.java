package com.aws.codestar.projecttemplates.repositories;

import com.aws.codestar.projecttemplates.models.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary, Long> {
    Secretary findSecretaryByUserLogin(String login);
    Boolean existsSecretaryByUserLogin(String login);
}
