package models;

import java.util.ArrayList;
import java.util.Scanner;

public class Battleground {
	private ArrayList<Monster> monsters; 
	private Player player;
	Scanner reader;
	
	MonsterGenerator monsterGenerator; 
	
	
	
	/**
	 * @param monsters
	 * @param player
	 */
	public Battleground(Player player, int numberOfMonsters) {
	
		this.player = player;
		monsterGenerator = new MonsterGenerator(); 	
		monsters = monsterGenerator.createMonsters(numberOfMonsters); 
		
	} 
	
	public boolean startBattleground() {
		reader = new Scanner(System.in);  
		
		int index = 0; 
		while (!player.isDead() || monsters.size() <= 0){
		
			Monster currentMonster = monsters.get(index);
			System.out.println("A monster appears!");
			System.out.println("It's: " + currentMonster + "\n");
			
			while (!currentMonster.isDead() || !player.isDead()) {
				System.out.println("What would you like to do?\nType [attack] to Fight or [run] to run away like a sissy.");
				System.out.println("\n>");
				String input = reader.nextLine().trim().toLowerCase();
				
			
				if (!(input.matches("run") || input.matches("attack"))) {
					System.out.println("Not a valid command, try again. ");
					continue; 
				}
			
				if (input.matches("run")) {
					System.out.println("You run away like a litle girl and loose 50 gold pieces.");
					break; 			
				}
				
				if (input.matches("attack")){
					int playerDmg = player.attack(); 
					System.out.println(player.getName() + " attacks " + currentMonster + " for " +playerDmg + "\n" );
					currentMonster.changeHealth(-playerDmg);
					if(currentMonster.isDead()) {
						System.out.println(currentMonster + " died! You won the fight!" + "\n");
						index++;
						break;  
					}
					System.out.println(currentMonster + " has " + currentMonster.getHealth() + " healthpoints left.");
					
					int monsterDmg = currentMonster.attack(); 
					if (monsterDmg <= 0){
						System.out.println(currentMonster + " missed!");
					} else {
					
					System.out.println(currentMonster + " attacks " + player.getName() + " for " +monsterDmg + "\n" );
					player.changeHealth(-monsterDmg);
					System.out.println(player.getName() + " has " + player.getHealth() + " healthpoints left.");
					}
				}
				
				if ( player.isDead()) {
					System.out.println("You died! GAME OVER");
					return false; 
				}
				
			
				
			}
			
		}
		
		System.out.println("Player status: " + player.isDead());
		System.out.println("Monsters left: " + monsters.size());
		reader.close(); 
		return true; 
			
		
	}
	
	

	
	
	
	
	
	

}
