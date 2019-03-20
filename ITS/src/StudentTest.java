import org.junit.Test;
import org.junit.Assert;

public class StudentTest {

	@Test
	public void testStudentDefault() {
		Student stu = new Student();
		stu.setUsername("haha");
		String username = stu.getUsername();
		Assert.assertEquals("haha", username);
		String password = stu.getPassword();
		Assert.assertEquals("guest", password);
	}
	
	@Test
	public void testStudent() {
		Student stu = new Student("testing","hurts");
		Assert.assertEquals("testing", stu.getUsername());
		Assert.assertEquals("hurts", stu.getUsername());
	}

}
