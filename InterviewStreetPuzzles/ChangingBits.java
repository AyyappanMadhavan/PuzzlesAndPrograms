import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class ChangingBits
{
	public static HashMap<String,String> additionLookupTable = new HashMap<String,String>();
	public static char nBitC[];
	public static String carry="0";

	public static void main(String args[])
	{
		ArrayList<String> queries = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);		
		formLookUpTableForAddition();

		int N = scan.nextInt();
		int Q = scan.nextInt();


		char nBitA[] = (scan.next()).toCharArray();
		char nBitB[] = (scan.next()).toCharArray();	

		//add A & B		
		nBitC = new char[N+1];
		addAB(nBitA,nBitB,N);

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
				nBitA[idx] =  q[2].charAt(0);				
				addAB(nBitA,nBitB,N);				
			}
			else if(q[0].startsWith("set_b"))
			{
				//Change bits of B
				idx = (N-1) - (Integer.parseInt(q[1]));
				nBitB[idx] =  q[2].charAt(0);				
				addAB(nBitA,nBitB,N);
			}
			else
			{
				//C=A+B					
				idx = (N) - ((Integer.parseInt(q[1])));				
				System.out.print(nBitC[idx]);
			}
		}
	}

	public static void addAB(char[] A, char[] B, int N)
	{
		
		 String numA = new String(A);
		 String numB = new String(B);
		
		 char carry = '0';
		 String resultBit= "";
		 StringBuffer finalResult=new StringBuffer();
		 String res = "";
		 String lookupkey = "";
		 for(int i=N-1;i>=0;i--)
		 {
		 	lookupkey = String.format("%c+%c+%c", carry, numA.charAt(i),  numB.charAt(i) );			
		 	
		 	resultBit = additionLookupTable.get(lookupkey);
			
		 	finalResult.append(resultBit.charAt(1));
		 	carry = resultBit.charAt(0);			
		 }

		 if(carry == '1')
		 	res = carry + finalResult.reverse().toString();
		 else
		 	res = '0' + finalResult.reverse().toString();
	
		 nBitC = res.toCharArray();
	}

	public static void formLookUpTableForAddition()
	{		
		additionLookupTable.put("0+0+0","00");
		additionLookupTable.put("0+0+1","01");
		additionLookupTable.put("0+1+0","01");
		additionLookupTable.put("0+1+1","10");
		additionLookupTable.put("1+0+0","01");
		additionLookupTable.put("1+0+1","10");
		additionLookupTable.put("1+1+0","10");
		additionLookupTable.put("1+1+1","11");
	}
}