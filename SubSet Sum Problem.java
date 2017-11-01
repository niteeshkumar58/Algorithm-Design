import java.util.*;
public class SubsetSum {
	
	static int[] w  ;	// given set matrix
	static int[] x;		// final subset 0/1 matrix
	static int m;	// target sum
	void sumOfSub(int s, int k, int r){
		//generating left child by including the elements
		x[k] = 1;
//		for(int i : x) System.out.print(i+"  "); System.out.println();		// remove the comment if you want to see how change x[] matrix
		if(s+w[k]==m){
			for(int i=1; i<x.length; i++){
				if(x[i]*w[i]!=0)
					System.out.print(x[i]*w[i]+ "  ");
			}
			System.out.println();
			x[k]=0;
		}
		else if(s+w[k]+w[k+1]<= m)		// including next element to the set
			sumOfSub(s+w[k], k+1, r-w[k]);
		
		// generating right child using backtracking
		if((s+r-w[k] >= m) && (s+w[k+1]<=m)){
			x[k] = 0;
			sumOfSub(s, k+1, r-w[k]);
		}
	}
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size: ");
		int n = sc.nextInt();
		System.out.print("enter sum :");
		m = sc.nextInt();
		System.out.println("enter element of subset: ");
		w = new int[n+1];
		Set<Integer> ww = new TreeSet<Integer>();	// creating a SetTree to maintain the set and ascending order
		for(int i=0; i<n; i++){
			ww.add(sc.nextInt());
		}
		int j=1, r=0;
		for(int i : ww){				// copying the values of SetTree into an array to easy access
			w[j++] = i;
			r += i;
		}
		x = new int[n+1];
		// call function here
		// Initial call of function 
		SubsetSum ss = new SubsetSum();
		System.out.println("Possible subsets are: ");
		ss.sumOfSub(0,1,r);
		 
	}
}
