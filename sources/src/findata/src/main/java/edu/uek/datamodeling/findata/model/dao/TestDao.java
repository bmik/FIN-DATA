package edu.uek.datamodeling.findata.model.dao;

import java.util.List;

import edu.uek.datamodeling.findata.model.entity.TestEntity;

public interface TestDao {
	
	public void addEntity(TestEntity entity);
	public List<TestEntity> getAllEntities();
	public void deleteEntity(Long id);
	
}
