import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Responsible for recording Student progress, and maintaining user infor between sessions
 * @author MUMAWBM1
 *
 */
public class Student {

	public String username;
	public String password;
	
	//AP topics
	private Map<String,Tuple> stats;

	//test/quiz grades stored as %
	private ArrayList<Double> quizzes;
	private ArrayList<Double> tests;

	//private Tuple bloom;



	/**
	 * default Student Object Constructor
	 * sets username and password to guest by default
	 * (used mostly for file generation)
	 */
	public Student(){
		stats = new HashMap<>();
		quizzes =  new ArrayList<>();
		tests = new ArrayList<>();

		//TODO: file readers and writers (specifically for txt files) maybe look at streams for doing numbers?
		FileInputStream fis = null;
		DataInputStream dis = null;
		username = "guest";
		password = "guest";
		String fname = "guest" + password.hashCode() + ".bin";
		try {
			fis = new FileInputStream(fname);
			dis = new DataInputStream(fis);
		}
		catch (FileNotFoundException e) {
			generateFile(fname);
			try {
				fis = new FileInputStream(fname);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			dis = new DataInputStream(fis);
		} 
		//this.username = "guest";
		//this.password = "guest";
		Tuple t;	//for bloom only atm
		String name = "";
		try {
			for(int i = 0;i<4;i++) {
				tests.add(dis.readDouble());
			}
			for (int i = 1;i<7;i++) {
				name = ("Bloom "+i);
				t = new Tuple(dis.readInt(),dis.readInt());
				stats.put(name,t);
			}
			name = ("Comments");
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = ("Primitive Types");
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Operators";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Object Comparison";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Escape Sequences";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "I/O";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Exceptions";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Arrays";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Control Statements";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Variables";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Methods";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Constructors";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Classes";
			t = new Tuple(dis.readInt(),dis.readInt());	
			stats.put(name,t);
			name = "Interfaces";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Inheritance";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Packages";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Miscellaneous Object Oriented Programming";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Standard Java Library";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * enhanced Student Constructor
	 * allows for multiple accounts
	 * (still only used for file generation)
	 * @param username
	 * @param password
	 */
	public Student(String username, String password){
		stats = new HashMap<>();
		quizzes =  new ArrayList<>();
		tests = new ArrayList<>();

		//TODO: file readers and writers (specifically for txt files) maybe look at streams for doing numbers?
		FileInputStream fis = null;
		DataInputStream dis = null;
		this.username = username;
		this.password = password;
		String fname = username + password.hashCode() + ".bin";
		try {
			fis = new FileInputStream(fname);
			dis = new DataInputStream(fis);
		}
		catch (FileNotFoundException e) {
			generateFile(fname);
			try {
				fis = new FileInputStream(fname);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			dis = new DataInputStream(fis);
		} 
		//this.username = "guest";
		//this.password = "guest";
		Tuple t;	//for bloom only atm
		String name = "";
		try {
			for(int i = 0;i<4;i++) {
				tests.add(dis.readDouble());
			}
			for (int i = 1;i<7;i++) {
				name = ("Bloom "+i);
				t = new Tuple(dis.readInt(),dis.readInt());
				stats.put(name,t);
			}
			name = ("Comments");
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = ("Primitive Types");
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Operators";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Object Comparison";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Escape Sequences";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "I/O";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Exceptions";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Arrays";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Control Statements";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Variables";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Methods";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Constructors";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Classes";
			t = new Tuple(dis.readInt(),dis.readInt());	
			stats.put(name,t);
			name = "Interfaces";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Inheritance";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Packages";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Miscellaneous Object Oriented Programming";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
			name = "Standard Java Library";
			t = new Tuple(dis.readInt(),dis.readInt());
			stats.put(name,t);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}	

	public void setUsername(String username) {
		this.username = username;
		return;
	}

	public void setPassword(String password) {
		//TODO
		
	}

	public Map<String,Tuple> getStats(){
		return stats;
	}
	
	public ArrayList<Double> getQuizzes(){
		return quizzes;
	}
	
	public void updateQuiz(Double score, int quizNumber) {
		if (quizzes.get(quizNumber)<score) {
			quizzes.set(quizNumber, score);
			saveProgress();
		}
	}
	
	public ArrayList<Double> getTests() {
		return tests;
	}
	
	public void addTest(Double score, int testNumber) {
		if(tests.get(testNumber)<score) {
			tests.set(testNumber,score);
			saveProgress();
		}
	}

	public void saveProgress() {
		try {
			FileOutputStream f = new FileOutputStream(username+".bin");
			DataOutputStream dos = new DataOutputStream(f);
			try {

			for (int i = 0; i<tests.size();i++) {
				dos.writeDouble(tests.get(i));
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Bloom "+i).getX());
				dos.writeInt(stats.get("Bloom "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Comments "+i).getX());
				dos.writeInt(stats.get("Comments "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Primitive Types "+i).getX());
				dos.writeInt(stats.get("Primitive Types "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Operators "+i).getX());
				dos.writeInt(stats.get("Operators "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Object Comparison "+i).getX());
				dos.writeInt(stats.get("Object Comparison "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Escape Sequences "+i).getX());
				dos.writeInt(stats.get("Escape Sequences "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("I/O "+i).getX());
				dos.writeInt(stats.get("I/O "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Exceptions "+i).getX());
				dos.writeInt(stats.get("Exceptions "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Arrays "+i).getX());
				dos.writeInt(stats.get("Arrays "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Control Statements "+i).getX());
				dos.writeInt(stats.get("Control Statements "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Variables "+i).getX());
				dos.writeInt(stats.get("Variables "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Methods "+i).getX());
				dos.writeInt(stats.get("Methods "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Constructors "+i).getX());
				dos.writeInt(stats.get("Constructors "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Classes "+i).getX());
				dos.writeInt(stats.get("Classes "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Interfaces "+i).getX());
				dos.writeInt(stats.get("Interfaces "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Inheritance "+i).getX());
				dos.writeInt(stats.get("Inheritance "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Packages "+i).getX());
				dos.writeInt(stats.get("Packages "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Miscellaneous Object Oriented Programming "+i).getX());
				dos.writeInt(stats.get("Miscellaneous Object Oriented Programming "+i).getY());
			}
			for(int i = 1; i<7;i++) {
				dos.writeInt(stats.get("Standard Java Library "+i).getX());
				dos.writeInt(stats.get("Standard Java Library "+i).getY());
			}
			dos.flush();
			dos.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void generateFile(String filename){
		File f = new File(filename);
		if (f.exists()) {
			f.delete();
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataOutputStream dos = new DataOutputStream(fos);
		try {
			for(int i = 0;i<4;i++) {
				dos.writeDouble(0.0);
			}
			for(int i = 0;i<12;i++) {
				dos.writeInt(0);
			}
			for(int i=0;i<18;i++) {
				for(int j = 0;j<12;j++) {
					dos.writeInt(0);
				}
			}
			dos.flush();
			dos.close();
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}

		return;
	}

}