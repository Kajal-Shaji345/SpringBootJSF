package com.springJSF.example.service;

import com.springJSF.example.entity.DeveloperEntity;
import com.springJSF.example.model.DeveloperModel;
import com.springJSF.example.repository.DevelopersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeveloperService {

    @Autowired
    DevelopersRepository developersRepository;

    public List<DeveloperModel> getAllDevelopers() {
        List<DeveloperModel> allDevelopers = new ArrayList<DeveloperModel>();
        List<DeveloperEntity> developersEntity = developersRepository.findAll();
        for(DeveloperEntity individualDeveloper: developersEntity ) {
            DeveloperModel developer =  mapEntityToModel(individualDeveloper);
            allDevelopers.add(developer);
        }
        return allDevelopers;
    }


    public boolean createNewDeveloper(DeveloperModel developersModel){
        DeveloperEntity entityToMap = new DeveloperEntity();
        DeveloperEntity developerEntity = developersRepository.save((mapModelToEntity(entityToMap, developersModel)));
        if(null != developerEntity.toString())
            return true;

        return false;
    }

	public DeveloperModel getIndividualDeveloper(Long id) {
		DeveloperEntity developersEntity = developersRepository.findOne(id);
		DeveloperModel developer =  mapEntityToModel(developersEntity);
		return developer;
	}

   public boolean updateDeveloper(DeveloperModel developersModel, Long id){
	   DeveloperEntity entityToMap = new DeveloperEntity();
        DeveloperEntity developerEntity = developersRepository.save((mapModelToEntity(entityToMap, developersModel)));
        if(null != developerEntity.toString())
            return true;
        return false;
    }


    private DeveloperModel mapEntityToModel(DeveloperEntity developersEntity){
        DeveloperModel developersModel = new DeveloperModel();
        developersModel.setId(developersEntity.getId());
        developersModel.setName(developersEntity.getName());
        developersModel.setEmail(developersEntity.getEmail());
        developersModel.setSkills(developersEntity.getSkills());
        return developersModel;
    }

   private DeveloperEntity mapModelToEntity(DeveloperEntity entityToMap, DeveloperModel developersModel){
        DeveloperEntity developersEntity = new DeveloperEntity();
        developersEntity.setId(developersModel.getId());
        developersEntity.setName(developersModel.getName());
        developersEntity.setEmail(developersModel.getEmail());
        developersEntity.setSkills(developersModel.getSkills());
        return developersEntity;
    }

}
