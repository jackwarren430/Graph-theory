import java.util.*;
import java.io.*;

public class Runner {
	public static void main(String[] args) throws IOException{
		System.out.print("Initiating Graph Theory Runner");
		try {
			//importang initialization business
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.print(".");
			Thread.sleep(500);
			System.out.println("done!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		boolean loopCond = true;
		int step = 0;
		AdjacencyList list = new AdjacencyList("blank");
		Scanner scan = new Scanner(System.in);
		String file = "";

		while (loopCond){
			if (step == 0){
				System.out.println("----------------------------------");
				System.out.println("Type in a graph file to process: ");
				file = scan.nextLine();
				try{
					list = new AdjacencyList(file);
					System.out.println("----------------------------------");
					System.out.println("Adjacency List for " + file + ":\n");
					System.out.println(list);
					step++;
				} catch (IOException e){
					e.printStackTrace();
					System.out.println("Failed to load file: " + file);
				}
			} else if (step == 1){
				System.out.println("----------------------------------");
				System.out.println("What kind Algorithm would you like to run?\n(BFS, DFS, Dijkstra's, Prim's)");
				String algorithm = scan.nextLine();
				System.out.println("Choose a starting Vertex: ");
				String startVertex = scan.nextLine();
				System.out.println("Print as Path List or Edge List?\n(Egde, Path)");
				String listType = scan.nextLine();
				if (!(listType.equals("Edge") || listType.equals("Path"))){
					System.out.println(listType + " is not a valid List Type");
				} else if (!(algorithm.equals("BFS") || algorithm.equals("Prim's")|| algorithm.equals("DFS") || algorithm.equals("Dijkstra's"))){
					System.out.println(algorithm + " is not a valid Algorithm");
				} else if (list.getVertex(startVertex) == null){
					System.out.println(startVertex + " is not a valid starting Vertex");
				} else {
					DataStructure<Path> ds;
					if (algorithm.equals("BFS")){
						ds = new MyQueue<Path>();
					} else if (algorithm.equals("DFS")){
						ds = new MyStack<Path>();
					} else if (algorithm.equals("Dijkstra's")){
						ds = new MyPQ<Path>(new DijkstraComparator<Path>());
					} else if (algorithm.equals("Prim's")){
						ds = new MyPQ<Path>(new PrimComparator<Path>());
					} else {
						ds = new MyPQ<Path>(new PrimComparator<Path>());
					}
					ArrayList<Path> arr = GraphTraverser.traverse(ds, list, startVertex);
					System.out.println("----------------------------------");
					System.out.println("Graph: " + file + "\nAlgorithm: " + algorithm + "\nList Type: " + listType);
					if (listType.equals("Path")){
						System.out.println(GraphTraverser.printPaths(arr));
					} else {
						EdgeList l = GraphTraverser.getEdgeList(arr, startVertex);
						System.out.println(l);
					}
					System.out.println("----------------------------------");
					System.out.println("Type 1 if you want to process another graph, 2 if you want to use a different algorithm, or 3 to quit: ");
					String stepper = scan.nextLine();
					while (!(stepper.equals("1") || stepper.equals("2") || stepper.equals("3"))){
						System.out.println(stepper + " is not 1, 2, or 3 silly");
						System.out.println("Type 1 if you want to process another graph, 2 if you want to process the same graph, or 3 to quit: ");
						stepper = scan.nextLine();
					}
					step = Integer.parseInt(stepper) - 1;
				}
			} else if (step == 2){
				loopCond = false;
			}


		}


	}
}









