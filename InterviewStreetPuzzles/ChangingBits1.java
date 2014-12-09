import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class ChangingBits1
{
	private static ArrayList<Integer> zeroarray = new ArrayList<Integer>();
	private static ArrayList<Integer> onearray = new ArrayList<Integer>();

	public static void main(String args[])
	{
		ArrayList<String> queries = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);				

		int N = scan.nextInt();
		int Q = scan.nextInt();

		String A = scan.next();
		String B = scan.next();
		
		char nBitA[] = A.toCharArray();
		char nBitB[] = B.toCharArray();	
		

		for(int i=0;i<N;i++)
		{
			if(nBitA[i] == nBitB[i])
			{
				if(nBitA[i] == '0')
					zeroarray.add((N-1) - i);
				else
					onearray.add((N-1) - i);				
			}
		}

		String[] q = new String[3];
		int idx = 0;	

		scan.nextLine();
		for(int i=0;i<Q;i++)
		{
			queries.add(scan.nextLine());			
		}

		for(String query: queries)
		{
			q = (query).split(" ");
			
			if(q[0].startsWith("set_a"))
			{
				//Change bits of A				
				idx = (N-1) - (Integer.parseInt(q[1]));
				//idx = (Integer.parseInt(q[1]));
				nBitA[idx] =  q[2].charAt(0);	

				if(nBitA[idx] == nBitB[idx])
				{
					if(nBitA[idx] == '0')
						zeroarray.add(idx);
					else
						onearray.add(idx);				
				}							
			}
			else if(q[0].startsWith("set_b"))
			{
				//Change bits of B
				idx = (N-1) - (Integer.parseInt(q[1]));
				//idx = (Integer.parseInt(q[1]));
				nBitB[idx] =  q[2].charAt(0);	
				if(nBitA[idx] == nBitB[idx])
				{
					if(nBitA[idx] == '0')
						zeroarray.add(idx);
					else
						onearray.add(idx);				
				}								
			}
			else
			{
				//C=A+B				
				idx = (Integer.parseInt(q[1]));	
				addAB(nBitA,nBitB, idx, N);
			}
		}
	}

	public static void addAB(char[] A, char[] B, int idx, int N)
	{		
		 //System.out.println("A = "+ new String(A));	
		 //System.out.println("B = "+ new String(B));
		 int startpos = 0;
		 int resultbit = 0;

		 if(idx == (N))
		 {	
		 	startpos = -1;
		 	resultbit =0;
		 }
		 else if(idx==0)
		 {	
		  	resultbit = A[N-1] ^ B[N-1];	
		 	System.out.print(resultbit);	 	
		 	return;
		 }
		 else
		 {
		 	startpos = (N-1) - idx;		 			 	
		 	resultbit = A[startpos] ^ B[startpos];		 	
		 	startpos++;
		 }

		 System.out.println("Ones are in "+ onearray);
		 System.out.println("Zeroes are in "+ zeroarray);
		 boolean fndPairOfOnes = false;
		 boolean fndPairOfZeroes = false;

		 Arrays.sort(onearray.toArray());
		 Arrays.sort(zeroarray.toArray());

		 //do a binary search
		 System.out.println("Seraching for startpos "+ startpos);
		 int srchedoneidx = Collections.binarySearch(onearray, startpos);
		 int srchedzeroidx = Collections.binarySearch(zeroarray, startpos);
		 
		System.out.println("zero idx "+ srchedzeroidx);
		 System.out.println("one idx "+ srchedoneidx);

		 if(srchedoneidx<0)
		 	srchedoneidx = -srchedoneidx;

		 if(srchedzeroidx<0)
		 	srchedzeroidx = -srchedzeroidx;

		 System.out.println("zero idx "+ srchedzeroidx);
		 System.out.println("one idx "+ srchedoneidx);
		 if(srchedzeroidx < srchedoneidx)
		 	fndPairOfZeroes = true;
		 else
		 	fndPairOfOnes = true;

		 //System.out.println("For idx = " + idx + " Start searching from "+ startpos);
		 
		 /*while(startpos<N)
		 {
		 	if(A[startpos]=='0' && B[startpos]=='0')
		 	{		 		
		 		//System.out.println("Fnd a zero pair at "+ startpos);
		 		fndPairOfZeroes = true;
		 		break;
		 	}
		 	else if(A[startpos]=='1' && B[startpos]=='1')
		 	{		 		
		 		//System.out.println("Fnd a one pair at "+ startpos);
		 		fndPairOfOnes = true;
		 		break;
		 	}
		 	startpos++;
		 }
*/
		 if(fndPairOfOnes)
		 {		 	
		 	//System.out.println("For one pair "+ resultbit + " will be changed to "+ (1-resultbit));
		 	System.out.print(1-resultbit);
		 }
		 else
		 {		 	
		 	//System.out.println("For zero/no pair "+ resultbit );
		 	System.out.print(resultbit);	
		 }
	}
	
}