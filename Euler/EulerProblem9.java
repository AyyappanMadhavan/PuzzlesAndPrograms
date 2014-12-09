public class EulerProblem9
{
	public static void main(String args[])
	{
		//a^2 + b^2 = c^  Pythogorean Triplet
		int finalProduct = 0;		
		double c=0.0; double totalSum = 0;
		boolean exitFlag = false;
		for(double a=2;;a++)
		{
			for(double b= a+1;; b++)
			{
				c = Math.sqrt( (a*a) + (b*b) );

				totalSum = a+b+c;
				if(totalSum > 1000 || b>c)
				{					
					//exitFlag = true;
					break;
				}
				if( (b<c) && (totalSum== 1000))
				{					
					System.out.println("a = "+ a);
					System.out.println("b = "+ b);
					System.out.println("c = "+ c);
					System.out.println("Product of abc is "+ (int) (a*b*c));
					exitFlag = true;
					break;
				}
			}
			if(exitFlag)
				break;
		}
	}
}