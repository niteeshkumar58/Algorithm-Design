import java.util.Scanner;

public class dijkstrasAlgo {
	static int V;
	int minkey(int[]key, boolean[] s){
		int infinity = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int v=0; v<V; v++){
			if(s[v]==false && key[v]<infinity){
				infinity = key[v];
				minIndex = v;
			}
		}
		return minIndex;
	}
	
	void algo(int[][] dist){
		int[] parent = new int[V];
		int[] key = new int[V];
		boolean[] s = new boolean[V];
		for(int v=0; v<V; v++){
			parent[v] = 0;
			key[v] = Integer.MAX_VALUE;
			s[v] = false;
		}
		key[0] = 0;
		for(int i=0; i<V-1; i++){
			int u = minkey(key, s);
			s[u] = true;
			for(int v=0; v<V; v++){
				if(dist[u][v]!=0 && s[v]==false && (dist[u][v]+key[u])<key[v]){
					key[v] = key[u] + dist[u][v];
					parent[v] = u;
				}
			}
		}
		print(key);
	}
	
	void print(int[] key ){
		System.out.println("distance from source A to : ");
		for(int v=1; v<V; v++){
			System.out.println((char)(v+65)+" = "+key[v]);
			
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of vertices: ");
		V = sc.nextInt();
		System.out.println("Enter distance Matrix row wise and press Enter after each row: ");
		int[][] dist = new int[V][V];
		for(int i=0; i<V; i++){
			for(int j=0; j<V; j++){
				dist[i][j] = sc.nextInt();
			}
		}
		dijkstrasAlgo da = new dijkstrasAlgo();
		da.algo(dist);
		sc.close();
	}
}
