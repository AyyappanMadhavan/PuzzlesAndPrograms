import java.util.Calendar;
public class EulerProblem4
{
	public static boolean checkPalindrome(int n)
	{
		String str = new Integer(n).toString();
		StringBuffer strBuf = new StringBuffer(str);
		String revStr = strBuf.reverse().toString();
		if(str.equals(revStr))
		  return true;
		return false;		  
	}

	public static void main(String args[])
	{
		Calendar cal = Calendar.getInstance();
		int startNum = 999;
		int endNum =100;
		int product = 0;
		boolean status = false;
		int highestPalindrome = 0;

		for(int i =startNum; i >= endNum; i--)
		{
			for(int j=startNum-1;j>=endNum;j--)
			{
				product = i*j;
				status = checkPalindrome(product);				
				if(status && product>highestPalindrome)
				{
					highestPalindrome = product;					
					endNum = j;
					System.out.println(""+i+"*"+j+"="+product);
				}
			}
		}
		Calendar cal1 = Calendar.getInstance();
		System.out.println("Computation Time "+ (cal1.getTimeInMillis() - cal.getTimeInMillis()) + " ms");
	}
}