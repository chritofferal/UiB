package models;

import monsterTypes.Rat;


/**
 * En monsterklasse til bruk i et rollespill. 
 * Klassen har fire subklasser som skal representere fire typer monstere som alle har forskjellige egenskaper.  
 * @author Christoffer
 *
 */
public class Monster {

	private int health, level; 
	private double dmgMultiplyer, maxDmg;
	private String name; 
	final int MIN_DMG = 20; 
	
	
	
	
	/**
	 * @param health health of the new monster
	 * @param name name of the new monster
	 */
	public Monster(int health, int level ) {		
		changeHealth(health);
		setName(getClass().getSimpleName()+" " + "(Level: " + level +")");
		setLevel(level);
		setMaxDmg(MIN_DMG + (level*dmgMultiplyer));
		
		
	}
	
	public int attack(){
		if (miss() != true){
			int dmg = (int) ((Math.random()*maxDmg+1) + MIN_DMG); 			
			return (int) (dmg); 
		} else 
			return -1; 
	}
	
	private boolean miss(){
		int random = (int)(Math.random()*10+1);
	
		if (random == 10){
			return true;
		} else return false; 
	}
	
	
	
	/**
	 * @return the dmgMultiplyer
	 */
	public double getDmgMultiplyer() {
		return dmgMultiplyer;
	}


	/**
	 * @param dmgMultiplyer the dmgMultiplyer to set
	 */
	public void setDmgMultiplyer(double dmgMultiplyer) {
		this.dmgMultiplyer = dmgMultiplyer;
	}
	
	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}


	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}


	/**
	 * @return the isDead
	 */
	public boolean isDead() {
		if ( getHealth() <= 0)	{
			return true;
		} else 
		return false; 
	}



	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * @param health the health to set
	 */
	public void changeHealth(int change) {
		int temp = health + change;
		if (temp > 100) {
			health = 100;
		} else if (temp <= 0) {
			health = 0;
		} else {
			health = temp;
		}
		
	}

	/**
	 * @return the maxDmg
	 */
	public double getMaxDmg() {
		return maxDmg;
	}

	/**
	 * @param maxDmg the maxDmg to set
	 */
	public void setMaxDmg(double maxDmg) {
		this.maxDmg = maxDmg;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return getName(); 
	}
	
	
	
	public static void main(String[] args) {
		Rat drag = new Rat(100, 10); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
		System.out.println(drag.attack()); 
	
	}
}















