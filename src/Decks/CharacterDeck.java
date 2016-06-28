package Decks;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Entities.PlayerChar;

public class CharacterDeck {
	
	private ArrayList<PlayerChar> characters = new ArrayList<PlayerChar>();
	public CharacterDeck(String filename) throws IOException, FileNotFoundException {
		File in = new File(filename);
		BufferedReader input = new BufferedReader(new FileReader(in));
		String nextLine;
		while((nextLine = input.readLine()) != null) {
			separateAndAdd(nextLine);
		}
		input.close();
	}

	private void separateAndAdd(String line) {
		//Adds each attribute to an ArrayList
		ArrayList<String> charAttrs = new ArrayList<String>();
		int j = 0;
		for(int i = 0; i < line.length(); i++) {
			if(line.charAt(i) == ' ') {
				charAttrs.add(line.substring(j, i));
				j = i+1;
			}
		}
		charAttrs.add(line.substring(j, line.length()));
		
		//checks to see if compatible with constructor
		if(charAttrs.size() != 6) {
			System.err.println("Incorrect number of arguments to construct a new PlayerChar from file.");
			System.exit(1);
		}
		//creates a new PlayerChar and adds it to the deck
		String name = charAttrs.get(0);
		int move = Integer.parseInt(charAttrs.get(1));
		int hp = Integer.parseInt(charAttrs.get(2));
		int att = Integer.parseInt(charAttrs.get(3));
		int def = Integer.parseInt(charAttrs.get(4));
		int lore = Integer.parseInt(charAttrs.get(5));
		this.characters.add(new PlayerChar(name, move, hp, att, def, lore));
				
	}
	
	public ArrayList<PlayerChar> getChars() {
		return this.characters;
	}
}

