import java.util.*;
import java.awt.*;
import javax.swing.*;

public class GraphDraw extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width;
    int height;

    ArrayList<Node> nodes;
    ArrayList<Edge> edges;

    public GraphDraw() { //Constructor
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	nodes = new ArrayList<Node>();
	edges = new ArrayList<Edge>();
	width = 30;
	height = 30;
    }

    public GraphDraw(String name) { //Construct with label
	this.setTitle(name);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	nodes = new ArrayList<Node>();
	edges = new ArrayList<Edge>();
	width = 30;
	height = 30;
    }

    
    public void addNode(String name, int x, int y) { 
	//add a node at pixel (x,y)
	nodes.add(new Node(name,x,y));
	this.repaint();
    }
    
    public void addEdge(int i, int j, String value) {
	//add an edge between nodes i and j
	edges.add(new Edge(i,j, value));
	this.repaint();
    }
    
    public void removeNode(String name)
    {
    	 Iterator<Node> iter = nodes.iterator();
         while (iter.hasNext()) {
             Node n = iter.next();
             if (n.getName().equals(name)) 
                 iter.remove();
         }
         this.revalidate();
         this.repaint();
    }
    
    public void removeEdge(int index)
    {
        Iterator<Edge> iter = edges.iterator();
        while (iter.hasNext()) {
            Edge p = iter.next();
            if (p.i == index || p.j == index) 
                iter.remove();
        }
        this.revalidate();
        this.repaint();
        
    }
    
    public void printnodes()
    {
    	for(Node i :nodes)
    	{
    		System.out.println(i.getName() + " " + i.getX() + " " + i.getY());
    	}
    }
    
    public void paint(Graphics g) { // draw the nodes and edges
    g.setColor(getBackground());
    g.fillRect(0, 0, getWidth(), getHeight());
    g.setColor(getForeground());
	FontMetrics f = g.getFontMetrics();
	int nodeHeight = Math.max(height, f.getHeight());

	g.setColor(Color.black);
	for (Edge e : edges) {
	    g.drawLine(nodes.get(e.i).x, nodes.get(e.i).y,
		     nodes.get(e.j).x, nodes.get(e.j).y);
	    g.drawString(e.value, (nodes.get(e.i).x+nodes.get(e.j).x)/2, (nodes.get(e.i).y + nodes.get(e.j).y)/2);
	}

	for (Node n : nodes) {
	    int nodeWidth = Math.max(width, f.stringWidth(n.name)+width/2);
	    g.setColor(Color.white);
	    g.fillOval(n.x-nodeWidth/2, n.y-nodeHeight/2, 
		       nodeWidth, nodeHeight);
	    g.setColor(Color.black);
	    g.drawOval(n.x-nodeWidth/2, n.y-nodeHeight/2, 
		       nodeWidth, nodeHeight);
	    
	    g.drawString(n.name, n.x-f.stringWidth(n.name)/2,
			 n.y+f.getHeight()/2);
	}
    }
}

