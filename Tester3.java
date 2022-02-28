import java.io.*;

public class Tester3 {
	public static void main(String[] args) throws IOException{
		
		
		System.out.println("\nTester for Data structures:\n");
		AdjacencyList list = new AdjacencyList("resources/graph1.txt");
		Vertex a = list.getVertex("A");
		Vertex b = list.getVertex("B");
		Vertex c = list.getVertex("C");
		Vertex d = list.getVertex("D");
		Path one = new Path(a);
		one.addVertex(c);
		Vertex e = new Vertex("E");
		one.getLastVertex().addFriend(e, 8);

		Path two = new Path(one, e);
		Path three = new Path(a);
		three.addVertex(b);

		System.out.println("---------------\nStack test:");
		MyStack<Path> stack = new MyStack<Path>();
		stack.add(one);
		stack.add(two);
		stack.add(three);
		System.out.println(stack);
		stack.remove();
		System.out.println(stack);
		stack.remove();
		stack.remove();
		System.out.println(stack);

		System.out.println("---------------\nQueue test:");
		MyQueue<Path> queue = new MyQueue<Path>();
		queue.add(one);
		queue.add(two);
		queue.add(three);
		System.out.println(queue);
		queue.remove();
		System.out.println(queue);
		queue.remove();
		queue.remove();
		System.out.println(queue);

		DijkstraComparator<Path> dijkstra = new DijkstraComparator<Path>();

		System.out.println("---------------\nDijkstra test:");
		MyPQ<Path> pq = new MyPQ<Path>(dijkstra);
		pq.add(one);
		pq.add(two);
		pq.add(three);
		System.out.println(pq);
		pq.remove();
		System.out.println(pq);
		pq.remove();
		System.out.println(pq);
		System.out.println("Last Weight: " + pq.peek().getLastWeight());
		pq.remove();
		System.out.println(pq);
		

		PrimComparator<Path> prim = new PrimComparator<Path>();

		System.out.println("---------------\nPrim test:");
		pq = new MyPQ<Path>(prim);
		pq.add(one);
		pq.add(two);
		pq.add(three);
		System.out.println(pq);
		pq.remove();
		System.out.println(pq);
		pq.remove();
		System.out.println(pq);
		System.out.println("Last Weight: " + pq.peek().getLastWeight());
		pq.remove();
		System.out.println(pq);
		

	}
}









