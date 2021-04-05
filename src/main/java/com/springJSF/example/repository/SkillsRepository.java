package com.springJSF.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springJSF.example.entity.SkillEntity;

@Repository
public interface SkillsRepository extends JpaRepository<SkillEntity, Long> {
}
