package com.saltwort.MyFirstApiRest.repository;

import com.saltwort.MyFirstApiRest.model.UserConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserConfigurationRepository extends JpaRepository<UserConfiguration, Long> {
    Optional<UserConfiguration> findByUserId(Long userId);

}
