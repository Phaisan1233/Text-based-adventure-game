package characters;

/**
 * This class represents a dragon
 * @author phaisan 17967479
 * 
 */
public class Dragon extends Monster
{
	/**
	 * Constructor
	 * Creates a new dragon
	 * @param probability change of this monster to appear
	 */
	public Dragon(int probability)
	{
		super("Dragon", 200, probability, 7);
	}

}
