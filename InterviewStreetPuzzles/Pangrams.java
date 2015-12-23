package interviewstreetpuzzles;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pangrams {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		String testStr = str.toLowerCase();
		char[] strArr = testStr.toCharArray();
		
		List<String> letterList = new ArrayList<String>();
		boolean isPangram = false;
		for(int i=0;i<strArr.length;i++){
			if(letterList.contains(String.valueOf(strArr[i]))){
				//do nothing
			}else{
				if((strArr[i]>=97 && strArr[i]<=122) || (strArr[i]>=65 && strArr[i]<=90))
					letterList.add(String.valueOf(strArr[i]));
			}
			System.out.println(letterList);
			if(letterList.size()==26){
				System.out.println("break success");
				isPangram = true;
				break;
			}else if((26-letterList.size())> (strArr.length-i)){
				System.out.println("break failure");
				break;
			}
		}
		
		if(isPangram){
			System.out.println("pangram");
		}else{
			System.out.println("not pangram");
		}
	}
}
