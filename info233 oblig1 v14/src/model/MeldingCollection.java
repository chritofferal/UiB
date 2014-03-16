package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import comparators.CompareMeldingLength;
import comparators.CompareMeldingTime;
import kravspesifikasjon.TwitterBruker;
import kravspesifikasjon.TwitterMelding;
import kravspesifikasjon.TwitterMeldingCollection;

public class MeldingCollection implements TwitterMeldingCollection, Iterable<TwitterMelding>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1435977235872095005L;	
	
	protected ArrayList<TwitterMelding> samling = new ArrayList<>();
	
	/**
	 * Lager en meldingssamling og tar en samling av meldinger som paramter.
	 * @param meldinger samling meldinger som legges til i samlingsobjektet. 
	 */
	public MeldingCollection(Collection <TwitterMelding> meldinger){	 
		samling = new ArrayList<>(); 
		for(TwitterMelding x: meldinger){
			samling.add(x); 
		}
	}
	
	public MeldingCollection (){
		  this.samling = new ArrayList<>(); 
	}


	@Override
	public boolean insert(TwitterMelding element) {
		if (samling.contains(element)){
			// Elementet er allerede tilstedet
			return false; 
		} 
		
		samling.add(element);
		return true;
		
	}
	

	@Override
	public int size() {	
		return samling.size();
	}

	@Override
	public boolean insert(TwitterMelding element, int index) {
		if (index >= samling.size() || index < 0){
			// index er out of bounds
			return false; 		
		} else {
			samling.add(index, element); 		
			return true; 		
		}
	}

	@Override
	public boolean remove(int index) {
		if (samling.get(index) != null){
			samling.remove(index); 
			return true; 
		} else 
		return false; 
	}

	@Override
	public TwitterMelding get(int index) {		
		return samling.get(index);
	}

	@Override
	public Collection<TwitterMelding> getTweetsWith(String word) {
		ArrayList<TwitterMelding> containsWord = new ArrayList<>(); 
		
		for (TwitterMelding tweet : samling) {
			if (tweet.getMeldingsTekst().matches(".*\\b" + word + "\\.*")){
				containsWord.add(tweet); 
			}					
		}
		
		return containsWord; 
	}

	@Override
	public boolean deleteTweet(TwitterMelding tm) {
		if (samling.contains(tm)){
			samling.remove(tm); 
			return true; 
		}
		return false;
	}

	@Override
	public TwitterMelding getTweet(String id) {
		for (TwitterMelding tweet : samling) {
			if(tweet.getID().equals(id)){
				return tweet; 
			}
		} 		
		
		return null;
	}

	@Override
	public boolean deleteTweet(String id) {
		if (getTweet(id) != null){
		samling.remove(getTweet(id));
		return true; 
		}
		
		return false; 
	}

	@Override
	public Collection<TwitterMelding> sortertEtterTid(boolean nyesteFørst) {

		Collections.sort(samling, new CompareMeldingTime(nyesteFørst));		
		return samling;
	}

	@Override
	public Collection<TwitterMelding> sortertEtterLengde(boolean lengsteFørst) {
		ArrayList<TwitterMelding> nySamling = new ArrayList<>(samling); 
	
		Collections.sort(nySamling, new CompareMeldingLength(lengsteFørst));
		return nySamling;
	}

	@Override
	public TwitterMeldingCollection meldingerFra(TwitterBruker bruker) {
		TwitterMeldingCollection meldingerFra = new MeldingCollection(); 
		
		for (TwitterMelding tweet : samling) {
			if(tweet.getBruker().equals(bruker)){
				meldingerFra.insert(tweet); 
			}
		}
		
		return meldingerFra; 
	}
	
	
	@Override
	public String toString() {
		String streng ="";
		for (TwitterMelding t : samling) {
			streng += t +"\n"; 
		}
		return streng;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ((!(obj instanceof MeldingCollection))){
			return false; 
		}
		if (this.size() == ((MeldingCollection) obj).size()) {
			for (TwitterMelding tweet : this.samling) {
				if ( !((MeldingCollection) obj).samling.contains(tweet) ){
					return false; 
				} 
			} return true; 
		}
		
		return false;	
	}

	
	private class meldingIterator implements Iterator<TwitterMelding>{

		private int index = 0; 
		
		@Override
		public boolean hasNext() {
			return index < samling.size();
		}

		@Override
		public TwitterMelding next() {
			index++;
			return (samling.get(index));
		}

		@Override
		public void remove() {
			samling.remove(index); 
		}

	}

	@Override
	public Iterator<TwitterMelding> iterator() {
		return new meldingIterator(); 
	}




}
