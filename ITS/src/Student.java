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
		File f = new File("guest.bin");
		Scanner scn = null;
		try {
			if(f.createNewFile()) {
				FileInputStream fis = new FileInputStream(f);
				scn = new Scanner (fis);
				generateFile(f);
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
						name = "I/O";
						t = new Tuple(x,y);
						break;
					case 8:
						name = "Exceptions";
						t = new Tuple(x,y);
						break;
					case 9:
						name = "Arrays";
						t = new Tuple(x,y);
						break;
					case 10:
						name = "Control Statements";
						t = new Tuple(x,y);
						break;
					case 11:
						name = "Variables";
						t = new Tuple(x,y);
						break;
					case 12:
						name = "Methods";
						t = new Tuple(x,y);
						break;
					case 13:
						name = "Constructors";
						t = new Tuple(x,y);
						break;
					case 14:
						name = "Classes";
						t = new Tuple(x,y);						
						break;
					case 15:
						name = "Interfaces";
						t = new Tuple(x,y);
						break;
					case 16:
						name = "Inheritance";
						t = new Tuple(x,y);
						break;
					case 17:
						name = "Packages";
						t = new Tuple(x,y);
						break;
					case 18:
						name = "Miscellaneous Object Oriented Programming";
						t = new Tuple(x,y);
						break;
					case 19:
						name = "Standard Java Library";
						t = new Tuple(x,y);
						break;
					default:
						name = "You Broke Everything";
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
				generateFile(f);
				
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
			PrintWriter pw = new PrintWriter(f);
			pw.println(username + " " + password);
			for (int i = 0; i<quizzes.size();i++) {
				if(!(i==quizzes.size()-1)) {
					pw.print(quizzes.get(i));
					pw.print(" ");
				}
				else {
					pw.println(quizzes.get(i));
				}
			}
			for (int i = 0; i<tests.size();i++) {
				if(!(i==tests.size()-1)) {
					pw.print(tests.get(i));
					pw.print(" ");
				}
				else {
					pw.println(tests.get(i));
				}
			}
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Bloom "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Comments "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Primitive Types "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Operators "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Object Comparison "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Escape Sequences "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("I/O "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Exceptions "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Arrays "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Control Statements "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Variables "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Methods "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Constructors "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Classes "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Interfaces "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Inheritance "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Packages "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Miscellaneous Object Oriented Programming "+i).toString() + " ");
			}
			pw.println();
			for(int i = 1; i<7;i++) {
				pw.print(stats.get("Standard Java Library "+i).toString() + " ");
			}
			pw.flush();
			pw.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void generateFile(File f) throws FileNotFoundException {
		FileOutputStream fos = new FileOutputStream(f);
		PrintWriter pw = new PrintWriter(fos);
		pw.println("guest guest");
		pw.print("0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0");//quizzes
		pw.print("\n0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0");//tests
		pw.print("\n0 0 0 0 0 0 0 0 0 0 0 0");
		for(int i=0;i<18;i++) {
			pw.print("\n0 0");
		}
		pw.flush();
		pw.close();

		return;
	}

}
