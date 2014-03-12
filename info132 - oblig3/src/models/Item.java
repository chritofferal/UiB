package models;
/**
 * Represents an item
 * 
 * @author Maiken Beate Fjellanger
 * @version 0.1 07.03.14
 */
public class Item {
	private String name;
	private String description;
	private int value;
	private int weight;
	private String action;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param description
	 * @param value
	 * @param weigth
	 * @param action
	 */
	public Item(String name, String description, int value, int weight,
			String action) {
		setName(name);
		setDescription(description);
		setValue(value);
		setWeight(weight);
		setAction(action);
	}

	/**
	 * Prints the information about the item
	 */
	public void print() {
		System.out.println("Name: " + name + " Description: " + description
				+ " Value: " + value + " Weight: " + weight);
	}
	
	@Override 
	public String toString(){
		return "[ Name: " + name + " | Description: " + description + " " + " | Value: " + value + " | Weight: " + weight +"]"; 
	}

	/**
	 * Sets items name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = Utils.checkString(name);
	}

	/**
	 * Sets items description
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = Utils.checkString(description);
	}

	/**
	 * Sets items value
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		this.value = Utils.checkInt(value);
	}

	/**
	 * Sets items weight
	 * 
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = Utils.checkInt(weight);
	}

	/**
	 * Sets items action
	 * 
	 * @param action
	 */
	public void setAction(String action) {
		this.action = Utils.checkString(action);
	}

	/**
	 * @return items name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return items description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return items value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return items weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @return items action
	 */
	public String getAction() {
		return action;
	}
}
