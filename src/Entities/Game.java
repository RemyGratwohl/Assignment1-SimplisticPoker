package Entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entities.Hand;

import Enums.Ranks;
import Enums.Suits;

public class Game {

	private List<String> playerIDs = new ArrayList<String>();
	private List<String> cardNameBank = new ArrayList<String>();
	private List<Hand> hands = new ArrayList<Hand>();
	
	private int numPlayers;
	
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
				 if (token.startsWith(r.toString().toLowerCase())){
					 rank = r;
					 token = token.replace(r.toString().toLowerCase(),"");
					 break;
				 }
			 }
			 
			 for(Suits s : Suits.values()){
				 if (token.equals(s.toString().toLowerCase())){
					 suit = s;
					 break;
				 }
			 }
			 
			 if (rank == null || suit == null){
				 throw new IllegalArgumentException("Invalid Tokens");
			 }else{
				 newHand.addCard(new Card(suit,rank));
			 }
		}
		Hand.sortByRank(newHand.getCards());
		return newHand;
	}
	
	public void start(){
		while(true){
			Scanner scanner = new Scanner(System.in);
		    numPlayers = 0;
			String input = "";
			
			System.out.println("Beginning Round");

			while(numPlayers < 2 || numPlayers > 4){
				System.out.println("Enter the number of Players (2-4):");
				numPlayers = scanner.nextInt();
			}
			scanner.nextLine();
			
			for (int i = 0; i < numPlayers; i++){
				System.out.println("Please enter input for hand " + (i+1));
				System.out.println("Use format playerid RankSuit RankSuit RankSuit RankSuit RankSuit");
				input = scanner.nextLine();
				hands.add(createHand(input));
			}
		}
	}
	
	private void checkIfPlayerIDExists(String s){
		if (playerIDs.contains(s)){
			throw new IllegalArgumentException("A Player with that name already exists");
		}
		playerIDs.add(s);
	}
	
	
	private void checkIfCardExists(String s){
		if (cardNameBank.contains(s)){
			throw new IllegalArgumentException("A Card of that type already exists");
		}
		cardNameBank.add(s);
	}
	
}
