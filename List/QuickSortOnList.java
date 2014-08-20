public class QuickSortOnList{
	private ListNode partition(ListNode head, ListNode[] leftTail){
		if(head == null || head.next == null){
			leftTail[0] = head;
			return head;
		}

		ListNode runner = head;
		ListNode pivot = null;
		ListNode rightTail = null;
		while(runner.next.next != null){
			runner = runner.next;
		}

		leftTail[0] = runner;
		pivot = runner.next;
		rightTail = pivot;
		runner = head;

		while(runner != pivot){
			if(runner.next.val > pivot.val){
				ListNode temp = runner.next;
				runner = temp.next;
				temp.next = null;
				rightTail.next = temp;
				rightTail = temp;
			}
			else
				runner = runner.next;
		}

		if(head.val > pivot.val){
			ListNode temp = head;
			rightTail.next = temp;
			head = temp.next;
			temp.next = null;
		}

		return head;
	}

    private void printList(ListNode head){
    	while(head.next != null){
    		System.out.print(head.val + "->");
    		head = head.next;
    	}
    	System.out.println(head.val);
    }

    public static void main(String[] args){
    	QuickSortOnList solution = new QuickSortOnList();
    	ListNode head = new ListNode(5);
    	head.next = new ListNode(4);
    	head.next.next = new ListNode(6);
    	head.next.next.next = new ListNode(2);

    	solution.printList(head);
    	head = solution.partition(head, new ListNode[1]);
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