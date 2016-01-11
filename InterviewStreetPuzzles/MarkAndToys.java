package interviewstreetpuzzles;

import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {


	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		int[] arr = new int[N];
		
		for(int i=0;i<N;i++){
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		int st = 0;
		int limit = st+K;
		
		for(int i=0;i<N;i++){
			if(arr[i] <= K && (st + arr[i]) <= limit){
				System.out.println(arr[i]);
				st += arr[i];
				System.out.println("Shopped so far "+st);
				cnt++;
			}
		}
		
		System.out.println(cnt +" "+ st);
	}

}
