package models;
/**
 * This class represents the game.
 * 
 * In oblig 1 the main method creates a Player and prints the information about
 * the player to the console.
 * 
 * @author Eirik Berntsen & Maiken Beate Fjellanger
 * @version 0.2 07.03.2014
 * 
 */
public class Game {

	/**
	 * Starts the game - creates a player and three items, adds the items to
	 * players inventory, and prints out the information about player
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Player player1 = new Player("Jim", "Warrior", 50);

		Item item1 = new Item("Sword", "Sharp", 40, 5, "cuts");
		Item item2 = new Item("Knife", "Sharp", 10, 1, "cuts");
		Item item3 = new Item("Axe", "Heavy", 50, 10, "chops");

		player1.addItem(item1);
		player1.addItem(item2);
		player1.addItem(item3);

		player1.print();
	}
}
