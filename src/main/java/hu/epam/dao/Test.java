package hu.epam.dao;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test {

	public class Answer{
		private String text;
		private boolean value;
	}
	
	@Id
	private long id;
	
	public String text;
	
	public ArrayList<Answer> answers;
	
	
}
