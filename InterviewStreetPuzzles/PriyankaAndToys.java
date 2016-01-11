package interviewstreetpuzzles;

import java.util.Arrays;
import java.util.Scanner;

public class PriyankaAndToys {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++){
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		int min = arr[0];
		int finalcnt =0, cnt = 1;
		for(int i=0;i<N;i++){
			if(arr[i] <= (min+4)){
				continue;
			}else{
				min = arr[i];	
				cnt++;
			}
		}
			
		System.out.println(cnt);
	}

}
