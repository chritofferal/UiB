package models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Oblig 1 This class represents a Player in a role-playing game.
 * 
 * @author Eirik Berntsen & Maiken Beate Fjellanger
 * @version 0.2 07.03.2014
 * 
 */
public class Player {

	// fields
	private String name;
	private String type;
	private int health;
	private HashMap<String, Item> items;
	private int maxWeight;
	private int gold;

	/**
	 * Constructor for the Player class.
	 * 
	 * @param playerName
	 *            the players name
	 * @param playerType
	 *            the players type
	 * @param maxWeight
	 *            - maximum weight limit player can carry
	 */
	public Player(String playerName, String playerType, int maxWeight) {
		setName(playerName);
		setType(playerType);
		setMaxWeight(maxWeight);
		items = new HashMap<String, Item>();;
		health = 100;
	}

	/**
	 * Adds an item to players inventory if the weight of the new item plus the
	 * weight of the remaining items in players inventory does not exceed the
	 * players carrying capacity
	 * 
	 * @param item
	 *            the new item
	 */
	public void addItem(Item item) {
		if ((item.getWeight() + getTotalWeight()) <= maxWeight) {
			items.put(item.getName(), item);
		} else {
			System.out.println("Too heavy to carry now");
		}
	}

	/**
	 * Finds an item based on the items name
	 * 
	 * @param itemName
	 *            items name
	 * @return item - if found else null
	 */
	public Item findItem(String itemName) {
		Item item = null;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getName().equals(itemName)) {
				item = items.get(i);
			}
		}
		return item;
	}

	/**
	 * Sell an item if found
	 * 
	 * @param itemName
	 *            items name
	 */
	public void sellItem(String itemName) {
		Item item = findItem(itemName);
		if (item != null) {
			gold += item.getValue();
			items.remove(item);
			System.out.println(itemName + " is sold for " + item.getValue()
					+ " gold!");
		} else {
			System.out.println("You don't have an item with this name.");
		}
	}

	/**
	 * Sums up and returns the weight of the items player is carrying.
	 * 
	 * @return totalWeight the weigth of players items
	 */
	private int getTotalWeight() {
		int totalWeight = 0;
		for (Map.Entry<String, Item> entry : items.entrySet()){
			totalWeight += entry.getValue().getWeight();
		}
		return totalWeight;
	}

	/**
	 * Checks if the player is dead or not.
	 * 
	 * @return true if the player is dead.
	 */
	public boolean isDead() {
		if (health > 0 && health <= 100) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Changes the players health. The health can not be less the 0 or greater
	 * than 100.
	 * 
	 * @param healthPoints
	 *            the amount to modify health. Can be positive or negative.
	 */
	public void changeHealth(int healthPoints) {
		int temp = health + healthPoints;
		if (temp > 100) {
			health = 100;
		} else if (temp <= 0) {
			health = 0;
		} else {
			health = temp;
		}
	}

	/**
	 * Prints info about the player.
	 */
	public void print() {
		System.out.println("Name: " + name + " Type: " + type + " Max Weight: "
				+ maxWeight + " Gold: " + gold);
		if (!isDead()) {
			System.out.println("Is alive with health: " + health);
		} else {
			System.out.println("Is dead. Game Over");
		}
		for (Map.Entry<String, Item> entry : items.entrySet()){
			entry.getValue().print();
		}
	}

	/**
	 * @return the players name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the players type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the players health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @return the players itemlist
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * @return the players max weight limit
	 */
	public int getMaxWeight() {
		return maxWeight;
	}

	/**
	 * @return the players gold
	 */
	public int getGold() {
		return gold;
	}

	/**
	 * @param newType
	 *            the players' new type
	 */
	public void setType(String type) {

		if (type.equals("Mage") || type.equals("Warrior")
				|| type.equals("Rogue") || type.equals("Ranger")) {
			this.type = type;
		} else {
			this.type = "Unspecified";
		}
	}

	/**
	 * @param items
	 *            players new list of items
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	/**
	 * @param newName
	 *            the players' new name
	 */
	public void setName(String newName) {
		name = Utils.checkString(newName);
	}

	/**
	 * @param maxWeight
	 *            players max weight limit
	 */
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = Utils.checkInt(maxWeight);
	}

	/**
	 * @param gold
	 *            players new amount of gold
	 */
	public void setGold(int gold) {
		this.gold = Utils.checkInt(gold);
	}
}
