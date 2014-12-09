import java.util.ArrayList;
public class EulerProblem12
{
	public static int findNoOfDivisors(long num)
	{
		 long limit = num;
    	 int numberOfDivisors = 0;

    	for (long i=1; i < limit; i++) 
    	{
        	if (num % i == 0)
        	{
            	limit = num / i;
            	numberOfDivisors++;
        	}
    	}
        return numberOfDivisors * 2;
	}
	public static void main(String args[])
	{
		long n=1L;
		boolean loopflag = true;
		ArrayList<Long> trianglenumberList = new ArrayList<Long>();
		long triangleNumber = 0L;
		int count = 0;
		while(loopflag)
		{
			//find trianlge numbers
			triangleNumber = (n*(n+1))/2;			
			trianglenumberList.add(triangleNumber);
			count = 0;long i=1L;
			//find factors for that triangle numbers
			count = findNoOfDivisors(triangleNumber);
			
			if(count > 500)
			{
			   System.out.println("First triangle number to have more than 500 divisors is "+ triangleNumber);			   
			   break;
			}
			n++;
		}
		//System.out.println("Triangle Number List contains "+ trianglenumberList.size() +"numbers and the list is\n "+ trianglenumberList);
	}
}