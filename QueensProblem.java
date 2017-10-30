import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NQueensBacktracking {
	static int Q;
	static int[][] board;
	static boolean isAttacked(int N, int row, int col){  //int[][] board, 
		for(int i=0; i<Q; i++){
			if(board[row][i]==1)	// checking row
				return true;
		}
		for(int i=0; i<Q; i++){
			if(board[i][col]==1)	// checking column
				return true;
		}
		for(int i=0; i<Q; i++){
			for(int j=0; j<Q; j++){
				if((i+j==row+col || (i-j)==(row-col)) && board[i][j]==1 )
					//if(board[i][j]==1)
						return true;
			}
		}
		return false;
	}
	static boolean NQueen(int N){   //int[][] board, 
		if(N==0)return true;
		for(int i=0; i<Q; i++){
			for(int j=0; j<Q; j++){
				if(!isAttacked(N, i, j)){	
					board[i][j] = 1;
					if(NQueen(N-1))	//solving subproblem
						return true;
					board[i][j] = 0;
				}
			}
		}
		return false;
	}
	static void PrintBoard(int N){		
		if(NQueen(N)){
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					System.out.print(board[i][j]+"   ");
				}
				System.out.println();
			}
		}else
			System.out.println("Solution Not Possible !");
		
	}
	public static void main(String[] args) throws Exception{
		System.out.print("Enter no. of queens: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Q = Integer.parseInt(br.readLine());
		int N = Q;
		board = new int[N][N];
		PrintBoard(N);
	}
}
