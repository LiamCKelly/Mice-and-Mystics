import java.util.Random;


public class Dice {
	private Random roller = new Random();
	private Face[] faces;
	public Dice() {
		this.faces[0] = new Face(1, "cheese", false);
		this.faces[1] = new Face(2, "range", false);
		this.faces[2] = new Face(2, "range", true);
		this.faces[3] = new Face(1, "melee", false);
		this.faces[4] = new Face(2, "melee", true);
		this.faces[5] = new Face(3, "defend", true);
	}
	
	public Face[] getRolls(int numRolls) {
		Face[] returner = new Face[numRolls];
		for(int i = 0; i < numRolls; i++) {
			returner[i] = this.faces[roller.nextInt(6)];
		}
		return returner;
	}
	
	static class Face {
		private int value;
		private String type;
		private boolean special;
		public Face(int val, String type, boolean spec) {
			this.value = val;
			this.type = type;
			this.special = spec;
		}
		public int getValue() {
			return value;
		}
		public String getType() {
			return type;
		}
		public boolean isSpecial() {
			return special;
		}
	}
}
