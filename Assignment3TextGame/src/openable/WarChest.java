package openable;

import pickups.Openable;
import pickups.Pickup;

/**
 * This class represents a war chest.
 * It can only be opened with a lock pick
 * @author phaisan 17967479
 * 
 */
public class WarChest extends Openable
{
	/**
	 * Constructor
	 * Creates a new war chest
	 * @param contents the contents of this chest
	 */
	public WarChest(Pickup contents)
	{
		super("War Chest", contents);
	}

}
