import java.util.*;

public class DijkstraComparator<E> implements Comparator<Path> {
	

	public int compare(Path p1, Path p2){
		int weight1 = p1.getTotalWeight();
		int weight2 = p2.getTotalWeight();
		if (weight1 == weight2){
			return 0;
		} else {
			return weight1 > weight2 ? 1 : -1;
		}
	}


}