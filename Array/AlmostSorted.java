/*
Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions. 
Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
Write an efficient function to search an element in this array. 
*/
public class AlmostSorted{
	public int searchIndex(int[] data, int left, int right, int target){

		//take care here, it's < or <=
		while(left <= right){
			int mid = left + (right - left)/2;

			if(data[mid] == target)
				return mid;
			else if(mid < right && data[mid+1] == target)
				return mid+1;
			else if(mid > left && data[mid-1] == target)
				return mid-1;

			if(data[mid] < target)
				return searchIndex(data, mid+2, right, target);
			else if(data[mid] > target)
				return searchIndex(data, mid-2 , left, target);

		}

		return -1;

	}

	public static void main(String[] args){
		AlmostSorted s = new AlmostSorted();

		int[] data = {3, 2, 10, 4, 40};

		//test cases that each element is as target
		for(int target : data){
			int result = s.searchIndex(data, 0, data.length-1, target);

			System.out.println("result is: " + result);
		}
	}

}