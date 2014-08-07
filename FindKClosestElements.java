/* 
Given a sorted array arr[] and a value X, find the k closest elements to X in
arr[].  Examples: Input: K = 4, X = 35        arr[] = {12, 16, 22, 30, 35, 39,
42, 45, 48, 50, 53, 55, 56} Output: 30 39 42 45

Note that if the element is present in array, then it should not be in output, 
only the other closest elements are required. 
*/
import java.util.*;
public class FindKClosestElements{
	public int findCrossPointIndex(int[] data, int pivot){
		int lo = 0;
		int hi = data.length-1;

		while(lo < hi){

			if(data[lo] >= pivot)
				return lo;
			if(data[hi] <= pivot)
				return hi;

			int mid = lo + (hi - lo)/2;

			//if pivot is not in data[], always return its lower closest index
			//without this statement, it may return lower or high closest index
			//then, can't handle in caller function
			if(data[mid] <= pivot && data[mid+1] >= pivot)
				return mid;

			if(data[mid] < pivot)
				lo = mid + 1;
			else
				hi = mid - 1; 
		}

		return lo;
	}

	public int[] find(int[] data, int K, int pivot){
		int index = findCrossPointIndex(data, pivot);	//index for cross point
		int j = index+1;	//loop variable in higher part

		if(data[index] == pivot)
			index -= 1;

		int i = index;		//loop variable in lower part
		int[] result = new int[K];
		int m = 0;	//index in result array
		while(i >= 0 && j < data.length && K > 0){
			if(pivot - data[i] > data[j] - pivot){
				result[m] = data[j];
				j++;
			}
			else{
				result[m] = data[i];
				i--;
			}
			m++;
			K--;
		}

		//higher part reaches end but K still > 0
		while(i >= 0 && K > 0){
			result[m] = data[i];
			i--;
			K--;
			m++;
		}

		//lower part reaches end but K still > 0
		while(j < data.length && K > 0){
			result[m] = data[j];
			j++;
			K--;
			m++;
		}

		Arrays.sort(result);
		return result;

	}

	public static void main(String[] args){
		FindKClosestElements solution = new FindKClosestElements();
		int K = 4, pivot = 35;
		int[] data = {12, 16, 22, 30, 35, 39, 42, 
               45, 48, 50, 53, 55, 56};

        if(K > data.length){
        	System.out.println("Invalid K, exceed the size of input array.");
        	return;
        }
        int[] result = solution.find(data,K,pivot);
        for(int i : result)
        	System.out.print(i + " ");

       	System.out.println();
	}
}