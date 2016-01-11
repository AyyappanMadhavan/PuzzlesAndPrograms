package interviewstreetpuzzles;

import java.util.Scanner;

public class PalindromeIndex {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int i=0;i<T;i++){
			String str = scan.next();
			char[] strarr = str.toCharArray();
			boolean isDone =false;
			for(int ii=0,j=strarr.length-1;ii<strarr.length/2&&j>=strarr.length/2;ii++,j--){
				if(strarr[ii]!=strarr[j]){
					
					if(strarr[ii] == strarr[j-1] && strarr[j] == strarr[ii+1]){
						int rIdx = ii, lIdx = j;
						ii++;j--;
						while(!isDone){
							if(strarr[ii]!=strarr[j] && strarr[j]==strarr[ii+1]){
								//use rIdx
								isDone = true;
								System.out.println(rIdx);
							}else if(strarr[ii]!=strarr[j] && strarr[ii] == strarr[j-1]){
								//use lIdx
								isDone = true;
								System.out.println(lIdx);
							}else{
								ii++;j--;
							}
						}						
					}
					else if(strarr[ii] == strarr[j-1]){
						isDone = true;
						System.out.println(j);
					}else{
						isDone = true;
						System.out.println(ii);
					}
					break;
				}else{
					continue;
				}
			}
            if(!isDone){
                System.out.println("-1");
            }
		}
	}

}
