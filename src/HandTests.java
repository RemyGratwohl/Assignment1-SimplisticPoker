import static org.junit.Assert.*;
import Enums.HandRanks;
import Enums.Ranks;
import Enums.Suits;
import org.junit.Test;

public class HandTests {

	@Test
	public void testRoyalFlush() {
		Hand hand1 = new Hand();
		
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.ACE));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.KING));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.QUEEN));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.JACK));
		hand1.addCard(new Card(Suits.DIAMONDS,Ranks.TEN));
		
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
		
	}
	
	@Test
	public void testTwoPair() {
		
	}
	
	@Test
	public void testOnePair() {
		
	}
	
	@Test
	public void testHighCard() {
		
	}
	
}
