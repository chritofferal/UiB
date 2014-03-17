package comparators;

import java.util.Comparator;

import kravspesifikasjon.TwitterBruker;

public class CompareBrukerFollowers implements Comparator<TwitterBruker> {
	
	boolean stigende; 
	
	public CompareBrukerFollowers(boolean stigende) {
		super();
		this.stigende = stigende;
	}


	@Override
	public int compare(TwitterBruker o1, TwitterBruker o2) {
		int compared = o1.numFollowers() - o2.numFollowers(); 
		if (!stigende) compared *= -1; 
		return compared; 
	}

}
