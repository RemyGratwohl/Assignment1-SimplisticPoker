package Tests;
import static org.junit.Assert.*;

import org.junit.Rule;

import Enums.HandRanks;
import Enums.Ranks;
import Enums.Suits;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Entities.Card;
import Entities.Hand;

public class HandTests {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testAddCard() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.ACE));
		assertEquals(1,hand1.getCards().size());
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.KING));
		assertEquals(2,hand1.getCards().size());
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.QUEEN));
		assertEquals(3,hand1.getCards().size());
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.JACK));
		assertEquals(4,hand1.getCards().size());
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.TEN));
		assertEquals(5,hand1.getCards().size());
		
		exception.expect(IndexOutOfBoundsException.class);
		exception.expectMessage("Hands can only have five cards.");
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.FOUR));
	}
	
	@Test
	public void testRoyalFlush() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.ACE));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.KING));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.QUEEN));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.JACK));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.TEN));
		
		System.out.println(hand1.getRank());
		assertEquals(HandRanks.ROYALFLUSH,hand1.getRank());
	}
	
	@Test
	public void testStraightFlush() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.SIX));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.SEVEN));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.EIGHT));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.NINE));
		
		assertEquals(HandRanks.STRAIGHTFLUSH,hand1.getRank());
	}
	
	@Test
	public void testFourOfAKind() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.SPADES,Ranks.FIVE));
		hand1.addCard(new Card(Suits.HEARTS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.CLUBS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.NINE));
		
		assertEquals(HandRanks.FOUROFAKIND,hand1.getRank());
	}
	
	@Test
	public void testFullHouse() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.HEARTS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.SPADES,Ranks.FIVE));
		hand1.addCard(new Card(Suits.SPADES,Ranks.EIGHT));
		hand1.addCard(new Card(Suits.CLUBS,Ranks.EIGHT));
		
		assertEquals(HandRanks.FULLHOUSE,hand1.getRank());
	}

	@Test
	public void testFlush() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.TWO));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.FOUR));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.TEN));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.QUEEN));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.KING));
		
		assertEquals(HandRanks.FLUSH,hand1.getRank());
	}
	
	@Test
	public void testStraight() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.CLUBS,Ranks.SIX));
		hand1.addCard(new Card(Suits.CLUBS,Ranks.SEVEN));
		hand1.addCard(new Card(Suits.HEARTS,Ranks.EIGHT));
		hand1.addCard(new Card(Suits.SPADES,Ranks.NINE));
		
		assertEquals(HandRanks.STRAIGHT,hand1.getRank());
	}
	
	@Test
	public void testThreeOfAKind() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.CLUBS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.HEARTS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.HEARTS,Ranks.EIGHT));
		hand1.addCard(new Card(Suits.SPADES,Ranks.NINE));
		
		assertEquals(HandRanks.THREEOFAKIND,hand1.getRank());
	}
	
	@Test
	public void testTwoPair() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.CLUBS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.SPADES,Ranks.EIGHT));
		hand1.addCard(new Card(Suits.HEARTS,Ranks.EIGHT));
		hand1.addCard(new Card(Suits.SPADES,Ranks.NINE));
		
		assertEquals(HandRanks.TWOPAIR,hand1.getRank());
	}
	
	@Test
	public void testOnePair() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.CLUBS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.SPADES,Ranks.EIGHT));
		hand1.addCard(new Card(Suits.HEARTS,Ranks.JACK));
		hand1.addCard(new Card(Suits.SPADES,Ranks.NINE));
		
		assertEquals(HandRanks.ONEPAIR,hand1.getRank());
	}
	
	@Test
	public void testHighCard() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.FIVE));
		hand1.addCard(new Card(Suits.CLUBS,Ranks.TWO));
		hand1.addCard(new Card(Suits.SPADES,Ranks.ACE));
		hand1.addCard(new Card(Suits.HEARTS,Ranks.EIGHT));
		hand1.addCard(new Card(Suits.SPADES,Ranks.NINE));
		
		assertEquals(HandRanks.HIGHCARD,hand1.getRank());
		assertEquals(Ranks.ACE,hand1.getHighestCard().getRank());
	}
}
