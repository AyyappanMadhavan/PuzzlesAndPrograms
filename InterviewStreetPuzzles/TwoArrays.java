package interviewstreetpuzzles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TwoArrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i=0;i<T;i++){
			int N = scan.nextInt();
			int K = scan.nextInt();
			List<Integer> array1 = new ArrayList<Integer>();
			List<Integer> array2 = new ArrayList<Integer>();
			
			for(int j=0;j<N;j++){
				array1.add(scan.nextInt());
			}
			
			for(int j=0;j<N;j++){
				array2.add(scan.nextInt());
			}
			
			
			Collections.sort(array1);
			Collections.sort(array2, new Comparator<Integer>(){
				
				public int compare(Integer i1, Integer i2){
					return i2- i1;
				}
			});
			
			System.out.println(array1);
			System.out.println(array2);
			boolean flg = false;
			for(int ii=0;ii<N;ii++){
				if(array1.get(ii)+array2.get(ii) >= K){
					flg = true;
					continue;
				}else{
					flg = false;
					break;
				}
			}
			
			if(flg){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
		
	}

}
