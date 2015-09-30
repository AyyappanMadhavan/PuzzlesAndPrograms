package interviewstreetpuzzles;

import java.util.Scanner;

public class DecentNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();

		for(int i=0;i<T;i++){
			int N = scan.nextInt();

			int finalNoOf3s = 0, finalNoOf5s = 0;

			int Nmod3 = N%3;
			int tempN = 0;
			if(N<3){
				finalNoOf3s = 0; finalNoOf5s = 0; 
			}
			else if(Nmod3 == 0){
				//we got the result
				finalNoOf5s = N/3;
			}else{
				tempN = N;
				while(true){
					tempN = tempN - 5;
					if(tempN<0){
						//no result;
						break;
					}
					if(tempN==0){
						//reached the bottom.
						finalNoOf3s = N/5;
						break;
					}
					else if(tempN%3 == 0){
						finalNoOf5s = (tempN/3);
						finalNoOf3s = ((N - tempN)/5);
						break;
					}				
				}
			}			
			printResult(finalNoOf5s, finalNoOf3s);

		}	
		scan.close();
	}
	    
	private static void printResult(int fives, int threes){    
		if(fives == 0 && threes == 0){
			System.out.print("-1");
		}else{
			for(int i=0;i<fives;i++){
				System.out.print("555");
			}
			for(int i=0;i<threes;i++){
				System.out.print("33333");
			}
		}

		System.out.println();
	}

}
