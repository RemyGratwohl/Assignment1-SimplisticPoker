package Entities;
import java.util.ArrayList;
import java.util.List;
import Entities.Card;
import Enums.Ranks;

public class Hand {
	private String playerID;
	private List<Card> cards;
	
	public void setPlayerID(String s){
		playerID = s;
	}
	
	public String getPlayerID(){
		return playerID;
	}
	public List<Card> getCards(){
		return cards;
	}
	
	public void addCard(Card card){
		
		if (cards == null){ cards = new ArrayList<Card>(5); }
		
		if (cards.size() == 5){
			throw new IndexOutOfBoundsException("Hands can only have five cards.");
		}else{
			cards.add(card);
		}
	}
	
	public static int getRank(){
		return 0;
	}
	

}
