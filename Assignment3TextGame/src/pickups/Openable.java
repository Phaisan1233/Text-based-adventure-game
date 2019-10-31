package pickups;

/**
 * This class represents an openable pickup
 * @author phaisan 17967479
 * 
 */
public abstract class Openable extends Pickup
{
	private boolean locked ; // True if a key or lockpick is required to open this openable
	private Pickup contents; // The content of the openable
	
	/**
	 * Constructor
	 * Creates a new openable
	 * @param description the description of the openable
	 * @param contents the contents of the openable
	 */
	public Openable(String description, Pickup contents)
	{
		super(description);
		this.setLocked(true);
		this.contents = contents;
	}
	
	/**
	 * Open this object
	 * @return the content of this object
	 */
	public Pickup open()
	{
		return contents;
	}

	/**
	 * Check if key or lockpick is required to open openable
	 * @return true if key or lockpick is required to open, false otherwise
	 */
	public boolean isLocked()
	{
		return locked;
	}

	/**
	 * Set key or lockpick is required to open this openable or not
	 * @param true if key or lockpick is required to open, false otherwise
	 */
	public void setLocked(boolean locked)
	{
		this.locked = locked;
	}
}
