package com.springJSF.example.controller;

import com.springJSF.example.model.DeveloperModel;
import com.springJSF.example.service.DeveloperService;

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

@Scope (value = "session")
@Component (value = "developersList")
@ELBeanName(value = "developersList")
@Join(path = "/", to = "/developers/developers-portal.jsf")
public class DevelopersListController {

	@Autowired
	private DeveloperService developerService;

	private List<DeveloperModel> developerModels;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void getDefaultDevelopersList() {
		developerModels = developerService.getAllDevelopers();
	}

	public List<DeveloperModel> getAllDevelopersList() {
		return developerModels;
	}

}
