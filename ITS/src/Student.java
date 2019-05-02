import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
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
	
	//Credentials
	private String username;
	private String password;
		
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
		Scanner scn = null;
		try {
				fis = new FileInputStream("guest.bin");
				DataInputStream dis = new DataInputStream(fis);
				scn = new Scanner (dis);
		}
		catch (FileNotFoundException e) {
			generateFile("guest.bin","guest","guest");
			scn = new Scanner("guest.bin");
		} 
		scn = new Scanner (fis);
		for(int i = 0; scn.hasNextLine(); i++) {
			String nextLine = scn.nextLine();
			System.out.println(nextLine);
			Scanner scan = new Scanner(nextLine);
			if (scan.hasNextInt()) {
				for(int j = 1;scan.hasNextInt();j++) {
					String name = "";
					Tuple t;	//for bloom only atm
					int x = scan.nextInt();
					int y = scan.nextInt();
					switch(i) {
					case 1:
						name = ("Bloom "+j);
						t = new Tuple(x,y);
						break;
					case 2:
						name = ("Comments "+j);
						t = new Tuple(x,y);
						break;
					case 3:
						name = ("Primitive Types "+j);
						t = new Tuple(x,y);
						break;
					case 4:
						name = "Operators "+j;
						t = new Tuple(x,y);
						break;
					case 5:
						name = "Object Comparison "+j;
						t = new Tuple(x,y);
						break;
					case 6:
						name = "Escape Sequences "+j;
						t = new Tuple(x,y);
						break;
					case 7:
						name = "I/O "+j;
						t = new Tuple(x,y);
						break;
					case 8:
						name = "Exceptions "+j;
						t = new Tuple(x,y);
						break;
					case 9:
						name = "Arrays "+j;
						t = new Tuple(x,y);
						break;
					case 10:
						name = "Control Statements "+j;
						t = new Tuple(x,y);
						break;
					case 11:
						name = "Variables "+j;
						t = new Tuple(x,y);
						break;
					case 12:
						name = "Methods "+j;
						t = new Tuple(x,y);
						break;
					case 13:
						name = "Constructors "+j;
						t = new Tuple(x,y);
						break;
					case 14:
						name = "Classes "+j;
						t = new Tuple(x,y);						
						break;
					case 15:
						name = "Interfaces "+j;
						t = new Tuple(x,y);
						break;
					case 16:
						name = "Inheritance "+j;
						t = new Tuple(x,y);
						break;
					case 17:
						name = "Packages "+j;
						t = new Tuple(x,y);
						break;
					case 18:
						name = "Miscellaneous Object Oriented Programming "+j;
						t = new Tuple(x,y);
						break;
					case 19:
						name = "Standard Java Library "+j;
						t = new Tuple(x,y);
						break;
					default:
						name = "You Broke Everything "+j;
						t = new Tuple(x,y);
					}
					stats.put(name,t);
				}
			}
			else if(scan.hasNextDouble()) {
				for (int j = 0; scan.hasNextDouble(); j++) {
					System.out.println(j);
					if(i==1) {
						quizzes.add(j,scan.nextDouble());
					}
					else if(i==2) {
						tests.add(j,scan.nextDouble());
					}
				}
				if(i==2) {
					i=0;
				}
			}
			else {
				username = scan.next();
				password = scan.next();
			}
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
		File f = new File(username+".bin");
		Scanner scn = null;
		try {
			if(f.createNewFile()) {
				FileInputStream fis = new FileInputStream(f);
				scn = new Scanner (fis);
				generateFile(username+".bin",username,password);
				
			}
		}
		catch (FileNotFoundException e) {
			scn = new Scanner("guest.bin");
			//this should never trigger
			e.printStackTrace();
		} catch (IOException e) {
			scn = new Scanner(System.in);
			//this should never trigger
			e.printStackTrace();
		}
		try {
			scn = new Scanner (f);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 0; scn.hasNextLine(); i++) {
			String nextLine = scn.nextLine();
			Scanner scan = new Scanner(nextLine);
			if (scan.hasNextInt()) {
				for(int j = 1;scan.hasNextInt();j++) {
					String name = "";
					Tuple t;	//for bloom only atm
					int x = scan.nextInt();
					int y = scan.nextInt();
					switch(i) {
					case 1:
						name = ("Bloom "+j);
						t = new Tuple(x,y);
						break;
					case 2:
						name = ("Comments "+j);
						t = new Tuple(x,y);
						break;
					case 3:
						name = ("Primitive Types "+j);
						t = new Tuple(x,y);
						break;
					case 4:
						name = "Operators "+j;
						t = new Tuple(x,y);
						break;
					case 5:
						name = "Object Comparison "+j;
						t = new Tuple(x,y);
						break;
					case 6:
						name = "Escape Sequences "+j;
						t = new Tuple(x,y);
						break;
					case 7:
						name = "I/O "+j;
						t = new Tuple(x,y);
						break;
					case 8:
						name = "Exceptions "+j;
						t = new Tuple(x,y);
						break;
					case 9:
						name = "Arrays "+j;
						t = new Tuple(x,y);
						break;
					case 10:
						name = "Control Statements "+j;
						t = new Tuple(x,y);
						break;
					case 11:
						name = "Variables "+j;
						t = new Tuple(x,y);
						break;
					case 12:
						name = "Methods "+j;
						t = new Tuple(x,y);
						break;
					case 13:
						name = "Constructors "+j;
						t = new Tuple(x,y);
						break;
					case 14:
						name = "Classes "+j;
						t = new Tuple(x,y);						
						break;
					case 15:
						name = "Interfaces "+j;
						t = new Tuple(x,y);
						break;
					case 16:
						name = "Inheritance "+j;
						t = new Tuple(x,y);
						break;
					case 17:
						name = "Packages "+j;
						t = new Tuple(x,y);
						break;
					case 18:
						name = "Miscellaneous Object Oriented Programming "+j;
						t = new Tuple(x,y);
						break;
					case 19:
						name = "Standard Java Library "+j;
						t = new Tuple(x,y);
						break;
					default:
						name = "You Broke Everything "+j;
						t = new Tuple(x,y);
					}
					stats.put(name,t);
				}
			}
			else if(scan.hasNextDouble()) {
				for (int j = 0; scan.hasNextDouble(); j++) {
					System.out.println(j);
					if(i==1) {
						quizzes.add(j,scan.nextDouble());
					}
					else if(i==2) {
						tests.add(j,scan.nextDouble());
					}
				}
				if(i==2) {
					i=0;
				}
			}
			else {
				this.username = scan.next();
				this.password = scan.next();
			}
		}
		this.username = username;
		this.password = password;
	}	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
			dos.writeBytes(username + " " + password);

			for (int i = 0; i<tests.size();i++) {
				if(!(i==tests.size()-1)) {
					dos.writeDouble(tests.get(i));
				}
				else {
					dos.writeDouble(tests.get(i));
				}
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

	public void generateFile(String filename, String username, String password){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataOutputStream dos = new DataOutputStream(fos);
		try {
			dos.writeBytes(username+ " " +password);
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
