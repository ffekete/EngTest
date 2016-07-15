package hu.epam.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestModel {
	private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "TestAnswers" );
	
	public TestDataInterface retrieveQuestionById(String id){
		
	    EntityManager entityManager = emfactory.createEntityManager();
	    
	    TestDataInterface question =  entityManager.find(TestData.class, Long.parseLong(id));
	    question.getAnswers().size(); // instantiating the list
	    
	    entityManager.close();
	    return question;
	}
	
	public TestDataInterface retrieveOneQuestion(){
	    EntityManager entityManager = emfactory.createEntityManager();
		Query allTestsQuery = entityManager.createQuery("SELECT t FROM TestData t");
    	List<TestDataInterface> allTests = (List<TestDataInterface>) allTestsQuery.getResultList();
    	
    	Collections.shuffle((List<?>) allTests);
    	
    	Iterator<TestDataInterface> it = allTests.iterator();
    	TestDataInterface testQuestion = null;
    	
    	if(it.hasNext()){
    		testQuestion = (TestDataInterface) it.next();
    	}
    	
    	testQuestion.getAnswers().size(); // instantiating indirect list

    	entityManager.close();
    	return testQuestion;
    	
	}
	
	public void storeData(TestDataInterface testData){
		if(testData == null || testData.getAnswers() == null) throw new IllegalArgumentException("Null object cannot be stored!");
		if(testData.getAnswers().size() == 0) throw new IllegalArgumentException("Question cannot be stored with zero answer");
		
	    EntityManager entityManager = emfactory.createEntityManager();
	    
	    entityManager.getTransaction().begin();
	    
	    Iterator<Answer> it = testData.getAnswers().iterator();
	    while(it.hasNext()){
	    	Answer a = (Answer) it.next();
	    	System.out.println("Answer to store: " + a);
	    	entityManager.persist(a);
	    }
	    
	    entityManager.persist(testData);
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
	}
}
