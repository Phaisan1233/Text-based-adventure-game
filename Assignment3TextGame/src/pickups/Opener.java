package pickups;

/**
 * This class represents an opener, which is a object required
 * to open openable objects.
 * @author phaisan 17967479
 * 
 */
public abstract class Opener extends Pickup
{
	/**
	 * Constructor
	 * Create a new opener
	 * @param description the description of the opener
	 */
	public Opener(String description)
	{
		super(description);
	}
}
