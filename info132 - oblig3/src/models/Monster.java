package models;

public class Monster {

	private int health, minDmg; 
	private String name; 
	final int MIN_DMG = 20; 
	
	
	
	/**
	 * @param health health of the new monster
	 * @param name name of the new monster
	 */
	public Monster(String name, int health) {		
		setHealth(health);
		setMinDmg(MIN_DMG);
		setName(name);
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
	public void setHealth(int health) {
		this.health = health;
	}
	/**
	 * @return the dmg
	 */
	public int getMinDmg() {
		return minDmg;
	}
	/**
	 * @param dmg the dmg to set
	 */
	public void setMinDmg(int dmg) {
		this.minDmg = dmg;
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
	
}
