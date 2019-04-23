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
//		for (String s: strs) {
//			if(stats.get(s).getTuple() == -1) {
//				st += s + "\n";
//			}
//		}
		vby.getChildren().add(new Text(st));
		/*
		vby.getChildren().add(new Text("Brush Back Up"));
		for (String s: strs) {
			if(stats.get(s).getTuple() < .7) {
				vby.getChildren().add(new Text(s));
			}
		}
		
		vby.getChildren().add(new Text("To Do"));
		for (String s: strs) {
			if(stats.get(s).getTuple() == -1) {
				vby.getChildren().add(new Text(s));
			}
		}*/
		
//        final CategoryAxis xAxis = new CategoryAxis();
//        final NumberAxis yAxis = new NumberAxis();
//        final BarChart<String,Number> bc = 
//            new BarChart<String,Number>(xAxis,yAxis);
//        bc.setTitle("Percent Correct by Topic");
//        xAxis.setLabel("Topic");       
//        yAxis.setLabel("Percent Correct");
//        
//        XYChart.Series series1 = new XYChart.Series();
//        //series1.setName("Percent Correct");       
//        series1.getData().add(new XYChart.Data(comments, stats.get(comments).getTuple()));
//        series1.getData().add(new XYChart.Data(primTypes, stats.get(primTypes).getTuple()));
//        series1.getData().add(new XYChart.Data(operators, stats.get(operators).getTuple()));
//        series1.getData().add(new XYChart.Data(objComparison, stats.get(objComparison).getTuple()));
//        series1.getData().add(new XYChart.Data(escSequence, stats.get(escSequence).getTuple()));
//        series1.getData().add(new XYChart.Data(IO, stats.get(IO).getTuple()));
//        series1.getData().add(new XYChart.Data(exceptions, stats.get(exceptions).getTuple()));
//        series1.getData().add(new XYChart.Data(arrays, stats.get(arrays).getTuple()));
//        series1.getData().add(new XYChart.Data(ctrlStatements, stats.get(ctrlStatements).getTuple()));
//        series1.getData().add(new XYChart.Data(vars, stats.get(vars).getTuple()));
//        series1.getData().add(new XYChart.Data(methods, stats.get(methods).getTuple()));
//        series1.getData().add(new XYChart.Data(constructors, stats.get(constructors).getTuple()));
//        series1.getData().add(new XYChart.Data(classes, stats.get(classes).getTuple()));
//        series1.getData().add(new XYChart.Data(interfaces, stats.get(interfaces).getTuple()));
//        series1.getData().add(new XYChart.Data(packages, stats.get(packages).getTuple()));
//        series1.getData().add(new XYChart.Data("OOP", stats.get(miscOOP).getTuple()));
//        series1.getData().add(new XYChart.Data(standardJavaLibrary, stats.get(standardJavaLibrary).getTuple()));    
        
        
        //Scene scene  = new Scene(bc,1000,600);
        //bc.getData().addAll(series1);
        //stage.setScene(scene);
        //vby.getChildren().add(bc);
        //stage.show();
	}

    
    //getter that returns the viewbox
    public VBox getBox(){
		return vby;
    }

}
