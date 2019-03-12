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
	private Tuple B1;
	private Tuple B2;
	private Tuple B3;
	private Tuple B4;
	private Tuple B5;
	private Tuple B6;
	
	//AP topics
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
		ArrayList<Object> order = new ArrayList<>();
		order.add(username);
		order.add(password);
		order.add(B1);
		order.add(B2);
		order.add(B3);
		order.add(B4);
		order.add(B5);
		order.add(B6);
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
		order.add(standardJavaLibrary);
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

	public Tuple getB1() {
		return B1;
	}

	public void setB1(Tuple b1) {
		B1 = b1;
	}

	public Tuple getB2() {
		return B2;
	}

	public void setB2(Tuple b2) {
		B2 = b2;
	}

	public Tuple getB3() {
		return B3;
	}

	public void setB3(Tuple b3) {
		B3 = b3;
	}

	public Tuple getB4() {
		return B4;
	}

	public void setB4(Tuple b4) {
		B4 = b4;
	}

	public Tuple getB5() {
		return B5;
	}

	public void setB5(Tuple b5) {
		B5 = b5;
	}

	public Tuple getB6() {
		return B6;
	}

	public void setB6(Tuple b6) {
		B6 = b6;
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
