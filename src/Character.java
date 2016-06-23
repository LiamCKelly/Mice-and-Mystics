import java.util.HashMap;


public class Character extends Creature{
	//Inventory goes by (slot type, item) convention
	private HashMap<String, ItemList.Item> inventory = new HashMap<String, ItemList.Item>();
	public Character(String name, int move, int hp, int att, int def, int lore) {
		super.movement = move;
		super.health = hp;
		super.attack = att;
		super.defense = def;
		super.lore = lore;
		super.name = name;
		super.type = "character";
		this.inventory.clear();
	}
	
	public void equip(ItemList.Item newItem) {
		for(int i = 0; i < newItem.types.length; i++) {
			if(this.inventory.get(newItem.types[i]) != null) {
				unequip(this.inventory.get(newItem.types[i]));
			} else {
				inventory.put(newItem.types[i], null);
			}
		}
		this.inventory.put(newItem.types[0], newItem);
		this.movement += newItem.movement;
		this.attack += newItem.attack;
		this.defense += newItem.defense;
		this.lore += newItem.lore;
	}
	
	public void unequip(ItemList.Item item) {
		for(String type : item.types) {
			this.inventory.put(type, null);
		}
		this.movement -= item.movement;
		this.attack -= item.attack;
		this.defense -= item.defense;
		this.lore -= item.lore;
	}
	
	public String toString() {
		String returner = super.toString();
		returner += "---------------------\n";
		returner += "INVENTORY \n";
		returner += "---------------------\n";
		returner += this.invString();
		return returner;
	}
	
	private String invString() {
		String returner = "";
		for(String key : this.inventory.keySet()) {
			returner += key + ": " + (this.inventory.get(key) != null ? this.inventory.get(key).name : "--") + "\n";
		}
		return returner;
	}
}
