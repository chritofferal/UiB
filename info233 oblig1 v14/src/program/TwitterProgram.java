package program;

import io.TwitterStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.text.MaskFormatter;

import kravspesifikasjon.TwitterBrukerCollection;
import kravspesifikasjon.TwitterMelding;
import kravspesifikasjon.TwitterMeldingCollection;
import model.Bruker;
import model.BrukerCollection;
import model.MeldingCollection;
import model.Month;
import model.Tweet;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import exceptions.TwitterConnectionException;





public class TwitterProgram {
	
	private static JsonFactory jsonFactory;
	private static JsonParser parser;
	private static GUI gui;
	private static TwitterMeldingCollection masterTweet;
	private static TwitterBrukerCollection masterBruker; 
	private static TwitterStream stream;
	
	public TwitterProgram(){
		jsonFactory = new JsonFactory();
		gui = new GUI();
		masterTweet = new MeldingCollection();
		masterBruker = new BrukerCollection();
		
	}
	
	public Tweet fraJson (JsonParser jp) throws JsonParseException, IOException {
		if(jp.nextToken() != JsonToken.START_OBJECT){
			throw new IOException("ugyldig json-streng oppdaget");
		}
		
		String tekst=null , id=null;
		Bruker bruker=null; 
		Calendar tid=null; 
		
		while(jp.nextToken() != JsonToken.END_OBJECT){
			
			jp.nextToken();
			
			switch (jp.getCurrentName()) {
			
			case "created_at":
				tid = datoFraJson(jp.getText()); 
				System.out.println("Tid OK");
			
				break;
			
			case "id_str":
				id = jp.getText(); 
				System.out.println("ID OK");
				break;

			case "text":
				tekst = jp.getText(); 
				System.out.println("Tekst OK");
				break; 
				
			case "user":
				bruker = brukerFraJson(jp);	
				System.out.println(bruker);
			
				break;
				
			default:
				
				System.out.printf("Ukjent felt: %s%n", jp.getCurrentName());
				break;
			}
	
		}
		System.out.println("før if");
		
		
		return new Tweet(tekst, id, bruker, tid);
		
	}

	



	private Bruker brukerFraJson(JsonParser jp) throws JsonParseException, IOException {
		String id=null, navn=null;
		Integer numTweets=null, numFollowers=null, numFriends=null; 
		
		while(jp.nextToken() != JsonToken.END_OBJECT){
			jp.nextToken();
			
			switch (jp.getCurrentName()) {
			case "id_str":
				id = jp.getText(); 				
				break;
				
			case "name": 
				navn = jp.getText();
				break; 
				
			case "followers_count":
				numFollowers = jp.getIntValue(); 
				break;
				
			case "statuses_count":
				numTweets = jp.getIntValue(); 
				break; 
				
			case "friends_count":	
				numFriends = jp.getIntValue(); 
				break;
				
			default:
		//		System.out.printf("Ukjent felt: %s%n", jp.getCurrentName());
				break;
			}
		}
		if(null == navn){
			throw new IOException("Fant ikke feltet \"navn\"");
			
		}
		
		if(null == id){
			throw new IOException("Fant ikke feltet \"id\"");
		}
		
		if(null == numFollowers){
			throw new IOException("Fant ikke feltet \"followers\"");
		}
		
		if(null == numTweets){
			throw new IOException("Fant ikke feltet \"statuses\"");
		}

		if(null == numFriends){
			throw new IOException("Fant ikke feltet \"friends\"");
		}


		
		
		return new Bruker(navn, id, numTweets, numFollowers, numFriends);
	}
	
	



	private Calendar datoFraJson(String jsonTid) throws IllegalArgumentException { 
		Calendar cal = Calendar.getInstance();
		String[] tidElementer = jsonTid.split(" "); 
		String[] tidKlokkeslett = tidElementer[4].split(":");
		
		Integer month = null;
			
		for (Month m : Month.values()) {
			
			if (tidElementer[1].equals(m.toString())){
				month = m.getValue();
				
			}
		}
		
		Integer day = Integer.parseInt(tidElementer[2]);
		Integer year = Integer.parseInt(tidElementer[5]);
		
		if (month == 0 || day == null || year == null){
			throw new IllegalArgumentException("Fant ikke dato"); 
		}
		
		cal.set(year, month, day);
		
		return cal; 
	}
		
	public void startProgram() throws JsonParseException, IOException{
		stream = TwitterStream.instance();
		stream.connect();
		
		while(true) {
			// Sov tjue sekunder for å la køen til twitter-strømmen fylles litt opp
			try {
				Thread.sleep(20000);	
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			// Hent ut alle twitter-meldinger i køen og skriv ut.
			ArrayList<String> tweets = new ArrayList<>();
			try {
				tweets.addAll(stream.getTweets(-1));
			} catch (TwitterConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (String t : tweets) {
				parser = jsonFactory.createParser(t);
				
				System.out.println(this.fraJson(parser));
				
				
			}
		
		}
		
		
	}

	public static void main(String[] args) throws JsonParseException, IOException {	
		
		TwitterProgram kjør = new TwitterProgram(); 
		kjør.startProgram();
		
	}

}
