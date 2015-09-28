package Entities;
import java.util.ArrayList;
import java.util.List;
import Entities.Card;
import Enums.Ranks;
import java.util.Collections;
import java.util.Comparator;

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
	
	public void sortHand(){
		Collections.sort(cards, new Comparator<Card>() {
            public int compare( Card c1, Card c2) {
                return c1.getRank().compareTo(c2.getRank());
            }
		});
	}
	
	public int getRank(){
		return 0;
	}
	
	public List<Card> getHighCards(){
		return null;
	}
	

}
