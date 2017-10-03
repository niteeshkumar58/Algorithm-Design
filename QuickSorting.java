import java.util.Scanner;

public class QuickSorting {
	static int[] arr ;
	static int partitioner(int[] arr, int p, int r){
		int x = arr[r];
		int i = p-1;
		for(int j=p; j<r; j++){
			if(arr[j]<x){
				i++;
				arr[i] = arr[i]^arr[j]^(arr[j]=arr[i]);
			}
		}
		arr[i+1] = arr[i+1]^arr[r]^(arr[r]=arr[i+1]);
		return i+1;
	}
	static void quickSort(int[] arr, int p, int r){
		if(p<r){
			int q = partitioner(arr, p, r);
			quickSort(arr, p, q-1);
			quickSort(arr, q+1, r);
//			for(int i=1; i<r; i++)
//				System.out.print(arr[i] +" ");
//			System.out.println();
		}	
	}
	
	public static void main(String[] agrs){
		int p = 1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int r = sc.nextInt();
		int arr[] = new int[r+1];
		System.out.println("Enter Elements: ");
		for(int i=1;i<=r; i++){
			arr[i] = sc.nextInt();
		} 
//		int pivotedElement = partitioner(arr, p, r);
//		System.out.println("Pivoted Element is at position: "+pivotedElement);
//		System.out.println("Output Array of Partitioner: ");
//		for(int i=1; i<=r; i++)
//			System.out.print(arr[i]+"  ");
//		System.out.println();
//		System.out.println("Different Step: ");
		quickSort(arr, p, r);
		System.out.println("Sorted Elements: ");
		for(int i=1; i<=r; i++)
			System.out.println(arr[i]);
		sc.close();
	}
}
