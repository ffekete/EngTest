package hu.epam.model;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TestData implements TestDataInterface {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	
	public void setId(long id) {
		this.id = id;
	}

	private String text;
	
	@OneToMany
	private List<Answer> answers;
	
	public TestData(){
		
	}
	
	public TestData(String text, List<Answer> answers){
		this.text = text;
		this.answers = answers;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public long getId() {
		return id;
	}
	
	@Override
	public String toString(){
		return "Queastion: " + this.text +" answers: " + this.answers;
	}
	
	public boolean evaluateAnswer(String answer){
		Iterator<Answer> it = answers.iterator();

		while(it.hasNext()){
			Answer a = it.next();
			if(a.getText().equals(answer)){
				return a.isValue();
			}
		}
		return false;	
	}
}
