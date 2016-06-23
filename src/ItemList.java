import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ItemList {
	private ArrayList<Item> items = new ArrayList<Item>();
	public ItemList(String filename) throws IOException {
		File in = new File(filename);
		BufferedReader input = new BufferedReader(new FileReader(in));
		String nextLine;
		while((nextLine = input.readLine()) != null) {
			separateAndAdd(nextLine);
		}
		input.close();
	}

	private void separateAndAdd(String line) {
		//Adds each attribute into an ArrayList
		ArrayList<String> atts = new ArrayList<String>();
		int j = 0;
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == '.') {
				atts.add(line.substring(j, i));
				j = i+1;
			}
		}
		atts.add(line.substring(j, line.length()));
		//Finds the item's designated equipment slots and puts them into an ArrayList
		ArrayList<String> slots = new ArrayList<String>();
		for(int i = 0; i < atts.size(); i++) {
			String att = atts.get(i);
			switch(att) {
			case("H"):
				slots.add("Head");
				atts.remove(i);
				i--;
				break;
			case("C"):
				slots.add("Chest");
				atts.remove(i);
				i--;
				break;
			case("MH"):
				slots.add("Main Hand");
				atts.remove(i);
				i--;
				break;
			case("OH"):
				slots.add("Off Hand");
				atts.remove(i);
				i--;
				break;
			case("L"):
				slots.add("Legs");
				atts.remove(i);
				i--;
				break;
			case("F"):
				slots.add("Feet");
				atts.remove(i);
				i--;
				break;
			default:
				break;
			}
		}
		//Converts the ArrayList of slots into a plain array of objects, then makes sure that each object in the array is a String
		Object[] types = slots.toArray();
		String[] typesStringify = new String[types.length];
		for(int i = 0; i < types.length; i++) {
			typesStringify[i] = types[i].toString();
		}
		//Converts all stat values from String to int, the isRange marker from String to int, and adds a new Item to the item list using the gathered data.
		this.items.add(new Item(atts.get(0), typesStringify, Integer.parseInt(atts.get(1)), Integer.parseInt(atts.get(2)), Integer.parseInt(atts.get(3)), Integer.parseInt(atts.get(4)), new Boolean(atts.get(5))));
	}
	
	
	static class Item {
		public int attack;
		public int defense;
		public int movement;
		public int lore;
		public boolean isRange;
		public String[] types;
		public String name;
	
		public Item(String name, String[] types, int att, int def, int move, int lore, boolean range) {
			this.name = name;
			this.types = types;
			this.attack = att;
			this.defense = def;
			this.movement = move;
			this.lore = lore;
			this.isRange = range;
		}
		
		public String toString() {
			String returner = "";
			returner += this.name + ":\n";
			returner += "Attack:    " + this.attack + "\n";
			returner += "Defense:   " + this.defense + "\n";
			returner += "Movement:  " + this.movement + "\n";
			returner += "Lore:      " + this.lore + "\n";
			returner += "Type:      " + (this.isRange ? "Ranged\n" : "Melee\n");
			return returner;
		}
	}
	
	public ArrayList<Item> getItems() {
		return this.items;
	}
}
