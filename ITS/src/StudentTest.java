import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class StudentTest {

	@Test
	public void testStudentDefault() {
		Student stu = new Student();
		String username = stu.getUsername();
		Assert.assertEquals("guest", username);
		String password = stu.getPassword();
		Assert.assertEquals("guest", password);
	}
	
	@Test
	public void testStudent() {
		Student stu = new Student("Acct","hurts");
		Assert.assertEquals("Acct", stu.getUsername());
		Assert.assertEquals("hurts", stu.getPassword());
		String s = "hurts";
		File f = new File("Acct"+s.hashCode()+".bin");
		f.delete();
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

	@Test
	public void testLogin() {
		String u = "Login";
		String r = "test";
		Student s = new Student(u,r);
		Student t = s.login(u, r);
		File f = new File(u+r.hashCode()+".bin");
		f.delete();
		Assert.assertEquals(s.equals(t), true);
	}
	
	@Test
	public void testReset() {
		String u = "Reset";
		String p = "test";
		Student s = new Student(u,p);
		s.getStats().get("I/O").updateTuple(1, 2, s);
		s = s.resetProgress();
		Assert.assertEquals(-1.0, s.getStats().get("I/O").getTuple(),.0001);
		File f = new File(u+p.hashCode()+".bin");
		f.delete();
	}
}
