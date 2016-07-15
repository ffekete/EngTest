package hu.epam.model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestModel {

	public TestDataInterface retrieveQuestionById(String id){
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "TestAnswers" );
	    EntityManager entityManager = emfactory.createEntityManager();
	    
	    TestDataInterface question =  entityManager.find(TestData.class, Long.parseLong(id));
	    question.getAnswers().size(); // instantiatin the list
	    
	    return question;
	}
	
	public TestDataInterface retrieveOneQuestion(){
		try {
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "TestAnswers" );
	    EntityManager entityManager = emfactory.createEntityManager();
		Query allTestsQuery = entityManager.createQuery("SELECT t FROM TestData t");
    	Collection<TestDataInterface> allTests = (Collection<TestDataInterface>) allTestsQuery.getResultList();
    	
    	Collections.shuffle((List<?>) allTests);
    	
    	Iterator it = allTests.iterator();
    	TestDataInterface testQuestion = null;
    	
    	if(it.hasNext()){
    		testQuestion = (TestDataInterface) it.next();
    	}
    	
    	testQuestion.getAnswers().size(); // instantiating indirect list

    	entityManager.close();
    	emfactory.close();
    	return testQuestion;
    	
	}
	
	public void storeData(TestDataInterface testData){
		if(testData == null || testData.getAnswers() == null) throw new IllegalArgumentException("Null object cannot be stored!");
		if(testData.getAnswers().size() == 0) throw new IllegalArgumentException("Question cannot be stored with zero answer");
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "TestAnswers" );
	    EntityManager entityManager = emfactory.createEntityManager();
	    
	    entityManager.getTransaction().begin();
	    
	    Iterator it = testData.getAnswers().iterator();
	    while(it.hasNext()){
	    	Answer a = (Answer) it.next();
	    	System.out.println("Answer to store: " + a);
	    	entityManager.persist(a);
	    }
	    
	    entityManager.persist(testData);
	    entityManager.getTransaction().commit();
	    
	    entityManager.close();
    	emfactory.close();
	}
}
