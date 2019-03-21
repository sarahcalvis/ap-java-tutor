import java.io.File;
import java.io.FileNotFoundException;
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
	private Tuple bloom1;
	private Tuple bloom2;
	private Tuple bloom3;
	private Tuple bloom4;
	private Tuple bloom5;
	private Tuple bloom6;
	private Tuple comments;
	private Tuple primTypes;
	private Tuple operators;
	private Tuple objComparison;
	private Tuple escSeq;
	private Tuple IO;
	private Tuple exceptions;
	private Tuple arrays;
	private Tuple ctrlStatements;
	private Tuple vars;
	private Tuple methods;
	private Tuple constructors;
	private Tuple classes;
	private Tuple interfaces;
	private Tuple inheritance;
	private Tuple packages;
	private Tuple miscOOP;
	private Tuple standardJavaLibrary;
	
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
		File f = new File("guest.txt");
		Scanner scn = null;
		try {
			if(f.createNewFile()) {
				scn = new Scanner (f);
				generateFile(f);
			}
		}
		catch (FileNotFoundException e) {
			scn = new Scanner("(default).txt");
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
						switch(j) {
						case 1:
							bloom1 = new Tuple(x,y);
							t = bloom1;
							break;
						case 2:
							bloom2 = new Tuple(x,y);
							t = bloom2;
							break;
						case 3:
							bloom3 = new Tuple(x,y);
							t = bloom3;
							break;
						case 4:
							bloom4 = new Tuple(x,y);
							t = bloom4;
							break;
						case 5:
							bloom5 = new Tuple(x,y);
							t = bloom5;
							break;
						case 6:
							bloom6 = new Tuple(x,y);
							t = bloom6;
							break;
						default:
							name = "You Broke Everything";
							t = new Tuple(x,y);
						}
						break;
					case 2:
						name = "Comments";
						comments = new Tuple(x,y);
						t = comments;
						break;
					case 3:
						name = "Primitive Types";
						primTypes = new Tuple(x,y);
						t = primTypes;
						
						break;
					case 4:
						name = "Operators";
						operators = new Tuple(x,y);
						t = operators;
						break;
					case 5:
						name = "Object Comparison";
						objComparison = new Tuple(x,y);
						t = objComparison;
						break;
					case 6:
						name = "Escape Sequences";
						escSeq = new Tuple(x,y);
						t = escSeq;
						break;
					case 7:
						name = "I/O";
						IO = new Tuple(x,y);
						t = IO;
						break;
					case 8:
						name = "Exceptions";
						exceptions = new Tuple(x,y);
						t = exceptions;
						break;
					case 9:
						name = "Arrays";
						arrays = new Tuple(x,y);
						t = arrays;
						break;
					case 10:
						name = "Control Statements";
						ctrlStatements = new Tuple(x,y);
						t = ctrlStatements;
						break;
					case 11:
						name = "Variables";
						vars = new Tuple(x,y);
						t = vars;
						break;
					case 12:
						name = "Methods";
						methods = new Tuple(x,y);
						t = methods;
						break;
					case 13:
						name = "Constructors";
						constructors = new Tuple(x,y);
						t = constructors;
						break;
					case 14:
						name = "Classes";
						classes = new Tuple(x,y);
						t = classes;						
						break;
					case 15:
						name = "Interfaces";
						interfaces = new Tuple(x,y);
						t = interfaces;
						break;
					case 16:
						name = "Inheritance";
						inheritance = new Tuple(x,y);
						t = inheritance;
						break;
					case 17:
						name = "Packages";
						packages = new Tuple(x,y);
						t = packages;
						break;
					case 18:
						name = "Miscellaneous Object Oriented Programming";
						miscOOP = new Tuple(x,y);
						t = miscOOP;
						break;
					case 19:
						name = "Standard Java Library";
						standardJavaLibrary = new Tuple(x,y);
						t = standardJavaLibrary;
						break;
					default:
						name = "You Broke Everything";
						t = new Tuple(x,y);
					}
					stats.put(name, t);
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
	public Student(String username, String password) {
		stats = new HashMap<>();
		quizzes = new ArrayList<>();
		tests = new ArrayList<>();
		File f = new File(username + ".txt");
		Scanner scn = null;
		try {
			if(f.createNewFile()) {
				scn = new Scanner (f);
				generateFile(f);
			}
		}
		catch (FileNotFoundException e) {
			scn = new Scanner("(default).txt");
			//this should never trigger
			System.out.println("why the hecc is this triggering. you got problems in your default Student constructor");
			e.printStackTrace();
		} catch (IOException e) {
			scn = new Scanner(System.in);
			//this should never trigger
			System.out.println("why the hecc is this triggering. you got problems in your default Student constructor");
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
						switch(j) {
						case 1:
							bloom1 = new Tuple(x,y);
							t = bloom1;
							break;
						case 2:
							bloom2 = new Tuple(x,y);
							t = bloom2;
							break;
						case 3:
							bloom3 = new Tuple(x,y);
							t = bloom3;
							break;
						case 4:
							bloom4 = new Tuple(x,y);
							t = bloom4;
							break;
						case 5:
							bloom5 = new Tuple(x,y);
							t = bloom5;
							break;
						case 6:
							bloom6 = new Tuple(x,y);
							t = bloom6;
							break;
						default:
							name = "You Broke Everything";
							t = new Tuple(x,y);
						}
						break;
					case 2:
						name = "Comments";
						comments = new Tuple(x,y);
						t = comments;
						break;
					case 3:
						name = "Primitive Types";
						primTypes = new Tuple(x,y);
						t = primTypes;
						
						break;
					case 4:
						name = "Operators";
						operators = new Tuple(x,y);
						t = operators;
						break;
					case 5:
						name = "Object Comparison";
						objComparison = new Tuple(x,y);
						t = objComparison;
						break;
					case 6:
						name = "Escape Sequences";
						escSeq = new Tuple(x,y);
						t = escSeq;
						break;
					case 7:
						name = "I/O";
						IO = new Tuple(x,y);
						t = IO;
						break;
					case 8:
						name = "Exceptions";
						exceptions = new Tuple(x,y);
						t = exceptions;
						break;
					case 9:
						name = "Arrays";
						arrays = new Tuple(x,y);
						t = arrays;
						break;
					case 10:
						name = "Control Statements";
						ctrlStatements = new Tuple(x,y);
						t = ctrlStatements;
						break;
					case 11:
						name = "Variables";
						vars = new Tuple(x,y);
						t = vars;
						break;
					case 12:
						name = "Methods";
						methods = new Tuple(x,y);
						t = methods;
						break;
					case 13:
						name = "Constructors";
						constructors = new Tuple(x,y);
						t = constructors;
						break;
					case 14:
						name = "Classes";
						classes = new Tuple(x,y);
						t = classes;						
						break;
					case 15:
						name = "Interfaces";
						interfaces = new Tuple(x,y);
						t = interfaces;
						break;
					case 16:
						name = "Inheritance";
						inheritance = new Tuple(x,y);
						t = inheritance;
						break;
					case 17:
						name = "Packages";
						packages = new Tuple(x,y);
						t = packages;
						break;
					case 18:
						name = "Miscellaneous Object Oriented Programming";
						miscOOP = new Tuple(x,y);
						t = miscOOP;
						break;
					case 19:
						name = "Standard Java Library";
						standardJavaLibrary = new Tuple(x,y);
						t = standardJavaLibrary;
						break;
					default:
						name = "You Broke Everything";
						t = new Tuple(x,y);
					}
					stats.put(name, t);
				}
			}
			
			else if(scan.hasNextDouble()) {
				for (int j = 0; scan.hasNextDouble(); j++) {
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
				this.username = username;
				this.password = password;
			}
		}		
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
		}
	}
	
	public ArrayList<Double> getTests() {
		return tests;
	}
	
	public void addTest(Double score, int testNumber) {
		if(tests.get(testNumber)<score) {
			tests.set(testNumber,score);
		}
	}

	public void saveProgress() {
		try {
			PrintWriter pw = new PrintWriter(username+".txt");
			pw.println(username + " "+ password);
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
			pw.print(stats.get("Bloom 1").toString() + " ");
			pw.print(stats.get("Bloom 2").toString() + " ");
			pw.print(stats.get("Bloom 3").toString() + " ");
			pw.print(stats.get("Bloom 4").toString() + " ");
			pw.print(stats.get("Bloom 5").toString() + " ");
			pw.println(stats.get("Bloom 6").toString());
			pw.println(stats.get("Comments").toString());
			pw.println(stats.get("Primitive Types").toString());
			pw.println(stats.get("Operators").toString());
			pw.println(stats.get("Object Comparison").toString());
			pw.println(stats.get("Escape Sequences").toString());
			pw.println(stats.get("I/O").toString());
			pw.println(stats.get("Exceptions").toString());
			pw.println(stats.get("Arrays").toString());
			pw.println(stats.get("Control Statements").toString());
			pw.println(stats.get("Variables").toString());
			pw.println(stats.get("Methods").toString());
			pw.println(stats.get("Constructors").toString());
			pw.println(stats.get("Classes").toString());
			pw.println(stats.get("Interfaces").toString());
			pw.println(stats.get("Packages").toString());
			pw.print(stats.get("Miscellaneous Object Oriented Programming").toString());
			pw.flush();
			pw.close();


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void generateFile(File f) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(f);
		pw.print("guest guest");
		pw.print("\n0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0");//quizzes
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
