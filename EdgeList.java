import java.util.*;

public class EdgeList {
	ArrayList<Edge> list;

	public EdgeList(){
		list = new ArrayList<Edge>();
	}

	public void addEdge(Edge e){
		list.add(e);
	}

	public void removeEdge(Edge e){
		list.remove(e);
	}

	public String toString(){
		String toReturn = "";
		for (Edge e : list){
			toReturn += e + ", ";
		}
		return toReturn;
	}


} class Edge {
	private Vertex left, right;
	private int weight;

	public Edge(Vertex left, Vertex right, int weight){
		this.left = left;
		this.right = right;
		this.weight = weight;
	}

	public Vertex getLeft(){
		return left;
	}

	public Vertex getRight(){
		return right;
	}

	public void setLeft(Vertex v){
		left = v;
	}

	public void setRight(Vertex v){
		right = v;
	}

	public int getWeight(){
		return weight;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}

	public String toString(){
		return left.getName() + " <-> " + right.getName() + ": " + weight;
	}


}