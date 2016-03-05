
public class Creature {
	protected int movement;
	protected int health;
	protected int attack;
	protected int defense;
	protected int lore;
	protected String type;
	protected String name;
	public Creature() {
		this.type = "default";
	}
	
	static class Roach extends Creature {
		public Roach() {
			super.movement = 0;
			super.health = 1;
			super.attack = 2;
			super.defense = 1;
			super.lore = 0;
			super.type = "roach";
			super.name = this.type;
		}
	}
	static class Rat extends Creature {
		public Rat() {
			super.movement = 0;
			super.health = 1;
			super.attack = 2;
			super.defense = 2;
			super.lore = 0;
			super.type = "rat";
			super.name = this.type;
		}
	}

	//Getters for ALL types of Creature
	public int getMovement() {
		return this.movement;
	}
	public int getHealth() {
		return this.health;
	}
	public int getAttack() {
		return this.attack;
	}
	public int getLore() {
		return this.lore;
	}
	public int getDefense() {
		return this.defense;
	}
	public String getType() {
		return this.type;
	}
	public String getName() {
		return this.name;
	}
}
