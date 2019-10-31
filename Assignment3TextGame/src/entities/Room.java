package entities;

import characters.Monster;
import gameplay.Entity;
import gameplay.Inventory;

/**
 * This class represents a room
 * @author phaisan 17967479
 * 
 */
public class Room extends Entity 
{	
	private Monster monster; // The monster which can appear in this room
	private Inventory pickupsInRoom; // The pickups the player can find in this room
	private Room[] connecting; // The rooms connected to this room
	boolean finalRoom; // Is the room the final room?
	
	/**
	 * Constructor
	 * Creates a new room
	 */
	public Room()
	{
		super("");
		pickupsInRoom = null;
		connecting = null;
		monster = null;
	}
	
	/**
	 * Constructor
	 * Creates a new room with given parameters
	 * @param description the description of this room
	 * @param pickupsInRoom the pickups this room contains
	 * @param connectingRooms the rooms connected to this room
	 */
	public Room(String description,Inventory pickupsInRoom,
			 Room[] connectingRooms)
	{
		super(description);
		this.pickupsInRoom = pickupsInRoom;
		this.connecting = connectingRooms;
	}
	
	/**
	 * Set the room to final room or to not final room
	 * @param room true if room is final, false otherwise
	 */
	public void setFinalRoom(boolean room)
	{
		finalRoom = room;
	}
	
	/**
	 * Check if the room is the final room
	 * @return true if room is final, false otherwise
	 */
	public boolean isFinalRoom()
	{
		return finalRoom;
	}
	
	/**
	 * Set the connected rooms to the given array of rooms
	 * @param connecting the new connected rooms
	 */
	public void setConnectingRooms(Room[] connecting)
	{
		this.connecting = connecting;
	}
	
	/**
	 * Set the monster to given monster
	 * @param monster the new monster this room contains
	 */
	public void setMonster(Monster monster)
	{
		this.monster = monster;
	}
	
	/**
	 * Check if this room has a monster
	 * @return true if room contains monster, false otherwise
	 */
	public boolean hasMonster()
	{
		return monster != null;
	}
	
	/**
	 * Get the monster this room contains
	 * @return the monster this room contains
	 */
	public Monster getMonster() 
	{
		return monster;
	}
	
	/**
	 * Get the rooms connected to this room
	 * @return array containing all connected rooms
	 */
	public Room [] getConnectingRooms()
	{
		return connecting;
	}
	
	/**
	 * Get the pickups in this room
	 * @return all pickups in this room
	 */
	public Inventory getPickupsInRoom()
	{
		return pickupsInRoom;
	}
	
	/**
	 * Set the pickups of this room to given inventory
	 * @param pickupsInRoom the inventory containing the pickups 
	 */
	public void setPickupsInRoom(Inventory pickupsInRoom)
	{
		this.pickupsInRoom = pickupsInRoom;
	}


}
