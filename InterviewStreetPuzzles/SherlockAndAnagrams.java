package interviewstreetpuzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//Brute-force technique

public class SherlockAndAnagrams {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		List<String> combinationlist = new ArrayList<String>();
		char[] s_arr;
		StringBuilder sbr = new StringBuilder();
		String s1, s2;
		int anagram=0;
		long start=0, end=0;
		start = System.currentTimeMillis();
		for(int i=0;i<T;i++){
			String s = scan.next();
			s_arr = s.toCharArray();
			sbr.delete(0,sbr.length());
			combinationlist.clear();
			for(int k=0;k<s.length();k++){
				for(int r=k;r<s.length();r++){					
					for(int l=k;l<=r;l++){
						sbr.append(s_arr[l]);
					}
					combinationlist.add(sbr.toString());
					sbr.delete(0,sbr.length());
				}
			}
			
			Collections.sort(combinationlist, new Comparator<String>(){
				public int compare(String obj1, String obj2){
					return obj1.length()-obj2.length();
				}
			});			

			s1="";s2="";anagram=0;
			for(int k=0;k<combinationlist.size();k++){
				s1 = combinationlist.get(k);
				
				for(int j=k+1;j<combinationlist.size();j++){
					s2 = combinationlist.get(j);
					if(s1.length() != s2.length()){
						break;
					}else{
						if(s1.length() == 1 && s1.equalsIgnoreCase(s2)){
							anagram++;
						}else{
							if(isAnagram(s1, s2)){
								anagram++;
							}						
						}						
					}
				}
			}
			System.out.println(anagram);			
		}
		end = System.currentTimeMillis();
		System.out.println("Time elapsed "+ (end-start) + " ms");
	}
	
	public static boolean isAnagram(String s1, String s2){
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		return Arrays.equals(arr1, arr2);
	}
}
