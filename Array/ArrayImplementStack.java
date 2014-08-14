public class ArrayImplementStack{
	public static void main(String[] args){
		AnotherStack st = new AnotherStack();
		st.push(1);
		st.push(3);
		st.push(5);

		System.out.println("the size of array is: " + st.size());
		st.printStack();
		st.push(99);
		System.out.println("the size of array is: " + st.size());
		st.push(4);
		System.out.println("the size of array is: " + st.size());
		st.pop();
		System.out.println("the size of array is: " + st.size());
	}
}

class AnotherStack{
	private int size = 0;
	private int capacity = 5;
	private int[] arr = null;

	public void printStack(){
		for(int i = size-1;i >=0;i--)
			System.out.println(arr[i]);
	}

	public AnotherStack(){
		arr = new int[capacity];
	}

	public AnotherStack(int capacity){
		this.capacity = capacity;
		arr = new int[this.capacity];
	}

	public void push(int val){
		size += 1;
		if(size >= capacity / 2){
			capacity *= 2;
			int[] larger = new int[capacity];
			for(int i = 0;i < arr.length;i++)
				larger[i] = arr[i];

			arr = larger;
		}
		arr[size-1] = val;
	}

	public int pop(){
		int val = arr[size-1];
		size -= 1;

		if(size < capacity /2 && size > 5){
			capacity /= 2;
			int[] smaller = new int[capacity];
			for(int i = 0;i < size;i++)
				smaller[i] = arr[i];

			arr = smaller;
		}

		return val;
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}

	public int peek(){
		return arr[size-1];
	}
}