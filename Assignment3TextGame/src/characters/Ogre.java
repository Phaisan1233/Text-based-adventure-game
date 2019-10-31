package characters;

/**
 * This class represents an ogre
 * @author phaisan 17967479
 * 
 */
public class Ogre extends Monster
{
	/**
	 * Constructor
	 * Creates a new ogre
	 * @param probability the chance of this monster to appear
	 */
	public Ogre(int probability)
	{
		super("Ogre", 90, probability, 5);
	}

}
