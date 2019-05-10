import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PredictiveDiagnostics {
	public VBox vby; 
	
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
    ArrayList<String> strs = new ArrayList<String>();
    
	
	PredictiveDiagnostics(Student obj) {
		HashMap<String, String> writeme = new HashMap<String, String>();
	    Map<String,Tuple> stats = obj.getStats();
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
	    
	    String d = "";
		vby = new VBox(); 
		String s1 = "Brush Back Up";
		String s2 = "To Do";
		writeme.put(s1, "");
		writeme.put(s2, "");
		for (String s: strs) {
			try {
				if (stats.get(s).getTuple() < 0) {
					String st = writeme.get(s2);
					st += s + "\n";
					writeme.put(s2, st);
				}
				else if (stats.get(s).getTuple() < 70) {
					String st = writeme.get(s1);
					st += s + " " + stats.get(s).getTuple() + "\n";
					writeme.put(s1, st);
				}
			}
			catch (NullPointerException e) {
				d += s;
			}
		}
		Text t1 = new Text(s1);
		t1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		Text t1b = new Text(writeme.get(s1));
		t1b.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		Text t2 = new Text(s2);
		t2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		Text t2b = new Text(writeme.get(s2));
		t2b.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
		vby.getChildren().add(t1);
		vby.getChildren().add(t1b);
		vby.getChildren().add(t2);
		vby.getChildren().add(t2b);

	}

    //getter that returns the viewbox
    public VBox getBox(){
		return vby;
    }
}
