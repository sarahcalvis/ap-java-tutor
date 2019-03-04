

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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx. *;


public class Main extends Application{

	public static void main(String[] args) {
		//GridPane grid = new GridPane();
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
        GridPane grid = new GridPane();
        VBox vb = new VBox();
        //vb.setSpacing(10);
        //vb.setPadding(new Insets(10,10,10,10));
        vb.setAlignment(Pos.CENTER);

        //creates a grid in the center
        //GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        
        grid.setHgap(10);
        grid.setVgap(10);
        
        //controls padding around the edges
        //grid.setPadding(new Insets(25,25,25,25));
        
        //makes size of the window
        Scene scene = new Scene(grid, 1080, 720);
        primaryStage.setScene(scene);
        //adds preliminary home screen UI
        Text scenetitle = new Text("Welcome Back!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
        grid.add(scenetitle, 1,0);
        buttons(grid, primaryStage);
        scene.getStylesheets().add
        (Main.class.getResource("Buttons.css").toExternalForm());
    }
        
    
        public void buttons(GridPane grid, Stage primaryStage){
	        //
	        //NAVIGATION BAR
	        //Maybe copy this code for the other pages???
	        //
        	//create a VBox to put all the buttons in???
        	VBox vb = new VBox();
	        //home button
	        Button home = new Button();
	        home.setText("Home");
	        home.setTextFill(Color.BLUE);
	        home.setMaxWidth(Double.MAX_VALUE);
	        home.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Home Button");
	        		// clear current screen
	        		grid.getChildren().clear(); 
	        		//add home screen shenanigans
	                Text scenetitle = new Text("Welcome Back!");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 12, 3);
	        		//calls buttons to set up the navbar again
	        		buttons(grid, primaryStage);
	                System.out.println("finished creating");
	        	}
	        });
	        grid.add(home, 5, 3,2,1);
	        
	        //textbook button
	        Button textbk = new Button();
	        textbk.setText("Textbook");
	        textbk.setTextFill(Color.BLUE);
	        textbk.setMaxWidth(Double.MAX_VALUE);
	        textbk.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Textbook Button");
	        		grid.getChildren().clear();
	        		//add textbook information here
	        		Text scenetitle = new Text("Textbook");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 12, 3, 2, 1);
	                //add the nav bar back
	        		buttons(grid, primaryStage);
	        		System.out.println("finished creating");
	        	}
	        });
	        grid.add(textbk, 4, 10,2,1);
	        
	        //lesson button
	        Button lessons = new Button();
	        lessons.setText("Lessons");
	        lessons.setTextFill(Color.BLUE);
	        lessons.setMaxWidth(Double.MAX_VALUE);
	        lessons.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Lessons Button");
	        		grid.getChildren().clear();
	        		//add lessons information here
	        		Text scenetitle = new Text("Lessons");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 12, 3, 2, 1);
	                //add the nav bar back
	        		buttons(grid, primaryStage);
	        		System.out.println("finished creating");
	        	}
	        });
	        grid.add(lessons, 5, 18,2,1);
	        
	        //Test/quizzes button
	        Button exams = new Button();
	        exams.setText("Quizzes and Exams");
	        exams.setTextFill(Color.BLUE);
	        exams.setMaxWidth(Double.MAX_VALUE);
	        exams.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Exams Button");
	        		grid.getChildren().clear();
	        		//add Exams information here
	        		Text scenetitle = new Text("Tests and Quizzes");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 12, 3, 2, 1);
	                //add the nav bar back
	        		buttons(grid, primaryStage);
	        		System.out.println("finished creating");
	        	}
	        });
	        grid.add(exams, 3, 25,5,1);
	        
	        //diagnostics button
	        Button diagnostics = new Button();
	        diagnostics.setText("Diagnostics");
	        diagnostics.setTextFill(Color.BLUE);
	        diagnostics.setMaxWidth(Double.MAX_VALUE);
	        diagnostics.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Diagnostics Button");
	        		grid.getChildren().clear();
	        		//add diagnostics information here
	        		Text scenetitle = new Text("Diagnostics");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 12, 3, 2, 1);
	                //add the nav bar back
	        		buttons(grid, primaryStage);
	        		System.out.println("finished creating");
	        	}
	        });
	        grid.add(diagnostics, 5, 33 ,5,1);
	        
	        //settings button
	        Button settings = new Button();
	        settings.setText("Settings");
	        settings.setTextFill(Color.BLUE);
	        settings.setMaxWidth(Double.MAX_VALUE);
	        settings.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Settings Button");
	        		grid.getChildren().clear();
	        		//add settings information here
	        		Text scenetitle = new Text("Settings");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 12, 3, 2, 1);
	                //add the nav bar back
	        		buttons(grid, primaryStage);
	        		System.out.println("finished creating");
	        	}
	        });
	        grid.add(settings, 5, 40,5,1);
	        
	        //add buttons to VB
	        vb.getChildren().addAll(home,lessons,textbk,diagnostics,exams,settings);
	        //add VB to grid
	        grid.add(vb,0,1);
	        
	        //add style sheet
	        //scene.getStylesheets().add
	        //(Main.class.getResource("Buttons.css").toExternalForm());
	        primaryStage.show();
        }
    }

