public class CountBinaryStrings{
	public int count(int N){
		int[] fillZero = new int[N];	//numbers that i bit fill 0
		int[] fillOne = new int[N];		//numbers that i bit fill 1

		fillZero[0] = 1;
		fillOne[0] = 1;
		int result = 0;
		for(int i = 1; i < N;i++){
			fillZero[i] = fillZero[i-1] + fillOne[i-1];
			fillOne[i] = fillZero[i-1];
		}

		result = fillZero[N-1] + fillOne[N-1];
		return result;
	}

	public static void main(String[] args){
		CountBinaryStrings solution = new CountBinaryStrings();
		int N = 3;
		int result = solution.count(N);
		System.out.println(result);
	}

}