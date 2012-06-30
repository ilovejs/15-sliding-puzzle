package mySlidingPuzzle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class AI {
	Node initialState;
	Node goalState;
	
	public AI(Board initialState, Board goalState){
		this.initialState = new Node(initialState, null, 0, "");
		this.goalState = new Node(goalState, null, 0, "");
	}
	
	public HashSet<Node> bfs(Node goal) {
		HashSet<Node> closed = new HashSet<Node>();
		List<Node> expansion;
		List<Node> q = new LinkedList<Node>();
		q.add(initialState);
		
		while ( ! q.isEmpty()) { //level 5 contains node 2^4 to 2^5-1 // 
			Node front = q.remove(0);
			if(front.board.equals(goalState.board)){
				System.out.println("found solution");
				System.out.println("found: " + front);
				ArrayList<Node> order = new ArrayList<Node>();
				Node cur = front;
				while(cur.parent != null){
					order.add(cur);
					cur = cur.parent;
				}
				for(Node n : order){
					System.out.println("Visited: " + n);
				}
//				goal = front; //why can't update reference ??TODO
				break;
		    }
			if(closed.add(front)){
				expansion = front.neighbours();
				q.addAll(expansion);
			}
		}
		return closed;
	}
	
	public void printBoard(Board b) {
		int[][] board = b.board;
		int size = board.length;
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				System.out.println("row: " + r + " col: " + c + " val: "
						+ board[r][c]);
			}
		}
	}
	//how to use below, make a exercise ?
//	class BoardComparator implements Comparator<Board>{
//		public int compare(Board a, Board b){
//			/* Your code here */
//			return 0;
//		}
//	}
}