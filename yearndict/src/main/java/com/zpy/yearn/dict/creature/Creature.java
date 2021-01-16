package creature;

import com.zpy.yearn.dict.verb.Verb;

import java.util.List;

public class Creature {

	List<creature.Desire> shortDesires;
	List<creature.Desire> longDesires;
	Verb toAct;//only do one action at a time
	//When creature is living, he always has a short desire running. 
	//When a desire is running, his toAct = the running desire
	
	public void live(){
		
	}
	
	public void nextToAct(){
		/*shortDesires.order();
		Desire firstDesire = shortDesires.pop();
		if( checkIfHappened( firstDesire ) ){
			toAct = firstDesire;
		}*/
	}
	
	public void readSentence(String input){
		
		
	}
}
