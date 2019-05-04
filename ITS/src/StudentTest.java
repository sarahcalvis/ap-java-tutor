import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class StudentTest {

	@Test
	public void testStudentDefault() {
		Student stu = new Student();
		stu.setUsername("haha");
		String username = stu.username;
		Assert.assertEquals("haha", username);
		String password = stu.username;
		Assert.assertEquals("guest", password);
	}
	
	@Test
	public void testStudent() {
		Student stu = new Student("testing","hurts");
		Assert.assertEquals("testing", stu.username);
		Assert.assertEquals("hurts", stu.username);
	}
	
	@Test
	public void testFactory() throws JSONException, IOException, ParseException{
		ParseQuestions p = new ParseQuestions();
		FactoryBank factbanky = p.fillFactoryBank();
		TestBank banky = p.fillTestBank();
		
		ArrayList<String> topics = new ArrayList<String>();
		topics.add("Exceptions");
		topics.add("I/O");
		topics.add("Control Statements");
		topics.add("Methods");
		
		//factbanky.getQuest(topics.get(3), 0);
		
		//factbanky.getQuest("Exceptions", 0);
		Testing quiz = new Testing(1, topics, banky, factbanky);
	}

}
