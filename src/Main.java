import java.io.IOException;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) throws IOException {
		Game game = new Game();
		printEach(game.getEncounterDeck());
		printEach(game.getBoardDeck());
		printEach(game.getItemDeck());
	}
	
	private static void printEach(ArrayList<?> list) {
		System.out.println("Printing in main...");
		for(Object ob : list) {
			System.out.println(ob.toString());
		}
		System.out.println("");
	}
}
