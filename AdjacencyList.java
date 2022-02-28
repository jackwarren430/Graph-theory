import java.util.*;
import java.io.*;

public class AdjacencyList {

	private ArrayList<Vertex> list;


	public AdjacencyList(String fileName) throws IOException{
		if (fileName.equals("blank")){
			list = new ArrayList<Vertex>();
		} else {
			list = new ArrayList<Vertex>();
			readMap(fileName);
		}
	}

	private void readMap(String fileName) throws IOException{
		Scanner scan = new Scanner(new File(fileName)); 	
		while (scan.hasNextLine()){
			String[] line = scan.nextLine().split(" ");

			String name1 = line[0];
			String name2 = line[1];
			int weight = Integer.parseInt(line[2]);
			if (getVertex(name1) == null){
				list.add(new Vertex(name1));
			}
			if (getVertex(name2) == null){
				list.add(new Vertex(name2));
			}
			ArrayList<Vertex> name1Friends = getVertex(name1).getFriends();
			if (!name1Friends.contains(getVertex(name2))){
				getVertex(name1).addFriend(getVertex(name2), weight);
			}
			ArrayList<Vertex> name2Friends = getVertex(name2).getFriends();
			if (!name2Friends.contains(getVertex(name1))){
				getVertex(name2).addFriend(getVertex(name1), weight);
			}
		}	
	}

	public void resetFlags(){
		for (Vertex x : list){
			x.setFlag(false);
		}
	}

	public Vertex getVertex(String name){
		for (Vertex x : list){
			if (x.getName().equals(name)){
				return x;
			}
		}
		return null;
	}

	public String toString(){
		String toReturn = "";
		for (Vertex x : list){
			toReturn += x.getName() + " -> " + x + "\n";
		}
		return toReturn;
	}

}

