package Entities;
import java.util.ArrayList;
import java.util.List;

import Entities.Hand;

import Enums.Ranks;
import Enums.Suits;

public class Game {

	private List<String> playerIDs = new ArrayList<String>();
	private List<String> cardNameBank = new ArrayList<String>();
	
	// Parses an input string and creates a new hand from it. 
	public Hand createHand(String input){
		
		if(input == ""){
			throw new IllegalArgumentException("Null Input");
		}
		
		String[] tokens = input.split("\\s");
		
		if (tokens.length != 6){
			throw new IllegalStateException("Incorrect Number of Tokens in String");
		}
		
		checkIfPlayerIDExists(tokens[0]);
		
		Hand newHand = new Hand();
		
		newHand.setPlayerID(tokens[0]);
		
		for(int i = 1; i <= 5; i++){
			 String token = tokens[i].toLowerCase();
			 
			 checkIfCardExists(token);
			 
			 Ranks rank = null;
			 Suits suit = null;
			 
			 for(Ranks r : Ranks.values()){
				 if (token.startsWith(r.name().toLowerCase())){
					 rank = r;
					 break;
				 }
			 }
			 
			 for(Suits s : Suits.values()){
				 if (token.endsWith(s.name().toLowerCase())){
					 suit = s;
					 break;
				 }
			 }
			 
			 if (rank == null && suit == null){
				 throw new IllegalArgumentException("Invalid Token");
			 }else{
				 newHand.addCard(new Card(suit,rank));
			 }
		}
		newHand.sortHand();
		return newHand;
	}
	
	private void checkIfPlayerIDExists(String s){
		if (playerIDs.contains(s)){
			throw new IllegalArgumentException("A Player with that name already exists");
		}
		playerIDs.add(s);
	}
	
	private void checkIfCardExists(String s){
		if (cardNameBank.contains(s)){
			throw new IllegalArgumentException("A Card with that name already exists");
		}
		cardNameBank.add(s);
	}
	
}
