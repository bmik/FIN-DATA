package edu.uek.datamodeling.findata.view;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.uek.datamodeling.findata.controller.service.TestService;
import edu.uek.datamodeling.findata.model.entity.TestEntity;

@Controller("testBean")
@ViewScoped
public class TestBean implements Serializable {

	private static final long serialVersionUID = -5317413022036931996L;

	@Autowired
	private TestService service;
	
	private String text = "index";

	public String getText() {
		return text;
	}
	
	public void addEntity() {
		TestEntity entity = new TestEntity("Marian", "Kowalski");
		service.addEntity(entity);
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
