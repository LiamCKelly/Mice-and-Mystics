package Decks;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Encounters {
	private ArrayList<Encounter> encounters = new ArrayList<Encounter>();
	public Encounters(String filename) throws IOException {
		File in = new File(filename);
		BufferedReader input = new BufferedReader(new FileReader(in));
		String nextLine;
		while((nextLine = input.readLine()) != null) {
			separateAndAdd(nextLine);
		}
		input.close();
	}
	
	private void separateAndAdd(String line) {
		//separates each encounter "card" (each line) into the type of encounter by page
		ArrayList<String> pages = new ArrayList<String>();
		int j = 0;
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == ' ') {
				pages.add(line.substring(j, i));
				j = i+1;
			}
		}
		pages.add(line.substring(j, line.length()));
		//separates each encounter by page into enemy type and enemy count, and creates a new Encounter with them
		ArrayList<Integer> counts = new ArrayList<Integer>();
		ArrayList<String> types = new ArrayList<String>();
		for(int i = 0; i < pages.size()-1; i++) {
			counts.add(Integer.parseInt("" + pages.get(i).charAt(0)));
			types.add(pages.get(i).substring(1, pages.get(i).length()));
		}
		this.encounters.add(new Encounter(types, counts, new Boolean(pages.get(pages.size()-1))));
	}
	
	public ArrayList<Encounter> getEncounters() {
		return this.encounters;
	}
	
	
	//Encounter class code
	public static class Encounter {
		private boolean hasTraps;
		private ArrayList<String> enemyTypes;
		private ArrayList<Integer> enemyCounts;
		public Encounter(ArrayList<String> types, ArrayList<Integer> counts, boolean traps) {
			hasTraps = traps;
			enemyTypes = types;
			enemyCounts = counts;
		}
		
		public ArrayList<String> getEnemies(int pageno) {
			ArrayList<String> enemies = new ArrayList<String>();
			for(int i = 0; i < this.enemyCounts.get(pageno); i++) {
				enemies.add(this.enemyTypes.get(pageno));
			}
			return enemies;
		}
		
		public boolean hasTraps() {
			return this.hasTraps;
		}
		
		public ArrayList<String> getSurge() {
			ArrayList<String> enemies = new ArrayList<String>();
			for(int i = 0; i < this.enemyCounts.get(0); i++) {
				enemies.add(this.enemyTypes.get(0));
			}
			return enemies;
		}
		
		public String toString() {
			String returner = "Encounter: ";
			for(int i = 0; i < this.enemyCounts.size(); i++) {
				returner += ("" + this.enemyCounts.get(i) + this.enemyTypes.get(i) + ", ");
			}
			returner += this.hasTraps ? "mousetraps" : "no mousetraps";
			return returner;
		}
	}
	
	//Helper methods
	private void printEach(ArrayList<?> list) {
		for(Object ob : list) {
			System.out.print(ob.toString() + ", ");
		}
		System.out.println("");
	}
	
}
