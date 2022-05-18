import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



class testGraphDraw {
    //Here is some example syntax for the GraphDraw class
    public static void main(String[] args) {
    	
    	
    //start frame and panel construction	
    	JFrame jframe = new JFrame("Control Panel");
    	jframe.setVisible(true);
    	jframe.setSize(410,600);
    	
	GraphDraw frame = new GraphDraw("Sample");

	frame.setSize(410,600);
	frame.setVisible(true);
	JButton addBtn = new JButton("Add node");
	TextField nodeName = new TextField("", 6);
	TextField nodeX = new TextField("100", 6);
	TextField nodeY = new TextField("150", 6);
	TextField node1 = new TextField("0", 6);
	TextField node2 = new TextField("0", 6);
	TextField value = new TextField("0", 6);
	JButton addBtnE = new JButton("Add edge");
	JButton addBtnEdit = new JButton("Edit node");
	JButton removeBtnN = new JButton("Remove node");
	JButton removeBtnE = new JButton("Remove edge");
	TextField searched_node = new TextField("", 6);
	TextField searched_nodeToRemove = new TextField("", 6);
	TextField searched_edgeToRemove = new TextField("", 6);
	TextField new_nodeName = new TextField("", 6);
	TextField new_nodeX = new TextField("0", 6);
	TextField new_nodeY = new TextField("0", 6);
	JPanel panel = new JPanel();
	jframe.add(panel);
	panel.add(addBtn);
	panel.add(nodeName);
	panel.add(nodeX);
	panel.add(nodeY);
	panel.add(addBtnE);
	panel.add(node1);
	panel.add(node2);
	panel.add(value);
	panel.add(addBtnEdit);
	panel.add(searched_node);
	panel.add(new_nodeName);
	panel.add(new_nodeX);
	panel.add(new_nodeY);
	panel.add(removeBtnN);
	panel.add(searched_nodeToRemove);
	panel.add(removeBtnE);
	panel.add(searched_edgeToRemove);
	//end frame and panel construction
	
	
	//start add btn listeners for adding nodes and edges
	addBtn.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){
	    	String textOX = nodeX.getText();
	    	int ox = Integer.parseInt(textOX);
	    	String textOY = nodeY.getText();
	    	int oy = Integer.parseInt(textOY);
	    	frame.addNode(nodeName.getText(), ox,oy); 
	    	System.out.println(ox);
	    	System.out.println(oy);    
	    }  
	    });
	addBtnE.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){
	    	String textOX = node1.getText();
	    	int ox = Integer.parseInt(textOX);
	    	String textOY = node2.getText();
	    	int oy = Integer.parseInt(textOY);
	    	frame.addEdge(ox,oy, value.getText()); 
	    	System.out.println(ox);
	    	System.out.println(oy);
	    }  
	    });
	//end add btn listeners for adding nodes and edges
	
	
	//start edit node btn
	addBtnEdit.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){
	    	for(Node i:frame.nodes)
	    	{
	    		if(i.getName().equals(searched_node.getText()) )
	    		{
	    			String textOX = new_nodeX.getText();
	    	    	int ox = Integer.parseInt(textOX);
	    	    	String textOY = new_nodeY.getText();
	    	    	int oy = Integer.parseInt(textOY);
	    			i.setName(new_nodeName.getText());
	    			i.setX(ox);
	    			i.setY(oy);
	    			frame.repaint();
	    		}
	    	}
	
	    }  
	    });
	//end edit node btn
	
	
	//start remove btn listeners for adding nodes and edges
	removeBtnN.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){
	    	
	  
	    		System.out.println("Seintra?");
	    		frame.removeNode(searched_nodeToRemove.getText());
	    		frame.repaint();
	    		frame.setVisible(false);
	    		frame.setVisible(true);
	    		
	    }
	 
	    });
	
	removeBtnE.addActionListener(new ActionListener(){  
	    public void actionPerformed(ActionEvent e){
	    	
	    	for(Node i:frame.nodes)
	    	{
	    		
	    		System.out.println(i.getName());
	    	
	    		if(i.getName().equals(searched_edgeToRemove.getText()) )
	    		{
	    			frame.removeEdge(frame.nodes.indexOf(i));
	    			
	    		}
	    	
	    	}
	    	
	    	frame.repaint();
	    	frame.setVisible(false);
	        frame.setVisible(true);
	    
	    	
	    }
	    });
	//end remove btn listeners for adding nodes and edges
    }
}