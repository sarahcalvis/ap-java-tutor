import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Textbook {
	public VBox vby; 
	ComboBox<String> comboBox;
	WebView browser;
	Textbook() {
		//make a browser to display the file
		browser = new WebView();
		
		//make a web engine to view the file
        WebEngine webEngine = browser.getEngine();
        
        //load the entire textbook
		File f = new File("ThinkJava.html");
		
		//load the file into the web view
		webEngine.load(f.toURI().toString());
		
		//resize the browser
		browser.setPrefSize(640, 850);
		
		//make the drop down list
		ObservableList<String> options = 
			    FXCollections.observableArrayList(
			        "Contents",
			        "Preface",
			        "Chapter 1",
			        "Chapter 2",
			        "Chapter 3",
			        "Chapter 4",
			        "Chapter 5",
			        "Chapter 6",
			        "Chapter 7",
			        "Chapter 8",
			        "Chapter 9",
			        "Chapter 10",
			        "Chapter 11",
			        "Chapter 12",
			        "Chapter 13",
			        "Chapter 14",
			        "Appendix A",
			        "Appendix B",
			        "Appendix C",
			        "Index",
			        "Full Text"
			    );
		
		//add the drop down list to the combo box
		comboBox = new ComboBox<String>(options);
		
		//when the user selects 
		comboBox.setOnAction((e) -> {
			
			//this holds the file name
			String fileStr = "ThinkJava.html";
			
			//change the file name based on what the user selected from the drop down menu
            if (comboBox.getSelectionModel().getSelectedItem() == "Contents") {
            	fileStr = "thinkjavaContents.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Preface") {
            	fileStr = "thinkjavaPreface.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 1") {
            	fileStr = "thinkjava1.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 2") {
            	fileStr = "thinkjava2.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 3") {
            	fileStr = "thinkjava3.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 4") {
            	fileStr = "thinkjava4.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 5") {
            	fileStr = "thinkjava5.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 6") {
            	fileStr = "thinkjava6.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 7") {
            	fileStr = "thinkjava7.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 8") {
            	fileStr = "thinkjava8.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 9") {
            	fileStr = "thinkjava9.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 10") {
            	fileStr = "thinkjava10.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 11") {
            	fileStr = "thinkjava11.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 12") {
            	fileStr = "thinkjava12.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 13") {
            	fileStr = "thinkjava13.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Chapter 14") {
            	fileStr = "thinkjava14.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Appendix A") {
            	fileStr = "thinkjavaA.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Appendix B") {
            	fileStr = "thinkjavaB.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Appendix C") {
            	fileStr = "thinkjavaC.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Index") {
            	fileStr = "thinkjavaIndex.html";
            }
            else if (comboBox.getSelectionModel().getSelectedItem() == "Full Text") {
            	fileStr = "ThinkJava.html";
            }
            
            //create a file with the new file name in it
			File f1 = new File(fileStr);
			
			//load that file into the web engine
			webEngine.load(f1.toURI().toString());
        });
	}
	
	//getter that returns the combobox
	public ComboBox<String> getCBox() {
		return comboBox;
	}
	
	//getter that returns the browser
	public WebView getBrowser() {
		return browser;
	}
}
