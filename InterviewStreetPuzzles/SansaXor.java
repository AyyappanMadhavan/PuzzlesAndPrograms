package interviewstreetpuzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SansaXor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int tc=0;tc<T;tc++){
			int N = scan.nextInt();
			int[] arr = new int[N];
			
		
			for(int i=0;i<N;i++){
				arr[i] = scan.nextInt();
			}
			
			//If Array length is even - then xor value of all continguous sublist elements will be 0
			//If odd - compute xor of all values at even olcation 0,2,4,...
			if(arr.length%2 == 0){
				System.out.println("0");
			}else{
				int xorResult = Integer.MIN_VALUE;
				for(int i=0;i<N;i+=2){
					if(xorResult == Integer.MIN_VALUE){
						xorResult = arr[i];
					}else{
						xorResult ^= arr[i];
					}
				}
				System.out.println(xorResult);
			}
			
			//Compute sublists
			/*int k=0;
			int xorResult = Integer.MIN_VALUE;
			for(int i=0;i<N;i++){						
				for(int j=i;j<N;j++){
					k=i;
					//System.out.println();
					while(k<=j){
						if(xorResult == Integer.MIN_VALUE){
							xorResult = arr[k];
						}else{
							xorResult ^= arr[k];
						}
						//System.out.print(arr[k]);
						k++;
					}
					
				}
			}
			System.out.println(xorResult);*/
		}		
		
	}
	
	public static Map<String,Integer> formSubList(int[] source, List<Integer> subsetlist){
		int currentSubset = 1 << source.length; 
		int tmp; 
		Map<String, Integer> xormap = new HashMap<String,Integer>();
		StringBuffer sbr = new StringBuffer();
		while(currentSubset!=0) 
		{ 
			sbr.setLength(0);
			tmp = currentSubset;
			int xorResult = 0;
			for(int i = 0; i<source.length; i++) 
			{ 
				if ((tmp & 1) !=0) {
					if(i>0){
						xorResult = xorResult ^ source[i];
					}else
						xorResult = source[i];
					sbr.append(source[i]);
					//System.out.print(source[i]);
				}					 
				tmp >>= 1;		
			}			
			currentSubset--;
			subsetlist.add(xorResult);
			if(sbr.length()>0 && !xormap.containsKey(sbr.toString()))
				xormap.put(sbr.toString(),xorResult);
		}
		
		return xormap;
	}
}
