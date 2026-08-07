package com.saltwort.MyFirstApiRest.repository;

import com.saltwort.MyFirstApiRest.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ListRepository extends JpaRepository<List, Long> {
    java.util.List<List> findByUserId(Long fkUser);
}
