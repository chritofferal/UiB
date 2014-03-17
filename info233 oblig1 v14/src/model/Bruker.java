package model;

import kravspesifikasjon.TwitterBruker;

public class Bruker implements TwitterBruker {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = -7415788700512583232L;
	
	private String navn, ID; 
	private Integer numTweets, numFollowers, numFriends, numCharacters;
	


	
	
	public Bruker(String navn, String ID, Integer numTweets, Integer numFollowers, Integer numFriends, Integer numChars){
		this.navn = navn; 
		this.ID = ID; 
		this.numTweets = numTweets; 
		this.numFollowers = numFollowers; 
		this.numFriends = numFriends; 
		this.numFollowers = numFollowers; 
		this.numCharacters = numChars; 
 
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
		return numCharacters; 
	}
	
	/**
	 * Sets the total number of characters. 
	 * @param newNum the new number
	 */
	public void setNumCharacters(Integer newNum){
		this.numCharacters = newNum; 
	}

	@Override
	public double getAverageNumCharacters() {
		return numCharacters() / numTweets();
	}

	@Override
	public int numFollowers() {
		return numFollowers;
	}
	
	/**
	 * Sets the number of followers
	 * @param newNumb the new number of followers
	 */
	public void setNumFollowers(Integer newNumb){
		this.numFollowers = newNumb; 
	}

	@Override
	public int numFriends() {
		return numFriends;
	}
	
	/**
	 * Sets the number of freinds
	 * @param newNumb the new number of friends. 
	 */

	public void setNumFriends(Integer newNumb){
		this.numFriends = newNumb; 
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
