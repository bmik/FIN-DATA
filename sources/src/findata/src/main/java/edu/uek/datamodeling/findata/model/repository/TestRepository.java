package edu.uek.datamodeling.findata.model.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import edu.uek.datamodeling.findata.model.dao.TestDao;
import edu.uek.datamodeling.findata.model.entity.TestEntity;

public class TestRepository implements TestDao {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public void addEntity(TestEntity entity) {
		em.persist(entity);
	}

	@Override
	public List<TestEntity> getAllEntities() {
		TypedQuery<TestEntity> query = em.createNamedQuery("TestEntity.selectAll", TestEntity.class);
		return query.getResultList();
	}

	@Override
	public void deleteEntity(Long id) {
		;
	}

}
