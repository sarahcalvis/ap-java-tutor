import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx. *;


public class Main extends Application{
	int whatPageWeOn = 1;
	static TestBank banky = new TestBank();
	static ArrayList<String> topics;
	Student studentObj = new Student();
	String selected = "";
	Boolean notCompleted = true;

	Testing quiz;
	//array for the checkboxes and responses to questions
	ArrayList<CheckBox> boxes = new ArrayList<CheckBox>();
	ArrayList<String> questions = new ArrayList<String>();
	//tile pane for displaying questions
	TilePane quest = new TilePane(); 
	//big important grid
	GridPane grid = new GridPane();
	int questCount;
	//vars for student
	Map<String,Tuple> stats = studentObj.getStats();

	public static void main(String[] args) {
		//GridPane grid = new GridPane();

		ArrayList<String> answers = new ArrayList<String>();
		answers.add("x = 4");
		answers.add("x = 87");
		answers.add("x = -2");
		answers.add("x = 34");

		Question q1 = new Question("What is 2 + 2?", answers, "Operators", "Bloom 1");

		answers.set(0, "An integer");
		answers.set(1, "A word");
		answers.set(2, "A character");
		answers.set(3, "A data structure");

		Question q2 = new Question("What is an int?", answers, "Methods", "Bloom 2");

		answers.set(0, "A thing (right)");
		answers.set(1, "Something else");
		answers.set(2, "Some other thing");
		answers.set(3, "Something else ALTOGETHER");

		Question q3 = new Question("What does \'static\' mean?", answers, "Operators", "Bloom 2");

		answers.set(0, "An integer");
		answers.set(1, "A word");
		answers.set(2, "A character");
		answers.set(3, "A data structure");

		Question q4 = new Question("What is a char?", answers, "Methods", "Bloom 1");


		banky.addQuest(q1);
		banky.addQuest(q2);
		banky.addQuest(q3);
		banky.addQuest(q4);

		topics = new ArrayList<String>();
		topics.add("Methods");
		topics.add("Operators");




		launch(args);


	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("AP Computer Science Prep");

		VBox vb = new VBox();
		//vb.setSpacing(10);
		//vb.setPadding(new Insets(10,10,10,10));

		//vb.setAlignment(Pos.CENTER);

		//creates a grid in the center
		//GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_LEFT);

		grid.setHgap(10);
		grid.setVgap(10);

		//controls padding around the edges
		//grid.setPadding(new Insets(10,10,10,10));

		//makes size of the window
		Scene scene = new Scene(grid, 1080, 720);
		primaryStage.setScene(scene);
		//adds preliminary home screen UI
		Text scenetitle = new Text("Welcome Back!");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
		grid.add(scenetitle, 2,1);
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
				grid.add(scenetitle, 2,1);
				//calls buttons to set up the navbar again
				buttons(grid, primaryStage);
				System.out.println("finished creating");
			}
		});
		grid.add(home, 5, 3);

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
				Text scenetitle = new Text("Think Java");
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
				grid.add(scenetitle, 2, 1);
				//add the nav bar back
				buttons(grid, primaryStage);
				System.out.println("finished creating");
				String pageNumber = Integer.toString(whatPageWeOn);
				if (pageNumber.length() == 1) {
					pageNumber = "00"+pageNumber;
				}
				else if (pageNumber.length() == 2) {
					pageNumber = "0"+pageNumber;
				}

				String file = "file:src/thinkjava(1)-page-"+pageNumber+".jpg";
				System.out.println(file);
				Image image = new Image(file);
				ImageView ivText = new ImageView();
				ivText.setImage(image);
				ivText.setFitHeight(700);
				ivText.setFitWidth(400);
				grid.add(ivText, 2, 2);
				Button btnNextPage = new Button("Next Page");
				btnNextPage.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2 &&GridPane.getColumnIndex(node) == 2);
						if (whatPageWeOn < 291) {
							whatPageWeOn++;
							String pageNumber = Integer.toString(whatPageWeOn);
							if (pageNumber.length() == 1) {
								pageNumber = "00"+pageNumber;
							}
							else if (pageNumber.length() == 2) {
								pageNumber = "0"+pageNumber;
							}
							String file = "file:src/thinkjava(1)-page-"+pageNumber+".jpg";
							System.out.println(file);
							Image image = new Image(file);
							ImageView ivText = new ImageView();
							ivText.setImage(image);
							ivText.setFitHeight(700);
							ivText.setFitWidth(400);
							grid.add(ivText, 2, 2);
						}

					}
				});
				
				Button btnPrevPage = new Button("Previous Page");
				btnPrevPage.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2 &&GridPane.getColumnIndex(node) == 2);
						if (whatPageWeOn >= 1) {
							whatPageWeOn--;
							String pageNumber = Integer.toString(whatPageWeOn);
							if (pageNumber.length() == 1) {
								pageNumber = "00"+pageNumber;
							}
							else if (pageNumber.length() == 2) {
								pageNumber = "0"+pageNumber;
							}
							String file = "file:src/thinkjava(1)-page-"+pageNumber+".jpg";
							System.out.println(file);
							Image image = new Image(file);
							ImageView ivText = new ImageView();
							ivText.setImage(image);
							ivText.setFitHeight(700);
							ivText.setFitWidth(500);
							grid.add(ivText, 2, 2);
						}
					}
				});
				VBox bookV = new VBox();
				bookV.getChildren().addAll(btnNextPage, btnPrevPage);
				grid.add(bookV, 3, 2);
			}
		});
		grid.add(textbk, 4, 10);

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
				grid.add(scenetitle, 2,1);
				//add the nav bar back
				buttons(grid, primaryStage);
				System.out.println("finished creating");
			}
		});
		grid.add(lessons, 5, 18);

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
				grid.add(scenetitle, 2, 1);
				//add the nav bar back
				buttons(grid, primaryStage);
				System.out.println("finished creating");

				VBox quizV = new VBox();
				for (int i = 0; i < 4; i++) {
					//add take quiz button here 
					Button takeQuizButt = new Button();
					takeQuizButt.setText("Take Quiz " + (i+1));
					takeQuizButt.setTextFill(Color.BLUE);
					takeQuizButt.setMaxWidth(Double.MAX_VALUE);
					takeQuizButt.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							//TODO add buttons for different chapters
							notCompleted = true;
	
							grid.getChildren().remove(takeQuizButt);
							//add questions
	
							quest.setPrefColumns(3);
							quest.setPrefRows(0);
							quiz = new Testing(1, topics, banky);
							//make counter for quiz equal to qPerT
							questCount = quiz.qPerT;
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
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Pressed Diagnostics Button");
				grid.getChildren().clear();
				//add diagnostics information here
				Text scenetitle = new Text("Diagnostics");
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
				grid.add(scenetitle, 2, 1);
				//add the nav bar back
				buttons(grid, primaryStage);
				System.out.println("finished creating");
				//Map<String,Tuple> stats = studentObj.getStats();
				ArrayList<String> keys = new ArrayList<String>();
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
				keys.add("Packages");
				keys.add("Miscellaneous Object Oriented Programming");

				String s = "";
				for (int i = 0; i < keys.size(); i++) {
					String txt = "" + stats.get(keys.get(i)).getTuple();
					if(txt.equals("-1.0")) {
						txt = "N/A";
					}
					s += keys.get(i) + ": " + txt + "\n";
				}
				Text diagnosticInfo = new Text(s);
				diagnosticInfo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
				grid.add(diagnosticInfo, 2, 2);
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
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
				grid.add(scenetitle, 2, 1);
				//add the nav bar back
				buttons(grid, primaryStage);
				System.out.println("finished creating");
			}
		});
		grid.add(settings, 5, 40);

		//add buttons to VB
		vb.getChildren().addAll(home,lessons,textbk,diagnostics,exams,settings);
		//add VB to grid
		grid.add(vb,0,1,1,4);

		//add style sheet
		//scene.getStylesheets().add
		//(Main.class.getResource("Buttons.css").toExternalForm());
		primaryStage.show();
	}





	public void fillQuest() {
		//get question text
		Label l = new Label(quiz.getQ(questCount).getText());
		quest.getChildren().add(l);  
		//fill questions with the question's possible responses
		//TODO randomize the order of the answers
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
			CheckBox c = new CheckBox(answ.get(i)); 
			quest.getChildren().add(c);
			boxes.add(c);
		}
		// create a event handler for each checkbox
		//it can print what has been selected
		EventHandler<ActionEvent> boxEvent = new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent e) 
			{ 
				for (int i = 0; i < boxes.size(); i++) {
					CheckBox c = boxes.get(i);
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
			CheckBox c = boxes.get(i);
			c.setOnAction(boxEvent); 
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
				if(questCount > 1) {
					for (int i =0; i <4; i++) {
						quest.getChildren().remove(boxes.get(i));
					}
					quest.getChildren().remove(l);
					grid.getChildren().remove(quest);
					//subtract from questCount to go to next question
					questCount --;
					//check if the submitted question is correct
					
					//Update Student code by dealing with the tuples
					String qTopic = quiz.getQ(questCount).getTopic();
					System.out.println("qTopic is " + qTopic);
					String qBloom = quiz.getQ(questCount).getBloom();
					System.out.println("qBloom is " + qBloom);
					
					//get tuples
					Tuple tupleTopic = stats.get(qTopic);
					Tuple tupleBloom = stats.get(qBloom);
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
					fillQuest();
				}
				//else the quiz is finished
				else {
					//check for topic and bloom then send to Ben's code
					String qTopic = quiz.getQ(questCount+1).getTopic();
					System.out.println("qTopic is " + qTopic);
					String qBloom = quiz.getQ(questCount+1).getBloom();
					System.out.println("qBloom is " + qBloom);
					
					//get tuples
					Tuple tupleTopic = stats.get(qTopic);
					Tuple tupleBloom = stats.get(qBloom);
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
					Text gradeL = new Text("Your grade on this assignment is "+grade+"%");
					gradeL.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
					grid.add(gradeL,3,4); 
					notCompleted = false;
					//grid.getChildren().remove(submit);

				}
			}
		};
		if (notCompleted == true) {
			submit.setOnAction(submitted);
		}
	}


}



