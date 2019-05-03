import java.util.ArrayList;

/**
 * Testing class (quiz/exam) pulls questions from test bank on creation and is given to
 * student
 * @author SPRECHERND1
 *
 */
public class Testing {
	//type (0=>quiz, 1=>exam), questions per topic (hardwired for now), and number of
	//topics, depending on type
	int type;
	int qPerT = 4;
	int numTopics;
	
	//questions and topics for the testing object
	ArrayList<Question> questions;
	ArrayList<String> topics;
	
	//number of correct and incorrect answers
	public int nCorrect;
	public int nWrong;
	
	//grade: nCorrect/(nCorrect+nWrong) * 100
	double grade;
	
	//reference to the bank this test uses (should be same as rest of program)
	TestBank bank;
	FactoryBank factory;
	
	//constructor. Determines type, topics, and populates test from those topics
	Testing(int type, ArrayList<String> topics, TestBank bank){
		this.topics = new ArrayList<String>();
		this.questions = new ArrayList<Question>();
		this.bank = bank;
		if(type == 0){
			int numTopics = 1;
		}else{
			//Placeholder numbers
			int numTopics = 4;
		}
		for(String t : topics){
			this.topics.add(t);
		}
		Populate(topics);
	}
	
	//populates test according to given topics (getQuest() returns random, unused question)
	void Populate(ArrayList<String> topics){
		for(String t : topics){
			for(int i = 0; i < qPerT - 1; i++){
				questions.add(bank.getQuest(t));
			}
		}
		
		for(String t : topics){
			questions.add(factory.getQuest(t, 0));
		}
	}
	
	//returns specific numbered question
	Question getQ(int numInTest){
		return questions.get(numInTest);
	}
	
	//TODO: later stage
	void setQ(boolean correct){
		//TODO: update user's scores 
		//update test score
		//update question in bank
		//update question in test
	}
	
	//calculates and returns final grade, based on number correct and incorrect
	double calcGrade(){
		double newCorrect = (double)nCorrect;
		double newWrong = (double)nWrong;
		
		System.out.println("nCorrect: " + nCorrect);
		System.out.println("nWrong: " + nWrong);
	    grade = (newCorrect/(newCorrect+newWrong)) * 100;
	    System.out.println("grade: " + grade);
	    return grade;
	  }
}