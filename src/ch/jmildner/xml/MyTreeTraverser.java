package ch.jmildner.xml;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class MyTreeTraverser
{
	private Node node;


	public MyTreeTraverser(Node node)
	{
		this.node = node;

//		test();	
//		if(true)return;
		
		displayName();
		displayValue();

		if (node.getNodeType() == Node.ELEMENT_NODE)
		{
			displayAttributes();
		}

		displayChildren();
	}


	private void displayChildren()
	{
		Node child = node.getFirstChild();

		while (child != null)
		{
			new MyTreeTraverser(child);
			child = node.getNextSibling();
		}
	}


	private void displayAttributes()
	{
		NamedNodeMap a = node.getAttributes();

		for (int i = 0; i < a.getLength(); i++)
		{
			System.out.printf("%nAttribute: %s = %s %n", a.item(i).getNodeName(),
					a.item(i).getNodeValue());
		}

	}


	private void displayValue()
	{
		String v = node.getNodeValue();
		if (v != null)
		{
			v = v.trim();
			out("Value: " + v);
		}
	}


	private void displayName()
	{
		out("Name : " + node.getNodeName());

	}


	private void out(String s)
	{

		System.out.println(s);
	}


	 void test()
	{
		
		System.out.println(node.getNodeName());
		
		node=node.getFirstChild();
		System.out.println(node.getNodeName());
		
		node=node.getNextSibling();
		System.out.println(node.getNodeName());
		
		node=node.getFirstChild();
		System.out.println(node.getNodeName());
		
		node=node.getNextSibling();
		System.out.println(node.getNodeName());
		
		System.out.println(111);	
		node=node.getFirstChild();
		System.out.println(node.getNodeName());
		
		System.out.println(222);	//person
		node=node.getNextSibling();
		System.out.println(node.getNodeName());
		
		System.out.println(333);	//txt
		node=node.getFirstChild();
		System.out.println(node.getNodeName());
		
		System.out.println(444);	// vorname	
		node=node.getNextSibling();
		System.out.println(node.getNodeName());
		
		System.out.println(445);	// txt	
		node=node.getNextSibling();
		System.out.println(node.getNodeName());
		
		System.out.println(446);	// nachname	
		node=node.getNextSibling();
		System.out.println(node.getNodeName());
		
		System.out.println(447);	// txt	
		node=node.getNextSibling();
		System.out.println(node.getNodeName());
		
		System.out.println(448);	// adresse	
		node=node.getNextSibling();
		System.out.println(node.getNodeName());
		
		System.out.println(555);	// txt
		node=node.getFirstChild();
		System.out.println(node.getNodeName());
		
		System.out.println(666);	// txt
		node=node.getParentNode();
		System.out.println(node.getNodeName());
		
		System.out.println(777);	// adresse	
		node=node.getNextSibling();
		System.out.println(node.getNodeName());

		
		System.out.println(777);	
		node=node.getNextSibling();
		System.out.println(node.getNodeName());
		
		System.out.println(444);	
		
	}

}
