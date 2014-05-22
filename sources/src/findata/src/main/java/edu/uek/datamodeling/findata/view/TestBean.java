package edu.uek.datamodeling.findata.view;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;

import org.springframework.stereotype.Controller;

@Controller("testBean")
@ViewScoped
public class TestBean implements Serializable {

	private static final long serialVersionUID = -5317413022036931996L;

	
	private String text = "index";

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
