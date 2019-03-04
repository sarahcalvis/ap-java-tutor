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

	public Double getB1() {
		return B1;
	}

	public void setB1(Double b1) {
		B1 = b1;
	}

	public Double getB2() {
		return B2;
	}

	public void setB2(Double b2) {
		B2 = b2;
	}

	public Double getB3() {
		return B3;
	}

	public void setB3(Double b3) {
		B3 = b3;
	}

	public Double getB4() {
		return B4;
	}

	public void setB4(Double b4) {
		B4 = b4;
	}

	public Double getB5() {
		return B5;
	}

	public void setB5(Double b5) {
		B5 = b5;
	}

	public Double getB6() {
		return B6;
	}

	public void setB6(Double b6) {
		B6 = b6;
	}

	public Map<String,Double> getComments() {
		return comments;
	}

	public void setComments(Map<String,Double> comments) {
		this.comments = comments;
	}

	public Map<String,Double> getPrimTypes() {
		return primTypes;
	}

	public void setPrimTypes(Map<String,Double> primTypes) {
		this.primTypes = primTypes;
	}

	public Map<String,Double> getOperators() {
		return operators;
	}

	public void setOperators(Map<String,Double> operators) {
		this.operators = operators;
	}

	public Map<String,Double> getObjComparison() {
		return objComparison;
	}

	public void setObjComparison(Map<String,Double> objComparison) {
		this.objComparison = objComparison;
	}

	public Map<String,Double> getEscSeq() {
		return escSeq;
	}

	public void setEscSeq(Map<String,Double> escSeq) {
		this.escSeq = escSeq;
	}

	public Map<String,Double> getIO() {
		return IO;
	}

	public void setIO(Map<String,Double> iO) {
		IO = iO;
	}

	public Map<String,Double> getNou() {
		return nou;
	}

	public void setNou(Map<String,Double> nou) {
		this.nou = nou;
	}

	public Map<String,Double> getArrays() {
		return arrays;
	}

	public void setArrays(Map<String,Double> arrays) {
		this.arrays = arrays;
	}

	public Map<String,Double> getCtrlStatements() {
		return ctrlStatements;
	}

	public void setCtrlStatements(Map<String,Double> ctrlStatements) {
		this.ctrlStatements = ctrlStatements;
	}

	public Map<String,Double> getVars() {
		return vars;
	}

	public void setVars(Map<String,Double> vars) {
		this.vars = vars;
	}

	public Map<String,Double> getMethods() {
		return methods;
	}

	public void setMethods(Map<String,Double> methods) {
		this.methods = methods;
	}

	public Map<String,Double> getConstructors() {
		return constructors;
	}

	public void setConstructors(Map<String,Double> constructors) {
		this.constructors = constructors;
	}

	public Map<String,Double> getClasses() {
		return classes;
	}

	public void setClasses(Map<String,Double> classes) {
		this.classes = classes;
	}

	public Map<String,Double> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(Map<String,Double> interfaces) {
		this.interfaces = interfaces;
	}

	public Map<String,Double> getInheritance() {
		return inheritance;
	}

	public void setInheritance(Map<String,Double> inheritance) {
		this.inheritance = inheritance;
	}

	public Map<String,Double> getPackages() {
		return packages;
	}

	public void setPackages(Map<String,Double> packages) {
		this.packages = packages;
	}

	public Map<String,Double> getMiscOOP() {
		return miscOOP;
	}

	public void setMiscOOP(Map<String,Double> miscOOP) {
		this.miscOOP = miscOOP;
	}

	public Map<String,Double> getStandardJavaLibrary() {
		return standardJavaLibrary;
	}

	public void setStandardJavaLibrary(Map<String,Double> standardJavaLibrary) {
		this.standardJavaLibrary = standardJavaLibrary;
	}
}
