
/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */


import java.util.LinkedList;

/**
 * represents a player of boss monster
 * @author spinoza
 *
 */
public class Player {
	private Dungeon dungeon;
	private LinkedList<Room> rooms;

	/**
	 * create a new player 
	 * players have a dungeon, which
	 * has a boss
	 * @param boss - boss to start player dungeon
	 */
	public Player(Boss boss) {
		this.dungeon = new Dungeon(boss);
		this.rooms = new LinkedList<Room>();
	}

	//standard getters
	public LinkedList<Room> getRooms(){return this.rooms;}
	public void addRoom(Room r) {this.rooms.add(r);}
	public Dungeon getDungeon() {return dungeon;}
	public void processHero(Hero h) {
	}
}

