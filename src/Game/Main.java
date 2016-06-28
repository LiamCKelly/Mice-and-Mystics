package Game;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Board.Board;
import Board.Tile;
import Entities.PlayerChar;
import Entities.Dice;


public class Main {
	private static ArrayList<PlayerChar> charList = new ArrayList<PlayerChar>();
	public static void main(String[] args) throws IOException {
		Game game = new Game(2016);

		Scanner input = new Scanner(System.in);
		System.out.println("How many players? ");
		int numPlayers = input.nextInt();
		while (numPlayers < 2 || numPlayers > 6) {
			System.out.println("Only 2 to 6 player(s) allowed. Enter a new number of players: ");
			numPlayers = input.nextInt();
		}
		choosePlayers(numPlayers, charList);
		
		
		//printEach(game.getEncounterDeck());
		//printEach(game.getBoardDeck());
		//printEach(game.getItemDeck());
		ArrayList<Coordinate> coords = new ArrayList<Coordinate>();
		Board currentBoard = game.getCurrentBoard();
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
		for(Dice.Face result : game.dice.getRolls(6)) {
			System.out.println(result.toString());
		}
		
		
		
		//Testing equipping/unequipping items
		/*
		test.equip(game.getItemDeck().get(0));
		System.out.println(test.toString());
		test.unequip(game.getItemDeck().get(0));
		System.out.println("AGAIN");
		System.out.println(test.toString());
		*/
		input.close();
	}
	
	private static void choosePlayers(int numPlayers, ArrayList<PlayerChar> charlist) {
		
	}

	private static void printEach(ArrayList<?> list) {
		System.out.println("Printing in main...");
		for(Object ob : list) {
			System.out.println(ob.toString());
		}
		System.out.println("");
	}
}
