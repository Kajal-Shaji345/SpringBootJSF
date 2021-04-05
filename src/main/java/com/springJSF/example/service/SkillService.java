package com.springJSF.example.service;


import com.springJSF.example.entity.SkillEntity;
import com.springJSF.example.model.SkillsModel;
import com.springJSF.example.repository.SkillsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {
	@Autowired
	SkillsRepository skillsRepository;

	public List<SkillsModel> getAllSkills() {
		List<SkillsModel> allSkills = new ArrayList<SkillsModel>();
		List<SkillEntity> skillsEntity = skillsRepository.findAll();
		for(SkillEntity singleSkill: skillsEntity ) {
			SkillsModel skill =  mapEntityToModel(singleSkill);
			allSkills.add(skill);
		}
		return allSkills;
	}

	private SkillsModel mapEntityToModel(SkillEntity skillEntity){
		SkillsModel skillsModel = new SkillsModel();
		skillsModel.setId(skillEntity.getId());
		skillsModel.setSkill(skillEntity.getSkill());
		return skillsModel;
	}
}
