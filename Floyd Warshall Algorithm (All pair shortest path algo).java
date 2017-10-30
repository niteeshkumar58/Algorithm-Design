import java.util.*;
public class FloyedWarshalAlgo {
	public static void main(String[] args){
		int I = Integer.MAX_VALUE;
		Scanner sc = new Scanner(System.in);
		int n = 0;
		
		System.out.print("Enter no. of vertices: ");
		n = sc.nextInt();
		int[][] mat = new int[n][n];//= {{0,4,11},{6,0,2},{3,I,0}};
		System.out.println("Enter distance matrix (use -1 for infinite distance): ");
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				mat[i][j] = sc.nextInt();
				if(mat[i][j]==-1) mat[i][j] = I;
			}
		}
		FloyedWarshalAlgo fwa = new FloyedWarshalAlgo();
		fwa.algo(mat, n);
		fwa.print(mat, n);
	}
	
	void algo(int[][] mat, int n){
		for(int k=0; k<n; k++){
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					mat[i][j] = min(mat[i][j],mat[i][k]+mat[k][j]);
				}
			}
		}
	}
	
	int min(int a, int b){
		if(a<b) return a;
		return b;
	}
	
	void print(int[][] mat, int n){
		System.out.println("All pair shortest path matrix: ");
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(mat[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
