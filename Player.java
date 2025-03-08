package Othello;

public class Player {
	
	private String name;
	private char symbol; 
	private int count; 
	
	public void setName(String input) {
		name = input; 
	}

	public String getName() {
		return name;
	}

	public void setSymbol(char inputA) {
		symbol = inputA; 
	}

	public char getSymbol() {
		return symbol;
	}

	public int getCount() {
		return count;
	}

}
