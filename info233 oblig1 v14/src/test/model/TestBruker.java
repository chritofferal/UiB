package test.model;

import static org.junit.Assert.*;

import java.util.Calendar;

import model.Bruker;
import model.Tweet;

import org.junit.Before;
import org.junit.Test;

public class TestBruker {

	private Bruker b1, b2; 
	private Tweet t1,t2,t3,t4,t5; 
	private Calendar cal1, cal2, cal3; 
	
	@Before
	public void setUp() throws Exception {
		b1 = new Bruker ("B1", "ID1"); 
		b2 = new Bruker ("B2", "ID2"); 
		
		cal2 = Calendar.getInstance(); 
		cal1 = Calendar.getInstance(); 
		cal3 = Calendar.getInstance(); 
		
		cal1.set(2014, 1, 1);	
		cal2.set(2014, 2, 2);
		cal3.set(2014, 3, 3);
		
		t1 = new Tweet("Tweet nr1", "t1", b1, cal1); 
		t2 = new Tweet("Tweet n2", "t2", b1, cal2); 
		t3 = new Tweet("Tweet nr3", "t3", b2, cal1); 
		t4 = new Tweet("Tweet nr4", "t4", b1, cal3); 
		t5 = new Tweet("Tweet nr5", "t5", b2, cal3); 
	}

	@Test
	public void testBruker() {
		Bruker b3 = new Bruker("B3", "ID3");
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
		fail("Not yet implemented");
	}

	@Test
	public void testSetTweets() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumCharacters() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAverageNumCharacters() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumFollowers() {
		fail("Not yet implemented");
	}

	@Test
	public void testNumFriends() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTweet() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject1() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString1() {
		fail("Not yet implemented");
	}

}
