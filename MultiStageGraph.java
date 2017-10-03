
public class MultiStageGraph {
	public static void main(String[] args){
		final int V = 12;
		int x[][]={
		          {0,9,7,3,2,0,0,0,0,0,0,0},
		          {0,0,0,0,0,4,2,1,0,0,0,0},
		          {0,0,0,0,0,2,7,0,0,0,0,0},
		          {0,0,0,0,0,0,0,11,0,0,0,0},
		          {0,0,0,0,0,0,11,8,0,0,0,0},
		          {0,0,0,0,0,0,0,0,6,5,0,0},
		          {0,0,0,0,0,0,0,0,4,3,0,0},
		          {0,0,0,0,0,0,0,0,0,5,6,0},
		          {0,0,0,0,0,0,0,0,0,0,0,4},
		          {0,0,0,0,0,0,0,0,0,0,0,2},
		          {0,0,0,0,0,0,0,0,0,0,0,5},
		          {0,0,0,0,0,0,0,0,0,0,0,0}
			      };
		
		
		
		int temp = 0;
		int[] cost = new int[V];
		int[] parent = new int[V];
		boolean flag = false;
		for(int i=0; i<V; i++){
			cost[i] = 0;
			parent[i] = 0;
		}
		for(int i=V-1; i>=0; i--){
			flag = false;
			for(int j=0; j<V; j++){
				if(x[i][j]!=0){
					if(!flag){
						cost[i] = cost[j] + x[i][j];
						parent[i] = j;
						flag = true;
					}else{
						temp = cost[j] + x[i][j]; 
						if(temp<cost[i]){
							cost[i] = temp;
							parent[i] = j;
						}
						
					}
				}
			}
		}
		int i = parent[0];
		System.out.print("0--->"+i);
		int result = x[0][i] ;
		int dummy = i;
		while(i!=V-1){
			i = parent[i];
			result += x[dummy][i];
			dummy = i;
			System.out.print("--->"+i);
		}
		System.out.println("\ntotal cost: "+result);
		
//		for(int i : parent)
//			System.out.print(i+" ");
//		System.out.println();
//		for(int i : cost)
//			System.out.print(i+" ");
	}
}
