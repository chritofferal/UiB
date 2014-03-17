package comparators;

import java.util.Comparator;

import kravspesifikasjon.TwitterBruker;

public class CompareBrukerFreinds implements Comparator<TwitterBruker> {
	
	boolean stigende; 
	
	public CompareBrukerFreinds(boolean stigende) {
		super();
		this.stigende = stigende;
	}


	@Override
	public int compare(TwitterBruker o1, TwitterBruker o2) {
		int compared = o1.numFriends() - o2.numFriends(); 
		if (!stigende) compared *= -1; 
		return compared; 
	}

}
