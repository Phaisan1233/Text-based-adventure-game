package wieldable;

import pickups.Wieldable;

/**
 * This class represents an axe which the player can use as a weapon
 * @author phaisan 17967479
 * 
 */
public class Axe extends Wieldable
{
	/**
	 * Create a new axe
	 * @param description the description of this wieldable
	 * @param low the minimum base damage this weapon will inflict
	 * @param high the maximum base damage this weapon will inflict
	 */
	public Axe(String description, int low, int high)
	{
		super(description, low, high);
	}

}
