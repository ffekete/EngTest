package hu.epam.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hu.epam.model.Answer;
import hu.epam.model.TestModel;
import hu.epam.model.TestModelInterface;

public class TestController {

	private List<TestModelInterface> testModel;
    private EntityManager entitymanager;
	
	public TestController(List<TestModelInterface> testModel, EntityManager entityManager){
		this.testModel = testModel; 
		this.entitymanager = entityManager;
	}
	
	public void addNewData(TestModelInterface testModel){
		this.testModel.add(testModel);
	}
	
}
