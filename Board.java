package mySlidingPuzzle;
import java.util.Arrays;

public class Board {
	int size;
	int[][] board;
	boolean visited = false;
	
	public Board(int size, String[] info) {
		this.size = size;
		this.board = new int[size][size];
		this.visited = false;
		
		int count = 0;
		// 1 2 3 4 or 0 1 2 3
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				String tiledata = info[count++];
				int intform = 0;
				try {
					intform = Integer.parseInt(tiledata);
				} catch (Exception e) {
					if (tiledata.equals("b")) {
						intform = -1;
					}
				}
				board[r][c] = intform;
			}
		}
	}

	//data is : 0 1 3 2
	public Board(int[][] data) {
		this.size = (data.length);
		this.visited = false;
		this.board = copyBoard(data);
	}

	public int[][] copyBoard(int[][] data) {
		int[][] myInt = new int[data.length][];
		// System.out.println("size: " + myInt.length);
		// System.out.println("matrix: " + data.length);
		for (int i = 0; i < data.length; i++) {
			myInt[i] = data[i].clone();
		}
		return myInt;
	}

	public void print() {
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				System.out.println("row: " + r + " col: " + c + " val: "
						+ board[r][c]);
			}
		}
	}

	public void printBoard(Board b) {
		int[][] board = b.board;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				System.out.println("row: " + r + " col: " + c + " val: "
						+ board[r][c]);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(board); //deep hash code
		result = prime * result + size;
		result = prime * result + (visited ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (!Arrays.deepEquals(board, other.board)) //deep equals
			return false;
		if (size != other.size)
			return false;
		if (visited != other.visited)
			return false;
		return true;
	}

	@Override
	public String toString() {
//		return "Board [board=" + Arrays.toString(board) + "]";
		return "[" + board[0][0] + "," + board[0][1] + "],[" + board[1][0] + "," + board[1][1] + "]";
	}	
}