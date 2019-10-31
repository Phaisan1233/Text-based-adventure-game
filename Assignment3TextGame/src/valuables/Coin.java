package valuables;

import pickups.Valuable;

/**
 * This class represents a coin
 * @author phaisan 17967479
 * 
 */
public class Coin extends Valuable
{
	/**
	 * Constructor
	 * Create a new coin
	 * @param description the description of this valuable
	 * @param value the value of the valuable
	 */
	public Coin(String description, int value)
	{
		super(description, value);
	}

}
