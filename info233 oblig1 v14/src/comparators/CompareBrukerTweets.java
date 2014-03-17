package comparators;

import java.util.Comparator;

import kravspesifikasjon.TwitterBruker;

public class CompareBrukerTweets implements Comparator<TwitterBruker> {
	
	boolean stigende; 
	
	public CompareBrukerTweets(boolean stigende){
		this.stigende = stigende; 
	}
	

	@Override
	public int compare(TwitterBruker o1, TwitterBruker o2) {
		int compared = o1.numTweets() - o2.numTweets(); 
		if (!stigende) compared *= -1;  
		return compared; 
	}

}
