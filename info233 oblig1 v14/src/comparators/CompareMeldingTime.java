package comparators;

import java.util.Comparator;

import kravspesifikasjon.TwitterMelding;

public class CompareMeldingTime implements Comparator<TwitterMelding> {
	boolean nyesteFyrst;
	
	public CompareMeldingTime(boolean nyasteFyrst) {
		this.nyesteFyrst = nyasteFyrst;
	}
	
	@Override
	public int compare(TwitterMelding o1, TwitterMelding o2) {
		int comparison = o1.dato().compareTo(o2.dato());
		if(nyesteFyrst){
			comparison *= -1;
		}
		
		return comparison;
	}

}
