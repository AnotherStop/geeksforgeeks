public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
            
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        
        newHead = reverse(newHead);
        merge(head,newHead);
    }
    
    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        ListNode runner = head;
        
        while(runner != null){
            ListNode next = runner.next;
            
            runner.next = newHead;
            newHead = runner;
            runner = next;
        }
        
        return newHead;
    }
    
    private void merge(ListNode l1, ListNode l2){
        ListNode runner = l1;
        
        while(l1 != null && l2 != null){
            l1 = l1.next;
            runner.next = l2;
            l2 = l2.next;

            runner = runner.next;
            runner.next = l1;
            runner = runner.next;
        }
/*        
        if(l1 != null)
            runner.next = l1;
        if(l2 != null)
            runner.next = l2;
*/
    }

    public void printList(ListNode head){
        while(head.next != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ReorderList solution = new ReorderList();
        solution.printList(head);
        solution.reorderList(head);
        solution.printList(head);
    }
}