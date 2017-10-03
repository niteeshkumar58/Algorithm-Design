import java.util.Scanner;
public class KnapSack_fraction {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements: ");
		int n = sc.nextInt();	
		float[] x = new float[n]; // it store fraction of iteams which is used
		int weight = 0; // current weight of bag
		
		int[] w = new int[n]; // given weight of elements
		int[] p = new int[n]; // given profit of elements
		System.out.println("Enter weight of all elements seperated by space: ");
		for(int i=0; i<n; i++)
			w[i] = sc.nextInt();
		System.out.println("Enter profit of corresponding elements seperated by space: ");
		for(int i=0; i<n; i++)
			p[i] = sc.nextInt();		
		System.out.println("Enter capacity of bag: ");
		int W = sc.nextInt(); //capacity of bag
		double netProfit = 0;
		float[] profitPerUnit = new float[n];
		for(int i=0; i<n; i++)
			profitPerUnit[i] =(float)p[i]/w[i];
		
		//Sorting All arrays ie. w[] & p[] according to profitPerUnit In Decreasing Order
		for(int i=0; i<n; i++){
			for(int j=0; j<n-1; j++){
				if(profitPerUnit[j]<profitPerUnit[j+1]){
					//profitPerUnit[j] = profitPerUnit[j]^profitPerUnit[j+1]^(profitPerUnit[j+1]=profitPerUnit[j]);
					w[j] = w[j]^w[j+1]^(w[j+1]=w[j]);
					p[j] = p[j]^p[j+1]^(p[j+1]=p[j]);
					float temp = profitPerUnit[j];
					profitPerUnit[j] = profitPerUnit[j+1];
					profitPerUnit[j+1] = temp;
				}		
			}
		}
		// Applying the algorithm
		for(int i=0; i<n; i++){
			if(weight+w[i] < W){
				x[i] = 1;
				weight += w[i]; 
			}else{
				x[i] = (float)(W-weight)/w[i];
				weight = W;
				break;
			}
		}
		
		//Calculating the total profit
		for(int i=0; i<n; i++){
			netProfit += p[i]*x[i];
		}

		System.out.println("Maximum Net Profit : "+netProfit);
	}
}
