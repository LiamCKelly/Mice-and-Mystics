package Board;

public class Board {
	private Tile[][] tileset;
	private Board flipBoard;
	private Board northBoard;
	private Board southBoard;
	private Board eastBoard;
	private Board westBoard;
	public Board(Tile[][] tiles) {
		this.tileset = tiles;
	}
	
	public void setFlipBoard(Board board) {
		this.flipBoard = board;
	}
	public void setNorthBoard(Board board) {
		this.northBoard = board;
	}
	public void setSouthBoard(Board board) {
		this.southBoard = board;
	}
	public void setEastBoard(Board board) {
		this.eastBoard = board;
	}
	public void setWestBoasrd(Board board) {
		this.westBoard = board;
	}
	public Tile[][] getTileset() {
		return this.tileset;
	}
	public void setTileset(Tile[][] set) {
		this.tileset = set;
	}
	
	public String toString() {
		String returner = "";
		for(int y = 0; y < this.tileset.length; y++) {
			for(int x = 0; x < this.tileset[0].length; x++) {
				returner += "[" + this.tileset[y][x].getType();
				if(this.tileset[y][x].hasCreatures()) { 
					returner += "*";
				}
				if(this.tileset[y][x].isFull()) {
					returner += "*";
				}
				returner += "]    ";
			}
			returner += "\n";
		}
		return returner;
	}
}
