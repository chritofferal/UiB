package model;

import java.util.ArrayList;
import java.util.Collection;

import kravspesifikasjon.TwitterBruker;
import kravspesifikasjon.TwitterBrukerCollection;

public class BrukerCollection implements TwitterBrukerCollection {

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
			insert(bruker);	
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
	public TwitterBruker getBruker(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TwitterBruker> sortertEtterAntallMeldinger(
			boolean stigende) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TwitterBruker> sortertEtterAntallFollowers(
			boolean stigende) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<TwitterBruker> sortertEtterAntallFriends(boolean stigende) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString(){
		String streng =""; 
		for (TwitterBruker bruker : brukerSamling) {
			streng += bruker +"\n"; 
		}
		return streng; 
	}

}
