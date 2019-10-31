package pickups;

/**
 * This class represents an item which can be admired by the player
 * @author phaisan 17967479
 * 
 */
public abstract class Valuable extends Consumable
{
	private int value; // The value of this valuable
	
	public int getValue() {
		return value;
	}

	/**
	 * Constructor
	 * Create a new valuable
	 * @param description the description of this valuable
	 * @param value the value of the valuable
	 */
	public Valuable(String description, int value)
	{
		super(description, false);
		this.value = value;
	}
	
	/**
	 * Consume this valuable
	 * @return the value of this valuable
	 */
	public int consume()
	{
		this.isConsumed = true;
		return value;
	}
}
