import java.util.ArrayList;

/**
 * A special factory question, has two parts to the text, options for the
 * specific question, options for the right answer, etc
 * @author SPRECHERND1
 *
 */
public class FactoryQuestion {
	private int qID;						//question's ID (position in topic arrayList)
	private String textA;					//Text of the first part of the question proper
	private String textB;					//Text of the second part of the question proper
	private ArrayList<String> textOps;		//Text of the optional part of the question
	private ArrayList<String> rightAns;		//right answers, matches numbers with textOp
	private ArrayList<String> answers;		//first answer is right, it will be displayed randomly
	private String topic;					//topic of the question
	private int bloom;
	
	//Constructor. Creates question object from text, answers, topic, and bloom tag
	FactoryQuestion(String textA, String textB, ArrayList<String> textOps, ArrayList<String> rightAns, ArrayList<String> answers, String topic, int bloom){
		this.rightAns = new ArrayList<String>();
		this.textOps = new ArrayList<String>();
		this.answers = new ArrayList<String>();
		this.textA = textA;
		this.textB = textB;
		
		for(String t : textOps){
			this.textOps.add(t);
		}
		for(String r : rightAns){
			this.rightAns.add(r);
		}
		for(String a : answers){
			this.answers.add(a);
		}
		
		//asked = false;
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
	ArrayList<String> getAnswers(){
		return answers;
	}
	
	//returns specified answer
	String getTextOp(int num){
		return textOps.get(num);
	}
	
	//returns specified answer
	String getRightAns(int num){
		return rightAns.get(num);
	}
	
	//returns topic
	String getTopic(){
		return topic;
	}
	
	//returns bloom tag
	int getBloom(){
		return bloom;
	}
	
	//returns text of question
	String getTextA(){
		return textA;
	}
	
	//returns text of question
	String getTextB(){
		return textB;
	}
	
	//Returns size of answer options
	int getNumAns(){
		return textOps.size();
	}
}
