package gameplay;

import java.util.Random;

/**
 * This abstract class represents an entity of this world
 * @author phaisan 17967479
 * 
 */
public abstract class Entity
{
	private String id; // The id of this entity
	private String description; // The description of this entity
	
	/**
	 * Constructor
	 * @param description the description of this entity
	 */
	public Entity(String description)
	{
		this.id = this.getClass().getSimpleName();
		this.description = description;
	}
	
	/**
	 * Generate a random number between x and y(exclusive)
	 * @param x the minimum 
	 * @param y the maximum (exclusive)
	 * @return random number between x and y
	 */
	protected int getRandom(int x, int y)
	{
		return new Random().nextInt(y-x) + x;
	}
	
	/**
	 * Compare the id of this entity with another id
	 * @param id the id to compare with
	 * @return true if equal, false otherwise
	 */
	public boolean compareID(String id)
	{
		return this.id.equalsIgnoreCase(id.toLowerCase());
	}
	
	@Override
	public String toString()
	{
		return id;
	}
	
	/**
	 * Set the description of the entity to given string
	 * @param description the new description of this entity
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	/**
	 * @return the description of this entity
	 */
	public String getDescription()
	{
		return description;
	}
}
