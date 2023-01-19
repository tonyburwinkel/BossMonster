
/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */

/**
 * class representing a hero 
 * heroes have a sign they are attracted to,
 * hitpoints they can withstand, and bloodpoints 
 * that can be dealt to a boss
 *
 */
public class Hero {
	private String name;
	private Sign sign;
	private int hp;
	private int bloodpoints;

	/**
	 * make a new hero
	 * @param name - name of hero
	 * @param sign - sign hero is attracted to
	 * @param hp - hero's hitpoints
	 * @param bp - amount of damage hero deals to boss
	 */
	public Hero(String name, Sign sign, int hp, int bp) {
		this.name = name;
		this.sign = sign;
		this.hp = hp;
		this.bloodpoints = bp;
	}
	
	// standard getters
	public String getName() {return this.name;}
	public Sign getSign() {return this.sign;}
	public int getHP() {return this.hp;}
	public int getBP() {return this.bloodpoints;}
	
	/**
	 * make this hero enter and attack a dungeon
	 * @param dungeon - dungeon to attack
	 */
	public void attack(Dungeon dungeon) {
		dungeon.getEntrance().defendAgainst(this);
	}
	
	/**
	 * deal damage to this hero
	 * @param damage - amount of damage to subtract from hp
	 * @throws IllegalArgumentException 
	 */
	public void setHP(int damage) throws IllegalArgumentException {
		if (damage < 0) throw new IllegalArgumentException("cannot deal negative damage");
		if (hp - damage < 0) {
			this.hp = 0;
		} else {
			this.hp -= damage;
		}
	}
	
	/**
	 * string of this hero's attributes
	 */
	public String toString() {
		return name + "\t" + "hp: " + Integer.toString(hp) + "\tbp: " + Integer.toString(bloodpoints) + "\t" + sign.name() + "\n";
	}

}
