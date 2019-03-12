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
	private Map<String,Tuple> bloom;
	private Map<String,Tuple> comments;
	private Map<String,Tuple> primTypes;
	private Map<String,Tuple> operators;
	private Map<String,Tuple> objComparison;
	private Map<String,Tuple> escSeq;
	private Map<String,Tuple> IO;
	private Map<String,Tuple> nou;	//exceptions
	private Map<String,Tuple> arrays;
	private Map<String,Tuple> ctrlStatements;
	private Map<String,Tuple> vars;
	private Map<String,Tuple> methods;
	private Map<String,Tuple> constructors;
	private Map<String,Tuple> classes;
	private Map<String,Tuple> interfaces;
	private Map<String,Tuple> inheritance;
	private Map<String,Tuple> packages;
	private Map<String,Tuple> miscOOP;
	private Map<String,Tuple> standardJavaLibrary;
	
	public Student() {
		stats = new HashMap<>();
		/*order.add(bloom);
		order.add(comments);
		order.add(primTypes);
		order.add(operators);
		order.add(objComparison);
		order.add(escSeq);
		order.add(IO);
		order.add(nou);
		order.add(arrays);
		order.add(ctrlStatements);
		order.add(vars);
		order.add(methods);
		order.add(constructors);
		order.add(classes);
		order.add(interfaces);
		order.add(inheritance);
		order.add(packages);
		order.add(miscOOP);
		order.add(standardJavaLibrary);*/
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

	public Map<String,Tuple> getBloom() {
		return bloom;
	}

	public void setBloom(Map<String,Tuple> bloom) {
		this.bloom = bloom;
	}

	public Map<String,Tuple> getComments() {
		return comments;
	}

	public void setComments(Map<String,Tuple> comments) {
		this.comments = comments;
	}

	public Map<String,Tuple> getPrimTypes() {
		return primTypes;
	}

	public void setPrimTypes(Map<String,Tuple> primTypes) {
		this.primTypes = primTypes;
	}

	public Map<String,Tuple> getOperators() {
		return operators;
	}

	public void setOperators(Map<String,Tuple> operators) {
		this.operators = operators;
	}

	public Map<String,Tuple> getObjComparison() {
		return objComparison;
	}

	public void setObjComparison(Map<String,Tuple> objComparison) {
		this.objComparison = objComparison;
	}

	public Map<String,Tuple> getEscSeq() {
		return escSeq;
	}

	public void setEscSeq(Map<String,Tuple> escSeq) {
		this.escSeq = escSeq;
	}

	public Map<String,Tuple> getIO() {
		return IO;
	}

	public void setIO(Map<String,Tuple> iO) {
		IO = iO;
	}

	public Map<String,Tuple> getNou() {
		return nou;
	}

	public void setNou(Map<String,Tuple> nou) {
		this.nou = nou;
	}

	public Map<String,Tuple> getArrays() {
		return arrays;
	}

	public void setArrays(Map<String,Tuple> arrays) {
		this.arrays = arrays;
	}

	public Map<String,Tuple> getCtrlStatements() {
		return ctrlStatements;
	}

	public void setCtrlStatements(Map<String,Tuple> ctrlStatements) {
		this.ctrlStatements = ctrlStatements;
	}

	public Map<String,Tuple> getVars() {
		return vars;
	}

	public void setVars(Map<String,Tuple> vars) {
		this.vars = vars;
	}

	public Map<String,Tuple> getMethods() {
		return methods;
	}

	public void setMethods(Map<String,Tuple> methods) {
		this.methods = methods;
	}

	public Map<String,Tuple> getConstructors() {
		return constructors;
	}

	public void setConstructors(Map<String,Tuple> constructors) {
		this.constructors = constructors;
	}

	public Map<String,Tuple> getClasses() {
		return classes;
	}

	public void setClasses(Map<String,Tuple> classes) {
		this.classes = classes;
	}

	public Map<String,Tuple> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(Map<String,Tuple> interfaces) {
		this.interfaces = interfaces;
	}

	public Map<String,Tuple> getInheritance() {
		return inheritance;
	}

	public void setInheritance(Map<String,Tuple> inheritance) {
		this.inheritance = inheritance;
	}

	public Map<String,Tuple> getPackages() {
		return packages;
	}

	public void setPackages(Map<String,Tuple> packages) {
		this.packages = packages;
	}

	public Map<String,Tuple> getMiscOOP() {
		return miscOOP;
	}

	public void setMiscOOP(Map<String,Tuple> miscOOP) {
		this.miscOOP = miscOOP;
	}

	public Map<String,Tuple> getStandardJavaLibrary() {
		return standardJavaLibrary;
	}

	public void setStandardJavaLibrary(Map<String,Tuple> standardJavaLibrary) {
		this.standardJavaLibrary = standardJavaLibrary;
	}
}
