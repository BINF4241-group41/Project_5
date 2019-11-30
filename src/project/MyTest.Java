package project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


class Test {

	/**
	 * @throws java.lang.Exception
	 * 
	 */
	private static Game game;
	private final static int boardsize=12;
	private static Square square;
	private static FirstSquare first;
	private static LastSquare last;
	private static String vett[]= {"first","second"};
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		game= new Game(boardsize, vett);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */

	/*
	 * Test the instance of the gameboard
	 * 
	 */
	@org.junit.jupiter.api.Test
	void testSquare() {
		
		assertEquals(game.getGameBoard().getClass(),square.getClass());
		assertEquals(game.getFirstSquare().getClass(),first.getClass());
		assertEquals(game.getLastSquare().getClass(),last.getClass());
		
	}
	/*
	 * create a Game and the instance should create a gameboard
	 * then check the size of the gameboard with your value
	 * 
	 * @param 	i size of the gameboard
	 * 		  	vett random String[]
	 */
	@org.junit.jupiter.api.Test
	void testBoard() {
		for(int i=1;i<100;i++) {
			game= new Game(i, vett);
			assertEquals(i,game.getBoardSize());
		}
	}
	/*
	 * try to set get a buffer overflow
	 * 
	 * @param i valori di input
	 */
	
	
	@org.junit.jupiter.api.Test
	void testDiv() {
		for(int i=1;i<10000;i++) {
			try {
			game.movePlayer(i);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}