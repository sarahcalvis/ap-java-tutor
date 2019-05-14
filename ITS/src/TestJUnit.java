import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestJUnit {
	//Testing Constructors
	@Test
	public void FactoryBankConstructor(){
		FactoryBank factory = new FactoryBank();
	}
	
	@Test
	public void FactoryQuestionConstructor(){
		String textA = "What is a ";
		String textB = " for?";
		ArrayList<String> textOps = new ArrayList<String>();
		textOps.add("Shmrg");
		textOps.add("BlehBlehBleh");
		textOps.add("Yodle Dee");
		textOps.add("Poodle");
		ArrayList<String> rightAns = new ArrayList<String>();
		rightAns.add("A Shmrg is for something");
		rightAns.add("A BlehBlehBleh is stupid");
		rightAns.add("A Yodle Dee is a placeholder");
		rightAns.add("A Poodle is cute");
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("b");
		answers.add("c");
		answers.add("d");
		
		FactoryQuestion sampleQ = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
	}

	//Testing getters for FQ
	@Test
	public void FactoryQuestionTextA(){
		String textA = "What is a ";
		String textB = " for?";
		ArrayList<String> textOps = new ArrayList<String>();
		textOps.add("Shmrg");
		ArrayList<String> rightAns = new ArrayList<String>();
		rightAns.add("A BlehBlehBleh is stupid");
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("b");
		
		FactoryQuestion sampleQ = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
		
		assertEquals(sampleQ.getTextA(), "What is a ");
	}
	
	@Test
	public void FactoryQuestionTextB(){
		String textA = "What is a ";
		String textB = " for?";
		ArrayList<String> textOps = new ArrayList<String>();
		textOps.add("Shmrg");
		ArrayList<String> rightAns = new ArrayList<String>();
		rightAns.add("A BlehBlehBleh is stupid");
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("b");
		
		FactoryQuestion sampleQ = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
		
		assertEquals(sampleQ.getTextB(), " for?");
	}
	
	@Test
	public void FactoryQuestionTextOp(){
		String textA = "What is a ";
		String textB = " for?";
		ArrayList<String> textOps = new ArrayList<String>();
		textOps.add("Shmrg");
		ArrayList<String> rightAns = new ArrayList<String>();
		rightAns.add("A BlehBlehBleh is stupid");
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("b");
		
		FactoryQuestion sampleQ = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
		
		assertEquals(sampleQ.getTextOp(0), "Shmrg");
	}
	
	@Test
	public void FactoryQuestionRightAns(){
		String textA = "What is a ";
		String textB = " for?";
		ArrayList<String> textOps = new ArrayList<String>();
		textOps.add("Shmrg");
		ArrayList<String> rightAns = new ArrayList<String>();
		rightAns.add("A BlehBlehBleh is stupid");
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("b");
		
		FactoryQuestion sampleQ = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
		
		assertEquals(sampleQ.getRightAns(0), "A BlehBlehBleh is stupid");
	}
	
	@Test
	public void FactoryQuestionAnswers(){
		String textA = "What is a ";
		String textB = " for?";
		ArrayList<String> textOps = new ArrayList<String>();
		textOps.add("Shmrg");
		ArrayList<String> rightAns = new ArrayList<String>();
		rightAns.add("A BlehBlehBleh is stupid");
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("b");
		
		FactoryQuestion sampleQ = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
		
		System.out.println(sampleQ.getAnswers());
	}
	
	@Test
	public void FactoryQuestionTopic(){
		String textA = "What is a ";
		String textB = " for?";
		ArrayList<String> textOps = new ArrayList<String>();
		textOps.add("Shmrg");
		ArrayList<String> rightAns = new ArrayList<String>();
		rightAns.add("A BlehBlehBleh is stupid");
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("b");
		
		FactoryQuestion sampleQ = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
		
		assertEquals(sampleQ.getTopic(), "SampleTopic");
	}
	
	@Test
	public void FactoryQuestionBloom(){
		String textA = "What is a ";
		String textB = " for?";
		ArrayList<String> textOps = new ArrayList<String>();
		textOps.add("Shmrg");
		ArrayList<String> rightAns = new ArrayList<String>();
		rightAns.add("A BlehBlehBleh is stupid");
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("b");
		
		FactoryQuestion sampleQ = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
		
		assertEquals(sampleQ.getBloom(), 0);
	}

	//Test FactoryBank
	@Test
	public void FBaddQnoT(){
		FactoryBank factory = new FactoryBank();
		
		String textA = "What is a ";
		String textB = " for?";
		ArrayList<String> textOps = new ArrayList<String>();
		textOps.add("Shmrg");
		ArrayList<String> rightAns = new ArrayList<String>();
		rightAns.add("A BlehBlehBleh is stupid");
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("b");
		
		FactoryQuestion sampleQ = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
		
		factory.addQuest(sampleQ);
	}
	
	@Test
	public void FBaddQyesT(){
		FactoryBank factory = new FactoryBank();
		
		String textA = "What is a ";
		String textB = " for?";
		ArrayList<String> textOps = new ArrayList<String>();
		textOps.add("Shmrg");
		ArrayList<String> rightAns = new ArrayList<String>();
		rightAns.add("A BlehBlehBleh is stupid");
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("b");
		
		FactoryQuestion sampleQ = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
		FactoryQuestion sample2 = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
		
		factory.addQuest(sampleQ);
		factory.addQuest(sample2);
	}

	@Test
	public void FBprintQ(){
		FactoryBank factory = new FactoryBank();
		
		String textA = "What is a ";
		String textB = " for?";
		ArrayList<String> textOps = new ArrayList<String>();
		textOps.add("Shmrg");
		textOps.add("BlehBlehBleh");
		textOps.add("Yodle Dee");
		textOps.add("Poodle");
		ArrayList<String> rightAns = new ArrayList<String>();
		rightAns.add("A Shmrg is for something");
		rightAns.add("A BlehBlehBleh is stupid");
		rightAns.add("A Yodle Dee is a placeholder");
		rightAns.add("A Poodle is cute");
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("b");
		answers.add("c");
		answers.add("d");
		
		FactoryQuestion sampleQ = new FactoryQuestion(textA, textB, textOps, rightAns, answers, "SampleTopic", 0);
	
		factory.addQuest(sampleQ);
		
		Question testQ = factory.getQuest("SampleTopic", 0);
		
		System.out.println(testQ.getText());
		System.out.println("\t"+testQ.getAnswer(0));
		System.out.println("\t"+testQ.getAnswer(1));
		System.out.println("\t"+testQ.getAnswer(2));
		System.out.println("\t"+testQ.getAnswer(3));
		
	}
}
