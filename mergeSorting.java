import java.util.Scanner;

public class mergeSorting {
	static int arr[];
	static void merge(int[] arr, int p, int q, int r){
		int n1 = q-p+1;
		int n2 = r-q;
		int[] L = new int[n1+2];
		int[] R = new int[n2+2];
		for(int i=1; i<=n1; i++)
			L[i] = arr[p+i-1];
		for(int j=1; j<=n2; j++)
			R[j] = arr[q+j];
		L[n1+1] = 99999999;
		R[n2+1] = 99999999;
		int i = 1;
		int j = 1;
		for(int k=p; k<=r; k++){
			if(L[i]<R[j]){
				arr[k] = L[i];
				i++;
			}else{
				arr[k] = R[j];
				j++;
			}
			
		}
	}
	
	static void mergeSort(int[]arr, int p, int r){
		if(p<r){
			int q = (int)((p+r)/2);
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q, r);
//			for(int i=1; i<=r; i++)
//				System.out.print(arr[i]+"\t");
//			System.out.println();
		}
	}
	
	public static void main(String[] args){
		int p = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int r = sc.nextInt();
		int arr[] = new int[r+1];
		System.out.println("Enter Elements: ");
		for(int i=1;i<=r; i++){
			arr[i] = sc.nextInt();
		} 
//		System.out.println("Different Step: ");
		mergeSort(arr, p, r);
		System.out.println("Sorted Elements: ");
		for(int i=1; i<=r; i++)
			System.out.println(arr[i]);
		sc.close();
	}
}
