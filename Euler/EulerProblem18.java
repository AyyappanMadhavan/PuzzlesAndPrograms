import java.util.ArrayList;
import java.util.List;

public class EulerProblem18 
{
	public static void main(String args[])
	{
		int rows = 15;
		int no_of_possible_routes = (int)(Math.pow(2,rows-1));
		int[] numArray = {75,95,64,17,47,82,18,35,87,10,20,4,82,47,65,19,1,23,75,3,34,88,2,77,73,7,63,67,99,65,4,28,6,16,70,92,41,41,26,56,83,40,80,70,33,41,48,72,33,47,32,37,16,94,29,53,71,44,65,25,43,91,52,97,51,14,70,11,33,28,77,73,17,78,39,68,17,57,91,71,52,38,17,14,91,43,58,50,27,29,48,63,66,4,68,89,53,67,30,73,16,69,87,40,31,4,62,98,27,23,9,70,98,73,93,38,53,60,4,23};
		
		List<Vertex> nodes;
		List<Edge> edges; 	
		/*@SuppressWarnings("unchecked")
		ArrayList<Integer>[] triangleArray = new ArrayList[rows];*/
		int idx = -1;	int j=0; int cols = 1; int tempValue = 0; 


		//Load the triangle		
		nodes = new ArrayList<Vertex>();
		for(int i=0;i<rows;i++)
		{
			Vertex Location = new Vertex("Node_"+i,numArray[i]);
			nodes.add(Location);
		}

		for(int i=0;i<rows;i++)
			System.out.println(""+nodes.get(i).getId());
		/*for(int i=0;i<rows;i++)		
		{
			triangleArray[i] = new ArrayList<Integer>();
			j=0;						
			do
			{
				tempValue = numArray[++idx];										
				//triangleArray[i].add(tempValue);
				//Vertex Location = new Vertex("Node_"+idx, tempValue);	
				//nodes.add(Location);	
				j++;
			}	    
			while(j<cols);		
			cols++;
		}		
				
		for(int i=0;i<rows;i++)	
		{
			System.out.println(triangleArray[i]);
		}

		//Find the routes..
		int sum=0; cols = 0; int prevSum = 0;
		StringBuffer bestroute = new StringBuffer("");
		String bestroute_str = "";
		int bestroute_sum = 0;
		for(int num=0;num<no_of_possible_routes;num++)
		{
			sum = triangleArray[0].get(0);
			cols = 0;
			for(int r=1; r<=rows;r++)
			{
				if(num%2 == 0)
				   cols = cols + 1;
				num = num/2;
				sum = sum + triangleArray[r].get(cols);
				bestroute.append((triangleArray[r].get(cols)).toString() + "->");
			}

			if(sum > prevSum)
			{
				bestroute_str = bestroute.toString();
				bestroute_sum = sum;			
			}
			else
			{
				prevSum = sum;
			}
		}

		System.out.println("Best Route is "+ bestroute_str);
		System.out.println("Sum of numbers in best route is "+ bestroute_sum);*/
	}	
}

