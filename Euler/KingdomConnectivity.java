import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.LinkedList;

public class KingdomConnectivity
{
	
	public static void main(String args[])
	{
		List<Vertex> nodes;
		List<Edge> edges;		
		String isVisited = "";

		String delimiter = " ";
		ArrayList<String> input = readInData();
 		String firstLine = input.get(0);
		int financial_capitol_id = 1;
                int warfare_capitol_id = Integer.parseInt((firstLine.split(delimiter))[0]);
                int no_of_roads = Integer.parseInt((firstLine.split(delimiter))[1]);

                //System.out.println(""+no_of_roads);

                //Form the Nodes
                nodes = new ArrayList<Vertex>();
                for(int i=1;i<= warfare_capitol_id; i++)
                {
                	Vertex location = new Vertex(i);
                	nodes.add(location);
                }

                //Form the Edges
                edges = new ArrayList<Edge>();
                for(int i=1;i<=no_of_roads;i++)
                {
                	String road = input.get(i);
                	int source = Integer.parseInt((road.split(delimiter))[0]);
                	int dest = Integer.parseInt((road.split(delimiter))[1]);        	
                	Edge lane = new Edge("Edge_"+i,nodes.get(source-1), nodes.get(dest-1));
                	edges.add(lane);
                }

                //Display the Nodes and Edges
                /*for(int i=0;i<no_of_roads;i++)
                {
                	System.out.println("Node "+ nodes.get(i).getValue());
                	System.out.println("Edge "+ edges.get(i).getSource().getValue() +"->"+edges.get(i).getDestination().getValue());
                }*/

                //Form the graph
                Graph graph = new Graph(nodes,edges);

                int no_of_paths = find_all_routes(graph,no_of_roads,warfare_capitol_id);
                System.out.println("No. of Routes "+ no_of_paths);
               
	}

        public static int find_all_routes(Graph graph, int no_of_roads, int endnode)
        {
                int total_routes = 0;
                ArrayList<LinkedList> pathlist = new ArrayList<LinkedList>();
                LinkedList<Vertex> vertexlist = new LinkedList<Vertex>();

                Vertex start = (graph.getVertexes()).get(0);                  
                vertexlist.add(start);
                pathlist.add(vertexlist);
                System.out.println( ((pathlist.get(0)).get(0)));
                /*java.util.Vector<Vertex> queue = new java.util.Vector<Vertex>();
                 //Start Iterating - BFS
                Vertex start = (graph.getVertexes()).get(0);                
                start.setVisited("Grey");
                queue.addElement(start);

                while(!queue.isEmpty())
                {
                        Vertex node_in_queue = queue.firstElement();
                        int node_value = node_in_queue.getValue();
                        //System.out.println("Queue Node Value "+ node_value);                        

                        for(int i=0;i<no_of_roads;i++)
                        {
                           if(node_value == (((graph.getEdges()).get(i)).getSource()).getValue())
                           {                                
                                Vertex node_to_traverse = ((graph.getEdges()).get(i)).getDestination();
                                //System.out.println("Node to Traverse "+ node_to_traverse.getValue()+"-"+node_to_traverse.getVisited());    
                                if(node_to_traverse.getVisited().equalsIgnoreCase("white"))
                                {                                    
                                    node_to_traverse.setVisited("Grey");
                                    queue.addElement(node_to_traverse);
                                }
                           }
                        }                        
                        node_in_queue.setVisited("Black");
                        queue.removeElement(node_in_queue);                        
                }            */    
                
               
               return total_routes;
        }

	public static ArrayList<String> readInData()
        {
                System.out.println("reading data");
                String inputLineToRead = "";
                ArrayList<String> inputData = new ArrayList<String>();
                try
                {                    
                    Scanner scanner = new Scanner(System.in);
                    while(scanner.hasNextLine())
                    {
                        inputLineToRead = scanner.nextLine();
                        inputData.add(inputLineToRead);                
                    }
                }
                catch(Exception e)
                {
                    System.out.println("IO Exception "+ e);
                }
                return inputData;
        }
}