package interviewstreetpuzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MaxSubArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i=0;i<T;i++){
			int N = scan.nextInt();
			int best_non_cont_sum = 0;
			int best_cont_sum = 0;
			int current_sum = 0, curr_value = 0;
			ArrayList<Integer> positiveNumbers = new ArrayList<Integer>();
			ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
			int arr[] = new int[N];
			for(int j=0;j<N;j++){
				int val = scan.nextInt();
				arr[j] = val;
				if(val>=0){
					positiveNumbers.add(val);
				}else{
					negativeNumbers.add(val);
				}
			}
			
			if(positiveNumbers.size()==0){
				//There are no positive numbers at all. Get the highest negative number.
				Collections.sort(negativeNumbers);
				best_non_cont_sum = best_cont_sum = negativeNumbers.get(negativeNumbers.size()-1);
			}else{
				//Compute sum of non contiguous num as sum of all positive numbers
				for(Integer inte:positiveNumbers){
					best_non_cont_sum += inte;
				}
				
				//Compute sum of contiguous num 
				for(int j=0;j<N;j++){
					int val = arr[j];
					curr_value = current_sum + val;
					if(curr_value>0)
						current_sum = curr_value;
					else
						current_sum = 0;
					
					if(current_sum > best_cont_sum){
						best_cont_sum = current_sum;
					}
				}
			}			
			
			System.out.println(best_cont_sum+" "+ best_non_cont_sum);
		}
		
		//First try
		/*Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int[] arr = null;
		for(int i=0;i<T;i++){
			int n = scan.nextInt();
			arr = new int[n];
			int sum_non_contiguous = 0;
			int sum_contiguous = 0;
			int current_sum = 0, curr_value = 0;
			boolean firstTimeDone = false;
			for(int ii=0;ii<n;ii++){
				arr[ii] = scan.nextInt();
				if(arr[ii] >=0){
					sum_non_contiguous += arr[ii];
				}else if(arr[ii] > sum_non_contiguous || sum_non_contiguous == 0){
					sum_non_contiguous = arr[ii];
				}
				
				curr_value = current_sum + arr[ii];
				if(curr_value > current_sum || !firstTimeDone){
					current_sum = curr_value;
					firstTimeDone = true;
				}else if(arr[ii] > current_sum){
					current_sum = arr[ii];
				}else{
					current_sum = 0;
				}
				
				if((sum_contiguous>0 && current_sum > sum_contiguous) || sum_contiguous==0){
					sum_contiguous = current_sum;
				}else if(sum_contiguous < 0 && current_sum!=0 && current_sum > sum_contiguous ){
					sum_contiguous = current_sum;
				}
			}
			
			System.out.println(sum_contiguous+" "+ sum_non_contiguous);
		}*/
	}

}
