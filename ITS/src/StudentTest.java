import org.junit.Test;
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
	
	public void testStudent() {
		Student stu = new Student("fuck","no");
		Assert.assertEquals("fuck", stu.getUsername());
		Assert.assertEquals("no", stu.getUsername());
	}

}
