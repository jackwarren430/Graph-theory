import java.util.*;
import java.io.*;

public class Tester4 {
	public static void main(String[] args) throws IOException{
		
		AdjacencyList list = new AdjacencyList("resources/graph2.txt");

		MyQueue<Path> queue = new MyQueue<Path>();
		ArrayList<Path> bfs = GraphTraverser.traverse(queue, list, "A");

		MyStack<Path> stack = new MyStack<Path>();
		ArrayList<Path> dfs = GraphTraverser.traverse(stack, list, "A");


		AdjacencyList list2 = new AdjacencyList("resources/graph3.txt");

		MyPQ<Path> dPQ = new MyPQ<Path>(new DijkstraComparator<Path>());
		ArrayList<Path> dijk = GraphTraverser.traverse(dPQ, list2, "W");

		MyPQ<Path> pPQ = new MyPQ<Path>(new PrimComparator<Path>());
		ArrayList<Path> prim = GraphTraverser.traverse(pPQ, list2, "W");


		System.out.println("------------------------------");
		System.out.println("BFS: \n\n" + GraphTraverser.printPaths(bfs));
		System.out.println("------------------------------");
		System.out.println("DFS: \n\n" + GraphTraverser.printPaths(dfs));
		System.out.println("------------------------------");
		System.out.println("Dijkstra's Algorithm: \n\n" + GraphTraverser.printPaths(dijk));
		System.out.println("------------------------------");
		System.out.println("Prim's Algorithm: \n\n" + GraphTraverser.printPaths(prim));
		System.out.println("------------------------------");
	}
}