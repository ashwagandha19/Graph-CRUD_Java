import javax.swing.JPanel;

class Node extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x, y;
	String name;
	
	public Node(String myName, int myX, int myY) {
	    x = myX;
	    y = myY;
	    name = myName;
	}
	
	public Node() {
	    x = -1;
	    y = -1;
	    name = "";
	}
	public void setName(String _name)
	{
		name = _name;
		
	}
	public void setX(int _x)
	{
		x = _x;
		
	}
	public void setY(int _y)
	{
		y = _y;
	}
	public String getName()
	{
		return this.name;
    }

	
   }