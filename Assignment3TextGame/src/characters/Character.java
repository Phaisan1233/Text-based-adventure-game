package characters;

import gameplay.Entity;

/**
 * This abstract class represents a character of the game
 * @author phaisan 17967479
 * 
 */
public abstract class Character extends Entity
{
	protected int healthPoints; // Health points of the character. If 0, the character dies.
	
	/**
	 * Constructor
	 * Creates a new character
	 * @param description the description of this character
	 * @param healthPoints the amount of health points
	 */
	public Character(String description, int healthPoints)
	{
		super(description);
		this.healthPoints = healthPoints;
	}
	
	/**
	 * This method provides the amount of damage dealt by this character
	 * @return the amount of damage dealt by this character
	 */
	protected abstract int dealAttackDamage();
		
	/**
	 * This method is called when the character is attacked by another character.
	 * @param enemy the character attacking this character
	 * @return the amount of damage inflicted to this character
	 */
	public abstract int defendAttack(Character enemy);

	/**
	 * Check if this character is still alive.
	 * @return true if alive, false if dead
	 */
	public boolean isAlive()
	{
		return healthPoints > 0;
	}
}
