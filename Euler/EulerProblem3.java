import java.util.ArrayList;
import java.util.Calendar;
public class EulerProblem3
{
	 // generates prime candidates for dividing...
	public static boolean isPrime(long n) 
	{
		if (n==2L) return true;

		for (long i=2L; i<=Math.sqrt(n); i+=2)  //Increment by 2 as all other primes are odd..
		{
			if(n%i == 0) return false;
		}
		return true;
	}

	public static void main(String args[])
	{
		Calendar cal = Calendar.getInstance();		
		long number = 8L; 	
		long divisor = 2L; //start value.. 1 is not a prime
		ArrayList<Long> factors = new ArrayList<Long>();		

		do 
		{
			if(isPrime(divisor))
			{							
				while(number%divisor == 0)
				{		
					factors.add((Long)divisor);						
					number = number/divisor;
				}	
			}
			if(divisor==2)	divisor++;   //Increment by 1 only first time when divisor is 2
			else divisor+=2; 			 //Increment by 2 as all other primes are odd..
		}
		while(divisor <= Math.sqrt(number));
		if(number!=1L)
			factors.add((Long)number); // add the last number as it is no more divisible						
		System.out.println(factors);
		System.out.println(factors.get(factors.size()-1)); //print the largest of the factors..
		Calendar cal1 = Calendar.getInstance();
		System.out.println("Computation Time "+ (cal1.getTimeInMillis() - cal.getTimeInMillis()) + " ms");
	}
}