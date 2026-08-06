package com.saltwort.MyFirstApiRest.repository;

import com.saltwort.MyFirstApiRest.model.UserConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserConfigurationRepository extends JpaRepository<UserConfiguration, Long> {
}
