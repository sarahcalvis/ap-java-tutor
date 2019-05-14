import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Test bank class, holds all question objects in domain, used by testing objects
 * @author SPRECHERND1
 *
 */
public class TestBank {
	Map<String, ArrayList<Question>> bank;
	Random rand;
	int randNo;
	boolean hasQ;
	
	//initializes bank
	TestBank(){
		bank = new HashMap<String, ArrayList<Question>>();
		rand = new Random();
	}
	
	//adds question to bank
	void addQuest(Question quest){
		//if the test bank does not contain this topic, create a new one and add question
		if(!bank.containsKey(quest.getTopic())){
			quest.setID(0);
			bank.put(quest.getTopic(), new ArrayList<Question>());
			bank.get(quest.getTopic()).add(quest);
		}else{
			quest.setID(bank.get(quest.getTopic()).size());
			bank.get(quest.getTopic()).add(quest);
		}
	}
	
	//TODO: Algorithm has a weakness, just for demo rn
	//returns random, unasked question from test bank topic
	Question getQuest(String topic){
		hasQ = false;
		while(!hasQ){
			randNo = rand.nextInt(bank.get(topic).size());
			if(!bank.get(topic).get(randNo).getAsked()){
				bank.get(topic).get(randNo).setAsked(true);
				return bank.get(topic).get(randNo);
			}
		}
		return null;
	}
}
