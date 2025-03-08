package Othello;

public class Board {
	
	private char[][] board; 
	private int count; 
	private static final char EMPTY = ' '; 
	private char s1, s2; 
	
	public Board(char a, char b) {
		s1 = a;
		s2 = b; 
		board = new char[8][8]; 
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				board[i][j] = EMPTY; 
			}
		}
		board[3][3]=board[4][4]=b; 
		board[3][4]=board[4][3]=a; 
		count = 4; 
	}
	
	public int getCount() {
		return count; 
	}

	public boolean isValidMove(int i, int j, char ch1) {
		if(board[i][j]!=EMPTY) {
			return false; 
		}
		
		char ch2 = EMPTY; 
		if(ch1==s1) {
			ch2=s2;
		}else {
			ch2=s1; 
		}
		
		boolean valid = false; 
		
		if(i>8||j>8||i<0||j<0) {
			return false; 
		}
		
		//STRAIGHT DOWN
		if(i+1<8) {
			if(board[i+1][j]==ch2) {
				int x = i+1, y=j; 
				while(x<8&&board[x][y]==ch2) {
					x++; 
				}
				if(x<8&&board[x][y]==ch1) {
					valid = true; 
					while(x!=i) {
						board[x][y]=ch1; 
						x--; 
					}
				}
			}
		}
		
		//STRAIGHT UP
		if(i-1>=0) {
			if(board[i-1][j]==ch2) {
				int x = i-1, y=j; 
				while(x>=0&&board[x][y]==ch2) {
					x--; 
				}
				if(x>=0&&board[x][y]==ch1) {
					valid = true; 
					while(x!=i) {
						board[x][y]=ch1; 
						x++; 
					}
				}
			}
		}
		
		//STRAIGHT RIGHT
		if(j+1<8) {
			if(board[i][j+1]==ch2) {
				int x = i, y=j+1; 
				while(y<8&&board[x][y]==ch2) {
					y++; 
				}
				if(y<8&&board[x][y]==ch1) {
					valid = true; 
					while(y!=j) {
						board[x][y]=ch1; 
						y--; 
					}
				}
			}
		}
		
		//STRAIGHT LEFT
		if(j-1>=0) {
			if(board[i][j-1]==ch2) {
				int x = i, y=j-1; 
				while(y>=0&&board[x][y]==ch2) {
					y--; 
				}
				if(y>=0&&board[x][y]==ch1) {
					valid = true; 
					while(y!=j) {
						board[x][y]=ch1; 
						y++; 
					}
				}
			}
		}
		
		//DIAGONAL RIGHT DOWN
		if(i+1<8&&j+1<8) {
			if(board[i+1][j+1]==ch2) {
				int x = i+1, y=j+1; 
				while(x<8&&y<8&&board[x][y]==ch2) {
					x++;
					y++; 
				}
				if(x<8&&y<8&&board[x][y]==ch1) {
					valid = true; 
					while(y!=j) {
						board[x][y]=ch1; 
						x--; 
						y--; 
					}
				}
			}
		}
		
		//DIAGONAL LEFT UP
		if(i-1>=0&&j-1>=0) {
			if(board[i-1][j-1]==ch2) {
				int x = i-1, y=j-1; 
				while(x>=0&&y>=0&&board[x][y]==ch2) {
					x--;
					y--; 
				}
				if(x>=0&&y>=0&&board[x][y]==ch1) {
					valid = true; 
					while(y!=j) {
						board[x][y]=ch1; 
						x++; 
						y++; 
					}
				}
			}
		}
		
		//DIAGONAL LEFT DOWN
		if(i+1<8&&j-1>=0) {
			if(board[i+1][j-1]==ch2) {
				int x = i+1, y=j-1; 
				while(x<8&&y>=0&&board[x][y]==ch2) {
					x++;
					y--; 
				}
				if(x<8&&y>=0&&board[x][y]==ch1) {
					valid = true; 
					while(y!=j) {
						board[x][y]=ch1; 
						x--; 
						y++; 
					}
				}
			}
		}
		
		//DIAGONAL RIGHT UP
		if(i-1>=0&&j+1<8) {
			if(board[i-1][j+1]==ch2) {
				int x = i-1, y=j+1; 
				while(x>=0&&y<8&&board[x][y]==ch2) {
					x--;
					y++; 
				}
				if(x>=0&&y<8&&board[x][y]==ch1) {
					valid = true; 
					while(y!=j) {
						board[x][y]=ch1; 
						x++; 
						y--; 
					}
				}
			}
		}
		
		if(valid) {
			return true; 
		}
		return false; 
		
		
	}

	public void input(int i, int j, char ch) {
		board[i][j] = ch; 
		count++; 
	}

	public void print(){
		System.out.print("\n   ");
		for(int i = 1; i<=8; i++) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		for(int i = 0; i<8; i++) {
			System.out.print(i+1+" ");
			for(int j = 0; j<8; j++) {
				System.out.print("|"+board[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("\n");
	}

	public void printResults(String Aname, String Bname) {
		int A = 0, B = 0; 
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if(board[i][j]==s1) {
					A++; 
				}else {
					B++; 
				}
			}
		}
		if(A>B) {
			System.out.println("GAME OVER\n"+Aname+" WINS!!!\nFinal score:\n"+Aname+": "+A+"\n"+Bname+": "+B);
		}else if(B>A) {
			System.out.println("GAME OVER\n"+Bname+" WINS!!!\nFinal score:\n"+Aname+": "+A+"\n"+Bname+": "+B);
		}else {
			System.out.println("GAME TIED");
		}
	}

}
