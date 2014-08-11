/*
Given a linked list, reverse alternate nodes and append them to end of list. 
Extra allowed space is O(1) 
Input List:  1->2->3->4->5->6
Output List: 1->3->5->6->4->2
*/
public class ReverseAlternateNodesAndAppend{
	public void reverseAlternate(ListNode head){
		if(head == null || head.next == null || head.next.next == null)
			return;

		ListNode evenHead = null;
		ListNode runner = head;

		while(runner.next != null && runner.next.next != null){
			ListNode next = runner.next.next;

			runner.next.next = evenHead;
			evenHead = runner.next;

			runner.next = next;
			runner = runner.next;
		}

		if(runner.next == null)
			runner.next = evenHead;
		else
			runner.next.next = evenHead;
	}

	public void printList(ListNode head){
		while(head.next != null){
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println(head.val);
	}

	public static void main(String[] args){
		ReverseAlternateNodesAndAppend solution = new ReverseAlternateNodesAndAppend();
/*		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
*/
		ListNode head = new ListNode(12);
		head.next = new ListNode(14);
		head.next.next = new ListNode(16);
		head.next.next.next = new ListNode(18);
		head.next.next.next.next = new ListNode(20);

		solution.printList(head);
		solution.reverseAlternate(head);
		solution.printList(head);
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}