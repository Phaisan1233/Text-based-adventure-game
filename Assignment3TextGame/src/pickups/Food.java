package pickups;

/**
 * This class represents food
 * @author phaisan 17967479
 * 
 */
public abstract class Food extends Consumable
{
	private int healPower; // The amound of health this food will heal
	
	/**
	 * Constructor
	 * Create a new food
	 * @param description the description of this food
	 * @param healPower the healpower of this food
	 */
	public Food(String description, int healPower)
	{
		super(description, false);
		this.healPower = healPower;
	}
	
	/**
	 * Consume this food
	 * @return the amound of health healed
	 */
	public int consume()
	{
		isConsumed = true;
		return healPower;
	}
}
