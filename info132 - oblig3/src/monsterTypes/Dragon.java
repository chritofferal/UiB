package monsterTypes;

import models.Monster;

public class Dragon extends Monster{
	
	public Dragon(int health, int level){
		super(health, level); 
		setDmgMultiplyer(1.3);
	}

}
