import java.util.*;
import java.io.*;

public class Tester{
	public static void main(String[] TESTERAAGGGHHHH) throws IOException{
		System.out.println("-------------------------------------------");
		System.out.println("\n\nTHIS IS THE ULTIMATE TESTER YEAH BABYYYY. prepare yourself!!\n\n");
		System.out.println("-------------------------------------------");
		Vertex joshua = new Vertex("buttcheecks");
		String name = joshua.getName();
		boolean flag = joshua.getFlag();
		String toString = joshua.toString();
		System.out.println("-------------------------------------------");
		System.out.println(" -- INITIALIZATION -- \n\n - name: " + name + "\n - flag: " + flag + "\n - Adj Vertex list: " + joshua);
		System.out.println("-------------------------------------------");
		System.out.println("\n\nADDING NEW NEIGHBORS OH YEAHHHH\n");
		System.out.println("Adding vertex b with weight 3");
		Vertex b = new Vertex("b");
		joshua.addFriend(b, 5);
		System.out.println("Adding vertex c with weight 7");
		Vertex c = new Vertex("c");
		joshua.addFriend(c, 7);
		System.out.println("Adding vertex d with weight 12");
		Vertex d = new Vertex("d");
		joshua.addFriend(d, 12);
		System.out.println("\nPrinting Adj list, should be <b,5> <c,7> <d,12>\nis: " + joshua);
		System.out.println("-------------------------------------------");
		System.out.println("\n\nNow changing vars, such as name and flag");
		joshua.setName("a");
		joshua.setFlag(true);
		System.out.println("Changed name to a and set flag to true\nName: " + joshua.getName() + "\nFlag: " + joshua.getFlag());
		System.out.println("\nChanging vertex b name to barbara and flag to true");
		b.setName("barbara");
		b.setFlag(true);
		System.out.println("Name is now: " + b.getName());
		System.out.println("Flag is now: " + b.getFlag());
		System.out.println("-------------------------------------------");
		System.out.println("\nAdding vertex to itself, and adding already added vertex");
		joshua.addFriend(joshua, 11);
		joshua.addFriend(b, 13);
		b.addFriend(b, 14);
		b.addFriend(joshua, 15);
		System.out.println("Printing adj list for a and b");
		System.out.println("a: " + joshua + "\nb: " + b);
		System.out.println("-------------------------------------------");
		System.out.println("\n\nMOVING ONTO ADJACENCYLIST OH YEEEAAH\nTesting Graph1, Graph2, and Graph3\n");
		System.out.println("-------------------------------------------");
		AdjacencyList adj = new AdjacencyList("graph1.txt");
		System.out.println("ToString of graph1: \n" + adj);
		adj = new AdjacencyList("graph2.txt");
		adj.getVertex("A").setFlag(true);
		adj.getVertex("N").setFlag(true);
		adj.getVertex("D").setFlag(true);
		adj.getVertex("P").setFlag(true);
		adj.resetFlags();
		System.out.println("ToString of graph2: \n" + adj);
		adj = new AdjacencyList("graph3.txt");
		System.out.println("ToString of graph3: \n" + adj);



	}
}