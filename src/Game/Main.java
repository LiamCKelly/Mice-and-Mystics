package Game;
import java.io.IOException;
import java.util.ArrayList;

import Board.Board;
import Board.Tile;
import Entities.Character;


public class Main {
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		//printEach(game.getEncounterDeck());
		//printEach(game.getBoardDeck());
		//printEach(game.getItemDeck());
		ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
		Character test = new Character("Liam", 5, 0, 0, 0, 0);
		game.addChars(test);
		Board currentBoard = game.getBoardDeck().get(0);
		Tile[][] tileset = currentBoard.getTileset();
		for(int y = 0; y < tileset.length; y++) {
			for(int x = 0; x < tileset[y].length; x++) {
				if(tileset[y][x].getType().equals("P")) {
					coords.add(new Coordinate(x, y));
				}
			}
		}
		for(int i = 0; i < game.getChars().size(); i++) {
			tileset[coords.get(i%coords.size()).y()][coords.get(i%coords.size()).x()].addCreature(game.getChars().get(i));
		}
		currentBoard.setTileset(tileset);
		System.out.println(currentBoard.toString());
		
		
		
		//Testing equipping/unequipping items
		/*
		test.equip(game.getItemDeck().get(0));
		System.out.println(test.toString());
		test.unequip(game.getItemDeck().get(0));
		System.out.println("AGAIN");
		System.out.println(test.toString());
		*/
	}
	
	private static void printEach(ArrayList<?> list) {
		System.out.println("Printing in main...");
		for(Object ob : list) {
			System.out.println(ob.toString());
		}
		System.out.println("");
	}
}
