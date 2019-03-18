import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

public class StudentTest {
	
	@Test
	public void testStudent() {
		Student stu;
		try {
			stu = new Student();
			String username = stu.getUsername();
			Assert.assertEquals("guest", username);
			String password = stu.getPassword();
			Assert.assertEquals("guest", password);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Assert.assertEquals(0,2);
		} catch (IOException e) {
			Assert.assertEquals(0, 2);
			e.printStackTrace();
		}
		
	}
	
}
