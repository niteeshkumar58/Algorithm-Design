import java.util.Scanner;
public class QueensProblem{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value of n : ");
		int n = sc.nextInt();		
		int[][] a = new int[n][n]; 
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++)
				a[i][j] = 0;
		}
		QueensProblem qp = new QueensProblem();
		qp.solveQueen(a, n);
	}

	boolean checkQueen(int[][] a, int col, int n){
		if(col>=n)
			return true;
		for(int i=0; i<n; i++){
			if(isSafe(a, i, col, n)){
				a[i][col] = 1;
				if(checkQueen(a, col+1, n))
					return true;
				a[i][col] = 0;		
			}	
		}
		return false;
	}

	boolean solveQueen(int[][] a, int n){
		if(!checkQueen(a, 0, n)){
			System.out.println("Solution Not Possible !!!");
			return false;
		}
		printSol(a, n);
		return  true;
	}

	void printSol(int[][] a, int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++)
				System.out.print(a[i][j]+"\t");
			System.out.println();
		}
	}
/*
	boolean safeRow(int[][] a, int row, int n){
		for(int i=0; i<row; i++){
			if(a[row][i]==1)
				return false;
			}
		return true;
	}	

	boolean safeCol(int[][] a, int col, int n){
		for(int i=0; i<col; i++){
			if(a[row][i]==1)
				return false;
			}
		return true;
	}	
	
	boolean safeDiagonal(int[][] a, int row, int col, int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				if(Math.abs(i-j)==Math.abs(row-col) || i+j==row+col){
					if(a[i][j] == 1)
						return false;
				}		
			}
		}
		return true;
	}	

	boolean isSafe(int[][] a, int row, int col, int n){
		if(safeCol(a, col, n) && safeDiagonal(a, row, col, n))
			return true;
		return false;		
	}
*/
	
	 boolean isSafe(int[][] a, int row, int col, int n){
        int i, j;
        for (i = 0; i < col; i++)
            if (a[row][i] == 1)
                return false;
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (a[i][j] == 1)
                return false;
        for (i=row, j=col; j>=0 && i<n; i++, j--)
            if (a[i][j] == 1)
                return false;
        return true;
    } 
}
