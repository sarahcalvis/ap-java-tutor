//import java.awt.Insets;
//import java.geometry;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx. *;


public class Main extends Application{

	public static void main(String[] args) {
        launch(args);
		
		/*
		System.out.println("Hello World!");
		System.out.println("I hate everything.");
		System.out.println("This is way harder than it needs to be.");
		System.out.println("Goodbye World!"); */
		
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AP Computer Science Prep");
        

        //creates a grid in the center
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        
        grid.setHgap(10);
        grid.setVgap(10);
        
        //controls padding around the edges
        grid.setPadding(new Insets(25,25,25,25));
        
        //makes size of the window
        Scene scene = new Scene(grid, 1080, 720);
        primaryStage.setScene(scene);
        
        //Layout Text for welcome screen
        Text scenetitle = new Text("Welcome Back!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
        grid.add(scenetitle, 12, 3, 2, 1);
        
        
        //
        //NAVIGATION BAR
        //Maybe copy this code for the other pages???
        //
        //home button
        Button home = new Button();
        home.setText("Home");
        home.setTextFill(Color.BLUE);
        home.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		System.out.println("Pressed Home Button");
        	}
        });
        grid.add(home, 5, 3,2,1);
        
        //textbook button
        Button textbk = new Button();
        textbk.setText("Textbook");
        textbk.setTextFill(Color.BLUE);
        textbk.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		System.out.println("Pressed Textbook Button");
        	}
        });
        grid.add(textbk, 4, 10,2,1);
        
        //lesson button
        Button lessons = new Button();
        lessons.setText("Lessons");
        lessons.setTextFill(Color.BLUE);
        lessons.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		System.out.println("Pressed Lessons Button");
        	}
        });
        grid.add(lessons, 5, 18,2,1);
        
        //Test/quizzes button
        Button exams = new Button();
        exams.setText("Quizzes and Exams");
        exams.setTextFill(Color.BLUE);
        exams.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		System.out.println("Pressed Exams Button");
        	}
        });
        grid.add(exams, 3, 25,5,1);
        
        //diagnostics button
        Button diagnostics = new Button();
        diagnostics.setText("Diagnostics");
        diagnostics.setTextFill(Color.BLUE);
        diagnostics.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		System.out.println("Pressed Diagnostics Button");
        	}
        });
        grid.add(diagnostics, 5, 33 ,5,1);
        
        //settings button
        Button settings = new Button();
        settings.setText("Settings");
        settings.setTextFill(Color.BLUE);
        settings.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		System.out.println("Pressed Settings Button");
        	}
        });
        grid.add(settings, 5, 40,5,1);
        
        //add style sheet
        //scene.getStylesheets().add
        //(Main.class.getResource("StyleForCAI.css").toExternalForm());
        primaryStage.show();
    }
}
