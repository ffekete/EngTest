package hu.epam.daotest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import hu.epam.controller.TestController;
import hu.epam.model.Answer;
import hu.epam.model.TestData;
import hu.epam.model.TestDataInterface;
import hu.epam.model.TestModel;


public class DaoTest{

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "TestAnswers" );
    EntityManager entitymanager = emfactory.createEntityManager();
    TestController testController;
    
	/*@BeforeSuite
	public void createTestObject(){
	
		ArrayList<Answer> testAnswers = new ArrayList<Answer>();
		Answer a1 = new Answer("Answer1", true);
		Answer a2 = new Answer("Answer2", false);
		
		testAnswers.add(a1);
		testAnswers.add(a2);
		
		TestDataInterface testData = new TestData("What is it?", testAnswers);
		
		entitymanager.getTransaction().begin();
		entitymanager.persist(a1);
		entitymanager.persist(a2);
		entitymanager.persist(testData);
		entitymanager.getTransaction().commit();
		
	}
    
    @Test
    public void testReadStoredDbItems(){
    	Query allTestsQuery = entitymanager.createQuery("SELECT t FROM TestData t");
    	Collection<TestData> allTests = (Collection<TestData>) allTestsQuery.getResultList();
    	
    	Iterator it = allTests.iterator();
    	
   		Assert.assertEquals(it.next().toString(), "Queastion: What is it? answers: [Answer1 (right), Answer2 (wrong)]");
    }*/
    
    @Test
    public void composeDataShouldReturnOneQuestion(){
    	TestModel testModel = new TestModel();
   	
		Answer a1 = new Answer("Sky", true);
		Answer a2 = new Answer("Sand", false);
    	
    	TestDataInterface testData = new TestData("Which one is blue?", Arrays.asList(new Answer[]{a1, a2})); 
    			
    	testModel.storeData(testData);
    	
		Answer a3 = new Answer("Twenty-four!", true);
		Answer a4 = new Answer("What how many?", false);
    	
    	TestDataInterface testData2 = new TestData("How many?", Arrays.asList(new Answer[]{a3, a4})); 
    			
    	testModel.storeData(testData2);
    	
    	TestDataInterface pickedQuestion = testModel.retrieveOneQuestion();
    	
    	for(int i=0; i < 10; i++){
    		System.out.println(testModel.retrieveOneQuestion());
    	}
    }
}
