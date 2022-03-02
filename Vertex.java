import java.io.*;
import java.util.*;

public class Vertex {
	private String name;
	private Boolean flag;
	private HashMap<Vertex, Integer> friends;

	public Vertex(String name){
		this.name = name;
		flag = false;
		friends = new HashMap<Vertex, Integer>();
	}

	public void addFriend(Vertex friend, int weight){
		if (friend != this && !friends.containsKey(friend) && !name.equals(friend.getName())){
			friends.put(friend, weight);
		}
	}

	public ArrayList<Vertex> getFriends(){
		ArrayList<Vertex> toReturn = new ArrayList<Vertex>();
		for (Vertex x : friends.keySet()){
			toReturn.add(x);
		}
		return toReturn;
	}

	public String toString(){
		String toReturn = getName();
		for (Vertex x : friends.keySet()){
			toReturn += "<" + x.getName() + "," + this.getWeight(x) + "> ";
		}
		return toReturn;
	}

	public int getWeight(Vertex v){
		return friends.containsKey(v) ? friends.get(v) : -1;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Boolean getFlag(){
		return flag;
	}

	public void setFlag(Boolean b){
		this.flag = b;
	}

	// ended up not being useful
	public boolean compareTo(Vertex v){
		if (this.name == v.getName() && this.flag == v.getFlag()){
			return false;
		}
		return true;
	}

}