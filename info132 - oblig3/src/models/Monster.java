package models;

public class Monster {

	private int health, minDmg, level; 
	private double dmgMultiplyer; 
	private String name; 
	final int MIN_DMG = 20; 
	
	
	
	
	/**
	 * @param health health of the new monster
	 * @param name name of the new monster
	 */
	public Monster(String name, int health, int level) {		
		setHealth(health);
		setMinDmg(MIN_DMG);
		setName(name);
		setLevel(level);
	}
	
	public int attack(){
		if (miss() != true){
			System.out.println(MIN_DMG * dmgMultiplyer);
			return (int) (MIN_DMG * dmgMultiplyer); 
		} else return -1; 
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
	
	
	public static void main(String[] args) {
		
		Monster monster = new Monster("Goblinator", 100	, 1);
		monster.attack();
		
	}
}
