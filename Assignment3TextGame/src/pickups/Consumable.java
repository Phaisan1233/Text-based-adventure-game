package pickups;

/**
 * This class represents a consumable item
 * @author phaisan 17967479
 * 
 */
public abstract class Consumable extends Pickup
{
	protected boolean isConsumed; // If this item is already consumed
	
	/**
	 * Constructor
	 * Creates a new Consumable
	 * @param description the description of the consumable
	 * @param isConsumed if the consumable is already consumed
	 */
	public Consumable(String description, boolean isConsumed)
	{
		super(description);
		this.isConsumed = isConsumed;
	}
	
	/**
	 * Check if the item is already consumed
	 * @return true if item was consumed, false otherwise
	 */
	public boolean isConsumed()
	{
		return isConsumed;
	}
	
	/**
	 * Set the isConsumed variable
	 * @param consumed true if item is already consumed, false otherwise
	 */
	public void setConsumed(boolean consumed)
	{
		isConsumed = consumed;
	}
}
