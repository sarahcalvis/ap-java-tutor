import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
	//variables to hold the font choices
	

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

	//bloom
	final String bloom1 = "Bloom 1";
	final String bloom2 = "Bloom 2";
	final String bloom3 = "Bloom 3";
	final String bloom4 = "Bloom 4";
	final String bloom5 = "Bloom 5";
	final String bloom6 = "Bloom 6";

	//to hold these^
	ArrayList<String> bStrs = new ArrayList<String>();


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

		//add bloom strigns to bloom arraylist
		bStrs.add(bloom1);
		bStrs.add(bloom2);
		bStrs.add(bloom3);
		bStrs.add(bloom4);
		bStrs.add(bloom5);
		bStrs.add(bloom6);		

		//this is how we get the stats based on strs^
		Map<String,Tuple> stats = obj.getStats();

		//this holds all the things we write in our predictive diagnostics viewbox
		HashMap<String, String> writeme = new HashMap<String, String>();

		//initialize the viewbox
		vby = new VBox(); 
		
		//mini vboxes inside the one that's returned 
		VBox vb1 = new VBox();
		VBox vb2 = new VBox();

		//holds all the headings for the predictive diagnostics
		ArrayList<String> headings = new ArrayList<String>();

		//put the headings in the arraylist
		headings.add("Let's Revisit This: Topics where your grade is less than 70%");
		headings.add("To Do: Topics you haven't attempted");
		headings.add("Your areas of strength in Bloom's Taxonomy");
		headings.add("Your areas for improvement in Bloom's Taxonomy");
		headings.add("Bloomn't: Areas of Bloom you have not yet worked on");

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
					st += s + " " + Math.floor(stats.get(s).getTuple()*100)/100 + "\n";
					writeme.put(headings.get(0), st);
				}

			} catch(NullPointerException e) {
				System.out.println(s);
			}
		}

		//iterate through the levels of Bloom, adding them to our predictive diagnostics as needed
		for (String b: bStrs) {
			try {

				//if the topic is untouched
				if (stats.get(b).getTuple() < 0) {
					String st = writeme.get(headings.get(4));
					st += b + "\n";
					writeme.put(headings.get(4), st);
				}

				//else if the student has taken the quiz but they did not score well
				else if (stats.get(b).getTuple() < 70) {
					String st = writeme.get(headings.get(3));
					st += b + " " + Math.floor(stats.get(b).getTuple()*100)/100 + "\n";
					writeme.put(headings.get(3), st);
				}

				//else if the student has taken the quiz but they did not score well
				else if (stats.get(b).getTuple() > 70) {
					String st = writeme.get(headings.get(2));
					st += b + " " + Math.floor(stats.get(b).getTuple()*100)/100 + "\n";
					writeme.put(headings.get(2), st);
				}

			} catch(NullPointerException e) {
				System.out.println(b);
			}
		}

		//actually add the strings to our viewbox
		for (String h: headings) {
			//spaces for formatting
			Text spacey = new Text(" ");
			Text spacey2 = new Text(" ");
			Text spacey3 = new Text(" ");
			
			//heading
			Text t = new Text(h);
			//t.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
			t.setId("text");
			vby.getChildren().add(t);
			//vby.getChildren().add(spacey);

			//body
			Text tb = new Text(writeme.get(h));
			//tb.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
			tb.setId("diagnostics");
			vby.getChildren().add(tb);
			vby.getChildren().add(spacey2);
			//vby.getChildren().add(spacey3);
		}
	}

	/**
	 * @return the viewbox
	 */
	public VBox getBox(){
		return vby;
	}
}
