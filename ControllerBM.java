
/*
 * Tony Burwinkel
 * CS5004 Fall 2022
 * Final Project
 * Boss Monster
 */


import java.io.IOException;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * controller class for taking user input,
 * manipulating the model, and displaying the
 * result to the view
 *
 */
public class ControllerBM {
	private Scanner input;
	private Readable read;
	private Appendable view;
	private Random rand;

	public ControllerBM(Readable r, Appendable op) {
		this.read = r;
		this.view = op;
		rand = new Random();
	}
	
	/**
	 * plays a game of boss monster
	 */
	public void go(ModelBM m) {
		this.input = new Scanner(read);
		try {
		view.append("========BOSS MONSTER========\n");
			playLoop(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * play loop for boss monster game
	 * build phase - build a room from your hand
	 * bait phase - move heroes from the tavern to the correct dungeon
	 * adventure phase - heroes attack dungeons
	 * @param model
	 * @throws InterruptedException
	 */
	public void playLoop(ModelBM model) throws InterruptedException {
		try {
		while (!(model.isGameOver())) {
			// deal a room card to each player and replenish tavern heroes
			waitContinue();

			view.append("---BUILD PHASE---\n\n");
			view.append(model.showDungeons());
		
			// have the opponent play a random card from their hand
			opponentPlay(model);
			waitContinue();
			// show the tavern so the player can decide what room to play
			view.append("Heroes are gathering in the tavern... \n\n");
			model.replenishHeroes();
			view.append(model.getTavern().showTavern());
			waitContinue();
			view.append("Choose room to build...\n\n");
			view.append(indexHand(model.getPlayer()));
			playRoom(model.getPlayer());
			view.append(model.showDungeons());

			view.append("---BAIT PHASE---\n");
			// move heroes to appropriate dungeons
			view.append(model.getTavern().dispatchHeroes(model.getPlayer().getDungeon(), model.getOpponent().getDungeon()));
			waitContinue();

			view.append("---ADVENTURE PHASE---\n");
			// process heroes that have queued
			view.append(processHeroes(model.getPlayer().getDungeon()));
			view.append(processHeroes(model.getOpponent().getDungeon()));
			
			// prepare for the next round by dealing each player a room
			model.newRound();
			}
		
		view.append("=====GAME OVER=====\n");
		view.append(model.showPlayers());
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * show the rooms in the player's hand with index numbers
	 * @param p player whose hand should show
	 * @return String of player's hand with index numbers
	 */
	private String indexHand(Player p) {
		String returnString = "";
		LinkedList<Room> rooms = p.getRooms();
		// sort the rooms by sign via their implementation of compareTo
		Collections.sort(rooms);
		int i;
		for (i=0;i<rooms.size();i++) {
			returnString = returnString.concat(String.format("Number %d\t%s\n", i+1, rooms.get(i).handString()));
		}
		return returnString;
	}
	
	/**
	 * play a room from the player's hand
	 * @param p player whose hand should be played from
	 */
	private void playRoom(Player p) {
		LinkedList<Room> rooms = p.getRooms();
		int choice = getChoice(1, rooms.size());
		p.getDungeon().addRoom(rooms.get(choice-1));
		rooms.remove(choice-1);
	}
	
	/**
	 * play a random room from the opponent's hand
	 * @param model instance of model to get opponent from
	 */
	private void opponentPlay(ModelBM model) {
		Player o = model.getOpponent();
		LinkedList<Room> rooms = o.getRooms();
		int roomNum = rand.nextInt(rooms.size()-1);
		Room randRoom = rooms.get(roomNum);
		o.getDungeon().addRoom(randRoom);
		rooms.remove(roomNum);
	}
	
	/**
	 * process the heroes waiting to attack a dungeon
	 * @param d dungeon heroes are queued to attack
	 * @return String showing results of attack
	 */
	public String processHeroes(Dungeon d) {
		String returnString = "";
		LinkedList<Hero> toProcess = d.getHeroQueue();
		for (Hero h: toProcess) {
			returnString = returnString.concat(h.getName() + " has entered " + d.getBoss().getName()+ "'s dungeon...\n");
			returnString = returnString.concat(d.defendAgainst(h) + "\n");
		}
		toProcess.clear();
		return returnString;
	}
	
	/**
	 * get a choice between min and max from the player
	 * @param min - minimum number to choose
	 * @param max - maximum number to choose
	 * @return validated player choice
	 */
	private int getChoice(int min, int max) {
		int choice=0;
		while (choice==0) {
			try {choice = input.nextInt();}
			catch(InputMismatchException e) {

				try {view.append("invalid selection");} 
				catch (IOException io) {io.printStackTrace();}
				
				choice=0;
				input.nextLine();
			}
			if (choice<min || choice>max) { 
				choice=0;
				input.nextLine();
				try {
					view.append(String.format("invalid selection. choose a number between %d and %d\n", min, max));
				} catch (IOException io) {
					io.printStackTrace();
				}
			}
		}
	return choice;
	}
	
	/**
	 * break up play into segments
	 * prompt user to press enter
	 */
	public void waitContinue() {
		try {
		view.append("Press enter to continue...\n\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		input.nextLine();
	}
	
	/**
	 * show both player's dungeons so choices can be made
	 * @param model game model to show dungeons from
	 * @return String of both dungeons
	 */
	public String showDungeons(ModelBM model) {
		return "=====Opponent dungeon===== \n" + model.getOpponent().getDungeon().show() + "\n" + 
		"=====Player dungeon===== \n" + model.getPlayer().getDungeon().show() + "\n\n"; 
	}

}

