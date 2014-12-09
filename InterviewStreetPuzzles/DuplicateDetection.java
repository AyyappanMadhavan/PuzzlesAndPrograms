import java.util.*;
public class DuplicateDetection
{
	public 	class Node
	{
		String lbl;
		ArrayList<String> adjacentList;
		boolean visited;
	}

	public static void main(String args[])
	{
		DuplicateDetection dd = new DuplicateDetection();

		String arr[] = {"ROVER BEACH,CA,93433,Distributed Inc.,08458734,annnemi@mail.com",	
					"ROVER BEACH,CA,93433,Distributed Inc.,989757546,domiusp@mail.com",
					"ROVER BEACH,CA,93433,Distributed Inc.,08458732,domiusp@mail.com",
					"ROVER BEACH,CA,93433,Distributed Inc.,987654321,abcd@mail.com",
					"ROVER BEACH,CA,93433,Distributed Inc.,989757546,abcd@mail.com"										
						};

		int N = arr.length;
		String phnum = "";
		String email = "";
		HashMap<String,Node> hp = new HashMap<String,Node>();
		
		for(int i=0;i<N;i++)
		{
			String tokens[] = arr[i].split(",");					
			phnum = tokens[4];
			email = tokens[5];	

			//First look if the nodes already exists
			boolean ph_fnd = hp.containsKey(phnum);
			boolean em_fnd = hp.containsKey(email);

			if(ph_fnd && em_fnd)		
				continue;
			else if(!ph_fnd && !em_fnd)
			{
				//create both ph and em nodes
				Node nd = dd.new Node();
				nd.visited = false;
				nd.lbl = phnum;				
				nd.adjacentList = new ArrayList<String>();
				nd.adjacentList.add(email);
				hp.put(phnum,nd);

				nd = dd.new Node();
				nd.visited = false;
				nd.lbl = email;
				nd.adjacentList = new ArrayList<String>();
				nd.adjacentList.add(phnum);
				hp.put(email,nd);
			}
			else if(ph_fnd && !em_fnd)
			{
				Node nd = dd.new Node();
				nd.lbl = email;
				nd.visited = false;
				nd.adjacentList = new ArrayList<String>();
				nd.adjacentList.add(phnum);
				hp.put(email,nd);

				nd = (Node)hp.get(phnum);
				nd.adjacentList.add(email);
			}
			else if(!ph_fnd && em_fnd)
			{
				Node nd = dd.new Node();
				nd.lbl = phnum;
				nd.visited = false;
				nd.adjacentList = new ArrayList<String>();
				nd.adjacentList.add(email);
				hp.put(phnum,nd);

				nd = (Node)hp.get(email);
				nd.adjacentList.add(phnum);
			}
			
		}
		System.out.println(hp.size());
		Set set = hp.entrySet();
		Iterator im = set.iterator();
		while(im.hasNext())
		{
			Map.Entry me = (Map.Entry)im.next();
			Node mName = (Node)me.getValue();
			System.out.println(mName.lbl + " " +mName.adjacentList);
		}

		String srchkey = "";
		for(Map.Entry<String,Node> entry : hp.entrySet())
		{
			srchkey = entry.getKey();
			Node node = (Node)entry.getValue();

			if(srchkey.equals(node.lbl) && node.visited == false)
			{
				node.visited = true;
				ArrayList al = (ArrayList)node.adjacentList;

			}
		}

		
	}
}
	

/*	package mainDraws;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DuplicateDetection {

	class Person{
		String personId;
		List<String> phone;
		List<String> email;	
		boolean duplicate;
		
		Person(){
			this.phone = new ArrayList<String>();
			this.email = new ArrayList<String>();
			duplicate = false;
			personId = "";
		}
		Person(String ph, String em, String id){
			this.phone.add(ph);
			this.email.add(em);
			this.personId = id;
		}
		@Override
		public String toString(){
			return this.personId+"|"+this.phone +"|"+this.email+"|"+duplicate;
		}
	}
	
	public static void main(String[] args) {
		DuplicateDetection dd = new DuplicateDetection();
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.nextLine();
		List<Person> personList = new ArrayList<Person>();
		int Id = -1;
		for(int i=0;i<N;i++){
			
			boolean emFnd = false;
			boolean phFnd = false;
			boolean addNewPerson = true;
			String whichoneIFndFirst = "";
			String ph_pid = "";
			String em_pid = "";
			
			String line = scan.nextLine();
			String ph_in = line.split(",")[4].toUpperCase().trim();
			String em_in = line.split(",")[5].toUpperCase().trim();
			
			//Look for email and phone in the list
			for(Person p: personList){				
					if(p.email.contains(em_in) && p.phone.contains(ph_in)){						
						addNewPerson = false;
						break;
					}
						
					if(p.email.contains(em_in)){
						if(whichoneIFndFirst.equalsIgnoreCase(""))
							whichoneIFndFirst = "EMAIL";
						addNewPerson = false;
						emFnd = true;
						em_pid = p.personId;
					}
					
					if(p.phone.contains(ph_in)){	
						if(whichoneIFndFirst.equalsIgnoreCase(""))
							whichoneIFndFirst = "PHONE";
						addNewPerson = false;
						phFnd = true;
						ph_pid = p.personId;
				    }					
					
					if(phFnd && emFnd)
						break;
			}		
			
			if(phFnd && emFnd){
				for(Person p:personList){
					if(whichoneIFndFirst.equalsIgnoreCase("PHONE")){
						if(p.personId.equalsIgnoreCase(em_pid)){
							p.duplicate = true;
							break;
						}
					}else{
						if(p.personId.equalsIgnoreCase(ph_pid)){
							p.duplicate = true;
							break;
						}
					}
				}
			}
			else if(emFnd){				
				for(Person p:personList){
					if(p.personId.equalsIgnoreCase(em_pid)){
						p.phone.add(ph_in);
						break;
					}
				}
			}
			else if(phFnd){
				for(Person p:personList){
					if(p.personId.equalsIgnoreCase(ph_pid)){
						p.email.add(em_in);
						break;
					}
				}
			}
			else if(addNewPerson){
				//Add a person			
				Person p = dd.new Person();
				p.email.add(em_in);
				p.phone.add(ph_in);	
				p.personId = String.valueOf(++Id);
				personList.add(p);  //Add to list
			}
		}
		int total=0;
		
		/*for(Person p: personList){
			System.out.println(p.toString());
			if(!p.duplicate){
				for(String ph: p.phone){
					for(Person p1:personList){
						if(!p1.duplicate){
							if(p1.personId != p.personId){
								if(p1.phone.contains(ph))
									p1.duplicate = true;
							}
						}
					}
				}
				for(String em: p.email){
					for(Person p1:personList){
						if(!p1.duplicate){
							if(p1.personId != p.personId){
								if(p1.email.contains(em))
									p1.duplicate = true;
							}
						}
					}
				}
			}
		}		*/
		for(Person p:personList){	
			System.out.println(p.toString());
			if(!p.duplicate)
				total++;
		}
		System.out.println(total);
	}
}*/
