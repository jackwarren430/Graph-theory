import java.util.*;

public class MyStack<E> implements DataStructure<E> {

	private Stack<E> list;

	public MyStack(){
		list = new Stack<E>();
	}

	public void add(E item){
		list.push(item);
	}

	public E remove(){
		if (!isEmpty()){
			E last = list.peek();
			list.pop();
			return last;
		}
		return null;
	}

	public boolean isEmpty(){
		return list.empty();
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