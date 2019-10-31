
package gameplay;

import java.util.Scanner;

import characters.Monster;
import characters.Player;
import entities.Room;
import pickups.*;
import valuables.Mobile;
import openable.*;
import wieldable.FistsOfFury;

/**
 * This class contains the game loop and handles the player input.
 * @author phaisan 17967479
 *
 */
public class World 
{
	private boolean gameInProgress; // True if the game is in progress, false if player won or lost the game
	private Player player; // The player
	private Room currentRoom; // The room the player is currently in
	private PlayMode mode; // The PlayMode, which can be battle or explore mode
	Scanner scanner = new Scanner(System.in); // Scanner to read user input
	
	/**
	 * Constructor
	 * Create a new world
	 * @param startRoom the room the player starts the game in
	 */
	public World(Room startRoom)
	{
		currentRoom = startRoom;
	}

	/**
	 * The PlayMode
	 * Can be battle or explore
	 * Each mode provides different commands to the player
	 */
	public enum PlayMode {battle,explore;}
	
	/**
	 * This method contains the main loop and will repeatedly call the appropriate

	 * processUserInput method until the game is over.
	 * @param player the player who plays this game
	 */
	private void play(Player player)
	{
		this.player=player;
		System.out.println("Welcome player "+player.getName()+" to the Dungeon!");
		System.out.println("-----------------------------------------------------------\n");
		System.out.println(player.getStatus());
		this.onEnterRoom();

		gameInProgress = true;
		mode = PlayMode.explore;
		
		while(gameInProgress)
		{
			try
			{
				switch(this.mode)
				{
					case explore:
						processExploreUserInput();
						break;
					case battle:
						processBattleUserInput();             
						break;
				}
			} catch (Exception e)
			{
				System.out.println("Cannot do that.");
			} 

		}
		System.out.println("\tThank you for playing");
		System.out.println("###########################################################");
	}
	
		/**
	 * This method is called when the player enters a room.
	 * It prints the room description and determines if the monster will appear or not.
	 * If it does appear, the mode will be set to battle.
	 */
	private void onEnterRoom()
	{
		System.out.println(currentRoom.getDescription());
		if(currentRoom.hasMonster())
			if(currentRoom.getMonster().appear())
			{
				System.out.println("\t# A " + currentRoom.getMonster() + " draws hither! #");
				System.out.println("\t"+player.getName() + " wields " +player.getWeapon().getDescription() +" and is ready for battle!");
				mode = PlayMode.battle;
			}
	}
	
	/**
	 * This method processes the user input in the explore mode.
	 */
	private void processExploreUserInput()
	{
		System.out.print("?> ");
		String input = scanner.nextLine().toLowerCase();
		String [] tokens = input.split(" ");
		
		switch(tokens[0])
		{
			case "pickup" : pickup(tokens[1]);
			break;
			case "describe" : describe();
			break;
			case "door" : openDoor(tokens[1]);
			break;
			case "wield" : switchWeapon(tokens[1]);
			break;
			case "admire" : admire(tokens[1]);
			break;
			case "exit" : tryExit();
			break;
			case "eat" : eat(tokens[1]);
			break;
			case "stats" : System.out.println(player.getStatus());
							System.out.println("\tBrave " + player.getName() + " is carrying the following items: " + player.getInventory()+"");
			break;
			case "open" : openChest(tokens[1]);
			break;
			case "mobile" : useMobile(tokens[1],tokens[2]);
			break;
			case "quit" : System.out.println("###########################################################");
							System.out.println("\tYou have quit the game");
							gameInProgress = false;
			break;
			case "help" : System.out.println("\t# Explore commands: admire, describe, door, eat, exit, help, mobile, open, pickup, quit, stats, wield #");
			break;
			default: System.out.println("# What does \""  + input + "\" mean? #");
		}
		
	}
	
	/**
	 * This method processes the user input in the battle mode.
	 * The player can only attack or switch weapons in this mode.
	 */
	private void processBattleUserInput()
	{
		System.out.print("?> ");
		String input = scanner.nextLine().toLowerCase();
		String [] tokens = input.split(" ");
		
		switch(tokens[0])
		{
			case "attack" : attack();
			break;
			case "wield" : switchWeapon(tokens[1]);
			break;
			case "help" : System.out.println("\t# battle commands: attack, wield, help #");
			break;
			default: System.out.println("# What does \""  + input + "\" mean? #");
		}
	}
	
	/**
	 * Print the current room and its contents
	 */
	private void describe()
	{
		System.out.println(currentRoom.getDescription());
		for(Pickup pickup : currentRoom.getPickupsInRoom().getItems())
		{
			System.out.println("\tThere is a " + pickup + " on the floor.");
		}
		int numDoors = currentRoom.getConnectingRooms().length;
	    String doors = numDoors == 1 ? "\tThere is 1 door" : "\tThere are " + numDoors + " doors";
		System.out.println(doors);
	}
	
	/**
	 * Pickup the given item.
	 * Will add the item to the players inventory.
	 * @param item the id of the item to pickup
	 */
	private void pickup (String item) 
	{
		Pickup pickup = currentRoom.getPickupsInRoom().select(item);
		if(pickup != null) 
		{
			currentRoom.getPickupsInRoom().remove(pickup);
			player.getInventory().add(pickup);
			System.out.println("\t" + player.getName() + " picks up the " + item + ".");
		}
		else 
		{
			System.out.println("\tNo such item found in this room!");
		}
	}
	
	/**
	 * Eat the given food
	 * @param id the id of the food to eat
	 */
	private void eat(String id)
	{
		Pickup pickup = player.getInventory().select(id);
		if(pickup instanceof Food)
		{
			Food food = (Food) pickup;
			if(food == pickup)
			{
				int value = food.consume();
				player.eat(value);
				System.out.println("\t" + player.getName() + " ate the " + food + ".\n" 
				+player.getName()+" health increases "+value);
				player.getInventory().remove(pickup);
			}
			else
			{
				System.out.println("\t # "+player.getName() + " could not find a " + food + " in his inventory");
			}
		}
		else
		{
			System.out.println("# Please select a valid food from the inventory. #");
		}
	}
	
	/**
	 * Admire the given item
	 * @param id the id of the item to admire
	 */
	private void admire(String id)
	{
		Pickup pickup = player.getInventory().select(id);
		if(pickup instanceof Valuable) 
		{
			Valuable valuable = (Valuable) pickup;
			if(!valuable.isConsumed())
			{
				int value = valuable.consume();
				player.admire(value);
				System.out.println("\t"+player.getName() +" admired the " + pickup.getDescription() + ".\n"
				+player.getName() + " confidence increases " + value);
			}
			else
			{
				System.out.println("\t"+player.getName() + " already used the " + valuable + "!");
			}
		}
		else
		{
			System.out.println("# Please select a valid item from the inventory. #");
		}
	}
	
		/**
	 * This method is called when the player enters the attack command.
	 * It will do one round of attacks for player and the monster.
	 */
	public void attack()
	{
		Monster monster = currentRoom.getMonster();
		System.out.println("\t" + player.getName() + " attacks the " + monster.getDescription());
		int damageToMonster = monster.defendAttack(player);
		System.out.println("\t>> The " + monster.getDescription() + " sustains " + damageToMonster + " damage!");
		if(monster.isAlive())
		{
			System.out.println("\tThe " + monster + " attacks!");
			int damageToPlayer = player.defendAttack(monster);
			System.out.println("\t>> " + player.getName() +" sustained " + damageToPlayer + " damage!");
			System.out.println(player.getStatus());
		}
		else
		{
			System.out.println("\n>>> Brave " + player.getName() + " has defeated the " + monster.getDescription() + "! <<<\n");
			mode = PlayMode.explore;
		}
		if(!player.isAlive())
		{
			System.out.println("###########################################################");
			System.out.println("\tAlas! " + player.getName() + " has been defeated!\n" + 
					"\tYou have failed your quest");
			gameInProgress = false;
		}
		
	}
		
	/**
	 * Switch to the given weapon
	 * @param id the id of the weapon to switch to
	 */
	private void switchWeapon(String id)
	{
		if(id.equalsIgnoreCase("fistsoffury") || id.equalsIgnoreCase("fists") ) // player use their fists to fight.
		{
			if(player.getWeapon() instanceof FistsOfFury)
			{
				System.out.println("\t" + player.getName() + " already wield this " + player.getWeapon());
			}
			else
			{
				player.getInventory().add(player.getWeapon());
				player.setWeapon(new FistsOfFury("Fists of fury",7,15));
				System.out.println("\t" + player.getName() + " use his Fists of fury.");
			}
		}
		
		else // player wield weapon.
		{
			Pickup item = player.getInventory().select(id);
			if(item instanceof Wieldable)
				{
					Wieldable weapon = (Wieldable) item;
					if(player.getWeapon() != weapon)
					{
						if(player.getWeapon() instanceof FistsOfFury)//cannot put fists inventory
						{
							player.setWeapon(weapon);
							System.out.println("\t" + player.getName() + " wields the " +weapon);
							player.getInventory().remove(weapon);
						}
						else// wield weapon form inventory and put current weapon in to inventory
						{
							player.getInventory().add(player.getWeapon());
							player.setWeapon(weapon);
							System.out.println("\t" + player.getName() + " wields the " +weapon);
							player.getInventory().remove(weapon);
						}
					}
					else {
						System.out.println("\t" + player.getName() + " already wield this " +weapon);
					}
				}
				else
				{
					System.out.println("# Please select a valid weapon from the inventory. #");
				}
		}
	}
	
			/**
	 * Try to open a chest. A key or lock pick is necessary to do so.
	 * If successful, the contents of the chest are added to the inventory and the key and chest are removed.
	 * @param id the id of the chest
	 */
	private void openChest(String id)
	{
		Pickup pickup = player.getInventory().select(id);
		if(pickup instanceof Openable)
		{
			Openable chest = (Openable) pickup;
			
			if(pickup instanceof TreasureChest)// use key to open treasure chest.
			{
				Key key = (Key) player.getInventory().select("Key");
				if(key != null)
				{
					player.getInventory().remove(key);
					Pickup content = chest.open();
					Valuable valuable = (Valuable) content;
					player.getInventory().remove(pickup);
					System.out.println("\t" + player.getName() + " opened a treasure chest! \n>>> It contained " + content.getDescription() 
										+ " = " + valuable.getValue() + " <<<\n");
					player.getInventory().add(content);
				}
				else
				{
					System.out.println("# You need a key to open a treasure chest! #");
				}
			}
			else if(pickup instanceof WarChest)// use lock pick to open war chest
			{
				LockPick pick = (LockPick) player.getInventory().select("LockPick");
				if(pick != null)
				{
					player.getInventory().remove(pick);
					Pickup content = chest.open();
					System.out.println("\t" + player.getName() + " opened a war chest! \n>>> It contained " + content.getDescription() + " <<<\n");
					player.getInventory().add(content);
				}
				else
				{
					System.out.println("# You need a lockpick to open a war chest! #");
				}
			}
		}
		else 
		{
			System.out.println("# Please select a valid chest from the inventory. #");
		}
	}
	
	/**
	 * Open the given door
	 * @param number the number of the door, starting from 1
	 */
	private void openDoor(String number)
	{
		int num = Integer.parseInt(number)-1;
		Room room = currentRoom.getConnectingRooms()[num];
		if(room != null)
		{
			System.out.println("\t" + player.getName() + " bravely opens door " + number);
			currentRoom = room;
			onEnterRoom();
		}
		else
		{
			System.out.println("\tThere is no door " + number); 
		}
	}
	
	/**
	 * Try to exit the maze.
	 * If successful, the game is won and over.
	 */
	private void tryExit()
	{
		if(currentRoom.isFinalRoom())
		{			
			System.out.println("###########################################################");
			System.out.println("\tWell done brave " + player.getName() + ".");
			System.out.println("\tYour quest has now ended.");
			System.out.println("\tYou have won the game!");
			gameInProgress = false;
		}
		else
		{
			System.out.println("# You couldn't find an exit! #");
		}
	}
	
	
	/**
	 * The method to get access to the Internet.
	 * It will print recently info.
	 * @param mobileApp method to define mobile application.
	 * @param id twitter user id
	 */
	private void useMobile(String mobileApp ,String id)
	{
		Pickup pickup = player.getInventory().select("mobile");
		if(pickup instanceof Mobile)
		{
			if(mobileApp.equalsIgnoreCase("latestTweet"))
			{
				Mobile mobile = (Mobile) pickup;
				System.out.println("\t\"" + mobile.showLatestTweetFrom(id) + "\"");
			}
		}
		else
		{
			System.out.println("\tYou does not have mobile in the inventory.");
		}
	}
	
	//--------------------------------------------------------
	public static void main(String[] args) 
	{
		World world = ReadWorldDataFile.simpleWorld();
		Player playerOne = new Player("Fang","Shiny Armour",100,10);// (name,armor,health,confidence)
		world.play(playerOne);		
	}
	//--------------------------------------------------------
}
