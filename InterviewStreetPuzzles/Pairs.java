import java.util.*;
public class Pairs 
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        Map<Integer,Integer> hp = new HashMap<Integer,Integer>();
        int[] arr = new int[N];
        int pairs =0; int j=0; int tmppairs=0;
        for(int i=0;i<N;i++)
        {            
			j = scan.nextInt();
            hp.put(new Integer(j),new Integer(j));
        }        
		
		Iterator entries = hp.entrySet().iterator();
		while(entries.hasNext())
		{
			Map.Entry entry = (Map.Entry) entries.next();
			Integer key = (Integer)entry.getKey();			
			int newkey = key + K;				
			if(hp.containsKey(newkey))			
                pairs++;			
		}               
        
        System.out.println(pairs);
    }
}