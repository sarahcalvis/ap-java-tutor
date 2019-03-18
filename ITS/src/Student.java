import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Student {
	
	//Credentials
	private String username;
	private String password;
		
	//AP topics
	private Map<String,Tuple> stats;
	//private Tuple bloom;
	private Tuple comments;
	private Tuple primTypes;
	private Tuple operators;
	private Tuple objComparison;
	private Tuple escSeq;
	private Tuple IO;
	private Tuple nou;	//exceptions
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
	
	public Student() {
		stats = new HashMap<>();
		
		//TODO: file readers and writers (specifically for txt files) maybe look at streams for doing numbers?
		File f = new File("(default).txt");
		Scanner scn;
		if(!f.exists()) {
			//TODO: generate file
		}
		try {
			scn = new Scanner (f);
		} 
		catch (FileNotFoundException e) {
			scn = new Scanner("(default).txt");
			// TODO Auto-generated catch block
			//this should never trigger
			System.out.println("why the hecc is this triggering. you got problems in your default Student constructor");
			e.printStackTrace();
		}
		for(int i = 0; scn.hasNextLine(); i++) {
			String nextLine = scn.nextLine();
			System.out.println(nextLine);
			Scanner scan = new Scanner(nextLine);
			if (scan.hasNextInt()) {
				for(int j = 1;scan.hasNextInt();j++) {
					String name = "";
					Tuple t = new Tuple();
					switch(i) {
					case 1:
						name = ("Bloom"+j);
						//t = 
						break;
					case 2:
						name = "Comments";
						t = comments;
						break;
					case 3:
						name = "Primitive Types";
						t = primTypes;
						break;
					case 4:
						name = "Operators";
						t = operators;
						break;
					case 5:
						name = "Object Comparison";
						t = objComparison;
						break;
					case 6:
						name = "Escape Sequences";
						t = escSeq;
						break;
					case 7:
						name = "I/O";
						t = IO;
						break;
					case 8:
						name = "Exceptions";
						t = nou;
						break;
					case 9:
						name = "Arrays";
						t = arrays;
						break;
					case 10:
						name = "Control Statements";
						t = ctrlStatements;
						break;
					case 11:
						name = "Variables";
						t = vars;
						break;
					case 12:
						name = "Methods";
						t = methods;
						break;
					case 13:
						name = "Constructors";
						t = constructors;
						break;
					case 14:
						name = "Classes";
						t = classes;
						break;
					case 15:
						name = "Interfaces";
						t = interfaces;
						break;
					case 16:
						name = "Inheritance";
						t = inheritance;
						break;
					case 17:
						name = "Packages";
						t = packages;
						break;
					case 18:
						name = "Miscellaneous Object Oriented Programming";
						t = miscOOP;
						break;
					case 19:
						name = "Standard Java Library";
						t = standardJavaLibrary;
						break;
					default:
						name = "You Broke Everything";
						t = new Tuple();
					}					
					int x = scan.nextInt();
					int y = scan.nextInt();
					System.out.println(name);
					System.out.println(x + " " + y);
					t.x = x;
					t.y = y;
					stats.put(name, t);
				}
			}
			else {
				username = scan.next();
				password = scan.next();
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

	
	/*public Double getBloom() {
		return bloom.x / bloom.y *100.0;
	}

	public void setBloom(int numCorrect, int numAsked) {
		Tuple b = new Tuple();
		b.x = numCorrect;
		b.y = numAsked;
		bloom.x = numCorrect;
		bloom.y = numAsked;
	}*/

	public Double getComments() {
		return comments.x / comments.y * 100.0;
	}

	public void setComments(int numCorrect, int numAsked) {
		comments.x +=numCorrect;
		comments.y +=numAsked;
	}
	
	public Double getPrimTypes() {
		return primTypes.x / comments.y *100.0;
	}
	
	public void setPrimTypes(int numCorrect, int numAsked) {
		primTypes.x +=numCorrect;
		primTypes.y +=numAsked;
	}
	
	public Double getOperators() {
		return operators.x / operators.y *100.0;
	}
	
	public void setOperators(int numCorrect, int numAsked) {
		operators.x +=numCorrect;
		operators.y +=numAsked;
	}
}
