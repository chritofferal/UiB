package test.model;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import model.Bruker;
import model.Tweet;

import org.junit.Before;
import org.junit.Test;

public class TestTweet {
	
	public Tweet melding; 
	public Bruker bruker; 
	public Calendar calendar;    
	public Tweet melding2;


	
	@Before
	public void setUp() {
		bruker = new Bruker("B1", "id1", 2, 2, 1);
	
		calendar = Calendar.getInstance();  
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.MONTH, 2);
		calendar.set(Calendar.DAY_OF_MONTH, 17);                 
		calendar.set(Calendar.HOUR_OF_DAY, 10);
		calendar.set(Calendar.MINUTE, 45);
		calendar.set(Calendar.SECOND, 0);
		melding = new Tweet("Hello", "900", bruker, calendar);
		melding2 = new Tweet("Hello", "900", bruker, calendar);
	}
	

	@Test
	public void testGetMeldingsTekst() {
		assertEquals("Hello", melding.getMeldingsTekst());
	}

	@Test
	public void testGetBruker() {
		assertEquals(bruker, melding.getBruker());  
	}

	@Test
	public void testSize() {
		assertEquals(5, melding.size()); 
	}

	@Test
	public void testDato() {
		assertEquals(calendar, melding.dato());
	}

	@Test
	public void testGetID() {
		assertEquals("900", melding.getID());
	}

	@Test
	public void testEquals() {
		assertEquals(true, melding.equals(melding2) );;
	}

	@Test
	public void testToString() {
		assertEquals("Hello av " + bruker +", 17/03/2013" , melding.toString());
	}

}
