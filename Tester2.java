import java.util.*;
import java.io.*;

public class Tester2{
	public static void main(String[] args) throws IOException{
		System.out.println("Tester for path");
		AdjacencyList list = new AdjacencyList("resources/graph1.txt");
		Vertex a = list.getVertex("A");
		Vertex b = list.getVertex("B");
		Vertex c = list.getVertex("C");
		Vertex d = list.getVertex("D");

		Path one = new Path(a);
		System.out.println(one);
		System.out.println("Adding B");
		one.addVertex(b);
		System.out.println(one);
		System.out.println("Last Weight: " + one.getLastWeight());
		System.out.println(one.getLastVertex().getName() + " -> " + one.getLastVertex());

		Vertex e = new Vertex("E");
		one.getLastVertex().addFriend(e, 8);

		Path two = new Path(one, e);
		System.out.println(one + "\n" + two);
		Path twov2 = new Path(one);
		twov2.addVertex(e);
		System.out.println(twov2);
		System.out.println("twov2 last weight: " + twov2.getLastWeight());

	}
}