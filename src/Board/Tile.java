package Board;
import Entities.Creature;

public class Tile {
	private boolean canSpawnEnemy;
	private boolean canFlip;
	private boolean canSpawnPlayer;
	private Creature[] creatures = new Creature[4];
	private int creatureCount;
	private String type;
	public Tile() {
		this.canSpawnEnemy = false;
		this.canFlip = false;
		this.canSpawnPlayer = false;
		this.type = "T";
		this.creatureCount = 0;
	}
	public boolean hasCreatures() {
		return (this.creatureCount != 0);
	}
	public boolean isFull() {
		return (this.creatureCount == 4);
	}
	public boolean canESpawn() {
		return this.canSpawnEnemy;
	}
	public boolean canPSpawn() {
		return this.canSpawnPlayer;
	}
	public boolean canFlip() {
		return this.canFlip;
	}
	public String getType() {
		return this.type;
	}
	//returns -1 if error, 0 otherwise
	public int addCreature(Creature newCreature) {
		if(this.isFull()) {
			System.out.println("Tile full; try again");
			return -1;
		} else {
			this.creatures[this.creatureCount] = newCreature;
			this.creatureCount++;
			return 0;
		}
	}
	
	//returns -1 if no such creature exists on the tile, 0 if it was removed properly.
	public int removeCreature(Creature toRemove) {
		for(int i = 0; i < this.creatures.length; i++) {
			if(this.creatures[i] == toRemove) {
				this.creatures[i] = null;
				return 0;
			}
		}
		return -1;
	}
	
	
	//Different types of Tiles
	
	//Enemy spawner Tiles
	public static class EnemySpawnTile extends Tile {
		public EnemySpawnTile() {
			super.canSpawnEnemy = true;
			super.type = "E";
		}
	}
	
	//Flip Tiles
	public static class FlipTile extends Tile {
		public FlipTile() {
			super.canFlip = true;
			super.type = "F";
		}
	}
	
	//Player start Tiles
	public static class PlayerSpawnTile extends Tile {
		public PlayerSpawnTile() {
			super.canSpawnPlayer = true;
			super.type = "P";
		}
	}
}
