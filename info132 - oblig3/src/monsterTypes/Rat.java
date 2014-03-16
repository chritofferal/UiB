package monsterTypes;

import models.Monster;

public class Rat extends Monster implements interfaces.Monster{

	
	public Rat(String name, int health, int level) {
		super(name, health, level);		
		setDmgMultiplyer(1.11);		
	}
	
	
	
}
