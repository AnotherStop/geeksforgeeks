/*
Find next greater number with same set of digits
same with LeetCode: Next permutation

Here is the solution for leetcode, no driver method
*/
public class Solution {
    public void nextPermutation(int[] num) {
        int k = num.length-1;
        
        if(k <= 0)
            return;
        
        while(k>0){
            if(num[k] > num[k-1])
                break;
            k--;
        }
                
        if(k == 0)
            reverse(num, 0, num.length-1);
        else{
            int index = num.length-1;
            while(num[index] <= num[k-1])
                index--;
                
            int temp = num[index];
            num[index] = num[k-1];
            num[k-1] = temp;
            
            reverse(num, k, num.length-1);
        }
    }
    
    private void reverse(int[] num, int i, int j){
            
        while(i < j){
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            i++;
            j--;
        }
    }
}