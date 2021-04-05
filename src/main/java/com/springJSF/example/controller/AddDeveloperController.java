package com.springJSF.example.controller;

import com.springJSF.example.model.DeveloperModel;
import com.springJSF.example.model.SkillsModel;
import com.springJSF.example.service.DeveloperService;
import com.springJSF.example.service.SkillService;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Scope(value = "session")
@Component(value = "addDeveloper")
@ELBeanName(value = "addDeveloper")
@Join(path = "/developer-fillDetails", to = "/developers/developer-fillDetails.jsf")
public class AddDeveloperController {

	@Autowired
	private DeveloperService developerService;
	@Autowired
	private SkillService skillService;

	private DeveloperModel developerModel = new DeveloperModel();
	private List<SkillsModel> skillsModel ;

    //Add New Developer
	public String addNewDeveloper() {
		boolean developerCreated = developerService.createNewDeveloper(developerModel);
		if(developerCreated == true) {
			return "/developers/developers-portal.xhtml?faces-redirect=true";
		}
		return null;
	}

	public DeveloperModel getDeveloperModel(){
		return developerModel;
	}

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getGeneralSkillsList() {
		skillsModel = skillService.getAllSkills();
	}


	public List<SkillsModel> getSkillsList() {
		return skillsModel;
	}

}
