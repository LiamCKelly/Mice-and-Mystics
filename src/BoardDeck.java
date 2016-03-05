import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BoardDeck {
	private ArrayList<Board> boards = new ArrayList<Board>();
	public BoardDeck(String filename) throws IOException {
		File in = new File(filename);
		BufferedReader input = new BufferedReader(new FileReader(in));
		String nextLine;
		while((nextLine = input.readLine()) != null) {
			separateAndAdd(nextLine);
		}
		input.close();
	}
	
	private void separateAndAdd(String line) {
		//Adds each Tile code into an ArrayList
		ArrayList<String> tileCodes = new ArrayList<String>();
		int j = 0;
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == ' ') {
				tileCodes.add(line.substring(j, i));
				j = i+1;
			}
		}
		tileCodes.add(line.substring(j, line.length()));
		//Converts Tile codes into Tile objects
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		for(String code: tileCodes) {
			switch(code) {
			case("e"):
				tiles.add(new Tile.EnemySpawnTile());
				break;
			case("p"):
				tiles.add(new Tile.PlayerSpawnTile());
				break;
			case("f"):
				tiles.add(new Tile.FlipTile());
				break;
			default:
				tiles.add(new Tile());
				break;
			}
		}
		//Converts the ArrayList of Tile objects into a full 2D array
		int arrayPos = 0;
		int length = (int) Math.sqrt(tiles.size());
		Tile[][] tileSet = new Tile[length][length];
		for(int y = 0; y < length; y++) {
			for(int x = 0; x < length; x++) {
				tileSet[y][x] = tiles.get(arrayPos);
				arrayPos++;
			}
		}
		//Creates a new Board using the 2D array and adds it to the board deck
		this.boards.add(new Board(tileSet));
	}
	
	public ArrayList<Board> getBoards() {
		return this.boards;
	}
}
