import java.util.*;

public class MyPQ<E> implements DataStructure<E> {

	private PriorityQueue<E> list;

	public MyPQ(Comparator<E> comp){
		list = new PriorityQueue<E>(10, comp);
	}

	public void add(E item){
		list.add(item);
	}

	public E remove(){
		return list.poll();
	}

	public boolean isEmpty(){
		return list.peek() == null ? true : false;
	}

	public String toString(){
		String toReturn = "";
		if (!isEmpty()){
			for (E obj : list){
				toReturn += obj + ";\n";
			}
		} else {
			toReturn += "~empty~";
		}
		return toReturn;
	}

	public E peek(){
		return list.peek();
	}
	
}