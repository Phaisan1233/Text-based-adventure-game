package characters;

import gameplay.Inventory;
import pickups.Wieldable;
import wieldable.FistsOfFury;

/**
 * This class represents the player
 * @author phaisan 17967479
 * 
 */
public class Player extends Character
{
	private int confidence; // Confidence of this player. Used for damage calculation
	private String name; // Name of this player
	private Wieldable weapon; // The current weapon wielded by the player
	private Inventory inventory; // The inventory of the player
	private String armor; // The armor this player is wearing
	
	/**
	 * Constructor
	 * Creates a new player
	 * @param name the name of the player
	 * @param armor the armor the player is wearing
	 * @param healthPoints the health points of the player
	 * @param confidence the confidence of the player
	 */
	public Player(String name, String armor, int healthPoints, int confidence)
	{
		super("Player", healthPoints);
		this.weapon = new FistsOfFury("Fists of fury",7,15);
		this.armor = armor;
		this.name = name;
		this.confidence = confidence;
		this.inventory = new Inventory();
	}

	@Override
	protected int dealAttackDamage()
	{
		int h = weapon.hit();
		return h + h * confidence / 100;
	}

	@Override
	public int defendAttack(Character enemy)
	{
		int d = enemy.dealAttackDamage();
		healthPoints -= d;
		confidence -= d/2;
		if (healthPoints < 0)
		{
			healthPoints = 0;
		}
		if (confidence < 0)
		{
			confidence = 0;
		}
		return d;
		
	}
	
	/**
	 * Get this players inventory
	 * @return the inventory of this player
	 */
	public Inventory getInventory()
	{
		return inventory;
	}
	
	/**
	 * Set this players weapon
	 * @param weapon the weapon the player switches to
	 */
	public void setWeapon(Wieldable weapon)
	{
		this.weapon = weapon;
	}
	
	/**
	 * Get the current wielded weapon of the player
	 * @return the weapon the player currently wields
	 */
	public Wieldable getWeapon()
	{
		return weapon;
	}
	
	/**
	 * Eat food. Increases the health points by given amount
	 * @param value the amount of healing the food provides
	 */
	public void eat(int value)
	{
		healthPoints += value;
	}
	
	/**
	 * Get the players name
	 * @return the name of the player
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get the confidence of the player
	 * @return the players confidence
	 */
	public int getConfidence()
	{
		return confidence;
	}
	
	/**
	 * Set the players confidence to given amount
	 * @param confidence the new confidence of the player
	 */
	public void setConfidence(int confidence)
	{
		this.confidence = confidence;	
	}
	
	/**
	 * Admire an item. Increases confidence by given amount.
	 * @param value the amount of confidence gained
	 */
	public void admire(int value)
	{
		confidence += value;
	}
	
	/**
	 * Get a string which represents the current stats of the player
	 * @return the current stats of the player
	 */
	public String getStatus()
	{
		return "\t" + name + " is wearing " + armor +"\n\t" 
				+ "Health: " + healthPoints + " Confidence: " + confidence + " Wielding: " + weapon;
	}

}
