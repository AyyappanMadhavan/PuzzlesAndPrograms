import java.util.*;
import java.math.BigInteger;

public class BinomialCoefficients
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int i=0;i<T;i++)
		{
			String n = scan.next();
			String p = scan.next();
			System.out.println(n+","+p);	

			//compute base p digits for n
			ArrayList n_digits = new ArrayList();

			BigInteger n_big = new BigInteger(n);
			BigInteger p_big = new BigInteger(p);
			BigInteger[] q = new BigInteger[2];
			while(p_big.compareTo(n_big) <= 0)
			{
				q = n_big.divideAndRemainder(p_big);
				n_digits.add(q[1].toString());
				n_big = q[0];
			}
			n_digits.add(n_big.toString());
			
			n_big = new BigInteger(n);

			//Find binomial coefficient that are divisible by p are
			BigInteger count= new BigInteger("1");
			BigInteger tmp;
			for(Object itm : n_digits)
			{
				System.out.println(itm.toString());
				tmp = new BigInteger(itm.toString());
				count.multiply(tmp);
			}
			count.add(new BigInteger("1"));
			System.out.println(count.toString());	
			System.out.println(n_big.toString());		
			
			String res = (n_big.subtract(count)).toString();
			System.out.println(res);
		}		

	}
}