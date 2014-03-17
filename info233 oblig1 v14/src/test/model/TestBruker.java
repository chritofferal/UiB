package test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import model.Bruker;

import org.junit.Before;
import org.junit.Test;

public class TestBruker {

	private Bruker b1; 
	
	@Before
	public void setUp() throws Exception {
		b1 = new Bruker ("B1", "ID1" , 1 , 1 , 1 , 1); 
		new Bruker ("B2", "ID2" , 2 , 2 , 2 , 2); 
		

	}

	@Test
	public void testBruker() {
		Bruker b3 = new Bruker("B3", "ID3" , 3 , 3 , 3, 3);
		assert (!(b3 != null)); 
	}

	@Test
	public void testGetNavn() {
		assertEquals("B1", b1.getNavn());
	}

	@Test
	public void testGetID() {
		assertEquals("ID1", b1.getID());
	}

	@Test
	public void testNumTweets() {
		assertEquals(1, b1.numTweets());;
	}

	@Test
	public void testSetTweets() {
		b1.setTweets(2);
		assertEquals(2, b1.numTweets());
	}

	@Test
	public void testNumCharacters() {
		assertEquals(1, b1.numCharacters());
	}

	@Test
	public void testGetAverageNumCharacters() {
		
	
		float f = (float)(b1.numCharacters() / b1.numTweets());

		assertEquals(f , b1.getAverageNumCharacters(), 0.00001);
	}

	@Test
	public void testNumFollowers() {
		assertEquals(1, b1.numFollowers());
	}

	@Test
	public void testNumFriends() {
		assertEquals(1, b1.numFriends());
	}



	@Test
	public void testToString() {
		assertEquals("B1", b1.toString());
	}

	@Test
	public void testEqualsObject() {
		Bruker b3 = new Bruker ("B1", "ID1", 1 , 3 , 4 , 5);
		assertTrue(b1.equals(b3));
	}



}
