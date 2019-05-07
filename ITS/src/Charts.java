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
	//vbox to send to main
	public VBox vby; 
	
	//topics
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
    //bloom
    final String bloom1 = "Bloom 1";
    final String bloom2 = "Bloom 2";
    final String bloom3 = "Bloom 3";
    final String bloom4 = "Bloom 4";
    final String bloom5 = "Bloom 5";
    final String bloom6 = "Bloom 6";
    
	
	Charts(Student obj) {
		
		vby = new VBox(); 
		Map<String,Tuple> stats = obj.getStats();
		 
		//topics chart
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
            new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Percent Correct by Topic");
        //xAxis.setLabel("Topic");       
        yAxis.setLabel("Percent Correct");
        bc.setLegendVisible(false);
        
        XYChart.Series series1 = new XYChart.Series();
            
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
        
        bc.getData().addAll(series1);
        
        //bloom chart
        final CategoryAxis xAxis2 = new CategoryAxis();
        final NumberAxis yAxis2 = new NumberAxis();
        final BarChart<String,Number> bloomC = 
            new BarChart<String,Number>(xAxis2,yAxis2);
        bloomC.setTitle("Percent Correct by Bloom Level");
        //xAxis2.setLabel("Bloom Level");       
        yAxis2.setLabel("Percent Correct");
        bloomC.setLegendVisible(false);
        
        XYChart.Series series2 = new XYChart.Series();
        
        series2.getData().add(new XYChart.Data(bloom1, stats.get(bloom1).getTuple()));
        series2.getData().add(new XYChart.Data(bloom2, stats.get(bloom2).getTuple()));
        series2.getData().add(new XYChart.Data(bloom3, stats.get(bloom3).getTuple()));
        series2.getData().add(new XYChart.Data(bloom4, stats.get(bloom4).getTuple()));
        series2.getData().add(new XYChart.Data(bloom5, stats.get(bloom5).getTuple()));
        series2.getData().add(new XYChart.Data(bloom6, stats.get(bloom6).getTuple()));
        
        bloomC.getData().addAll(series2);
        
        vby.getChildren().addAll(bc, bloomC);

	}

    
    //getter that returns the viewbox
    public VBox getBox(){
		return vby;
    }

}

