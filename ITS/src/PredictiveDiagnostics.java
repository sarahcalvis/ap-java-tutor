import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * @author CALVISSE1
 * this is a class that creates a predictive diagnostics viewbox
 */
public class PredictiveDiagnostics {
	//the viewbox to hold all of our predictive diagnostics
	public VBox vby; 

	//all of the topics we are assessing
	final String comments = "Comments";
	final String primTypes = "Primitive Types";
	final String operators = "Operators";
	final String objComparison = "Object Comparison";
	final String escSequence = "Escape Sequences";
	final String IO = "I/O";
	final String exceptions = "Exceptions";
	final String arrays = "Arrays";
	final String ctrlStatements = "Control Statements";
	final String vars = "Variables";
	final String methods = "Methods";
	final String constructors = "Constructors";
	final String classes = "Classes";
	final String interfaces = "Interfaces";
	final String inheritance = "Inheritence";
	final String packages = "Packages";
	final String miscOOP = "Miscellaneous Object Oriented Programming";
	final String standardJavaLibrary = "Standard Java Library";

	//to hold these^
	ArrayList<String> strs = new ArrayList<String>();


	/**
	 * @param obj takes a student object
	 * initialize the predictive diagnostics and create the viewbox
	 */
	PredictiveDiagnostics(Student obj) {
		//add the strings to the arraylist
		strs.add(comments);
		strs.add(primTypes);
		strs.add(operators);
		strs.add(objComparison);
		strs.add(escSequence);
		strs.add(IO);
		strs.add(exceptions);
		strs.add(arrays);
		strs.add(ctrlStatements);
		strs.add(vars);
		strs.add(methods);
		strs.add(constructors);
		strs.add(classes);
		strs.add(interfaces);
		strs.add(inheritance);
		strs.add(packages);
		strs.add(miscOOP);
		strs.add(standardJavaLibrary);

		//this is how we get the stats based on strs^
		Map<String,Tuple> stats = obj.getStats();

		//this holds all the things we write in our predictive diagnostics viewbox
		HashMap<String, String> writeme = new HashMap<String, String>();

		//initialize the viewbox
		vby = new VBox(); 

		//holds all the headings for the predictive diagnostics
		ArrayList<String> headings = new ArrayList<String>();

		//put the headings in the arraylist
		headings.add("Brush Back Up");
		headings.add("To Do");

		//also add those headings to the hashmap
		for (String h: headings) {
			writeme.put(h, "");
		}

		//iterate through the topics, adding them to our predictive diagnostics as needed
		for (String s: strs) {
			try {
				
				//if the topic is untouched
				if (stats.get(s).getTuple() < 0) {
					String st = writeme.get(headings.get(1));
					st += s + "\n";
					writeme.put(headings.get(1), st);
				}
				
				//else if the student has taken the quiz but they did not score well
				else if (stats.get(s).getTuple() < 70) {
					String st = writeme.get(headings.get(0));
					st += s + " " + stats.get(s).getTuple() + "\n";
					writeme.put(headings.get(0), st);
				}
				
			} catch(NullPointerException e) {
				System.out.println(s);
			}
		}
		
		//actually add the strings to our viewbox
		for (String h: headings) {
			//heading
			Text t = new Text(h);
			t.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			vby.getChildren().add(t);
			
			//body
			Text tb = new Text(writeme.get(h));
			tb.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
			vby.getChildren().add(tb);
		}
	}

	//getter that returns the viewbox
	public VBox getBox(){
		return vby;
	}
}
