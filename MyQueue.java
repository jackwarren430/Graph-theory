import java.util.*;

public class MyQueue<E> implements DataStructure<E> {

	private ArrayDeque<E> list = new ArrayDeque<E>();

	public void add(E item){
		list.add(item);
	}

	public E remove(){
		E obj = list.pollFirst();
		return obj;
	}

	public boolean isEmpty(){
		return list.isEmpty();
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
	
}