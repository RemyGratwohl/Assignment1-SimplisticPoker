package Tests;
import static org.junit.Assert.*;
import Entities.Game;
import Entities.Hand;
import Enums.Ranks;
import Enums.Suits;
import org.junit.Test;

public class GameTests {

	@Test
	public void testMakeHand() {
		String samplestring = "John TenSpades AceHearts SevenDiamonds KingClubs TwoSpades";
		Game newgame = new Game();
		Hand newhand = newgame.makeHand(samplestring);
		
		assertEquals("John",newhand.getPlayerID());
		
		assertNotNull(newhand.getCards());
		assertEquals(5,newhand.getCards().size());
		
		assertEquals(Ranks.ACE,newhand.getCards().get(0).getRank());
		assertEquals(Suits.HEARTS,newhand.getCards().get(0).getSuit());
		assertEquals(Ranks.KING,newhand.getCards().get(1).getRank());
		assertEquals(Suits.DIAMONDS,newhand.getCards().get(1).getSuit());
		assertEquals(Ranks.TEN,newhand.getCards().get(2).getRank());
		assertEquals(Suits.SPADES,newhand.getCards().get(2).getSuit());
		assertEquals(Ranks.SEVEN,newhand.getCards().get(3).getRank());
		assertEquals(Suits.DIAMONDS,newhand.getCards().get(3).getSuit());
		assertEquals(Ranks.TWO,newhand.getCards().get(4).getRank());
		assertEquals(Suits.SPADES,newhand.getCards().get(4).getSuit());
	}
	
}
