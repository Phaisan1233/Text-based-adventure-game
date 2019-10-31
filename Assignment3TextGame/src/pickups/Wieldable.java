package pickups;

/**
 * This class represents items which can be wielded by the player
 * @author phaisan 17967479
 * 
 */
public abstract class Wieldable extends Pickup
{
	private int low; // The minimum base damage
	private int high; // The maximum base damage
	
	/**
	 * Constructor
	 * Create a new wieldable
	 * @param description the description of the wieldable
	 * @param low the minimum damage of this wieldable
	 * @param high the maximum damage of this wieldable
	 */
	public Wieldable(String description, int low, int high)
	{
		super(description);
		this.low = low;
		this.high = high;
	}
	
	/**
	 * Get the damage of an attack with this wieldable
	 * @return the damage inflicted by this wieldable
	 */
	public int hit()
	{
		return getRandom(low, high);
	}
	
	
}
