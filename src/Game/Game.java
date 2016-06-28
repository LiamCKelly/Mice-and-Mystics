package Game;
import java.io.IOException;
import java.util.ArrayList;

import Board.Board;
import Decks.BoardDeck;
import Decks.CharacterDeck;
import Decks.Encounters;
import Decks.ItemList;
import Entities.Creature;
import Entities.Dice;
import Entities.PlayerChar;


public class Game {
	private ArrayList<Board> boardDeck;
	private ArrayList<Encounters.Encounter> encounterDeck;
	private ArrayList<ItemList.Item> itemDeck; 
	private ArrayList<PlayerChar> characterDeck;
	private ArrayList<Creature> turnOrder = new ArrayList<Creature>();
	private ArrayList<Creature> characterList = new ArrayList<Creature>();
	private int currentPage;
	private Board currentBoard;
	private int maxPage;
	private int surgeCount;
	private boolean isWon;
	public Dice dice = new Dice();
	public Game() throws IOException {
		//Creates the various decks and Game elements
		this.encounterDeck = new Encounters("encounters.txt").getEncounters();
		this.boardDeck = new BoardDeck("boards.txt").getBoards();
		this.itemDeck = new ItemList("items.txt").getItems();
		this.characterDeck = new CharacterDeck("characters.txt").getChars();
		
		//Sets various starting values
		if(this.boardDeck != null) {
			this.currentBoard = boardDeck.get(0);
		}
		this.currentPage = 1;
		this.surgeCount = 0;
		this.isWon = false;
	}
	
	//alternate debug constructor to seed RNG
	public Game(long seed) throws IOException {
		this();
		this.dice = new Dice(seed); 
	}
	
	public ArrayList<Board> getBoardDeck() {
		return this.boardDeck;
	}
	public ArrayList<Encounters.Encounter> getEncounterDeck() {
		return this.encounterDeck;
	}
	public ArrayList<ItemList.Item> getItemDeck() {
		return this.itemDeck;
	}
	public ArrayList<Creature> getTurnOrder() {
		return this.turnOrder;
	}
	public ArrayList<Creature> getChars() {
		return this.characterList;
	}
	public boolean isWon() {
		return this.isWon;
	}
	public void addChars(Creature newChar) {
		this.characterList.add(newChar);
	}
	public Board getCurrentBoard() {
		return currentBoard;
	}

	public void setCurrentBoard(Board currentBoard) {
		this.currentBoard = currentBoard;
	}
}
