
public class Tile {
	private boolean canSpawnEnemy;
	private boolean canFlip;
	private boolean canSpawnPlayer;
	private Creature[] creatures = new Creature[4];
	private String type;
	public Tile() {
		this.canSpawnEnemy = false;
		this.canFlip = false;
		this.type = "T";
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
	
	
	//Different types of Tiles
	
	//Enemy spawner Tiles
	static class EnemySpawnTile extends Tile {
		public EnemySpawnTile() {
			super.canSpawnEnemy = true;
			super.type = "E";
		}
	}
	
	//Flip Tiles
	static class FlipTile extends Tile {
		public FlipTile() {
			super.canFlip = true;
			super.type = "F";
		}
	}
	
	//Player start Tiles
	static class PlayerSpawnTile extends Tile {
		public PlayerSpawnTile() {
			super.canSpawnPlayer = true;
			super.type = "P";
		}
	}
}
