package Entities;
import java.util.ArrayList;
import java.util.List;
import Entities.Card;
import Enums.HandRanks;
import Enums.Ranks;
import java.util.Collections;
import java.util.Comparator;

public class Hand {
	private String playerID;
	private List<Card> cards;
	
	private Ranks mainRank;
	private List<Ranks> highcards;
	
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
	
	public static void sortByRank(List<Card> l){
		Collections.sort(l, new Comparator<Card>() {
            public int compare( Card c1, Card c2) {
                return c1.getRank().compareTo(c2.getRank());
            }
		});
	}
	
	public static void sortBySuit(List<Card> l){
		Collections.sort(l, new Comparator<Card>() {
            public int compare( Card c1, Card c2) {
                return c1.getSuit().compareTo(c2.getSuit());
            }
		});
	}
	
	public HandRanks getRank(){
		if(isStraight(cards) && isFlush(cards) && (getHighestCard().getRank() == Ranks.ACE)){
			return HandRanks.ROYALFLUSH;
		}else if(isFlush(cards) && isStraight(cards)){
			return HandRanks.STRAIGHTFLUSH;
		}else if (isFlush(cards)){
			return HandRanks.FLUSH;
		}else if(isStraight(cards)){
			return HandRanks.STRAIGHT;
		}else if(isFullHouse(cards)){
			return HandRanks.FULLHOUSE;
		}else if(hasFourOfAKind(cards)){
			return HandRanks.FOUROFAKIND;
		}else if(hasThreeOfAKind(cards)){
			return HandRanks.THREEOFAKIND;
		}else if(hasTwoPairs(cards)){
			return HandRanks.TWOPAIR;
		}else if(hasOnePair(cards)){
			return HandRanks.ONEPAIR;
		}else{
			return HandRanks.HIGHCARD;
		}
	}
	
	public Card getHighestCard(){
		sortByRank(cards);
		return cards.get(0);
	}
	
	private boolean isFlush(List<Card> l){
		sortBySuit(l);
		return (l.get(0).getSuit() == l.get(4).getSuit());
		
	}
	
	private boolean isStraight(List<Card> l){
		sortByRank(l);
		
			int testRank = l.get(0).getRank().ordinal() + 1;
			
			for (int i = 1; i < 5; i++ )
	         {
	            if ( l.get(i).getRank().ordinal() != testRank )
	               return(false); 
	            testRank++;
	         }
	         return(true);    

	}
	
	private boolean isFullHouse(List<Card> l){
		sortByRank(l);
		
		boolean firststate = l.get(0).getRank() == l.get(1).getRank() &&
				  l.get(1).getRank() == l.get(2).getRank() &&
				  l.get(3).getRank() == l.get(4).getRank();
		
		boolean secondstate  = l.get(0).getRank() == l.get(1).getRank() &&
				  l.get(2).getRank() == l.get(3).getRank() &&
				  l.get(3).getRank() == l.get(4).getRank();
		
		return (firststate || secondstate);
	}
	
	private boolean hasFourOfAKind(List<Card> l){
		sortByRank(l);
		
		boolean case1 = l.get(0).getRank() == l.get(1).getRank() &&
						l.get(1).getRank() == l.get(2).getRank() &&
	        			l.get(2).getRank() == l.get(3).getRank();
		
		boolean case2 = l.get(1).getRank() == l.get(2).getRank() &&
					   l.get(2).getRank() == l.get(3).getRank() &&
					   l.get(3).getRank() == l.get(4).getRank();
		
		return (case1 || case2);
	}
	
	
	private boolean hasThreeOfAKind(List<Card> l){
		sortByRank(l);
		
		boolean case1 = l.get(0).getRank() == l.get(1).getRank() &&
			        	l.get(1).getRank() == l.get(2).getRank();
				
		boolean case2 = l.get(1).getRank() == l.get(2).getRank() &&
					    l.get(2).getRank() == l.get(3).getRank();
		
		boolean case3 = l.get(2).getRank() == l.get(3).getRank() &&
				        l.get(3).getRank() == l.get(4).getRank();
		
		return (case1 || case2 || case3 );
	}
	
	private boolean hasTwoPairs(List<Card> l){
		sortByRank(l);
		
		boolean case1 = l.get(0).getRank() == l.get(1).getRank() &&
						l.get(2).getRank() == l.get(3).getRank();
		
		boolean case2 = l.get(0).getRank() == l.get(1).getRank() &&
						l.get(3).getRank() == l.get(4).getRank();
		
		boolean case3 = l.get(1).getRank() == l.get(2).getRank() &&
						l.get(3).getRank() == l.get(4).getRank();
		
		return (case1||case2||case3);
	}			
	
	private boolean hasOnePair(List<Card> l){
		sortByRank(l);
		
		boolean case1 = l.get(0).getRank() == l.get(1).getRank(); // first  two cards are a pair
		boolean case2 = l.get(1).getRank() == l.get(2).getRank(); // second two cards are a pair
		boolean case3 = l.get(2).getRank() == l.get(3).getRank(); // third  two cards are a pair
		boolean case4 = l.get(3).getRank() == l.get(4).getRank(); // fourth two cards are a pair
		
		return (case1 || case2 ||case3 || case4);
	}
}
