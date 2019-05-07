import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;
import netscape.javascript.JSObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx. *;
import org.json.*;
import org.json.JSONException;

public class Main extends Application {
	//this one tells whether the button should show right now or not
	boolean buttonsExpanded = true;
	//what page of the text book we are on
	int whatPageWeOn = 1;
	static TestBank banky;
	static FactoryBank factbanky;
	static ArrayList<String> topics;
	static Student studentObj = new Student();
	String selected = "";
	Boolean notCompleted = true;

	Testing quiz;
	//array for the checkboxes and responses to questions
	ArrayList<RadioButton> boxes = new ArrayList<RadioButton>();
	ArrayList<String> questions = new ArrayList<String>();
	//tile pane for displaying questions
	VBox quest = new VBox(); 
	//big important grid
	GridPane grid = new GridPane();
	int questCount;
	//vars for student
	static Map<String,Tuple> stats = studentObj.getStats();
	static ArrayList<String> keys = new ArrayList<String>();
	Scene scene;
	//stuff for CSS files
	String curText = "text";
	String curHeading = "heading";
	String curSubText = "question";
	String curTinyText = "tiny";
	int timesSelected = 0;
	int theme = 0;

	public static void main(String[] args) {
		//GridPane grid = new GridPane();
		
		for (int i = 1; i < 7; i++) {
			keys.add("Bloom " + i);
		}
		keys.add("Comments");
		keys.add("Primitive Types");
		keys.add("Operators");
		keys.add("Object Comparison");
		keys.add("Escape Sequences");
		keys.add("I/O");
		keys.add("Exceptions");
		keys.add("Arrays");
		keys.add("Control Statements");
		keys.add("Variables");
		keys.add("Methods");
		keys.add("Constructors");
		keys.add("Classes");
		keys.add("Interfaces");
		keys.add("Inheritance");
		keys.add("Packages");
		keys.add("Miscellaneous Object Oriented Programming");
		keys.add("Standard Java Library");
		
		System.out.println("Factory make");
		try {
			ParseQuestions p = new ParseQuestions();
			banky = p.fillTestBank();
			factbanky = p.fillFactoryBank();
			
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		catch (JSONException j) {
			System.out.println("j " + j.getMessage());
		}
		catch (ParseException p) {
			System.out.println("p " + p.getMessage());
		}

		topics = new ArrayList<String>();
		

		launch(args);


	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("AP Computer Science Prep");
		
		//move chart stuff over here

		VBox vb = new VBox();

		//creates a grid in the center
		grid.setAlignment(Pos.TOP_LEFT);

		grid.setHgap(10);
		grid.setVgap(10);


		//makes size of the window
		scene = new Scene(grid, 1080, 720);
		primaryStage.setScene(scene);
		//adds preliminary home screen UI
		Text scenetitle = new Text("Welcome Back!");
		//scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
		scenetitle.setId(curHeading);
		grid.add(scenetitle, 2,1);
		buttons(grid, primaryStage);
		scene.getStylesheets().add
		(Main.class.getResource("Buttons.css").toExternalForm());
	}


	public void buttons(GridPane grid, Stage primaryStage){
		if (buttonsExpanded) {
			//
			//NAVIGATION BAR
			//Maybe copy this code for the other pages???
			//
			//create a VBox to put all the buttons in???
			VBox vb = new VBox();
			
			//this link, when clicked, hides the buttons
			Hyperlink hide = new Hyperlink();
			hide.setText("v");
			hide.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					buttonsExpanded = false;
					buttons(grid, primaryStage);
				}
			});
			//add this link to the grid
			grid.add(hide, 0, 0);
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
					//scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
					scenetitle.setId(curHeading);
					grid.add(scenetitle, 2,1);
					//calls buttons to set up the navbar again
					buttons(grid, primaryStage);
					System.out.println("finished creating");
					
					//chart goes here
					PredictiveDiagnostics diagy = new PredictiveDiagnostics();
					VBox box = diagy.getBox();
					grid.add(box,2,2);
				}
			});
			grid.add(home, 5, 3);
	
			//textbook button
			Button textbk = new Button();
			textbk.setText("Textbook");
			textbk.setTextFill(Color.BLUE);
			textbk.setMaxWidth(Double.MAX_VALUE);
			
			//when the user clicks "textbook"
			textbk.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					//clear the grid
					grid.getChildren().clear();
					
					//make a textbook object
					Textbook t = new Textbook();
					
					//add the actual book
					grid.add(t.getBrowser(), 2, 2);
					
					//add the combo box to navigate the book
					grid.add(t.getCBox(), 2, 1);
					
					//re-add the buttons
					buttons(grid, primaryStage);
				}
			});
			
			//add the textbook button
			grid.add(textbk, 4, 10);
	
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
					scenetitle.setId(curHeading);
					//scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
					grid.add(scenetitle, 2, 1);
					//add the nav bar back
					buttons(grid, primaryStage);
					System.out.println("finished creating");
	
					VBox quizV = new VBox();
					for (int i = 0; i < 4; i++) {
						//add take quiz button here 
						Button takeQuizButt = new Button();
						takeQuizButt.setText("Take Test " + (i+1));
						takeQuizButt.setTextFill(Color.BLUE);
						takeQuizButt.setMaxWidth(Double.MAX_VALUE);
						final int k = i;
						takeQuizButt.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								notCompleted = true;
		
								grid.getChildren().remove(quizV);
								//add questions
		
								//quest.setPrefColumns(3);
								//quest.setPrefRows(0);
								ArrayList<String> topics = new ArrayList<String>();
								
								if (k == 0) {
									topics.clear();
									topics.add("Comments");
									topics.add("Primitive Types");
									topics.add("Operators");
									topics.add("Object Comparison");
									
								}
								if (k == 1) {
									topics.clear();
									topics.add("Escape Sequences");
									topics.add("I/O");
									topics.add("Exceptions");
									topics.add("Arrays");
									
								}
								if (k == 2) {
									topics.clear();
									topics.add("Control Statements");
									topics.add("Variables");
									topics.add("Methods");
									topics.add("Constructors");
									
								}
								if (k == 3) {
									topics.clear();
									topics.add("Classes");
									topics.add("Interfaces");
									//topics.add("Inheritance");
									topics.add("Packages");
									topics.add("Miscellaneous Object Oriented Programming");
								}
								
								quiz = new Testing(1, topics, banky, factbanky);
								//make counter for quiz equal to qPerT
								questCount = 11; //quiz.qPerT;
								fillQuest();
		
							}
						});
						quizV.getChildren().add(takeQuizButt);
					}
					grid.add(quizV, 2, 2);
				}
			});
			grid.add(exams, 3, 25);
	
	
			//diagnostics button
			Button diagnostics = new Button();
			diagnostics.setText("Diagnostics");
			diagnostics.setTextFill(Color.BLUE);
			diagnostics.setMaxWidth(Double.MAX_VALUE);
			diagnostics.setOnAction(new EventHandler<ActionEvent>() {
				@SuppressWarnings("unchecked")
				@Override
				public void handle(ActionEvent event) {
					System.out.println("Pressed Diagnostics Button");
					grid.getChildren().clear();
					//add diagnostics information here
					Text scenetitle = new Text("Diagnostics");

					scenetitle.setId(curHeading);
					grid.add(scenetitle, 2, 1);
					//add the nav bar back
					buttons(grid, primaryStage);
					System.out.println("finished creating");
					//Map<String,Tuple> stats = studentObj.getStats();
					//chart goes here
					Charts charty = new Charts(studentObj);
					VBox boxy = charty.getBox();
					grid.add(boxy,2,4);
					
				}
			});

			grid.add(diagnostics, 5, 33);
	
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
					//scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
					scenetitle.setId(curHeading);
					grid.add(scenetitle, 2, 1);
					//add the nav bar back
					buttons(grid, primaryStage);
					System.out.println("finished creating");
					
					
					//
					//settings go here
					//					
					
					//Tim Mattson
					VBox boxxy = new VBox();
				    ToggleGroup group = new ToggleGroup();
					Text titley = new Text("Mascot");
					//titley.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
					titley.setId(curText);
				    RadioButton button1 = new RadioButton("Tim Mattson");
				    button1.setToggleGroup(group);
				    button1.setSelected(true);
				    boxxy.getChildren().addAll(titley, button1);	
				    //grid.add(boxxy, 2, 4);
				    
				    
				    //colors
				    VBox colorBox = new VBox();
				    ToggleGroup groupy = new ToggleGroup();
				    RadioButton light = new RadioButton("Light");
				    light.setToggleGroup(groupy);
				    if (theme == 0) {
				    	light.setSelected(true);
				    }
				    RadioButton dark = new RadioButton("Dark");
				    if (theme == 1) {
				    	dark.setSelected(true);
				    }
				    dark.setToggleGroup(groupy);
				    //change CSS file based on which button is selected
					EventHandler<ActionEvent> boxxyEvent = new EventHandler<ActionEvent>() { 
						public void handle(ActionEvent e) 
						{ 
							//if (timesSelected < 1) {
								if (dark.isSelected()) {
									scene.getStylesheets().add(Main.class.getResource("Dark.css").toExternalForm());
									System.out.println("dark mode");
									theme = 1;
									timesSelected++;
								}
								if (light.isSelected()) { 
									scene.getStylesheets().add(Main.class.getResource("Buttons.css").toExternalForm());
									System.out.println("light mode");
									theme = 0;
									timesSelected ++;
								}
							//}
						}
					};
					
					Text title = new Text("Theme");
					title.setId(curText);
					light.setOnAction(boxxyEvent);
					dark.setOnAction(boxxyEvent);
					Text placeholder = new Text(" \n");
					
					//add reset button
					Button reset = new Button();
					reset.setText("Reset Progress");
					//action for reset button
					reset.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							studentObj.resetProgress();
							System.out.println("progress reset");
						}
					});
					//space for spacing reasons
					Text place = new Text(" ");
					place.setId(curHeading);
					
				    boxxy.getChildren().addAll(placeholder, title, light, dark, place,reset);	    
				    grid.add(boxxy, 2, 4);
					
				}
			});
			grid.add(settings, 5, 40);

			//add buttons to VB
			vb.getChildren().addAll(home, textbk, diagnostics, exams, settings);
			//add VB to grid
			grid.add(vb,0,1,1,4);
			
			primaryStage.show();
		}
		
		//if the buttons are not supposed to show
		else {
			//firstly, clear the buttons
			grid.getChildren().removeIf(node -> GridPane.getColumnIndex(node) == 0);
			//make a little link if you want to show the buttons
			Hyperlink show = new Hyperlink();
			show.setText(">");
			show.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				//if someone clicks the link, recall this method with buttons expanded changed
				public void handle(ActionEvent event) {
					buttonsExpanded = true;
					buttons(grid, primaryStage);
				}
			});
			//add the little link
			grid.add(show, 0, 0);
			//show the stage
			primaryStage.show();
		}
	}





	public void fillQuest() {
		//get question text
		Text l = new Text(quiz.getQ(questCount).getText());
		l.setId(curSubText);
		Text space = new Text(" ");
		quest.getChildren().addAll(l,space);  
		//fill questions with the question's possible responses
		ArrayList<String> answ = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			String a = quiz.getQ(questCount).getAnswer(i);
			answ.add(a);
		}
		String correctA = answ.get(0);
		Collections.shuffle(answ);
		/*
		 * for (int i = 0; i < 4; i++) { questions.add(quiz.getQ(0).getAnswer(i));
		 * System.out.println(quiz.getQ(0).getAnswer(i)); }
		 */

		for (int i = 0; i < 4; i++) { 
			// create a checkbox 
			RadioButton c = new RadioButton(answ.get(i)); 
			quest.getChildren().add(c);
			boxes.add(c);
		}
		// create a event handler for each checkbox
		//it can print what has been selected
		//ToggleGroup allows only one button to be selected at a time
		final ToggleGroup group = new ToggleGroup();
		EventHandler<ActionEvent> boxEvent = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				for (int i = 0; i < boxes.size(); i++) {
					RadioButton c = boxes.get(i);
					if (c.isSelected()) { 
						System.out.println(c.getText() + " selected");
						selected = c.getText();
					}
					//else
					//System.out.println("not selected");
				} 
			}
		}; 


		//add event to all checkboxes
		for (int i = 0; i < boxes.size(); i++) {
			RadioButton c = boxes.get(i);
			c.setOnAction(boxEvent); 
			c.setToggleGroup(group);
		}   
		//add all this to grid
		grid.add(quest, 2, 4);
		
		//add submit button
		Button submit = new Button();
		submit.setText("Submit Question");
		submit.setTextFill(Color.BLUE);
		submit.setMaxWidth(Double.MAX_VALUE);
		grid.add(submit,2,14);
		EventHandler<ActionEvent> submitted = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent next) 
			{
				//call action again to form new question in the UI only if there are more questions
				if(questCount > 0) {
					for (int i =0; i <4; i++) {
						quest.getChildren().remove(boxes.get(i));
					}
					quest.getChildren().remove(l);
					grid.getChildren().remove(quest);
					//subtract from questCount to go to next question
					questCount --;
					//check if the submitted question is correct					
					//Update Student code by dealing with the tuples
					String qTopic = quiz.getQ(questCount+1).getTopic();
					System.out.println("qTopic is " + qTopic);
					int qBloom = quiz.getQ(questCount+1).getBloom();
					System.out.println("qBloom is " + qBloom);
					
					//get tuples
					Tuple tupleTopic = stats.get(qTopic);
					Tuple tupleBloom = stats.get("Bloom "+qBloom);
					System.out.println("tupleTopic is " + tupleTopic);
					System.out.println("tupleBloom is " + tupleBloom);
				
					
					System.out.println("selected is: " + selected);
					System.out.println("correctA is: " + correctA);
					if (selected.equals(correctA)) {
						//mark as correct
						System.out.println("correct answer");
						System.out.println("");
						quiz.nCorrect ++;
						//update Tuples
						tupleTopic.updateTuple(1,1,studentObj);
						tupleBloom.updateTuple(1,1,studentObj);
					}
					else {
						System.out.println("wrong answer");
						System.out.println("");
						quiz.nWrong ++;
						//update Tuples
						tupleTopic.updateTuple(0,1,studentObj);
						tupleBloom.updateTuple(0,1,studentObj);
					}
					quest.getChildren().clear();
					grid.getChildren().remove(quest);
					grid.getChildren().remove(submit);
					fillQuest();
					
				}
				//else the quiz is finished
				else {
					//check for topic and bloom then send to Ben's code
					String qTopic = quiz.getQ(questCount+1).getTopic();
					System.out.println("qTopic is " + qTopic);
					int qBloom = quiz.getQ(questCount+1).getBloom();
					System.out.println("qBloom is " + qBloom);
					
					//get tuples
					Tuple tupleTopic = stats.get(qTopic);
					Tuple tupleBloom = stats.get("Bloom " + qBloom);
					System.out.println("tupleTopic is " + tupleTopic);
					System.out.println("tupleBloom is " + tupleBloom);
					
					//check for wrong or right one last time
					if (selected.equals(correctA)) {
						//mark as correct
						System.out.println("correct answer");
						System.out.println("");
						quiz.nCorrect ++;
						//updateTuples
						tupleTopic.updateTuple(1,1,studentObj);
						tupleBloom.updateTuple(1,1,studentObj);
					}
					else {
						System.out.println("wrong answer");
						System.out.println("");
						quiz.nWrong ++;
						//update Tuples
						tupleTopic.updateTuple(0,1,studentObj);
						tupleBloom.updateTuple(0,1,studentObj);
					}
					
					grid.getChildren().remove(quest);
					grid.getChildren().remove(submit);
					System.out.println("Completed Exam");
					//calc grade
					double grade = quiz.calcGrade();
					Text gradeL = new Text("Your grade on this assignment is "+Math.floor(grade*100)/100+"%");
					//gradeL.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
					gradeL.setId(curText);
					
					grid.add(gradeL,2,4); 
					notCompleted = false;
					grid.getChildren().remove(submit);

				}
			}
		};
		if (notCompleted == true) {
			submit.setOnAction(submitted);
		}
	}
}