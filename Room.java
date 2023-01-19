
/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */

/**
 * class representing a room in a dungeon
 * rooms deal an amount of damage to heroes,
 * have a sign for attracting heroes
 * and have a next room
 *
 */
public class Room implements DungeonRoom, Comparable<Room>{
	private String name;
	private int damage;
	private Sign sign;
	private DungeonRoom next;

	/**
	 * make a new room
	 * @param name - name of room
	 * @param damage - amount of damage room deals
	 * @param sign - sign of this room
	 */
	public Room(String name, int damage, Sign sign) {
		this.name = name;
		this.damage = damage;
		this.sign = sign;
	}
	
	/**
	 * @return the sign of this room
	 */
	public Sign getSign() {return sign;}
	
	/**
	 * get the next room in the dungeon
	 * @return - next room in dungeon
	 */
	public DungeonRoom getNextRoom() {return this.next;}
	
	/**
	 * set this room's next room
	 * @param room - room to be set to this room's next
	 */
	public void setNextRoom(DungeonRoom room) {this.next = room;}
	
	/**
	 * deal damage to a hero and pass it on
	 */
	public String defendAgainst(Hero h) {
		if (h.getHP()>0) 
			{h.setHP(damage);
			return String.format("%s Dealt %d damage to %s.\n",name, damage, h.getName()) +
					this.next.defendAgainst(h);}
		else return next.defendAgainst(h);
	}
	
	/**
	 * method for showing room as part of dungeon map
	 */
	public String show() {
		return this.toString() + "\n\t|\n\tv\n" + next.show();
	}

	/**
	 * method for showing room when in player's hand
	 * @return - simplified string of room
	 */
	public String handString() {
		return 	this.name + "\t\t"
				+"damage: " + Integer.toString(damage) + "\t"
				+ this.sign.name() + "\n";
	}

	/**
	 * string version of this room
	 */
	public String toString() {
		return "ROOM \n" +
				this.name + "\n"
				+ "damage: " + Integer.toString(damage) + "\t"
				+ this.sign.name() + "\n";
	}

	/**
	 * iterator method, rooms have a next room
	 */
	public boolean canAdvance() {
		return true;
	}

	/**
	 * iterator method, advancing returns the next room
	 */
	public DungeonRoom advance() {
		return next;
	}

	/**
	 * implement compareTo so that we can sort our hand by room sign
	 */
	public int compareTo(Room r) {
		return this.sign.name().compareTo(r.getSign().name());
	}
}
