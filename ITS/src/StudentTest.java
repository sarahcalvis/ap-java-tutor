import org.junit.Test;


import org.junit.Assert;

public class StudentTest {

	@Test
	public void testStudent() {
		Student stu;
		stu = new Student();
		String username = stu.getUsername();
		Assert.assertEquals("guest", username);
		String password = stu.getPassword();
		Assert.assertEquals("guest", password);
	}

}
