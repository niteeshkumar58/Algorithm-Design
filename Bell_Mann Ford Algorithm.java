import java.util.*;
public class BellmanFordAlgo {
	static final int inf = 999;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter no. of vertices: ");
		int n = sc.nextInt();
		int[][] graph = new int[n][n];
		System.out.println("Enter Adjacency Matrix (use 999 in place of Infinity) : ");
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				graph[i][j]=sc.nextInt();
			}
		}
		
		int edge[] = new int[n];
		for(int i=0; i<n; i++)
			edge[i] = inf;
		edge[0] = 0;
		for(int k=0; k<n-1; k++){
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(graph[i][j] != inf && graph[i][j] != 0){
						if(edge[j]>(graph[i][j]+edge[i])){
							edge[j] = graph[i][j]+edge[i];
						}
					}
				}
			}
		}
		System.out.println("Shortest Distance from Source to : ");
		for(int i=1; i<n; i++)
			System.out.println((char)(i+64)+" -->  "+edge[i]);
	}
}


/*
  example Input:
  Adjacency matrix of a graph :
 
0 10 999 999 999 8
999 0 999 2 999 999
999 1 0 999 999 999
999 999 -2 0 999 999
999 -4 999 -1 0 999
999 999 999 999 1 0
 
 
 */
