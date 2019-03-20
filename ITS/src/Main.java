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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javafx. *;


public class Main /*extends Application*/{

	public static void main(String[] args) throws FileNotFoundException, IOException {
        //launch(args);
		
		System.out.println("Hello World!");
		System.out.println("I hate everything.");
		System.out.println("This is way harder than it needs to be.");
		System.out.println("Goodbye World!");
		
		Student s = new Student();
		s.updateQuiz(5.2,0);
		s.saveProgress();
    }
    
    /*@Override
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
        
        //add style sheet
        scene.getStylesheets().add
        (Main.class.getResource("StyleForCAI.css").toExternalForm());
        primaryStage.show();
    }*/
}