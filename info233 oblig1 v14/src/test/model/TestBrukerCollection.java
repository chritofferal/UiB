package test.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kravspesifikasjon.TwitterBruker;
import model.Bruker;
import model.BrukerCollection;

import org.junit.Before;
import org.junit.Test;

public class TestBrukerCollection {
	
	Bruker b1, b2, b3, b4;
	BrukerCollection brukerSamling, brukerSamling1; 

	@Before
	public void setUp() throws Exception {
		b1 = new Bruker ("Bruker 1", "U0001");
		b2 = new Bruker ("Bruker 2", "U0002");
		b3 = new Bruker ("Bruker 3", "U0003");
		b4 = new Bruker ("Bruker 4", "U0004");
		
		brukerSamling = new BrukerCollection();
		brukerSamling.insert(b1); 
		brukerSamling.insert(b2); 
		brukerSamling.insert(b3); 
	}

	@Test
	public void testBrukerCollection(){
	ArrayList<TwitterBruker> konstruktørTest = new ArrayList<>(); 
	konstruktørTest.add(b1); 
	konstruktørTest.add(b2); 
	konstruktørTest.add(b3); 
		
	brukerSamling1 = new BrukerCollection(konstruktørTest);
	
	assertEquals(brukerSamling, brukerSamling1); 
	}
	
	@Test
	public void testSize() {
		assertEquals(3, brukerSamling.size());
	}

	@Test
	public void testInsertTwitterBruker() {
		brukerSamling.insert(b4); 
		
		assertEquals(b4, brukerSamling.get(3));
	}

	@Test
	public void testInsertTwitterBrukerInt() {
		brukerSamling.insert(b4, 2); 
		
		assertEquals(b4, brukerSamling.get(2));
		assertEquals(b3, brukerSamling.get(3));

	}

	@Test
	public void testRemove() {		
		assertEquals(b2, brukerSamling.get(1));
		brukerSamling.remove(1); 		
		assertEquals(b3, brukerSamling.get(1));
	}

	@Test
	public void testGet() {
		assertEquals(b1, brukerSamling.get(0));
	}

	@Test
	public void testGetBruker() {
		fail("Not yet implemented");
	}

	@Test
	public void testSortertEtterAntallMeldinger() {
		fail("Not yet implemented");
	}

	@Test
	public void testSortertEtterAntallFollowers() {
		fail("Not yet implemented");
	}

	@Test
	public void testSortertEtterAntallFriends() {
		fail("Not yet implemented");
	}

	@Test
	public void testEquals() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		assertEquals(b1+"\n"+b2+"\n"+b3+"\n", brukerSamling.toString());
	}

}
