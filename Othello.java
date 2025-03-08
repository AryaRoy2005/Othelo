package Othello;
import java.util.Scanner; 

public class Othello {
	
	Scanner s = new Scanner(System.in); 
	
	private Player A; 
	private Player B; 
	private Board board;
	
	public Othello() {
		System.out.println("Hello, and welcome to Othello");
	}
	
	public void play() {
		initializePlayers(); 
		initializeBoard(); 
		printInstructions(); 
		
		Player currPlayer = A; 
		board.print();
		while(board.getCount()<64) {
			System.out.print(currPlayer.getName()+", enter row and column: ");
			int row = s.nextInt(); 
			int column = s.nextInt(); 
			while(!board.isValidMove(row-1, column-1, currPlayer.getSymbol())) {
				System.out.println("Sorry, not a valid move. Try again");
				System.out.print("Enter row and column: ");
				row = s.nextInt(); 
				column = s.nextInt(); 
			}
			
			board.input(row-1, column-1, currPlayer.getSymbol());
			board.print(); 
			
			if(currPlayer==A) {
				currPlayer=B; 
			}else {
				currPlayer=A; 
			}
		}
		
		board.printResults(A.getName(), B.getName()); 
		
	}

	private void printInstructions() {
		System.out.println("RULES OF PLAY: \nThe objective of this game is to conquer as many boxes as possible\nBoxes may be conquered only if they are filled by opponent's piece, by trapping it on opposite sides with your own piece\nOnly those moves which result in a possible conquer of a box, are considered a VALID move\nEnter the row and column where you want to place your piece\nPlease note that row/column count ranges from 1 to 8\n\nGOOD GAME!!!\n\n");
	}

	private void initializeBoard() {
		board = new Board(A.getSymbol(), B.getSymbol()); 
	}

	private void initializePlayers() {
		A=new Player();
		B=new Player();
		System.out.println("Please insert your names and choose your symbols below");
		
		System.out.print("Player 1: ");
		A.setName(s.next()); 
		System.out.print("Pick your symbol, "+A.getName()+": ");
		char inputA = s.next().charAt(0); 
		while(inputA==' ') {
			System.out.println("Really, an empty space? Don't be a smarty pants. Try again");
			System.out.print("Pick your symbol: ");
			inputA = s.next().charAt(0); 
		}
		A.setSymbol(inputA); 
		
		System.out.print("Player 2: ");
		B.setName(s.next()); 
		System.out.print("Pick your symbol, "+B.getName()+": ");
		char inputB = s.next().charAt(0); 
		while(inputB==' '||inputB==inputA) {
			if(inputB==' ')System.out.println("Really, an empty space? Don't be a smarty pants. Try again");
			if(inputB==inputA)System.out.println("No originality huh? Pick something "+A.getName()+" didn't already pick");
			System.out.print("Pick your symbol: ");
			inputB = s.next().charAt(0); 
		}
		B.setSymbol(inputB);
		
		System.out.println("\n"+A.getName()+": "+A.getSymbol()+"\n"+B.getName()+": "+B.getSymbol()+"\n");
	} 

}
