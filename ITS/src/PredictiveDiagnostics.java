import java.util.ArrayList;
import java.util.Map;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PredictiveDiagnostics {
	public VBox vby; 
	static Student studentObj = new Student();
	
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
    
    Map<String,Tuple> stats = studentObj.getStats();
	
	PredictiveDiagnostics() {
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
		String st = "Brush Back Up\n";
		for (String s: strs) {
			try {
				if(stats.get(s).getTuple() < .7) {
					st += s + "\n";
				}
			}
			catch (NullPointerException e) {
				System.out.println(st);
				d += s;
			}
		}
		st+= "\nTo Do\n" + d;
		vby.getChildren().add(new Text(st));

	}

    //getter that returns the viewbox
    public VBox getBox(){
		return vby;
    }

}
