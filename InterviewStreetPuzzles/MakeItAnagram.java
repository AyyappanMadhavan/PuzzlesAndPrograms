package interviewstreetpuzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakeItAnagram {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s1 = scan.next();
		String s2 = scan.next();
		//System.out.println("First String "+ s1);
		//System.out.println("Second String "+ s2);
		
		//Base case - If strings are of same length and contains same chars
		//Case 1 - Longer string to be deleted chars first. Select chars
		System.out.println("1 KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		
		int len1 = arr1.length, len2 = arr2.length;
		List<String> str1list = new ArrayList<String>();
		List<String> str2list = new ArrayList<String>();
		List<String> str1templist = new ArrayList<String>();
				
		for(int i=0;i<len1;i++){			
			str1list.add(String.valueOf(arr1[i]));
			str1templist.add(String.valueOf(arr1[i]));
		}
		for(int i=0;i<len2;i++){
			str2list.add(String.valueOf(arr2[i]));
		}
		
		for(int i=0;i<str1templist.size();i++){
			String s = str1templist.get(i);
			if(str2list.contains(s)){
				str2list.remove(s);
				str1list.remove(s);
			}			
		}
		System.out.println("2. KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
		
		System.out.println(str1list.size()+str2list.size());
	}
}
