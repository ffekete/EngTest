package hu.epam.model;

import java.util.ArrayList;
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
	
	public String text;
	
	@OneToMany
	public List<Answer> answers;
	
	public TestData(){
		
	}
	
	public TestData(String text, List<Answer> answers){
		this.text = text;
		this.answers = answers;
	}

	/* (non-Javadoc)
	 * @see hu.epam.model.TestModelInterface#getText()
	 */
	public String getText() {
		return text;
	}

	/* (non-Javadoc)
	 * @see hu.epam.model.TestModelInterface#setText(java.lang.String)
	 */
	public void setText(String text) {
		this.text = text;
	}

	/* (non-Javadoc)
	 * @see hu.epam.model.TestModelInterface#getAnswers()
	 */
	public List<Answer> getAnswers() {
		return answers;
	}

	/* (non-Javadoc)
	 * @see hu.epam.model.TestModelInterface#setAnswers(java.util.List)
	 */
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	/* (non-Javadoc)
	 * @see hu.epam.model.TestModelInterface#getId()
	 */
	public long getId() {
		return id;
	}
	
	@Override
	public String toString(){
		return "Queastion: " + this.text +" answers: " + this.answers;
	}
	
}
