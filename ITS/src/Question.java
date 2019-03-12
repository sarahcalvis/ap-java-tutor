import java.util.ArrayList;

/**
 * Question class. An individual question
 * @author SPRECHERND1
 *
 */
public class Question {
	int qID;						//question's ID (position in topic arrayList)
	String text;					//Text of the question proper
	ArrayList<String> answers;		//first answer is right, it will be displayed randomly
	boolean asked;					//true if asked, false if not yet asked
	String topic;					//topic of the question
	String bloom;					//which level of Bloom's Taxonomy
	
	//Constructor. Creates question object from text, answers, topic, and bloom tag
	Question(String text, ArrayList<String> answers, String topic, String bloom){
		this.answers = new ArrayList<String>();
		this.text = text;
		for(String a : answers){
			this.answers.add(a);
		}
		asked = false;
		this.topic = topic;
		this.bloom = bloom;
	}
	
	//sets ID, to be done by test bank, when it adds this question
	void setID(int id){
		this.qID = id;
	}
	
	//returns ID
	int getID(){
		return qID;
	}
	
	//returns specified answer
	String getAnswer(int ans){
		return answers.get(ans);
	}
	
	//sets this questions "asked" status, to be done by testing object, upon creation
	void setAsked(boolean asked){
		this.asked = asked;
	}
	
	//returns asked status
	boolean getAsked(){
		return asked;
	}
	
	//returns topic
	String getTopic(){
		return topic;
	}
	
	//returns bloom tag
	String getBloom(){
		return bloom;
	}
	
	//returns text of question
	String getText(){
		return text;
	}
}
