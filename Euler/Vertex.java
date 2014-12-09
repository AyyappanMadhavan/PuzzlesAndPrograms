//package GraphTraverser;
public class Vertex
{			
		private int vertexId;	
		private String visited;

		public Vertex(int value) 
		{
			this.vertexId = value;
			this.visited = "white";
		}
	
		public int getVertexId() 
		{
			return vertexId;
		}

		public void setVisited(String value)
		{
			this.visited = value;
		}

		public String getVisited()
		{
			return visited;
		}		
}