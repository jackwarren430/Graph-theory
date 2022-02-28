import java.util.*;

public class GraphTraverser {

	public static ArrayList<Path> traverse(DataStructure<Path> ds, AdjacencyList graph, String startName){
		ArrayList<Path> arr = new ArrayList<Path>();

		Vertex start = graph.getVertex(startName);
		Path startVertex = new Path(start);
		ds.add(startVertex);
		while (!ds.isEmpty()){
			Path p = ds.remove();
			Vertex lastVertex = p.getLastVertex();
			if (!lastVertex.getFlag()){
				lastVertex.setFlag(true);
				arr.add(p);
				for (Vertex v : lastVertex.getFriends()){
					if (!v.getFlag()){
						p = new Path(p, v);
						ds.add(p);
					}
				}
			}
		}
		graph.resetFlags();
		return arr;
	}

	public static EdgeList getEdgeList(ArrayList<Path> arr, String startVertex){
		EdgeList toReturn = new EdgeList();
		for (Path p : arr){
			if (p.getLastVertex().getName() != startVertex){
				Vertex[] pArr = p.getList();
				Edge toAdd = new Edge(pArr[pArr.length-2], p.getLastVertex(), p.getLastWeight());
				toReturn.addEdge(toAdd);
			}
		}
		return toReturn;
	}

	public static String printPaths(ArrayList<Path> arr){
		String toReturn = "";
		for (Path p : arr){
			toReturn += p + "\n";
		}
		return toReturn;
	}


}