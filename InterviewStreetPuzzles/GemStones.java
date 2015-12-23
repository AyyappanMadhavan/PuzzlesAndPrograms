package interviewstreetpuzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GemStones {


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		List<String> gemList = new ArrayList<String>();
		List<String> gemMasterList = new ArrayList<String>();
		//Build master list
		String str = scan.next();
		char[] inStrArry = str.toCharArray();
		for(int k=0;k<inStrArry.length;k++){
			if(!gemMasterList.contains(String.valueOf(inStrArry[k]))){			
				gemMasterList.add(String.valueOf(inStrArry[k]));
			}			
		}
		
		//Build gemList
		for(int i=1;i<N;i++){
			str = scan.next();
			inStrArry = str.toCharArray();
			gemList.clear();
			for(int k=0;k<inStrArry.length;k++){
				if(gemMasterList.contains(String.valueOf(inStrArry[k]))){
					if(!gemList.contains(String.valueOf(inStrArry[k])))
						gemList.add(String.valueOf(inStrArry[k]));
				}
			}
			gemMasterList = new ArrayList<String>(gemList);
		}
		
		System.out.println(gemMasterList.size());
	}

}
