package wieldable;

import pickups.Wieldable;

/**
 * This class represents the standard weapon of the player
 * @author phaisan 17967479
 * 
 */
public class FistsOfFury extends Wieldable
{
	/**
	 * Create a FistsOfFury
	 * @param description the description of this wieldable
	 * @param low the minimum base damage this weapon will inflict
	 * @param high the maximum base damage this weapon will inflict
	 */
	public FistsOfFury(String description, int low, int high)
	{
		super(description, low, high);
	}

}
