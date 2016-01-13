package interviewstreetpuzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClosestNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++){
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		List<Integer> finalList = new ArrayList<Integer>();
		for(int i=1;i<N;i++){
			if(arr[i]-arr[i-1] < min){
				finalList.clear();
				min = arr[i]-arr[i-1];
				finalList.add(arr[i-1]);
				finalList.add(arr[i]);
			}else if(arr[i]-arr[i-1] == min){
				min = arr[i]-arr[i-1];
				finalList.add(arr[i-1]);
				finalList.add(arr[i]);
			}
		}
		
		System.out.println(finalList);
		
		for(Integer ii:finalList){
			System.out.print(ii + " ");
		}
	}

}
