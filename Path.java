public class Path {
	
	private int totalWeight, lastWeight;
	private Vertex[] arr;


	public Path(Vertex v){
		arr = new Vertex[1];
		arr[0] = v;
		totalWeight = 0;
		lastWeight = 0;
	}

	public Path(Path p){
		arr = deepCopy(p.getList());
		this.totalWeight = p.getTotalWeight();
		this.lastWeight = p.getLastWeight();
	}

	public Path(Path p, Vertex v){
		arr = deepCopy(p.getList());
		this.totalWeight = p.getTotalWeight();
		this.lastWeight = p.getLastWeight();
		addVertex(v);
	}

	public void addVertex(Vertex v){
		if (!arr[arr.length-1].getFriends().contains(v)){
			return;
		}
		totalWeight += arr[arr.length-1].getWeight(v);
		lastWeight = arr[arr.length-1].getWeight(v);
		Vertex[] newArr = new Vertex[arr.length + 1];
		for (int i = 0; i < arr.length; i++){
			newArr[i] = arr[i];
		}
		newArr[newArr.length-1] = v;
		arr = deepCopy(newArr);
		//do I need to deepcopy again?
		//or can I just say arr = newArr
	}

	public int getNumVertices(){
		return arr.length;
	}

	public Vertex getLastVertex(){
		return arr[arr.length-1];
	}

	public Vertex getVertex(int index){
		return arr[index];
	}

	public int getLastWeight(){
		return lastWeight;
	}

	public int getTotalWeight(){
		return totalWeight;
	}

	public Vertex[] getList(){
		return arr;
	}

	private Vertex[] deepCopy(Vertex[] pList){
		Vertex[] list = new Vertex[pList.length];
		for (int i = 0; i < pList.length; i++){
			list[i] = pList[i];
		}
		return list;
	}

	public String toString(){
		String toReturn = "";
		for (Vertex x : arr){
			toReturn += x.getName() + " -> ";
		}
		toReturn += "Distance: " + getTotalWeight();
		return toReturn;
	}

}