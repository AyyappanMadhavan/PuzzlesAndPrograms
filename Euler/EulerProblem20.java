import java.math.BigInteger;

public class EulerProblem20
{
	public static void main(String args[])
	{
		int n = 100;
		BigInteger bg = new BigInteger("1");		

		for(int i=1;i<=100;i++)
			bg = bg.multiply(new BigInteger(new Integer(i).toString()));

		System.out.println(bg.toString());
		String result = bg.toString();
		int digitSum = 0;

		for(int i=0;i<result.length();i++)
		   digitSum += Integer.parseInt(result.substring(i,i+1));
		
		System.out.println("Sum of digits: "+ digitSum);
	}
}