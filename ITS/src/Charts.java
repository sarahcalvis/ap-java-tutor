import java.util.Map;

import com.sun.corba.se.pept.transport.EventHandler;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class Charts {
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
    

    //Map<String,Tuple> stats = studentObj.getStats();
	
	Charts(Student obj) {
		vby = new VBox(); 
		Map<String,Tuple> stats = obj.getStats();
		 //scene.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Percent Correct by Topic");
        xAxis.setLabel("Topic");       
        yAxis.setLabel("Percent Correct");
        bc.setLegendVisible(false);
        
        XYChart.Series series1 = new XYChart.Series();
        //series1.setName("Percent Correct");       
        series1.getData().add(new XYChart.Data(comments, stats.get(comments).getTuple()));
        series1.getData().add(new XYChart.Data(primTypes, stats.get(primTypes).getTuple()));
        series1.getData().add(new XYChart.Data(operators, stats.get(operators).getTuple()));
        series1.getData().add(new XYChart.Data(objComparison, stats.get(objComparison).getTuple()));
        series1.getData().add(new XYChart.Data(escSequence, stats.get(escSequence).getTuple()));
        series1.getData().add(new XYChart.Data(IO, stats.get(IO).getTuple()));
        series1.getData().add(new XYChart.Data(exceptions, stats.get(exceptions).getTuple()));
        series1.getData().add(new XYChart.Data(arrays, stats.get(arrays).getTuple()));
        series1.getData().add(new XYChart.Data(ctrlStatements, stats.get(ctrlStatements).getTuple()));
        series1.getData().add(new XYChart.Data(vars, stats.get(vars).getTuple()));
        series1.getData().add(new XYChart.Data(methods, stats.get(methods).getTuple()));
        series1.getData().add(new XYChart.Data(constructors, stats.get(constructors).getTuple()));
        series1.getData().add(new XYChart.Data(classes, stats.get(classes).getTuple()));
        series1.getData().add(new XYChart.Data(interfaces, stats.get(interfaces).getTuple()));
        series1.getData().add(new XYChart.Data(packages, stats.get(packages).getTuple()));
        series1.getData().add(new XYChart.Data("OOP", stats.get(miscOOP).getTuple()));
        series1.getData().add(new XYChart.Data(standardJavaLibrary, stats.get(standardJavaLibrary).getTuple()));    
        
        
        //Scene scene  = new Scene(bc,1000,600);
        bc.getData().addAll(series1);
        //stage.setScene(scene);
        vby.getChildren().add(bc);
        //stage.show();
	}

    
    //getter that returns the viewbox
    public VBox getBox(){
		return vby;
    }

}

