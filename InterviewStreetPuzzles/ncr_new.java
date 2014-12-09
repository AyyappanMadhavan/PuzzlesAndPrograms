import java.util.*;
import java.io.*;
import java.math.BigInteger;
class ncr_new{
	public static void main(String args[]){
		System.out.println("Start "+new Date());	

		try{

			String sCurrentLine;
			//br = new BufferedReader(new FileReader("C:\\Users\\ayyappan_m\\Downloads\\input.txt"));
			Scanner scan = new Scanner(new FileReader("C:\\Users\\ayyappan_m\\Downloads\\input1.txt"));
			int T = scan.nextInt();
			System.out.println("No of testcases "+T);
			for(int i=0;i<T;i++){
				int tmp_n = scan.nextInt();
				int tmp_r = scan.nextInt();
				System.out.println("Computing "+ tmp_n +" C "+ tmp_r);
				//Base Case
				if(tmp_r == 0)
					System.out.println("1");
				else if(tmp_n == 0)
					System.out.println("0");
				else if(tmp_r > tmp_n)
					System.out.println("0");
				else{
					BigInteger N = new BigInteger(String.valueOf(tmp_n));
					BigInteger R = new BigInteger(String.valueOf(tmp_r));

					BigInteger fs = new BigInteger("1");
					BigInteger BI_142857 = new BigInteger("142857");				
					for(BigInteger d = BigInteger.ONE;
						 d.compareTo(R)<1;
					 	d = d.add(BigInteger.ONE)){

						fs = fs.multiply(N);
						N = N.subtract(BigInteger.ONE);
						fs = fs.divide(d);																		
					}			
					//output all answere modulo 142857
					BigInteger[] ans = new BigInteger[2];
					ans = fs.divideAndRemainder(BI_142857);
					System.out.println(ans[1]);
				}
			}
			System.out.println("End "+new Date());		

		}catch(IOException e){
			System.out.println("Error in file read "+ e.getMessage());
		}		
	}
}
/*class ncr{
	public static void main(String args[]){
		int n = 100000000;		        
		int[] numlist = new int[n+1];		
        
        int idx=1;
		for(int i=2;i<=n;i++)
			numlist[++idx] = i;
		
		int mults=2;				
		int p = 2;
		while(p!=-1){
			markMultiples(numlist,p);
//			printArray(numlist);
			mults+=1;
			p = getNextNum(numlist, mults);
//			System.out.println("Next Num "+ p);
		}

		printPrimes(numlist);
	}

	static int getNextNum(int[] numlist,int p){		
		for(int i=p;i<numlist.length;i++){
			if(numlist[i]!=-1)
				return numlist[i];
		}
		return -1;
	}

	static void markMultiples(int[] numlist, int p){
//		System.out.println("marking mulitples of "+p);
		int mul = p+p;
		for(;mul<numlist.length;mul+=p){
			numlist[mul] = -1;
		}	
	}

	static void printArray(int[] numlist){
		for(int num:numlist)
			System.out.print(num+",");
		System.out.println("");
	}

	static void printPrimes(int[] numlist){
		int count = 0;
		for(int num : numlist){
			if(num!=-1 && num !=0){
				//System.out.print(num+",");
				count++;
			}
		}
		System.out.println("\nTotal Primes "+ count);
	}
}*/