package edu.uek.datamodeling.findata.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="findata.test_entity")
public class TestEntity {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Long idTest;
	private String col1;
	private String col2;
	
	protected TestEntity() {}
	
	public TestEntity(String col1, String col2) {
		this.col1 = col1;
		this.col2 = col2;
	}

	public Long getIdTest() {
		return idTest;
	}

	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}

	public String getCol1() {
		return col1;
	}

	public void setCol1(String col1) {
		this.col1 = col1;
	}

	public String getCol2() {
		return col2;
	}

	public void setCol2(String col2) {
		this.col2 = col2;
	}

	@Override
	public String toString() {
		return String.format("TestEntity[id=%d, col1=%s, col2=%s", idTest, col1, col2);
	}
	
}
