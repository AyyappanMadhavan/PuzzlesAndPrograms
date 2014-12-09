import java.util.LinkedList;
import java.util.Calendar;
public class EulerProblem14
{
	public static void main(String args[])
	{
		Calendar cal = Calendar.getInstance();	
		long inputNum =0L;
		boolean loopflag = true;			
		LinkedList<Long> masterList = new LinkedList<Long>();

		for(long i =1000000L; i>0;i--)
		{			
			LinkedList<Long> sequenceList = new LinkedList<Long>();
			inputNum = i;
			loopflag = true;
			sequenceList.add(i);
			while(loopflag)
			{			
				if(inputNum%2 ==0)
				{
					//even logic
					inputNum = (inputNum/2);
					sequenceList.add(inputNum);		
				}
				else
				{
					//odd logic
					inputNum = (3*inputNum)+1;
					sequenceList.add(inputNum);
				}				
				if(inputNum == 1)
					loopflag = false;				
								
			}

			if(sequenceList.size() > masterList.size())
				masterList = sequenceList;				
		
		}

		System.out.println("Best Sequence : "+ masterList);
		Calendar cal1 = Calendar.getInstance();	
		System.out.println("\nComputation Time "+ (cal1.getTimeInMillis() - cal.getTimeInMillis()) + " ms");

	}
}