package mySlidingPuzzle;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Executer {
	public static void main(String[] args) throws FileNotFoundException {
		//read in file use scanner
//		Scanner sc = new Scanner(new File("t1.txt"));
//		String line = null;
//		String[] tileinfo = null;
//		while(sc.hasNextLine()){
//			line = sc.nextLine();
//			tileinfo = line.split(" ");
//			//System.out.println(line);
//		}
//		String[] tileinfo = {"1","2","3","-1"};
		String[] tileinfo = {"1","2","3",
				             "4","5","6",
				             "7","8","-1"};
		int size = (int)Math.sqrt(tileinfo.length);
		Board initialState = new Board(size, tileinfo);
		
		//make goalState
//		String[] temp = {"-1","3","2","1"};
//		String[] temp = {"2","1","3","4","-1","6","5","7","8"};
//		String[] temp = {"3","2","6","1","8","5","4","-1","7"};
		String[] temp = {"-1","1","2","3","4","5","6","7","8"};
		int size2 = (int)Math.sqrt(temp.length);
		Board goalState = new Board(size2 ,temp);
		
//		System.out.println("goal:============");
//		goalState.print();
//		System.out.println("end goal:============");
//
//		System.out.println("init:============");
//		initialState.print();
//		System.out.println("end init:============");
		
		System.out.println("Read console output bottom up, check each move with direction s.t. up,down,left,right");
		
		AI solver = new AI(initialState, goalState);
		Node truegoal = new Node();
		HashSet<Node> verbose = solver.bfs(truegoal);
		System.out.println("closet size: " + verbose.size());
//		System.out.println("true goal: " + truegoal);
//		readCloset(verbose, truegoal, initialState);
		//List<Board> neighbours = board.Neighbour(board);
	}
	
	public static void readCloset(HashSet<Node> closet, Node goal, Board initialState){
		ArrayList<Node> order = new ArrayList<Node>();
		//child and parent map
		HashMap<Node,Node> CPmap = new HashMap<Node,Node>();
		//find goal node
//		Node init = new Node(initialState, null, 0);
		
		for(Node node : closet){
			CPmap.put(node, node.parent);
		}
		Node cur = goal;
		while(cur.parent != null){
			order.add(cur);
			cur = cur.parent;
		}
		for(Node n : order){
			System.out.println("Visited: " + n);
		}
	}
}