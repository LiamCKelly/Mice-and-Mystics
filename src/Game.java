import java.io.IOException;
import java.util.ArrayList;


public class Game {
	private ArrayList<Board> boardDeck;
	private ArrayList<Encounters.Encounter> encounterDeck;
	private ArrayList<ItemList.Item> itemDeck; 
	private ArrayList<Creature> turnOrder;
	private ArrayList<Creature> characterList;
	private int currentPage;
	private int maxPage;
	private int surgeCount;
	private boolean isWon;
	public Game() throws IOException {
		//Creates the Encounter card deck and the Board deck
		this.encounterDeck = new Encounters("encounters.txt").getEncounters();
		this.boardDeck = new BoardDeck("boards.txt").getBoards();
		this.itemDeck = new ItemList("items.txt").getItems();
		
		//Sets various starting values
		this.currentPage = 1;
		this.surgeCount = 0;
		this.isWon = false;
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
	public boolean isWon() {
		return this.isWon;
	}
}
