import java.util.Scanner;
public class PrimsAlgorithm {
	static int V;
	
	int minKey(int[] key, boolean[] mstSet){
		int infinty = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int v=0; v<V; v++){
			if(mstSet[v]==false && key[v]<infinty){
				infinty = key[v];
				minIndex = v;
			}
		}
		return minIndex;
	}
	
	void print(int[] parent, int[][] dist){
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++)
            System.out.println((char)(parent[i]+65)+" "+ (char)(i+65)+"    "+dist[i][parent[i]]);                           
	}
	
	void spanTree(int[][] dist){
		int[] key = new int[V];
		int[] parent = new int[V];
		boolean[] mstSet = new boolean[V];
		for(int i=0; i<V; i++){
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		
		for(int i=0; i<V; i++){
			int u = minKey(key, mstSet);
			mstSet[u] = true;
			for(int v=0; v<V; v++){
				if(dist[u][v]!=0 && mstSet[v]==false && dist[u][v]<key[v]){
					key[v] = dist[u][v];
					parent[v] = u;
				}
			}
		}
		print(parent, dist);
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
		PrimsAlgorithm pan = new PrimsAlgorithm();
        pan.spanTree(dist);
        sc.close();
        
	}
}
