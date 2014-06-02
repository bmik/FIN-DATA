package edu.uek.datamodeling.findata.controller.service;

import java.util.List;

import edu.uek.datamodeling.findata.model.entity.TestEntity;

public interface TestService {

	public void addEntity(TestEntity entity);
	public List<TestEntity> getAllEntities();
	public void deleteEntity(Long id);
	
}
