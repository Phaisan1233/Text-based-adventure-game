package valuables;

import pickups.Valuable;

/**
 * This class represents a money bag
 * @author phaisan 17967479
 * 
 */
public class MoneyBag extends Valuable
{
	/**
	 * Constructor
	 * Create a new moneybag
	 * @param description the description of this valuable
	 * @param value the value of the valuable
	 */
	public MoneyBag(String description, int value)
	{
		super(description, value);
	}

}
