import java.util.HashMap;


public class Character extends Creature{
	private HashMap<String, ItemList.Item> inventory;
	public Character(String name, int move, int hp, int att, int def, int lore) {
		this.movement = move;
		this.health = hp;
		this.attack = att;
		this.defense = def;
		this.lore = lore;
		this.name = name;
		this.type = "character";
		this.inventory.clear();
	}
	
	public void equip(ItemList.Item newItem) {
		for(int i = 0; i < newItem.types.length; i++) {
			if(inventory.get(newItem.types[i]) != null) {
				unequip(inventory.get(newItem.types[i]));
			}
			inventory.put(newItem.types[i], null);
		}
		inventory.put(newItem.types[0], newItem);
		this.movement += newItem.movement;
		this.attack += newItem.attack;
		this.defense += newItem.defense;
		this.lore += newItem.lore;
	}
	
	public void unequip(ItemList.Item item) {
		this.movement -= item.movement;
		this.attack -= item.attack;
		this.defense -= item.defense;
		this.lore -= item.lore;
	}
}
