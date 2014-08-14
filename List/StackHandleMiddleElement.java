/*
How to implement a stack which will support following operations in O(1) time complexity?
1) push() which adds an element to the top of stack.
2) pop() which removes an element from top of stack.
3) findMiddle() which will return middle element of the stack.
4) deleteMiddle() which will delete the middle element.
Push and pop are standard stack operations.
*/
public class StackHandleMiddleElement{
	public static void main(String[] args){
		StackPlus sp = new StackPlus();

		sp.push(10);
		sp.push(9);
		sp.push(8);
		sp.push(7);
		sp.push(6);
		sp.push(5);
		sp.push(4);
		sp.push(3);
		sp.push(2);
		sp.push(1);
		System.out.println("after push the size is: " + sp.size());
		System.out.println("after push the mid is: " + sp.getMiddle());
		sp.deleteMiddle();
		System.out.println("after del the size is: " + sp.size());
		System.out.println("after del the mid is: " + sp.getMiddle());
		sp.push(99);
		System.out.println("after push the mid is: " + sp.getMiddle());
	}
}

class StackPlus{
	DoublyListNode top = null;
	DoublyListNode mid = null;
	int total = 0;

	public void push(int val){
		DoublyListNode newNode = new DoublyListNode(val);
		if(top != null){
			newNode.next = top;
			top.prev = newNode;
		}
		top = newNode;
		total += 1;

		if(total == 1)
			mid = top;
		else if(total % 2 == 0)
			mid = mid.prev;
	}

	public int pop(){
		int value = top.val;
		top.next.prev = null;
		top = top.next;
		total -= 1;

		if(total == 0)
			mid = null;
		else if(total % 2 == 1)
			mid = mid.next;

		return value;
	}

	public int getMiddle(){
		return mid.val;
	}

	public void deleteMiddle(){
		DoublyListNode toBeDel = mid;
		total -= 1;
		if(total % 2 == 0)
			mid = mid.prev;
		else
			mid = mid.next;

		toBeDel.prev.next = toBeDel.next;
		toBeDel.next.prev = toBeDel.prev;
	}

	public int size(){
		return total;
	}
}

class DoublyListNode{
	int val;
	DoublyListNode prev = null;
	DoublyListNode next = null;

	public DoublyListNode(int val){
		this.val = val;
	}
}