package interviewstreetpuzzles;

import java.util.Scanner;

public class FunnyStrings {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int i=0;i<T;i++){
			String str = scan.next();
			char[] inStr = str.toCharArray();
			char[] revStr = new char[inStr.length];
			int idx = -1;
			for(int j=inStr.length-1;j>=0;j--){
				revStr[++idx] = inStr[j];
			}
			boolean isFunny = false;
			for(int j=1;j<inStr.length;j++){
				if(Math.abs(inStr[j]-inStr[j-1]) == Math.abs(revStr[j]-revStr[j-1])){
					isFunny = true;
					continue;
				}else{
					isFunny = false;
					break;
				}
			}
			
			if(isFunny){
				System.out.println("Funny");
			}else{
				System.out.println("Not Funny");
			}
		}
	}

}
