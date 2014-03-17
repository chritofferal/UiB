package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import kravspesifikasjon.TwitterBruker;
import kravspesifikasjon.TwitterBrukerCollection;

import comparators.CompareBrukerFollowers;
import comparators.CompareBrukerFreinds;
import comparators.CompareBrukerTweets;

import exceptions.BrukerNotFoundException;

public class BrukerCollection implements TwitterBrukerCollection, Iterable<TwitterBruker> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1204847412725657905L;

	ArrayList<TwitterBruker> brukerSamling; 
	private int maxSize; 
	
	/**
	 * Konstruktør som tar en ArrayList med brukere og legger dem inn i brukerSamling. 
	 * @param brukere brukerene som skal legges inn i samlingen. 
	 */
	public BrukerCollection(ArrayList<TwitterBruker> brukere){
		brukerSamling = new ArrayList<>(); 
		for (TwitterBruker bruker : brukere) {
			this.insert(bruker);	
		}
		
		maxSize = 100; 
	}
	
	public BrukerCollection(Collection<TwitterBruker> samling){
		brukerSamling = new ArrayList<>(); 
		for (TwitterBruker bruker : samling) {
			brukerSamling.add(bruker); 
		}
		
		maxSize = 100; 
	}
	
	public BrukerCollection(){
		brukerSamling = new ArrayList<>(); 
		maxSize = 100; 
	}
	
	
	@Override
	public int size() {
		return brukerSamling.size();
	}

	@Override
	public boolean insert(TwitterBruker element){
		if (brukerSamling.contains(element) || brukerSamling.size() >= maxSize){			
			return false;
		}
		brukerSamling.add(element);
		return true; 
	}

	@Override
	public boolean insert(TwitterBruker element, int index) {
		if (brukerSamling.contains(element) || brukerSamling.size() >= maxSize){			
			return false;
		}
		brukerSamling.add(index, element);
		return true; 
	}

	@Override
	public boolean remove(int index) {
		if(brukerSamling.size() == 0){
			return false; 
		}
		if(!(brukerSamling.get(index) == null)){
			brukerSamling.remove(index); 
			return true; 
		}
		return false;
	}

	@Override
	public TwitterBruker get(int index) {
		return brukerSamling.get(index); 
	}

	@Override
	public TwitterBruker getBruker(String id)throws BrukerNotFoundException { 
		for (TwitterBruker bruker : brukerSamling) {
			if ( bruker.getID() == id){
				return bruker; 
			}
		} throw new BrukerNotFoundException("User not found"); 
	}

	@Override
	public Collection<TwitterBruker> sortertEtterAntallMeldinger(boolean stigende) {
		
		ArrayList<TwitterBruker> sortert = new ArrayList<>(brukerSamling); 
		Collections.sort(sortert, new CompareBrukerTweets(stigende));
		return sortert; 
	}

	@Override
	public Collection<TwitterBruker> sortertEtterAntallFollowers(boolean stigende) {
		ArrayList<TwitterBruker> sortert = new ArrayList<>(brukerSamling); 
		Collections.sort(sortert, new CompareBrukerFollowers(stigende));
		return sortert; 
	}

	@Override
	public Collection<TwitterBruker> sortertEtterAntallFriends(boolean stigende) {
		ArrayList<TwitterBruker> sortert = new ArrayList<>(brukerSamling); 
		Collections.sort(sortert, new CompareBrukerFreinds(stigende));
		return sortert; 
	}
	
	/**
	 * . 
	 * @return listen av brukere
	 */
	public ArrayList<TwitterBruker> list(){
		return brukerSamling; 
	}
	
	
	
	
	@Override
	public String toString(){
		String streng =""; 
		for (TwitterBruker bruker : brukerSamling) {
			streng += bruker +"\n"; 
		}
		return streng; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		BrukerCollection other = (BrukerCollection) obj;
		if(!(brukerSamling.size() == other.brukerSamling.size()))
			return false; 
		
		for (int i = 0; i < brukerSamling.size(); i++){
			if(!(brukerSamling.get(i).equals(other.brukerSamling.get(i))))
				
				return false; 
		}	
		
		return true;
	}

	
	private class brukerIterator implements Iterator<TwitterBruker>{

		private int index = 0; 
		
		@Override
		public boolean hasNext() {
			return index < brukerSamling.size();
		}

		@Override
		public TwitterBruker next() {
			index++;
			return (brukerSamling.get(index));
		}

		@Override
		public void remove() {
			brukerSamling.remove(index); 
		}

	}
	
	@Override
	public Iterator<TwitterBruker> iterator() {
		return new brukerIterator(); 
	}
	
	
	
}


