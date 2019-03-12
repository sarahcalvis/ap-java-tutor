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
	private Tuple bloom;
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
			Scanner scan = new Scanner(nextLine);
			if (scan.hasNextInt()) {
				for(int j = 1;scan.hasNextInt();j++) {
					String name = "";
					switch(i) {
					case 1:
						name = ("Bloom"+j);
						break;
					case 2:
						name = "Comments";
						break;
					case 3:
						name = "Primitive Types";
						break;
					case 4:
						name = "Operators";
						break;
					case 5:
						name = "Object Comparison";
						break;
					case 6:
						name = "Escape Sequences";
						break;
					case 7:
						name = "I/O";
						break;
					case 8:
						name = "Exceptions";
						break;
					case 9:
						name = "Arrays";
						break;
					case 10:
						name = "Control Statements";
						break;
					case 11:
						name = "Variables";
						break;
					case 12:
						name = "Methods";
						break;
					case 13:
						name = "Constructors";
						break;
					case 14:
						name = "Classes";
						break;
					case 15:
						name = "Interfaces";
						break;
					case 16:
						name = "Inheritance";
						break;
					case 17:
						name = "Packages";
						break;
					case 18:
						name = "Miscellaneous Object Oriented Programming";
						break;
					case 19:
						name = "Standard Java Library";
						break;
					default:
						name = "You Broke Everything";
					}					
					int x = scan.nextInt();
					int y = scan.nextInt();
					Tuple t = new Tuple();
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

	
	public Double getBloom() {
		return bloom.x / bloom.y *100.0;
	}

	public void setBloom(int numCorrect, int numAsked) {
		this.bloom = bloom;
	}
}
