package wieldable;

import pickups.Wieldable;

/**
 * This class represents a sword which the player can equip and attack with.
 * @author phaisan 17967479
 * 
 */
public class Sword extends Wieldable
{
	/**
	 * Create a new sword
	 * @param description the description of this wieldable
	 * @param low the minimum base damage this weapon will inflict
	 * @param high the maximum base damage this weapon will inflict
	 */
	public Sword(String description, int low, int high)
	{
		super(description, low, high);
	}

}
