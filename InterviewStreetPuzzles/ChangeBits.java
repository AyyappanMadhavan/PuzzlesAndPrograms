import java.util.Scanner;
import java.util.BitSet;
import java.util.ArrayList;

public class ChangeBits
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		ArrayList<String> queries = new ArrayList<String>();
		String[] q = new String[3];
		int idx = 0;
		int startsearchpos = 0;

		int N = scan.nextInt();
		int Q = scan.nextInt();

		StringBuffer A = new StringBuffer(scan.next());
		StringBuffer B = new StringBuffer(scan.next());

		BitSet numA = new BitSet(N);
		BitSet numB = new BitSet(N);

		numA = fromString(A.toString());
		numB = fromString(B.toString());
/*
		System.out.println("At 0 "+ numA.get(0));
		System.out.println("At N-1 "+ numA.get(N-1));
		System.out.println("At N "+ numA.get(N));

		System.out.println(numA.get(0,(N)));
		System.out.println(numA.get(3,(N)));*/
		

		scan.nextLine();
		for(int i=0;i<Q;i++)
		{
			//queries.add(scan.nextLine());			
			String query = scan.nextLine();
		//}

		/*for(String query : queries)
		{*/
			q = (query).split(" ");
			
			if(q[0].startsWith("set_a"))
			{
				//Change bits of A															
				idx = Integer.parseInt(q[1]);
				if(q[2].equalsIgnoreCase("0"))
					numA.clear(idx);
				else
					numA.set(idx);						
			}
			else if(q[0].startsWith("set_b"))
			{
				//Change bits of B
				idx = Integer.parseInt(q[1]);
				if(q[2].equalsIgnoreCase("0"))
					numB.clear(idx);
				else
					numB.set(idx);																
			}
			else
			{
				//C=A+B				

				BitSet tempA = new BitSet();
				BitSet tempB = new BitSet();

				boolean resultbit = false;
				boolean res = false;
				idx = Integer.parseInt(q[1]);
				if(idx == 0)	
				{
					res = numA.get(0) ^ numB.get(0);
					if(res)
						System.out.print("1");
					else
					 	System.out.print("0");

					 continue;
				}				
				else if(idx == N)
				{
					startsearchpos = N-1;
					resultbit = false;
				}
				else
				{
					startsearchpos = idx-1;					
					resultbit = numA.get(startsearchpos) ^ numB.get(startsearchpos);
				}

				System.out.println("Start searching from "+ startsearchpos);

				boolean fndZeroPair = false;
				boolean fndOnePair = false;
				int nextZeroPos =0;
				int nextOnePos = 0;

				while(true)
				{			
					if(nextZeroPos != -1)		
						nextZeroPos = numA.nextClearBit(nextZeroPos);

					if(nextOnePos != -1)
						nextOnePos = numA.nextSetBit(nextOnePos);

					if(nextZeroPos == -1 && nextOnePos == -1)
						break;

					System.out.println("Next zero is in "+ nextZeroPos);
					System.out.println("Next One is in "+ nextOnePos);

					if(nextZeroPos>=0 && !numB.get(nextZeroPos))
					{
						System.out.println("Found zero pair");
						fndZeroPair = true;
						break;
					}
					else if(nextOnePos>=0 && numB.get(nextOnePos))
					{
						System.out.println("Found one pair");
						fndOnePair = true;
						break;
					}
					
				}

				if(fndOnePair)
				{
					if(resultbit)
						System.out.print("0");
					else
						System.out.print("1");
				}
				else
				{
					System.out.print(resultbit);
				}
				/*tempA = numA.get(0,startsearchpos);
				tempB = numB.get(0,startsearchpos);

				System.out.println("tempA =" + toString(tempA));
				System.out.println("tempB ="+ toString(tempB));

				boolean fndAOnePair = tempA.intersects(tempB);
				if(fndAOnePair)
				{
					System.out.println("Fnd a one pair "+ fndAOnePair +"So change resultbit "+ resultbit + " to "+ !resultbit);
					if(resultbit)
						System.out.print("0");
					else
						System.out.print("1");
				}
				else
				{
					System.out.println("No one pair So resultbit "+ resultbit);					
					if(resultbit)
						System.out.print("1");
					else
					 	System.out.print("0");
				}	 */
			}
		}

	}

	public static BitSet fromString(String s)
	{
		return BitSet.valueOf(new long[]{Long.parseLong(s,2)});
	}

	private static String toString(BitSet bs) {
        return Long.toString(bs.toLongArray()[0], 2);
    }

}