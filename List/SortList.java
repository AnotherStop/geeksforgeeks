import java.util.*;
public class SortList{
	
	//using quick sort strategy to sort list
	private ListNode qsort(ListNode head, ListNode tail){
		if(head == tail || head.next == tail)
			return head;

		ListNode leftHead = head;
		ListNode pivot = head;
		ListNode runner = head;

		while(runner != tail && runner.next != tail){
			if(runner.next.val > pivot.val)
				runner = runner.next;
			else{
				ListNode temp = runner.next;
				runner.next = temp.next;
				temp.next = leftHead;
				leftHead = temp;
			}
		}

		leftHead = qsort(leftHead, pivot);
		pivot.next = qsort(pivot.next, tail);

		return leftHead;
	}

	public static void main(String[] args){

		SortList solution = new SortList();

		ArrayList<ArrayList<Integer>> testSet = solution.generateTestSet(5);

		for(int i = 0;i < testSet.size();i++){
			ListNode head = solution.createTestCase(testSet.get(i));
			solution.printList(head);
			System.out.print("  sort:  ");
			head = solution.qsort(head, null);
			solution.printList(head);
			System.out.println();
		}
		
	}

	private ArrayList<ArrayList<Integer>> generateTestSet(int n){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		boolean[] used = new boolean[n];

		permutation(result, temp, used, n);
		return result;
	}

	private void permutation(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, boolean[] used, int n){
		if(temp.size() == n){
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		for(int i = 0;i < n;i++){
			if(used[i] == true)
				continue;
			temp.add(i);
			used[i] = true;
			permutation(result, temp, used, n);
			used[i] = false;
			temp.remove(temp.size()-1);
		}
	}

	private ListNode createTestCase(ArrayList<Integer> testCase){
		ListNode head = new ListNode(testCase.get(0));
		ListNode runner = head;
		for(int i = 1;i < testCase.size();i++){
			runner.next = new ListNode(testCase.get(i));
			runner = runner.next;
		}
		return head;
	}

	private void printList(ListNode head){
		while(head.next != null){
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.print(head.val);
	}
}

class ListNode{
	int val;
	ListNode next = null;
	public ListNode(int val){
		this.val = val;
	}
}