import java.util.*;
public class SelectKthLargest2nd{
	//get Kth largest element in data[]
	private int getKthLargest(int data[], int K){
		int len = data.length;

		if(len == 1)
			return data[0];

		//get pivot to partition array
		int pivot = getPivot(data);

		//to handle repeated elements, using set
		HashSet<Integer> smaller = new HashSet<Integer>();	//smaller than pivot
		HashSet<Integer> larger = new HashSet<Integer>();	//larger than pivot

		//allocate elements to each set
		for(int i =0; i<len;i++){
			if(data[i] < pivot)
				smaller.add(data[i]);
			else if(data[i] > pivot)
				larger.add(data[i]);
		}

		//recursive call on one side
		if(smaller.size() == K-1)
			return pivot;
		else if(smaller.size() >= K){
			int[] small = new int[smaller.size()];
			
			Iterator it = smaller.iterator();
			int i = 0;
			while(it.hasNext()){
				small[i++] = (int)it.next();
			} 

			return getKthLargest(small, K);
		}else{
			int[] large = new int[larger.size()];

			Iterator it = larger.iterator();
			int i = 0;
			while(it.hasNext()){
				large[i++] = (int)it.next();
			}

			return getKthLargest(large, K-smaller.size()-1);
		}
	}

	private int getPivot(int[] data){
		if(data.length == 1)
			return data[0];

		//each group has 5 elements
		int numOfGroup = data.length / 5;
		if(data.length % 5 != 0)
			numOfGroup += 1;

		int[] setOfMedians = new int[numOfGroup];	//median of each group
		for(int i = 0;i < numOfGroup;i++){
			int[] group = null;

			if(data.length % 5 != 0 && i == numOfGroup - 1)
				group = new int[data.length%5];
			else
				group = new int[5];

			for(int j = 0;j<group.length;j++){
				group[j] = data[i*5 + j];
			}

			setOfMedians[i] = getMedian(group);
		}

		return getKthLargest(setOfMedians, setOfMedians.length/2);

	}

	private int getMedian(int[] data){

		for(int i = 0;i<data.length;i++){
			int countSmaller = 0;

			for(int j = 0;j < data.length;j++){
				if(data[j] < data[i])
					countSmaller++;
			}

			if(countSmaller == (data.length-1)/2)
				return data[i];
		}

		return -1;
	}

	public static void main(String[] args){
		SelectKthLargest2nd solution = new SelectKthLargest2nd();

		int[] data = {1,3,2,4,5,9,7,8,6};

		int result = solution.getKthLargest(data, 7);
		System.out.println(result);

	}


}