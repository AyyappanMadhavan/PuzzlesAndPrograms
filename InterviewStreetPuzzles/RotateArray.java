package interviewstreetpuzzles;

import java.util.ArrayList;
import java.util.Scanner;

public class RotateArray
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();
		int N = scan.nextInt();
		int R = scan.nextInt();
		int a[][] = new int[M][N];
		
		
		for(int i=0;i<M;i++){
			for(int j=0;j<N;j++){
				a[i][j] = scan.nextInt();
			}
		}
		
		int total_1D_array = (N<M)?N/2:M/2;
		
		for(int i=0;i<total_1D_array;i++){
			int m = M - 2 * i;
	        int n = N - 2 * i;
	        int count = 2*(n + m - 2);
	        int temp[] = new int[1200];
	        //get top
	        for (int j = 0; j < n; j++) {
	            temp[j] = a[i][i + j];
	        }
	        //get right
	        for (int j = 0; j < m; j++) {
	            temp[n - 1 + j] = a[i + j][i + n - 1];
	        }
	        //get bottom
	        for (int j = 0; j < n; j++) {
	            temp[n - 1 + m - 1 + j] = a[m + i - 1][n - 1 + i - j];
	        }
	        //get left
	        for (int j = 0; j < m - 1; j++) {
	            temp[2*n + m - 3 + j] = a[i + m - 1 - j][i];
	        }
	        //set top
	        for (int j = 0; j < n; j++) {
	            a[i][i + j] = temp[(j + R) % count];
	        }
	        //set right
	        for (int j = 0; j < m; j++) {
	            a[i + j][i + n - 1] = temp[(n - 1 + j + R) % count];
	        }
	        //set bottom
	        for (int j = 0; j < n; j++) {
	            a[m + i - 1][n - 1 + i - j] = temp[(n - 1 + m - 1 + j + R) % count];
	        }
	        //set left
	        for (int j = 0; j < m - 1; j++) {
	            a[i + m - 1 - j][i] = temp[(2*n + m - 3 + j + R) % count];
	        }
		}
		
		for (int i = 0; i < M; i ++) {
	        for (int j = 0; j < N; j++) {
	            System.out.print(a[i][j]+" ");
	        }
	        System.out.println();
	    }
		
	}
}