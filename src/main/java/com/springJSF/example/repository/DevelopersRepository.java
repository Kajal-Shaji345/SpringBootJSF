package com.springJSF.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springJSF.example.entity.DeveloperEntity;

@Repository
public interface DevelopersRepository extends JpaRepository<DeveloperEntity, Long> {

}
