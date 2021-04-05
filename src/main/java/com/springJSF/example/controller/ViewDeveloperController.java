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

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Scope (value = "session")
@Component (value = "viewDeveloper")
@ELBeanName(value = "viewDeveloper")
@Join(path = "/view-developer/{id}", to = "/developers/view-developer.jsf")
public class ViewDeveloperController {


	@Autowired
	DeveloperService developerService;
	@Autowired
	SkillService skillService;

	private DeveloperModel developerModel = new DeveloperModel();
	private List<SkillsModel> skillsModel;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getOneDeveloper() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String id = request.getParameter("id");
		developerModel = developerService.getIndividualDeveloper(Long.parseLong(id));
	}

	public DeveloperModel getDeveloper(){
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

    //Update Developer Skills
	public String updateDeveloperSkills() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String id = request.getParameter("id");
		DeveloperModel currentDeveloperData = developerService.getIndividualDeveloper(Long.parseLong(id));
		String skillUpdate = currentDeveloperData.getSkills() + " , " + developerModel.getSkills();
		developerModel.setSkills(skillUpdate);
		boolean developerUpdated = developerService.updateDeveloper(developerModel, Long.parseLong(id));
		if(developerUpdated == true) {
			return "/developers/view-developer/{id}";
		}
		return null;
	}




}
