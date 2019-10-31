package pickups;

import gameplay.Entity;

/**
 * This class represents an item which can be picked up by the player.
 * @author phaisan 17967479
 * 
 */
public abstract class Pickup extends Entity
{
	/**
	 * Constructor
	 * Create a new pickup
	 * @param description the description of this pickup
	 */
	public Pickup (String description)
	{
		super(description);
	}
}
