import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;

public class ReadOutlook
{
	public static void main(String args[])
	{
		Folder inbox;

		try
		{
			Properties props = System.getProperties();
     		props.setProperty("mail.store.protocol", "imaps"); 
     		Session session = Session.getDefaultInstance(props, null);
     		Store store = session.getStore("imaps");
     		System.out.println("connecting");
     		store.connect("10.81.88.93","ayyappan_m@infosys.com", "VerizonAAA1!");
     		System.out.println("connected");
     		inbox = store.getFolder("Inbox");
     		System.out.println("No of Unread Messages : " + inbox.getUnreadMessageCount());
     		inbox.open(Folder.READ_ONLY);

     	/*  Get the messages which is unread in the Inbox*/
     		Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
     		System.out.println(messages);
		}
		catch(Exception e)
		{
			System.out.println("Exception caught!! "+e);
		}
		

     	
	}
}

	 
