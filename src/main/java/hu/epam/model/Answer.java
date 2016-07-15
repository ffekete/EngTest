package hu.epam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Answer{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private long id;
	
	private String text;
	private boolean value;
	
	public Answer(){}
	
	public Answer(String text, boolean value) {
		this.text = text;
		this.value = value;
	}
	
	@Override
	public String toString(){
		return text + " ("+ (value?"right":"wrong") + ")";
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public long getId() {
		return id;
	}
	
	
}