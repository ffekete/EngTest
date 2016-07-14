package hu.epam.daotest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import hu.epam.controller.TestController;
import hu.epam.model.Answer;
import hu.epam.model.TestModel;
import hu.epam.model.TestModelInterface;


public class DaoTest{

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "TestAnswers" );
    EntityManager entitymanager = emfactory.createEntityManager();
    TestController testController;
    
	@BeforeSuite
	public void createTestObject(){
		this.testController = new TestController(new ArrayList<TestModelInterface>(), entitymanager);
		
		ArrayList<Answer> testAnswers = new ArrayList<Answer>();
		Answer a1 = new Answer("Answer1", true);
		Answer a2 = new Answer("Answer2", false);
		
		testAnswers.add(a1);
		testAnswers.add(a2);
		
		TestModelInterface testModel = new TestModel("What is it?", testAnswers);
		
		entitymanager.getTransaction().begin();
		entitymanager.persist(a1);
		entitymanager.persist(a2);
		entitymanager.persist(testModel);
		entitymanager.getTransaction().commit();
		
	}
    
    @Test
    public void testReadStoredDbItems(){
    	Query allTestsQuery = entitymanager.createQuery("SELECT t FROM TestModel t");
    	Collection<TestModel> allTests = (Collection<TestModel>) allTestsQuery.getResultList();
    	
    	Iterator it = allTests.iterator();
    	
   		Assert.assertEquals(it.next().toString(), "Queastion: What is it? answers: [Answer1 (right), Answer2 (wrong)]");
    }
}
