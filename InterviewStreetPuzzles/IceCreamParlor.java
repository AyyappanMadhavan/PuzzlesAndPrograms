package interviewstreetpuzzles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i=0;i<T;i++){
			int money = scan.nextInt();
			int flavors = scan.nextInt();
			int[] flavor_rates = new int[flavors];
			HashMap<Integer,List<Integer>> rateMap = new HashMap<Integer, List<Integer>>();
			for(int k=0;k<flavors;k++){			
				int rate =  scan.nextInt();
				flavor_rates[k] = rate;
				List<Integer> idxlist = new ArrayList<Integer>();
				if(rateMap.containsKey(rate)){
					//collision		
					idxlist = rateMap.get(rate);
					idxlist.add(k);
					rateMap.put(rate, idxlist);
				}else{
					idxlist.add(k);
					rateMap.put(rate, idxlist);
				}				
			}
			System.out.println(rateMap);
			for(int k=0;k<flavor_rates.length;k++){
				int srchKey = money - flavor_rates[k];
				//System.out.println(srchKey);
				if(srchKey >= 0){
					if(rateMap.containsKey(srchKey)){
						System.out.println(srchKey);
						int idx1 = k;
						int idx2 = -1;
						for(Integer inte:rateMap.get(srchKey)){
							if(inte > idx1){
								idx2 = inte;
								break;
							}
						}
						if(idx2 == -1){
							continue;
						}else{
							System.out.println((idx1+1)+" "+(idx2+1));
							break;
						}
					}
				}
			}			
		}
	}
}
