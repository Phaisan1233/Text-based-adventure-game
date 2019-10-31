package characters;

/**
 * This class represents a monster which the player can fight.
 * @author phaisan 17967479
 * 
 */
public class Monster extends Character
{
	private int probability; // The chance of this monster to appear
	private int damage; // The damage this monster will inflict
	
	/**
	 * Constructor
	 * Creates a new monster
	 * @param description the description of this monster
	 * @param healthPoints the health points of this monster
	 * @param probability the chance of this monster to appear
	 * @param damage the damage this monster inflicts
	 */
	public Monster(String description, int healthPoints, int probability, int damage)
	{
		super(description, healthPoints);
		this.probability = probability;
		this.damage = damage;
	}

	@Override
	protected int dealAttackDamage()
	{
		return damage + getRandom(1, 11);
	}

	@Override
	public int defendAttack(Character enemy)
	{
		int damage = enemy.dealAttackDamage();
		healthPoints -= damage;
		if(healthPoints < 0)
			healthPoints = 0;
		
		return damage;
	}
	
	/**
	 * Check if this monster will appear.
	 * @return true if monster appears, false otherwise
	 */
	public boolean appear()
	{
		if(healthPoints == 0)
		{
			return false;
		}
		else
		{
			int random = getRandom(0,101);
			return random <= probability;
		}
	}

}
