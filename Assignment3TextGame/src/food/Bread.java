package food;

import pickups.Food;

/**
 * This class represents a bread
 * @author phaisan 17967479
 * 
 */
public class Bread extends Food
{
	/**
	 * Constructor
	 * Creates a new bread
	 * @param description the description of this food
	 * @param healPower the amount of health this food heals
	 */
	public Bread(String description, int healPower)
	{
		super(description, healPower);
	}

}
