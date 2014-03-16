package model;

import kravspesifikasjon.TwitterBruker;
import kravspesifikasjon.TwitterMelding;

public class Bruker implements TwitterBruker {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = -7415788700512583232L;
	
	private String navn, ID; 
	private Integer numTweets, numFollowers, numFriends;
	


	
	
	public Bruker(String navn, String ID, Integer numTweets, Integer numFollowers, Integer numFriends){
		this.navn = navn; 
		this.ID = ID; 
		this.numTweets = numTweets; 
		this.numFollowers = numFollowers; 
		this.numFriends = numFriends; 
		this.numFollowers = numFollowers; 
 
	}
	
	@Override
	public String getNavn() {
		return navn;
	}

	@Override
	public String getID() {
		return ID;
	}

	@Override
	public int numTweets() {
		return numTweets;
	}
	
	/**
	 * Setter numTweets til et nytt tall. 
	 * @param newNumb det nye numTweets. 
	 */
	public void setTweets (int numTweets){
		this.numTweets = numTweets; 
	}

	@Override
	public int numCharacters() {
		MeldingCollection meldinger = new MeldingCollection();
		meldinger.meldingerFra(this); 
		int numChar = 0;
		
		for (TwitterMelding tweet : meldinger) {
			numChar += tweet.getMeldingsTekst().length();
		}
		return numChar; 
	}

	@Override
	public double getAverageNumCharacters() {
		return numCharacters() / numTweets();
	}

	@Override
	public int numFollowers() {
		return numFollowers;
	}

	@Override
	public int numFriends() {
		return numFriends;
	}
	
	@Override
	public String toString() {
		return navn;
	}


	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Bruker)) {
			return false;
		}
		Bruker other = (Bruker) obj;
		if (ID == null) {
			if (other.ID != null) {
				return false;
			}
		} else if (!ID.equals(other.ID)) {
			return false;
		}
		return true;
	}

}
