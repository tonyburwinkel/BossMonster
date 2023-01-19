
/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */


import java.util.Iterator;
import java.util.LinkedList;

/**
 * class representing a player's dungeon
 * dungeons have rooms and a boss which can
 * be attacked (traversed) by heroes
 *
 */
public class Dungeon implements Iterable<DungeonRoom>{
	private DungeonRoom entrance;
	private int count;
	private Boss boss;
	private LinkedList<Hero> heroQueue;

	/**
	 * dungeon constructor
	 * to be initialized, dungeons must have a boss
	 * boss objects are like emptynodes, they bottom
	 * out the recursive methods that dungeon implements
	 * @param b - boss, last room in the dungeon
	 */
	public Dungeon(Boss b) {
		this.entrance = b;
		this.boss = b;
		this.count = 0;
		this.heroQueue = new LinkedList<Hero>();
	}

	// standard getters
	public Boss getBoss() {return this.boss;}
	public int getCount() {return count;}
	public DungeonRoom getEntrance() {return this.entrance;}
	public LinkedList<Hero> getHeroQueue() {return heroQueue;}
	
	/**
	 * iterative implementation of get that returns
	 * number of signs in the dungeon
	 * @param s sign to check for
	 * @return number of rooms of sign s
	 */
	public int getNumSigns(Sign s) {
		int numSigns = 0;
		if (boss.getSign()==s) numSigns++;
		// this is the call to the iterable
		// instead of recursing through the dungeon rooms
		// we use a for each loop
		for(DungeonRoom r:this) {
			if (r.getSign()==s) numSigns++;
			}
		return numSigns;
		}
	
	/**
	 * add a room to the dungeon
	 * new rooms must be attached to the entrance, 
	 * and become the new entrance
	 * @param room - room to be added
	 */
	public void addRoom(Room room) {
		room.setNextRoom(this.entrance);
		this.entrance = room;
		count++;
	}
	
	/**
	 * defend against an attacking hero
	 * heroes traverse the dungeon recursively
	 * @param h - hero to defend against
	 * @return a String showing everything that happened to the hero/boss
	 */
	public String defendAgainst(Hero h) {return this.entrance.defendAgainst(h);}
	
	/**
	 * returns a string of the dungeon map
	 * method recurses over rooms to get string versions
	 * @return string of dungeon map
	 */
	public String show() {return this.entrance.show();}

	/**
	 * add a hero to the queue of attackers
	 * @param h - hero to be added
	 */
	public void queueHero(Hero h) {
		this.heroQueue.add(h);
	}

	/**
	 * @return an iterator object pointing to the head (entrance) of this dungeon
	 */
	public Iterator<DungeonRoom> iterator() {
		return new DungeonIterator(entrance);
	}
	
	/**
	 * iterator definition for Dungeons
	 */
	private class DungeonIterator implements Iterator<DungeonRoom>{
		private DungeonRoom current;

		/**
		 * make a new iterator that points to the entrance
		 * @param current - head of dungeon to traverse
		 */
		private DungeonIterator(DungeonRoom current) {
			this.current = current;
		}
		
		/**
		 * check if the current room is the last one
		 */
		public boolean hasNext() {
			return current.canAdvance();
		}

		/**
		 * return the current room and advance the iterator
		 */
		public DungeonRoom next() {
			DungeonRoom temp = this.current;
			this.current = current.advance();
			return temp;
		}
	}

}
