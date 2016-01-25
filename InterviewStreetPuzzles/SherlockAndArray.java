package interviewstreetpuzzles;

import java.util.Scanner;

public class SherlockAndArray {
	//Algorithm
	/*
	 *  1) Initialize leftsum  as 0
		2) Get the total sum of the array as sum
		3) Iterate through the array and for each index i, do following.
    			a)  Update sum to get the right sum.  
           		b) If leftsum is equal to sum, then return current index. 
    			c) leftsum = leftsum + arr[i] // update leftsum for next iteration.
		4) If we come out of loop without returning then no equilibrium index
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int[] arr = null;
		for(int i=0;i<T;i++){
			int N = scan.nextInt();
			arr = new int[N];
			int totalSum = 0;
			for(int ii=0;ii<N;ii++){
				arr[ii] = scan.nextInt();
				totalSum += arr[ii];
			}
			
			int leftSum = 0;
			int rightSum = totalSum;
			boolean fndEquilibrium = false;
			for(int ii=0;ii<N;ii++){
				rightSum -= arr[ii];
				if(leftSum == rightSum){
					fndEquilibrium = true;					
					break;
				}
				leftSum += arr[ii];
			}
			
			if(fndEquilibrium){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

}
