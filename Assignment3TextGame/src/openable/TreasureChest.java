package openable;

import pickups.Openable;
import pickups.Pickup;

/**
 * This class represents a trasure chest.
 * It can only be opened with a key
 * @author phaisan 17967479
 * 
 */
public class TreasureChest extends Openable
{
	/**
	 * Constructor
	 * Create a new treasure chest
	 * @param contents the contents of this chest
	 */
	public TreasureChest(Pickup contents)
	{
		super("Treasure", contents);
	}

}
