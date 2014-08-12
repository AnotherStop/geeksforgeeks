import java.util.*;
public class SelectKthLargest{
	private int getKthLargest(int[] data, int K){
		if(data.length == 1)
			return data[0];
		int pivot = getPivot(data);

		HashSet<Integer> smaller = new HashSet<Integer>();
		HashSet<Integer> larger = new HashSet<Integer>();

		for(int i = 0;i < data.length;i++){
			if(data[i] < pivot)
				smaller.add(data[i]);
			else if(data[i] > pivot)
				larger.add(data[i]);
		}

		Iterator it = null;
		if(smaller.size() >= K){
			it = smaller.iterator();
			int[] small = new int[smaller.size()];
			int i = 0;
			while(it.hasNext())
				small[i++] = (int)it.next();

			return getKthLargest(small, K);

		}else if(smaller.size() == K-1){
			return pivot;
		}else{
			it = larger.iterator();
			int[] large = new int[larger.size()];
			int i = 0;
			while(it.hasNext())
				large[i++] = (int)it.next();

			return getKthLargest(large, K-smaller.size()-1);
		}
	}

	private int getPivot(int[] data){
		if(data.length == 1)
			return data[0];

		int numOfGroup = data.length / 5;
		if(data.length % 5 != 0)
			numOfGroup += 1;

		int[] setOfMedians = new int[numOfGroup];

		for(int i = 0;i<numOfGroup;i++){
			int[] group;
			if(data.length % 5 != 0 && i == numOfGroup-1)
				group = new int[data.length % 5];
			else
				group = new int[5];

			for(int j = 0;j < group.length;j++)
				group[j] = data[i*5 + j];

			setOfMedians[i] = getMedian(group);	
		}

		return getKthLargest(setOfMedians, setOfMedians.length/2);
	}

	private int getMedian(int[] data){

		int countSmaller = 0;

		for(int i = 0;i<data.length;i++){
			for(int j = 0;j<data.length;j++){
				if(data[j] < data[i])
					countSmaller++;
			}
			if(countSmaller == (data.length - 1)/2)
				return data[i];
			countSmaller = 0;
		}

		return -1;
	}

	public static void main(String[] args){
		SelectKthLargest solution = new SelectKthLargest();

		int[] data = {1,3,2,4,5,9,7,8,6};

		int result = solution.getKthLargest(data, 7);
		System.out.println(result);

	}
}