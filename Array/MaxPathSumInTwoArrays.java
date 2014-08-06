/*
Given two sorted arrays such the arrays may have some common elements. Find the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays. We can switch from one array to another array only at common elements.

Input:  ar1[] = {2, 3, 7, 10, 12, 15, 30, 34}
        ar2[] = {1, 5, 7, 8, 10, 15, 16, 19}
Output: 122
122 is sum of 1, 5, 7, 8, 10, 12, 15, 30, 34

Expected time complexity is O(m+n) where m is the number of elements in ar1[] and n is the number of elements in ar2[].
*/
public class MaxPathSumInTwoArrays{
	public int maxPathSum (int[] A, int[] B){
		int result = 0;
		int sumA = 0, sumB = 0;

		int i = 0, j =0;

		while(i < A.length && j < B.length){
			if(A[i] != B[j]){
				if(A[i] < B[j]){
					sumA += A[i];
					i++;
				}
				else{
					sumB += B[j];
					j++;
				}

			}else{
				sumA += A[i];
				sumB += B[j];
				result += Math.max(sumA, sumB);
				sumA = 0;
				sumB = 0;
				i++;
				j++;
			}
		}

		while(i < A.length){
			sumA += A[i];
			i++;
		}

		while(j < B.length){
			sumB += B[j];
			j++;
		}

		result += Math.max(sumA, sumB);
		return result;

	}

	public static void main(String[] args){
		MaxPathSumInTwoArrays solution = new MaxPathSumInTwoArrays();
		int[] A = {2, 3, 7, 10, 12, 15, 30, 34};
		int[] B = {1, 5, 7, 8, 10, 15, 16, 19};

		int result = solution.maxPathSum(A, B);
		System.out.println(result);
	}


}