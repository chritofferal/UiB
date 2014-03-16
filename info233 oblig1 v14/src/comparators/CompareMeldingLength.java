package comparators;

import java.util.Comparator;

import kravspesifikasjon.TwitterMelding;

public class CompareMeldingLength implements Comparator<TwitterMelding>{

	boolean lengsteFørst; 
	
	public CompareMeldingLength (boolean lengsteFørst){
		this.lengsteFørst = lengsteFørst; 
	}
	
	@Override
	public int compare(TwitterMelding o1, TwitterMelding o2) {
		int compare; 
		
		if (o1.getMeldingsTekst().length() > o2.getMeldingsTekst().length()){
			compare = -1;
		}
		
		if  (o1.getMeldingsTekst().length() < o2.getMeldingsTekst().length()){
			compare =  1;
			
		} else compare = 0; 
		
	if (!lengsteFørst){
		compare = compare*-1; 
	}
	
	return compare; 
	}
	

}
