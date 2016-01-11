package interviewstreetpuzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i=0;i<T;i++){
			String str = scan.next();
			
			//Base case. Odd length strings cannot be used to create anagram
			if(str.length()%2!=0){
				System.out.println("-1");
				continue;
			}
			
			//Split String
			char[] str1 = new char[str.length()/2];
			char[] str2 = new char[str.length()/2];
			for(int k=0;k<str.length()/2;k++){
				str1[k] = str.charAt(k);
			}
			for(int j=0, k=str.length()/2;k<str.length();k++,j++){
				str2[j] = str.charAt(k);
			}
			
			List<String> str1list = new ArrayList<String>();
			List<String> str2list = new ArrayList<String>();
			List<String> str1templist = new ArrayList<String>();
					
			for(int ii=0;ii<str1.length;ii++){			
				str1list.add(String.valueOf(str1[ii]));
				str1templist.add(String.valueOf(str1[ii]));
			}
			for(int ii=0;ii<str2.length;ii++){
				str2list.add(String.valueOf(str2[ii]));
			}
			
			for(int ii=0;ii<str1templist.size();ii++){
				String s = str1templist.get(i);
				if(str2list.contains(s)){
					str2list.remove(s);
					str1list.remove(s);
				}			
			}
			
			System.out.println((str1list.size()+str2list.size())/2);
		}
	}
}
