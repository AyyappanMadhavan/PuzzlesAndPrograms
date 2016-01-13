package interviewstreetpuzzles;

import java.util.Scanner;

public class SherlockAndWatson {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();	 //no. of elements in array
		int K = scan.nextInt();	 //No. of times to rotate
		int Q = scan.nextInt();  //Queries
		
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++){
			arr[i] = scan.nextInt();
		}
		
		/*for(int i=0;i<N;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();*/
		//Rotate array. 
		//Divide array into 2 parts
		//reverse part 1
		//reverse part 2
		//reverse whole array
		int dividepos = K % N;
		int len_part = N - dividepos;
		reverse(arr, 0, len_part-1);
		reverse(arr, len_part, N-1);
		reverse(arr,0, N-1);
		
		for(int i=0;i<Q;i++){
			int quest = scan.nextInt();
			System.out.println(arr[quest]);
		}
	}
	
	public static void reverse(int[] arr, int left, int right){
		if(arr.length == 1){
			return;
		}
		
		while(left < right){
			int tmp = arr[right];
			arr[right] = arr[left];
			arr[left] = tmp;
			left++;
			right--;
		}
	}

}
