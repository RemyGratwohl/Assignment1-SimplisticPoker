package Tests;
import static org.junit.Assert.*;

import org.junit.Rule;

import Entities.Game;
import Entities.Hand;
import Enums.Ranks;
import Enums.Suits;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GameTests {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testMakeHand() {
		String samplestring = "John TenSpades AceHearts SevenDiamonds KingClubs TwoSpades";
		Game newgame = new Game();
		Hand newhand = newgame.createHand(samplestring);
		
		assertEquals("John",newhand.getPlayerID());
		
		assertNotNull(newhand.getCards());
		assertEquals(5,newhand.getCards().size());
		
		assertEquals(Ranks.ACE,newhand.getCards().get(0).getRank());
		assertEquals(Ranks.KING,newhand.getCards().get(1).getRank());
		assertEquals(Ranks.TEN,newhand.getCards().get(2).getRank());
		assertEquals(Ranks.SEVEN,newhand.getCards().get(3).getRank());
		assertEquals(Ranks.TWO,newhand.getCards().get(4).getRank());
		
		assertEquals(Suits.HEARTS,newhand.getCards().get(0).getSuit());
		assertEquals(Suits.CLUBS,newhand.getCards().get(1).getSuit());
		assertEquals(Suits.SPADES,newhand.getCards().get(2).getSuit());
		assertEquals(Suits.DIAMONDS,newhand.getCards().get(3).getSuit());
		assertEquals(Suits.SPADES,newhand.getCards().get(4).getSuit());
	}
	
	@Test
	public void testHandInputTooShort(){
		String samplestring1 = "John"; // String with less than six arguments
	
		Game newgame = new Game();
		
		exception.expect(IllegalStateException.class);
		exception.expectMessage("Incorrect Number of Tokens in String");
		newgame.createHand(samplestring1);
	}
	
	@Test
	public void testHandInputTooLong(){
		String samplestring1 = "John TenSpades AceHearts SevenDiamonds KingClubs TwoSpades SevenHearts"; // String with less than six arguments
	
		Game newgame = new Game();
		
		exception.expect(IllegalStateException.class);
		exception.expectMessage("Incorrect Number of Tokens in String");
		newgame.createHand(samplestring1);
	}
	
	@Test
	public void testInvalidInput(){
		String samplestring1 = "John TenSpades AcedssdsHearts SevenDiamonds KingClubs TwoSpades";
		
		Game newgame = new Game();
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Invalid Tokens");
		newgame.createHand(samplestring1);
	}
	
	@Test
	public void testDuplicateCardInput(){
		String samplestring1 = "John TenSpades TenSpades TenSpades TenSpades TenSpades";
		
		Game newgame = new Game();
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("A Card of that type already exists");
		newgame.createHand(samplestring1);
	}
	
	@Test
	public void testDuplicateCardDifferentHand(){
		String samplestring1 = "John TenSpades AceHearts SevenDiamonds KingClubs TwoSpades";
		String samplestring2 = "Jeff ThreeSpades EightSpades QueenSpades AceSpades TenSpades";
		
		Game newgame = new Game();
		
		newgame.createHand(samplestring1);
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("A Card of that type already exists");
		newgame.createHand(samplestring2);
	}
	
	@Test
	public void testDuplicatePlayerID(){
		String samplestring1 = "John TenSpades AceHearts SevenDiamonds KingClubs TwoSpades";
		String samplestring2 = "John ThreeSpades EightSpades QueenSpades AceSpades TwoHearts";
		
		Game newgame = new Game();
		
		newgame.createHand(samplestring1);
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("A Player with that name already exists");
		newgame.createHand(samplestring2);
	}
	
	
}
