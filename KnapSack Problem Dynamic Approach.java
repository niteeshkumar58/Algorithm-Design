import java.util.Scanner;

public class KnapSackDynamic {

    static int max(int a, int b) { 
    	return (a > b)? a : b; 
    }
    static int knapSack(int W, int wt[], int val[], int n){
         int i, w;
         int K[][] = new int[n+1][W+1];
      
	     for (i = 0; i <= n; i++){
	         for (w = 0; w <= W; w++){
	             if (i==0 || w==0)
	                  K[i][w] = 0;
	             else if (wt[i-1] <= w)
	                   K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
	             else
	                   K[i][w] = K[i-1][w];
	         }
	      }
	      
	      return K[n][W];
	    }
 
    public static void main(String args[]){
	    Scanner sc =  new Scanner(System.in);
	    System.out.print("Enter no. of Element: ");
	    int n = sc.nextInt();
        int val[] = new int[n];
	    int wt[] = new int[n];
	    System.out.println("Enter profit of elements: ");
	    for(int i=0; i<n; i++)
	    	val[i] = sc.nextInt();
	    System.out.println("Enter weight of elements: ");
	    for(int i=0; i<n; i++)
	    	wt[i] = sc.nextInt();
	    System.out.print("Enter KnapSack capacity: ");
	    int  W = sc.nextInt();
	    
	    int l = val.length;
	    System.out.print("Maximum profit is : ");
	    System.out.println(knapSack(W, wt, val, l));
    }
}
