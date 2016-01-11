package interviewstreetpuzzles;

import java.util.HashSet;
import java.util.Scanner;

public class TwoStrings {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i=0;i<T;i++){
			String s1 = scan.next();
			String s2 = scan.next();
			
			HashSet<Character> set1 = new HashSet<Character>();
			HashSet<Character> set2 = new HashSet<Character>();
			
			for(int k=0,j=0;k<s1.length()||j<s2.length();k++,j++){
				if(k<s1.length()){
					set1.add(s1.charAt(k));
				}
				if(j<s2.length()){
					set2.add(s2.charAt(j));
				}
			}
			
			if(set1.removeAll(set2)){ //Denotes that there were common elements 
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
		}
	}

}
