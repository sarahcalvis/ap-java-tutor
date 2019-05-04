import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseQuestions {
	static TestBank banky = new TestBank();
	/**
	 * @throws JSONException
	 * @throws IOException
	 * @throws ParseException
	 * This method opens a JSON file holding an array of all the questions
	 * It parses the file
	 * It creates question objects which are added to the question bank
	 */
	public static TestBank fillTestBank() throws JSONException, IOException, ParseException {
		//create the textbook variables
		Question question;
		String text;
		String topic;
		int bloom;
		ArrayList<String> answers;
		
		//parse the JSON file into an array
		JSONParser parser = new JSONParser();
		JSONArray arr = (JSONArray) parser.parse(new FileReader("q.json"));
		
		//iterate through the array
		for (Object r: arr) {
			
			//convert each question into a JSON object
			JSONObject q = (JSONObject) r;
			
			//get the question
			text = (String) q.get("text");
			
			//get the answers to the questions
			JSONObject a = (JSONObject) q.get("answers");
			answers = new ArrayList<String>();
			answers.add((String)a.get("0"));
			answers.add((String)a.get("1"));
			answers.add((String)a.get("2"));
			answers.add((String)a.get("3"));
			
			//get the topic
			topic = (String)q.get("topic");
			
			//get the Bloom portion
			bloom = Integer.parseInt((String)q.get("Bloom"));
			
			//create a new question
			question = new Question(text, answers, topic, bloom);
			
			//add the question to the question bank
			banky.addQuest(question);
		}
		return banky;
	}
}
