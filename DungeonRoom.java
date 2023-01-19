
/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */


/**
 * dungeon room interface defines methods
 * for room and boss classes. allows for
 * dynamic dispatch and recursive calls
 * to traverse the dungeon
 *
 */
public interface DungeonRoom {
	/**
	 * defend against an attacking hero
	 * @param h - hero that is attacking
	 */
	public String defendAgainst(Hero h);

	/**
	 * show this room's attributes as a string
	 * @return string of this room
	 */
	public String show();

	/**
	 * return whether this room has the sign requested
	 * @param s - sign to check for
	 * @return - total number of this sign in the dungeon
	 */
	
	/**
	 * @return the sign of this room
	 */
	public Sign getSign();
	
	/**
	 * iterator method
	 * @return true if has a next room, else false
	 */
	public boolean canAdvance();
	
	/**
	 * set the iterator to the next room and return this one
	 * @return this room
	 */
	public DungeonRoom advance();
}
