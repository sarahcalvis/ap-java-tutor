import org.junit.Test;

import org.junit.Assert;

public class StudentTest {

	@Test
	public void testStudentDefault() {
		Student stu = new Student();
		stu.setUsername("haha");
		String username = stu.username;
		System.out.println(username);
		String password = stu.password;
		System.out.println(password);
		Assert.assertEquals("haha", username);
		Assert.assertEquals("guest", password);
	}
	
	@Test
	public void testStudent() {
		Student stu = new Student("testing","hurts");
		Assert.assertEquals("testing", stu.username);
		Assert.assertEquals("hurts", stu.password);
	}

}
