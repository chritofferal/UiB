package test.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import kravspesifikasjon.TwitterBruker;
import model.Bruker;
import model.BrukerCollection;

import org.junit.Before;
import org.junit.Test;

import exceptions.BrukerNotFoundException;

public class TestBrukerCollection {
	
	Bruker b1, b2, b3, b4;
	BrukerCollection brukerSamling, brukerSamling1; 

	@Before
	public void setUp() throws Exception {
		b1 = new Bruker ("Bruker 1", "U0001", 1 , 1 , 1 , 1);
		b2 = new Bruker ("Bruker 2", "U0002", 2 , 2 , 2 , 2);
		b3 = new Bruker ("Bruker 3", "U0003", 3 , 3 , 3 , 3);
		b4 = new Bruker ("Bruker 4", "U0004", 4 , 4 , 4 , 4);
		 
		brukerSamling = new BrukerCollection();
		brukerSamling1 = new BrukerCollection(); 
		brukerSamling.insert(b1); 
		brukerSamling.insert(b2); 
		brukerSamling.insert(b3); 
	
	}

	@Test
	public void testBrukerCollection(){

		System.out.println(brukerSamling.list());
	brukerSamling1 = new BrukerCollection(brukerSamling.list());
	System.out.println(brukerSamling1);
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
	public void testGetBruker() throws BrukerNotFoundException {
		assertEquals(b1, brukerSamling.getBruker("U0001"));
	
	}
	
	@Test(expected = BrukerNotFoundException.class)  
	public void testBrukerNotFound() throws BrukerNotFoundException {  
	  brukerSamling.getBruker("IDFEIL"); 
	}
	

	@Test
	public void testSortertEtterAntallMeldinger() {
		BrukerCollection sortert = new BrukerCollection(brukerSamling.sortertEtterAntallMeldinger(false)); 
		assertEquals(b3, sortert.get(0));
		
		sortert = new BrukerCollection(brukerSamling.sortertEtterAntallMeldinger(true)); 
		assertEquals(b1, sortert.get(0));
	}

	@Test
	public void testSortertEtterAntallFollowers() {
		BrukerCollection sortert = new BrukerCollection(brukerSamling.sortertEtterAntallFollowers(false)); 
		assertEquals(b3, sortert.get(0));
		
		sortert = new BrukerCollection(brukerSamling.sortertEtterAntallFollowers(true)); 
		assertEquals(b1, sortert.get(0));
	}

	@Test
	public void testSortertEtterAntallFriends() {
		BrukerCollection sortert = new BrukerCollection(brukerSamling.sortertEtterAntallFriends(false)); 
		assertEquals(b3, sortert.get(0));
		
		sortert = new BrukerCollection(brukerSamling.sortertEtterAntallFriends(true)); 
		assertEquals(b1, sortert.get(0));
	}

	@Test
	public void testEquals() {
		brukerSamling1.insert(b1);
		brukerSamling1.insert(b2);
		brukerSamling1.insert(b3);
		
		
		//System.out.println(brukerSamling);
		
		assertTrue(brukerSamling1.equals(brukerSamling));
		
		brukerSamling1 = new BrukerCollection(brukerSamling1.sortertEtterAntallFollowers(false)); 
	
		assertTrue(!brukerSamling1.equals(brukerSamling));
	}

	@Test
	public void testToString() {
		assertEquals(b1+"\n"+b2+"\n"+b3+"\n", brukerSamling.toString());
	}

}
