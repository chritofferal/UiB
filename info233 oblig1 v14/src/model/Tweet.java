package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import kravspesifikasjon.TwitterBruker;
import kravspesifikasjon.TwitterMelding;
import program.GUI;

public class Tweet implements TwitterMelding, Comparable<Tweet> {


	private static final long serialVersionUID = 3400419175506034457L;
	String melding, ID; 
	TwitterBruker bruker; 
	Calendar tid; 
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	
	public Tweet (String melding, String ID, TwitterBruker bruker, Calendar tid){
		this.melding = melding; 
		this.ID = ID; 
		this.bruker = bruker; 
		this.tid = tid; 
		
	}
	@Override
	public String getMeldingsTekst() {
		
		return melding;
	}

	@Override
	public TwitterBruker getBruker() {
		return bruker;  
	}

	@Override
	public int size() {
		
		return melding.length();
	}

	@Override
	public Calendar dato() {
		return tid;
	}

	@Override
	public String getID() {
		return ID;
	}
	

	@Override
	public String toString() {
		return melding + " av " + bruker + ", " + dateFormat.format(tid.getTime());
	}
	

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TwitterMelding){
			return ((TwitterMelding) obj).getID().equals(this.getID());
		}
		return false;
	}
	
	@Override
	public int compareTo(Tweet o) {
		if(this.tid.before(o.tid)){
		return 1;
		} else if(o.tid.before(this.tid)){
			return -1;
		} else return 0; 
	}

	
	
}
