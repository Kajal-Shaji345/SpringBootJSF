package com.springJSF.example.entity;


import javax.persistence.*;

@Entity
@Table (name = "SKILL_SET_ENTITY")
public class SkillEntity {
	@Id
	private Long id;
	private String skill;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
}
