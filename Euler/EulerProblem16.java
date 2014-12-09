import java.math.BigInteger;
public class EulerProblem16
{
	public static void main(String args[])
	{		
		BigInteger sumOfTwo = new BigInteger("2");
		BigInteger tempSum = BigInteger.ONE;
		int digitSum = 0;
		for(int i=1;i<1000;i++)
		{
			tempSum = sumOfTwo;
			sumOfTwo = tempSum.multiply(new BigInteger("2"));
		}

		String result = sumOfTwo.toString();
		System.out.println("Sum of Two power 1000 "+ result);		

		for(int i=0;i<result.length();i++)
		   digitSum += Integer.parseInt(result.substring(i,i+1));
		
		System.out.println("Sum of first 10 digits: "+ digitSum);

	}
}