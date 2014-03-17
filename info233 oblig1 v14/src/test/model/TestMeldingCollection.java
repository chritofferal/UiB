package test.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;


import kravspesifikasjon.TwitterMelding;
import model.Bruker;
import model.MeldingCollection;
import model.Tweet;

import org.junit.Before;
import org.junit.Test;


import com.google.common.collect.Iterables;

public class TestMeldingCollection {
	
	MeldingCollection samling; 
	Bruker b1, b2, b3; 
	Calendar calendar,calendar1, calendar2; 
	Tweet melding1, melding2, melding3;
	
	@Before
	public void setup() throws Exception{
		
		b1 = new Bruker ("NAVN", "ID", 1, 1, 1, 1);
		b2 = new Bruker ("NAVN1", "ID1", 2, 2, 2, 2);
		b3 = new Bruker ("NAVN2", "ID2", 3, 3, 3, 3); 
	
		calendar = Calendar.getInstance();
		calendar1 = Calendar.getInstance();
		calendar2 = Calendar.getInstance(); 
		
		calendar.set(2014, 1, 1);	
		calendar1.set(2014, 2, 2);
		calendar2.set(2014, 3, 3);
		
		samling = new MeldingCollection();
		
		melding1 = (new Tweet("Hello", "900", b1, calendar1));
		melding2 = (new Tweet("Tester igjen", "209", b1, calendar)); 
		melding3 = (new Tweet("OG IGJEN", "201", b3, calendar2)); 
		
		samling.insert(melding1); 
		samling.insert(melding2);
		samling.insert(melding3); 
				
	}


	@Test
	public void testSize() {			 
		samling.insert(melding3); 
		assertEquals(3, samling.size());
	}

	@Test
	public void testInsertTwitterMelding() {
		samling.insert(melding3); 	
		assertEquals(samling.get(samling.size()-1), melding3 );
	}

	@Test
	public void testInsertTwitterMeldingInt() {
		samling.insert(melding1); 
		samling.insert(melding2); 
		samling.insert(melding3,1); 
		
		assertEquals(melding3, samling.get(1));
	}

	@Test
	public void testRemove() {
		samling.remove(0);
		
		assertEquals(melding2, samling.get(0));
	}

	@Test
	public void testGet() {
		assertEquals(melding1, samling.get(0));;
	}

	@Test
	public void testGetTweetsWith() {
		ArrayList<TwitterMelding> test = new ArrayList<>(); 
		test.add(melding1); 
		
		assertEquals(test, samling.getTweetsWith("Hello"));
	}

	@Test
	public void testDeleteTweetTwitterMelding() {
		samling.deleteTweet(melding1); 
		
		assertEquals(melding2, samling.get(0));
	}

	@Test
	public void testGetTweet() {
		assertEquals(melding1, samling.getTweet("900"));		
	}

	@Test
	public void testDeleteTweetString() {
		samling.deleteTweet("900"); 
		
		assertEquals(null, samling.getTweet("900"));
	}

	@Test
	public void testSortertEtterTid() {
		Collection<TwitterMelding> samling1 = samling.sortertEtterTid(true);
		Collection<TwitterMelding> samling2 = samling.sortertEtterTid(false);
	
		for (TwitterMelding twitterMelding : samling1) {
			
			assertTrue(Iterables.get(samling1, 0).dato().after(twitterMelding.dato()) || Iterables.get(samling1, 0).dato().equals(twitterMelding.dato() )); 
		}
		
		for (TwitterMelding twitterMelding : samling2) {
			assertTrue(Iterables.get(samling2, 0).dato().before(twitterMelding.dato()) || Iterables.get(samling2, 0).dato().equals(twitterMelding.dato()) ); 
		}
	}
	
	
	

	@Test
	public void testSortertEtterLengde() {
	
		Collection<TwitterMelding> samling1 = samling.sortertEtterLengde(true);
		Collection<TwitterMelding> samling2 = samling.sortertEtterLengde(false);
		
		for (TwitterMelding twitterMelding : samling1) {
			assertTrue(Iterables.get(samling1, 0).getMeldingsTekst().length() >= twitterMelding.getMeldingsTekst().length()); 
		}
		
		for (TwitterMelding twitterMelding : samling2) {
			assertTrue(Iterables.get(samling2, 0).getMeldingsTekst().length() <= twitterMelding.getMeldingsTekst().length()); 
		}
		
		
		
		
	}

	@Test
	public void testMeldingerFra() {
		MeldingCollection list = new MeldingCollection(); 
		list.insert(melding1);
		list.insert(melding2);
		
		assertEquals(samling.meldingerFra(b1), list);
	}

	@Test
	public void testEquals() {
		
		MeldingCollection samling1 = new MeldingCollection();
		samling1.insert(melding1);
		samling1.insert(melding2); 
		
		assertEquals(true, samling.equals(samling));;
		assertEquals(false, samling.equals(samling1));
	}

	@Test
	public void testToString() {
		assertEquals(melding1+"\n"+melding2+"\n"+melding3+"\n", samling.toString());;
	}

}
