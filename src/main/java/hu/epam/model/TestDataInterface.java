package hu.epam.model;

import java.util.List;

public interface TestDataInterface {

	String getText();

	void setText(String text);

	List<Answer> getAnswers();

	void setAnswers(List<Answer> answers);

	long getId();

}