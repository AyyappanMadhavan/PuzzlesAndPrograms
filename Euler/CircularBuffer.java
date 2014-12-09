import java.util.Scanner;

public class CircularBuffer
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int bufsize = scan.nextInt();
        int idxmin = 0;
        int idxmax = bufsize - 1;
        String[] arr = new String[bufsize];
        scan.nextLine();
        String input,temp; String[] parms = new String[2];
        boolean overflow = false;
        int head = -1; int tail = -1; int itemsincommand = 0;
        do
        {
            input = scan.nextLine();
            parms = input.split(" ");
            if(parms[0].equalsIgnoreCase("A"))
            {
                System.out.println("Append");
                itemsincommand = Integer.parseInt(parms[1]);
                for(int i=0;i<itemsincommand;i++)
                {
                    temp = scan.nextLine();
                    if(!overflow)
                    {
                    	if(head == -1)
                        	head++;
                        if(tail < idxmax)
                        {
                            tail++;
                        }
                        else
                        {
                            overflow = true;
                            tail = 0;
                            if(tail == head)
                        	{
                        		if(head < idxmax)
                        			head++;
                        		else
                        			head = 0;
                        	}  
                        }
                        arr[tail] = temp;
                    }
                    else
                    {
                        if(tail<idxmax)
                        {
                        	tail++;
                        	if(tail == head)
                        	{
                        		if(head < idxmax)
                        			head++;
                        		else
                        			head = 0;
                        	}                        	
                        }                        
                        else 
                        {
                        	tail = 0;
                        	if(tail == head)
                        	{
                        		if(head < idxmax)
                        			head++;
                        		else
                        			head = 0;
                        	} 
                        	//head = 1;
                        }                        
                        arr[tail] = temp;
                    }

                }
                System.out.println("head = "+head);
                System.out.println("tail = "+tail);
            }
            else if (parms[0].equalsIgnoreCase("L"))
            {                
            	System.out.println("List");
            	System.out.println("head = "+head);
                System.out.println("tail = "+tail);
                if(head != -1 && tail != -1)
                {
                    if(!overflow)
                    {
                        for(int i=head;i<=tail;i++)
                            System.out.println(arr[i]);
                    }
                    else
                    {
                        if(head > tail)
                        {                            
                            for(int i=head;i<=idxmax;i++)
                                System.out.println(arr[i]);                         
                            for(int j=idxmin;j<=tail;j++)
                                System.out.println(arr[j]);
                        }
                        else
                        {                            
                            for(int j=head;j<=tail;j++)
                                System.out.println(arr[j]);
                        }
                        
                    }
                }
                else
                {
                    System.out.println("list is empty");
                }
            }
            else if (parms[0].equalsIgnoreCase("R"))
            {
                System.out.println("Remove");
                boolean lastelem = false;
                itemsincommand = Integer.parseInt(parms[1]);
                if(itemsincommand >= bufsize)
                {
                    head = tail = -1;
                    overflow = false;
                }
                else if (head <= tail && (head - tail == 0))
                {
                	head = tail = -1;
                    overflow = false;
                }
                else
                {
                    for(int i=0;i<itemsincommand;i++)
                    {
                        if(head < idxmax)
                        {
                            head++;
                            if(head == tail)
                            {
                            	lastelem = true;
                            	continue;
                            }
                            if(lastelem)
                            {
                            	head = -1;tail =-1; //list has become empty
                            	 overflow = false;
                            }
                        }
                        else
                        {
                            head = 0;
                            if(head == tail)
                            {
                            	lastelem = true;
                            	continue;
                            }
                            if(lastelem)
                            {
                            	head = -1;tail =-1; //list has become empty
                            	 overflow = false;
                            }
                        }
                        //arr[head] = "";
                    }                    
                }
                System.out.println("head = "+head);
                System.out.println("tail = "+tail);
            }
        }while(!parms[0].equalsIgnoreCase("Q"));
    }
}
