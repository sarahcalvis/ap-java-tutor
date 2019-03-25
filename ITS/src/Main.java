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
	VBox quest = new VBox(); 
	//big important grid
	GridPane grid = new GridPane();
	int questCount;
	//vars for student
	Map<String,Tuple> stats = studentObj.getStats();
	static ArrayList<String> keys = new ArrayList<String>();

	public static void main(String[] args) {
		//GridPane grid = new GridPane();
		fillTestBank();
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
								topics.add("Packages");
								topics.add("Miscellaneous Object Oriented Programming");
							}
							
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
					int qBloom = quiz.getQ(questCount).getBloom();
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
					int qBloom = quiz.getQ(questCount+1).getBloom();
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

	public static void fillTestBank(){
		ArrayList<String> answers = new ArrayList<String>();
		Question q1;
		String text;
		
		//1
		text = "Consider the following output.\n\t1  1  1  1  12  2  2  23  3  34  45\n\nWhich of the following code segments will produce this output?";
		answers.add("for (int j = 1; j <= 5; j++){\n\tfor (int k = 5; k >= j; k--){\n\t\tSystem.out.print(j + \"  \");\n\t}\n\tSystem.out.println();\n}");	
		answers.add("for (int j = 1; j <= 5; j++){\n\tfor (int k = 1; k <= 5; k++){\n\t\tSystem.out.print(j + \"  \");\n\t}\n\tSystem.out.println();\n}");
		answers.add("for (int j = 1; j <= 5; j++){\n\tfor (int k = 1; k <= j; k++){\n\t\tSystem.out.print(j + \"  \");\n\t}\n\tSystem.out.println();\n}");
		answers.add("for (int j = 1; j <= 5; j++){\n\tfor (int k = j; k <= 5; k++){\n\t\tSystem.out.print(k + \"  \");\n\t}\n\tSystem.out.println();\n}");
		q1 = new Question(text, answers, "Control Statements", 5);
		banky.addQuest(q1);

		//2
		text = "Which of the following lines represents a primitive data type?";
		answers.set(0, "char");
		answers.set(1, "ArrayList<String>");
		answers.set(2, "String");
		answers.set(3, "Integer");
		q1 = new Question(text, answers, "Primitive Types", 2);
		banky.addQuest(q1);

		//3
		text = "What\'s wrong with the following code?\n\n\tvoid printsometext(){\n\t\tSystem.println(\"Printing text\n\");\n\t\tfor(int i=0; i<3; i++){\n\t\t\tSystem.println(i + \"\n\");\n\t\t}\n\t\treturn 5;\n\t}";
		answers.set(0, "Void functions can't return ints.");
		answers.set(1, "The loop is formatted incorrectly.");
		answers.set(2, "There should be a semicolon after the function declaration.");
		answers.set(3, "The character '\n' does not exist.");
		q1 = new Question(text, answers, "Methods", 5);
		banky.addQuest(q1);

		//4
		text = "Which of the following operations allow you to define the function func1() outside of the class definition?";
		answers.set(0, "public");
		answers.set(1, "class school");
		answers.set(2, "{");
		answers.set(3, "school();");
		q1 = new Question(text, answers, "Methods", 1);
		banky.addQuest(q1);

		//5
		text = "Consider the following code segment.\n\n\tfor (int k = 0; k < 20; k = k + 2){\n\t\tif (k % 3 == 1){\n\t\t\tSystem.out.print(k + \"  \");\n\t\t  }\n\t}\n\nWhat is printed as a result of executing the code segment?";
		answers.set(0, "4  10  16");
		answers.set(1, "4  16");
		answers.set(2, "0  6  12  18");
		answers.set(3, "0  2  4  6  8  10  12  14  16  18");
		q1 = new Question(text, answers, "Control Statements", 3);
		banky.addQuest(q1);

		//6
		text = "Consider the following code segment.\n\n\tList<String> animals = new ArrayList<String>();\n\tanimals.add(\"dog\");\n\tanimals.add(\"cat\");\n\tanimals.add(\"snake\");\n\tanimals.set(2, \"lizard\");\n\tanimals.add(1, \"fish\");\n\tanimals.remove(3);\n\tSystem.out.println(animals);\n\n\tWhat is printed as a result of executing the code segment?";
		answers.set(0, "[dog, fish, cat]");
		answers.set(1, "[dog, fish, lizard]");
		answers.set(2, "[dog, lizard, fish]");
		answers.set(3, "The code throws anArrayIndexOutOfBoundsExceptionexception.");
		q1 = new Question(text, answers, "Arrays", 1);
		banky.addQuest(q1);

		//7
		text = "Consider two strings, stringA and stringB. How would we test these strings for equivalence?";
		answers.set(0, "stringA.equals(stringB)");
		answers.set(1, "stringA = stringB");
		answers.set(2, "stringA == stringB");
		answers.set(3, "stringA.isEqual(stringB)");
		q1 = new Question(text, answers, "Arrays", 1);
		banky.addQuest(q1);

		//8
		text = "What must be true immediately after the following code snippet has run?\n\n\tdouble square(double n){\n\t\treturn n*n;\n\t}";
		answers.set(0, "The result will be positive.");
		answers.set(1, "It is impossible to tell.");
		answers.set(2, "The result will be stored in a new variable.");
		answers.set(3, "The result will be a negative number.");
		q1 = new Question(text, answers, "Operators", 3);
		banky.addQuest(q1);

		//9
		text = "Which one of these is not a primitive type?";
		answers.set(0, "String");
		answers.set(1, "int");
		answers.set(2, "boolean");
		answers.set(3, "double");
		q1 = new Question(text, answers, "Primitive Types",1);
		banky.addQuest(q1);

		//10
		text = "What does JVM stand for?";
		answers.set(0, "Java Virtual Machine");
		answers.set(1, "Jumpsuits Via Mail Order");
		answers.set(2, "Jesuits Visiting Maryland");
		answers.set(3, "Jamaican Vertebral Mechanism");
		q1 = new Question(text, answers, "Primitive Types",1);
		banky.addQuest(q1);

		//11
		text = "int x = 0;/nfor (int i = 0; i < 9; i*=2) {/n/tx++;/n}/n/nWhat is the value of x after the above code finishes executing?";
		answers.set(0, "0");
		answers.set(1, "4");
		answers.set(2, "8");
		answers.set(3, "9");
		q1 = new Question(text, answers, "Control Statements",4);
		banky.addQuest(q1);

		//12
		text = "A _____ is a special method that initializes an object.";
		answers.set(0, "constructor");
		answers.set(1, "class");
		answers.set(2, "string literal");
		answers.set(3, "working product");
		q1 = new Question(text, answers, "Constructors",1);
		banky.addQuest(q1);

		//13
		text = "An object is an instance of a _____.";
		answers.set(0, "class");
		answers.set(1, "variable");
		answers.set(2, "JUnit test");
		answers.set(3, "program");
		q1 = new Question(text, answers, "Classes",2);
		banky.addQuest(q1);

		//14
		text = "File file = new File(\"words.txt\");\nScanner scan = new Scanner(file);\n\nWhat exception needs to be handled in a program containing these lines?";
		answers.set(0, "FileNotFoundException");
		answers.set(1, "ScannerNotFoundException");
		answers.set(2, "No exceptions could be thrown by this code.");
		answers.set(3, "NullPointerException");
		q1 = new Question(text, answers, "Exceptions",1);
		banky.addQuest(q1);

		//15
		text = "Implicit if not defined, every class has a ______.";
		answers.set(0, "constructor");
		answers.set(1, "variable");
		answers.set(2, "JUnit test");
		answers.set(3, "IDE");
		q1 = new Question(text, answers, "Classes",3);
		banky.addQuest(q1);

		//16
		text = "Which one of the following is a legal comment?";
		answers.set(0, "// your comment, my good sir");
		answers.set(1, "/**/yo dawg here is a comment");
		answers.set(2, "\\my brethren I give you this comment");
		answers.set(3, "/consider yourself commented, my guy");
		q1 = new Question(text, answers, "Comments",2);
		banky.addQuest(q1);

		//17
		text = "How is a JavaDoc block begun?";
		answers.set(0, "/**");
		answers.set(1, "/JD/");
		answers.set(2, "//");
		answers.set(3, "*/*");
		q1 = new Question(text, answers, "Comments",1);
		banky.addQuest(q1);

		//18
		text = "What is the escape sequence that denotes a newline?";
		answers.set(0, "\n");
		answers.set(1, "|n");
		answers.set(2, "/n");
		answers.set(3, "\\n");
		q1 = new Question(text, answers, "Escape Sequences",1);
		banky.addQuest(q1);

		//19
		text = "What does '\t' denote?";
		answers.set(0, "tab");
		answers.set(1, "space");
		answers.set(2, "title");
		answers.set(3, "Terrence");
		q1 = new Question(text, answers, "Escape Sequences",1);
		banky.addQuest(q1);

		//20
		text = "Which of the following is the best equals() method for class 'car?'\n\nclass car{\n\tint numWheels;\n\tint miles;\n\tString name;\n\tString model;\n\n\tcar(String name, String model){\n\t\tthis.name = name;\n\t\tthis.model = model;\n\t}\n}";
		answers.set(0, "boolean equals(car a, car b){\n\treturn (a.numWheels == b.numWheels\n\t&& a.miles == b.miles\n\t&& a.name.equals(b.name)\n\t&& a.model.equals(b.model));\n}");
		answers.set(1, "boolean equals(car a, car b){\n\treturn (a.miles == b.miles\n\t&& a.name.equals(b.name)\n\t&& a.model.equals(b.model));\n}");
		answers.set(2, "boolean equals(car a, car b){\n\treturn (a.numWheels == b.numWheels\n\t&& a.name.equals(b.name)\n\t&& a.model.equals(b.model));\n}");
		answers.set(3, "boolean equals(car a, car b){\n\treturn (a.numWheels == b.numWheels\n\t&& a.miles == b.miles\n\t&& a.name.equals(b.name));\n}");
		q1 = new Question(text, answers, "Object Comparison",5);
		banky.addQuest(q1);

		//21
		text = "To initialize a scanner:\n\nScanner scnr = new Scanner(_________);";
		answers.set(0, "System.in");
		answers.set(1, "Input.sys");
		answers.set(2, "iostream");
		answers.set(3, "Terrence");
		q1 = new Question(text, answers, "I/O",1);
		banky.addQuest(q1);

		//22
		text = "A class name is usually...";
		answers.set(0, "a noun");
		answers.set(1, "a verb");
		answers.set(2, "a preposition");
		answers.set(3, "private to that class");
		q1 = new Question(text, answers, "Classes",3);
		banky.addQuest(q1);

		//23
		text = "Which of these will give the number of elements in an array a?";
		answers.set(0, "a.length");
		answers.set(1, "a.length()");
		answers.set(2, "a.size");
		answers.set(3, "a.size()");
		q1 = new Question(text, answers, "Arrays",2);
		banky.addQuest(q1);

		//24
		text = "Which one of these is a proper array declaration?";
		answers.set(0, "int[] a = new int[7];");
		answers.set(1, "int[] a = new int[];");
		answers.set(2, "char c[] = new char[];");
		answers.set(3, "char c [7];");
		q1 = new Question(text, answers, "Arrays",2);
		banky.addQuest(q1);

		//25
		text = "Which package needs to be imported to use System.out.println?";
		answers.set(0, "No packages needed");
		answers.set(1, "java.io");
		answers.set(2, "ioStream");
		answers.set(3, "stdio");
		q1 = new Question(text, answers, "I/O",2);
		banky.addQuest(q1);

		//26
		text = "What will the following code return? Assume a is true, b is false, and c is true.\n\t((a && (b || c)) || b)";
		answers.set(0, "true");
		answers.set(1, "false");
		answers.set(2, "5");
		answers.set(3, "c");
		q1 = new Question(text, answers, "Operators",4);
		banky.addQuest(q1);

		//27
		text = "What will be the result of the following code?\n\na[4] = {2, 3, 5, 8};\n\nfor(int i = 0; i == a.length; i++){\n\tc += a[i];\n}\n\nSystem.out.println(c);";
		answers.set(0, "OutOfBoundsException");
		answers.set(1, "IllegalArgumentException");
		answers.set(2, "18");
		answers.set(3, "10");
		q1 = new Question(text, answers, "Exceptions",3);
		banky.addQuest(q1);

		//28
		text = "Consider the following class:/n/nclass Node{/n/tint numStuff;/n/tdouble thing;/n/n/tNode(int numStuff, double thing){/n/t/tnumStuff = numStuff;/n/t/tthing = thing;/n/t}/n}/n/nWhat needs to be changed to produce the desired results?";
		answers.set(0, "'this.' needs to be inserted before the left hand variables in the constructor");
		answers.set(1, "'this.' needs to be inserted before the right hand variables in the constructor");
		answers.set(2, "The code will work as is");
		answers.set(3, "Terrence");
		q1 = new Question(text, answers, "Constructors",5);
		banky.addQuest(q1);

		//29
		text = "What is a block comment?";
		answers.set(0, "Multiple lines enclosed by /**/");
		answers.set(1, "Multiple lines enclosed by // //");
		answers.set(2, "Block comments are just an urban legend");
		answers.set(3, "String");
		q1 = new Question(text, answers, "Comments",1);
		banky.addQuest(q1);

		//30
		text = "What is the value of an uninitialized int variable?";
		answers.set(0, "null");
		answers.set(1, "0");
		answers.set(2, "int");
		answers.set(3, "");
		q1 = new Question(text, answers, "Variables",2);
		banky.addQuest(q1);

		//31
		text = "To which of these types can operators NOT be applied?";
		answers.set(0, "String");
		answers.set(1, "int");
		answers.set(2, "char");
		answers.set(3, "double");
		q1 = new Question(text, answers, "Operators",2);
		banky.addQuest(q1);

		//32
		text = "Object obj1;/nObject obj2;/nWhich one of these check whether obj1 and obj2 hold the same attributes?";
		answers.set(0, "none of these");
		answers.set(1, "obj1 = obj2;");
		answers.set(2, "obj1 == obj2;");
		answers.set(3, "obj1.equals(obj2);");
		q1 = new Question(text, answers, "Object Comparison",3);
		banky.addQuest(q1);

		//33
		text = "What will this print?\n\tSystem.out.print(\"\tJava is hot.\");";
		answers.set(0, "\tJava is hot.");
		answers.set(1, "\tJava is \\n hot.");
		answers.set(2, "\tJava is hot.");
		answers.set(3, "\t\"Java is hot.\"");
		q1 = new Question(text, answers, "Escape Sequences",2);
		banky.addQuest(q1);

		//34
		text = "How do you resolve an uncaught exception?";
		answers.set(0, "Any of these");
		answers.set(1, "Add a throws declaration");
		answers.set(2, "Surround it with a try/catch block");
		answers.set(3, "None of these");
		q1 = new Question(text, answers, "Exceptions",5);
		banky.addQuest(q1);

		//35
		text = "Which of these is a legal variable name in Java?";
		answers.set(0, "var");
		answers.set(1, "this");
		answers.set(2, "new");
		answers.set(3, "string");
		q1 = new Question(text, answers, "Variables",1);
		banky.addQuest(q1);

		//36
		text = "Which of these types would you use for a variable to hold someone's bank balance?";
		answers.set(0, "double");
		answers.set(1, "long");
		answers.set(2, "int");
		answers.set(3, "char");
		q1 = new Question(text, answers, "Variables",4);
		banky.addQuest(q1);

		//37
		text = "A _ 's name is usually a verb";
		answers.set(0, "method");
		answers.set(1, "object");
		answers.set(2, "class");
		answers.set(3, "main");
		q1 = new Question(text, answers, "Methods",4);
		banky.addQuest(q1);

		//38
		text = "Which one of these allows you to initialize an object?";
		answers.set(0, "constructor");
		answers.set(1, "method header");
		answers.set(2, "main");
		answers.set(3, "class");
		q1 = new Question(text, answers, "Constructors",1);
		banky.addQuest(q1);

		//39
		text = "An interface is...?";
		answers.set(0, "A collection of abstract methods");
		answers.set(1, "An environment for developing Java code");
		answers.set(2, "An instance of a class");
		answers.set(3, "Essential for the working product");
		q1 = new Question(text, answers, "Interfaces",3);
		banky.addQuest(q1);

		//40
		text = "All methods in an interface are by default _______.";
		answers.set(0, "abstract");
		answers.set(1, "private");
		answers.set(2, "void");
		answers.set(3, "overloaded");
		q1 = new Question(text, answers, "Interfaces",2);
		banky.addQuest(q1);

		//41
		text = "Which of these is NOT a key way in which interfaces defer from classes?";
		answers.set(0, "An interface cannot have methods");
		answers.set(1, "An interface cannot be instantiated");
		answers.set(2, "Everything in an interface is abstract");
		answers.set(3, "A class does not extend an interface but implements it");
		q1 = new Question(text, answers, "Interfaces",4);
		banky.addQuest(q1);

		//42
		text = "What package contains the necessary imports to read and write to files?";
		answers.set(0, "java.io");
		answers.set(1, "java.file");
		answers.set(2, "java.util");
		answers.set(3, "java.lang");
		q1 = new Question(text, answers, "Packages",1);
		banky.addQuest(q1);

		//43
		text = "What keyword would you use to add a package to your project?";
		answers.set(0, "import");
		answers.set(1, "add");
		answers.set(2, "include");
		answers.set(3, "package");
		q1 = new Question(text, answers, "Packages",1);
		banky.addQuest(q1);

		//43
		text = "What do packages do?";
		answers.set(0, "prevent naming conflicts");
		answers.set(1, "control access to classes");
		answers.set(2, "make searching classes easier");
		answers.set(3, "all of the above");
		q1 = new Question(text, answers, "Packages",3);
		banky.addQuest(q1);

		//44
		text = "Which of these is not a principle of object oriented programmming?";
		answers.set(0, "iteration");
		answers.set(1, "abstraction");
		answers.set(2, "polymorphism");
		answers.set(3, "inheritance");
		q1 = new Question(text, answers, "Miscellaneous Object Oriented Programming",5);
		banky.addQuest(q1);

		//45
		text = "An object...";
		answers.set(0, "Is an instance of a class");
		answers.set(1, "Is a variable");
		answers.set(2, "Belongs to a package");
		answers.set(3, "Is always private");
		q1 = new Question(text, answers, "Miscellaneous Object Oriented Programming",5);
		banky.addQuest(q1);

		//45
		text = "What is encapsulation?";
		answers.set(0, "Keeping data hidden from methods that don't explicitly need that data");
		answers.set(1, "An instace of a class");
		answers.set(2, "A working product");
		answers.set(3, "A new form of packaging");
		q1 = new Question(text, answers, "Miscellaneous Object Oriented Programming",4);
		banky.addQuest(q1);
	}


}