package edu.uek.datamodeling.findata.controller.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uek.datamodeling.findata.controller.service.TestService;
import edu.uek.datamodeling.findata.model.dao.TestDao;
import edu.uek.datamodeling.findata.model.entity.TestEntity;

@Service("tesdDao")
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDao testDao;
	
	@Override
	@Transactional
	public void addEntity(TestEntity entity) {
		testDao.addEntity(entity);
	}

	@Override
	@Transactional
	public List<TestEntity> getAllEntities() {
		return testDao.getAllEntities();
	}

	@Override
	@Transactional
	public void deleteEntity(Long id) {
		testDao.deleteEntity(id);
	}
	
}
