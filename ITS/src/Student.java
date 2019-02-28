import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Student {
	
	//Credentials
	private String username;
	private String password;
	
	//Vars for Bloom's 1-6
	private Double B1;
	private Double B2;
	private Double B3;
	private Double B4;
	private Double B5;
	private Double B6;
	
	//AP topics
	private Map<String,Double> comments;
	private Map<String,Double> primTypes;
	private Map<String,Double> operators;
	private Map<String,Double> objComparison;
	private Map<String,Double> escSeq;
	private Map<String,Double> IO;
	private Map<String,Double> nou;	//exceptions
	private Map<String,Double> arrays;
	private Map<String,Double> ctrlStatements;
	private Map<String,Double> vars;
	private Map<String,Double> methods;
	private Map<String,Double> constructors;
	private Map<String,Double> classes;
	private Map<String,Double> interfaces;
	private Map<String,Double> inheritance;
	private Map<String,Double> packages;
	private Map<String,Double> miscOOP;
	private Map<String,Double> standardJavaLibrary;
	
	public Student() {
		ArrayList<Object> order = new ArrayList<>();
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
		while(scn.hasNextLine()) {
			String nextLine = scn.nextLine();
			Scanner scan = new Scanner(nextLine);
		}
	}
}
