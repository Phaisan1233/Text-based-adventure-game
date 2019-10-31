package characters;

/**
 * This class represents a zombie
 * @author phaisan 17967479
 * 
 */
public class Zombie extends Monster 
{
	/**
	 * Constructor
	 * Creates a zombie
	 * @param probability the chance of this zombie to appear
	 */
	public Zombie(int probability)
	{
		super("Zombie", 50, probability, 2);
	}

}
