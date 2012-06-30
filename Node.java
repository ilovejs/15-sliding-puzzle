package mySlidingPuzzle;
import java.util.ArrayList;
import java.util.List;

public class Node {
	Board board;
	int depth;
	Node parent;
	String direction;
	
	public Node() {
		this.board = null;
		parent = null;
		depth = 0;
		direction = null;
	}
	
	public Node(Board board) {
		this.board = board;
		parent = null;
		depth = 0;
		direction = new String();
	}

	public Node(Board board, Node parent, int depth, String direction) {
		this.board = board;
		this.parent = parent;
		this.depth = depth;
		this.direction = direction;
	}

	// ================================================================
	public List<Node> neighbours() {
		int[][] board = this.board.board;
		int size = this.board.size;
		
		List<Node> neighbours = new ArrayList<Node>();
		// search empty tile
		int br = 0;
		int bc = 0;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (board[r][c] == -1) {
					br = r;
					bc = c;
					// System.out.println("blank row: " + br + " b col: " + bc);
				}
			}
		}
		int[][] temp = null;
		Board tb = null;
		// up
		if (br != 0) {
			temp = move(board, "up", br, bc);
			tb = new Board(temp);
			neighbours.add(new Node(tb, this, depth + 1, "up"));
		}
		// move down
		if (br != size - 1) {
			temp = move(board, "down", br, bc);
			tb = new Board(temp);
			neighbours.add(new Node(tb, this, depth + 1, "down"));
		}
		// move left
		if (bc != 0) {
			temp = move(board, "left", br, bc);
			tb = new Board(temp);
			neighbours.add(new Node(tb, this, depth + 1, "left"));
		}
		// can move right
		if (bc != size - 1) {
			temp = move(board, "right", br, bc);
			tb = new Board(temp);
			neighbours.add(new Node(tb, this, depth + 1, "right"));
		}
		return neighbours;
	}

	// blank row and blank column
	public int[][] move(int[][] data, String position, int br, int bc) {
		int[][] after = copyBoard(data);
		int t = 0;
		// top
		if (position.equals("up")) {
			t = after[br][bc];
			after[br][bc] = after[br - 1][bc];
			after[br - 1][bc] = t;
		}
		// down
		if (position.equals("down")) {
			t = after[br][bc];
			after[br][bc] = after[br + 1][bc];
			after[br + 1][bc] = t;
		}
		// left
		if (position.equals("left")) {
			t = after[br][bc];
			after[br][bc] = after[br][bc - 1];
			after[br][bc - 1] = t;
		}
		// right
		if (position.equals("right")) {
			t = after[br][bc];
			after[br][bc] = after[br][bc + 1];
			after[br][bc + 1] = t;
		}
		return after;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((board == null) ? 0 : board.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {  //TODO:this will cause problem is not implemented but why ??
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (board == null) {
			if (other.board != null)
				return false;
		} else if (!board.equals(other.board))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "direction=" + direction + " depth=" + depth + ", parent=" + parent;
	}
}