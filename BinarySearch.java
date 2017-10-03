import java.util.Scanner;
public class BinarySearch {
	 int search(int element, int[] arr){
		boolean flag = true;
		int lb = 1;
		int ub = arr.length-1;
		int mid = 0;
		if(element>=arr[lb] && element <= arr[ub])
			while(flag){
				mid = (int)(lb + ub)/2;
				if(arr[mid] == element){
					flag = false;
					return mid;
				}
				else if (arr[mid]>element)
					ub = mid-1;
				else if (arr[mid]<element)
					lb = mid+1;
				else
					return -1;
			}
		return -1;
	}
	 void takeInput(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter No. of Element : ");
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		System.out.println("Enter "+n+" Elements : ");
		for(int i=1; i<=n; i++)
			arr[i] = sc.nextInt();
		System.out.print("Enter Element to Search: ");
		int element = sc.nextInt();
		long time1 = System.nanoTime();
		int result = search(element, arr); 
		long time2 = System.nanoTime();
		long netTime = time2-time1;
		if(result!=-1)
			System.out.println("Position of Element is : "+result);
		else
			System.out.println("Searched Element is not present in Array");
		System.out.println("Time Taken: "+netTime+" ns");
		sc.close();	
	}
	public static void main(String args[]){
		BinarySearch bs = new BinarySearch();
		bs.takeInput();	
	}	
}