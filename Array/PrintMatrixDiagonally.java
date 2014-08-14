public class PrintMatrixDiagonally{
	public static void main(String[] args){
		int row = 5, col = 4;
		int[][] data = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16},
                       {17, 18, 19, 20},
                      };;

		int counter = 1;
		for(int i = 0;i < row;i++){
			for(int j = 0;j < col;j++){
				data[i][j] = counter++;
			}
		}

		printMatrixDiagonally(data);
	}

	private static void printMatrixDiagonally(int[][] data){
		int row = data.length;
		int col = data[0].length;

		int total = row + col -1;

		for(int i = 0;i < total;i++){

			for(int k = 0;k<col;k++){
				for(int j = 0;j<row;j++){
					if(j+k == i)
						System.out.print(data[j][k] + " ");
				}
			}
			System.out.println();
		}
	}
}