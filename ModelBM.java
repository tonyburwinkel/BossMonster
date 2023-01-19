
/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */

/**
 * model class for collecting all logical operations of game
 */
public class ModelBM {
	private Player player;
	private Player opponent;
	private Tavern tavern;
	private HeroDeck heroes;
	private RoomDeck rooms;
	private BossDeck bosses;
	
	/**
	 * creates a new model with shuffled decks of cards,
	 * two players (person and computer) with hands of cards
	 * and a tavern for waiting heroes
	 */
	public ModelBM() {
		this.rooms = new RoomDeck();
		rooms.shuffle();
		this.heroes = new HeroDeck();
		heroes.shuffle();
		this.bosses = new BossDeck();
		bosses.shuffle();
		this.player = new Player(bosses.draw());
		this.opponent = new Player(bosses.draw());
		this.tavern = new Tavern();
		deal(); 
	}

	// standard getters
	public Player getPlayer() {return player;}
	public Player getOpponent() {return opponent;}
	public Tavern getTavern() {return tavern;}
	public HeroDeck getHeroes() {return heroes;}
	
	/**
	 * deals initial hand of the game to both players
	 */
	private void deal() {
		int i;
		for(i=0;i<5;i++) {player.addRoom(rooms.draw()); opponent.addRoom(rooms.draw());}
	}
	
	/**
	 * assigns two more heroes to the tavern 
	 * called in middle of each round
	 */
	public void replenishHeroes() {
		if (heroes.size()<2) {
			heroes = new HeroDeck();
			heroes.shuffle();
		}
		int i;
		for(i=0;i<2;i++) tavern.addHero(heroes.draw());
	}
	
	/**
	 * deals a card to each player
	 * called at beginning of each round
	 */
	public void newRound() {
		if (rooms.size()<2) {
			rooms = new RoomDeck();
			rooms.shuffle();
		}
		player.addRoom(rooms.draw());
		opponent.addRoom(rooms.draw());
	}
	
	
	/** 
	 * checks model conditions to see if anyone has won
	 * @return whether the game is over
	 */
	public boolean isGameOver() {
		Boss pb = player.getDungeon().getBoss();
		Boss ob = opponent.getDungeon().getBoss();
		return pb.getHP()==0 || ob.getHP()==0 || pb.getCoins()>4 || ob.getCoins()>4;
	}
	
	public String showPlayers() {
		return "Player: \n" + player.getDungeon().getBoss().toString() + "\n" +
				"Opponent: \n" + opponent.getDungeon().getBoss().toString() + "\n";
	}
	
	public String showDungeons() {
		return "=====Opponent dungeon===== \n" + opponent.getDungeon().show() + "\n" + 
		"=====Player dungeon===== \n" + player.getDungeon().show() + "\n\n"; 
	}
	
}
