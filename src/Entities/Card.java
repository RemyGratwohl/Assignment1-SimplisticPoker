package Entities;
import Enums.Suits; 
import Enums.Ranks;

public class Card {

	private Suits suit;
	private Ranks rank;

    public Card(Suits suit, Ranks rank){
    	this.rank = rank;
    	this.suit = suit;
    }
    
    public Ranks getRank(){
    	return rank;
    }
    
    public Suits getSuit(){
    	return suit;
    }
    
    public int compareTo(Card c){
    	if(getRank().ordinal() < c.getRank().ordinal()){
    		return 1; // This card has a higher rank
    	}else if (getRank().ordinal() == c.getRank().ordinal()){
    		return 0;
    	}else{
    		return -1;
    	}
    }
    
    public @Override String toString(){
    	return String.format("%s of %s", rank, suit);
    }
    
}
