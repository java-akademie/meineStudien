package ch.jmildner.spiele.schiebespiel;

public class Schiebespiel
{
	static int TIEFE = 1;
	static int MAX = 30;


	public static void main(String[] args)
	{
		System.out.println("Schiebespiel");
		System.out.println("------------\n");

		for (int i = 1; i <= 10; i++)
		{
			vera(i);
		}
	}


	static void vera(int i)
	{
		System.out.println("\n\n\nlauf: " + i);
		System.out.println("----------");
		System.out.println();

		String startwert = Tool.getZufall();
		String ziel = Tool.getZufall();

		// startwert="2831647 5";
		// ziel= "12345678 ";

		// startwert="2831647 5";
		// ziel= "1238 4765";

		// startwert="18354672 ";
		// ziel= "87654321 ";
		
		// startwert="23456718 ";
		// ziel="12345678 ";
		
		System.out.println("Startwert=" + startwert + "/");
		System.out.println(" Zielwert=" + ziel + "/");

		Tool.debug1("\nlauf: " + i + " 1");
		TIEFE = 1;
		while (true)
		{

			Tool.debug2(TIEFE + " ");

			Node tree = new Node(startwert, ziel);

			addNodes1(tree, TIEFE++);

			// tree.showTree();

			Node.checkTree(tree, ziel);

			if (TIEFE > MAX)
				break;
		}

		Tool.debug1("\nlauf: " + i + " 2");
		TIEFE = 1;
		while (true)
		{

			Tool.debug2(TIEFE + " ");

			Node tree = new Node(startwert, ziel);

			addNodes2(tree, TIEFE++);

			// tree.showTree();

			Node.checkTree(tree, ziel);

			if (TIEFE > MAX)
				break;
		}

		Tool.debug1("\nlauf: " + i + " 3");
		TIEFE = 1;
		while (true)
		{

			Tool.debug2(TIEFE + " ");

			Node tree = new Node(startwert, ziel);

			addNodes3(tree, TIEFE++);

			// tree.showTree();

			Node.checkTree(tree, ziel);

			if (TIEFE > MAX)
				break;
		}

		Tool.debug1("\nlauf: " + i + " 4");
		TIEFE = 1;
		while (true)
		{

			Tool.debug2(TIEFE + " ");

			Node tree = new Node(startwert, ziel);

			addNodes4(tree, TIEFE++);

			// tree.showTree();

			Node.checkTree(tree, ziel);

			if (TIEFE > MAX)
				break;
		}
	}


	static void addNodes1(Node p, int t)
	{
		if (--t == 0)
		{
			return;
		}

		Node n;

		if ((n = Node.getNode(p, "r")) != null)
		{
			p.rechts = n;
			addNodes1(n, t);
		}

		if ((n = Node.getNode(p, "l")) != null)
		{
			p.links = n;
			addNodes1(n, t);
		}

		if ((n = Node.getNode(p, "o")) != null)
		{
			p.oben = n;
			addNodes1(n, t);
		}

		if ((n = Node.getNode(p, "u")) != null)
		{
			p.unten = n;
			addNodes1(n, t);
		}
	}


	static void addNodes2(Node p, int t)
	{
		if (--t == 0)
		{
			return;
		}

		Node n;

		if ((n = Node.getNode(p, "l")) != null)
		{
			p.links = n;
			addNodes2(n, t);
		}

		if ((n = Node.getNode(p, "r")) != null)
		{
			p.rechts = n;
			addNodes2(n, t);
		}

		if ((n = Node.getNode(p, "u")) != null)
		{
			p.unten = n;
			addNodes2(n, t);
		}

		if ((n = Node.getNode(p, "o")) != null)
		{
			p.oben = n;
			addNodes2(n, t);
		}
	}


	static void addNodes3(Node p, int t)
	{
		if (--t == 0)
		{
			return;
		}

		Node n;

		if ((n = Node.getNode(p, "o")) != null)
		{
			p.oben = n;
			addNodes3(n, t);
		}

		if ((n = Node.getNode(p, "r")) != null)
		{
			p.rechts = n;
			addNodes3(n, t);
		}

		if ((n = Node.getNode(p, "u")) != null)
		{
			p.unten = n;
			addNodes3(n, t);
		}

		if ((n = Node.getNode(p, "l")) != null)
		{
			p.links = n;
			addNodes3(n, t);
		}
	}


	static void addNodes4(Node p, int t)
	{
		if (--t == 0)
		{
			return;
		}

		Node n;

		if ((n = Node.getNode(p, "u")) != null)
		{
			p.unten = n;
			addNodes3(n, t);
		}

		if ((n = Node.getNode(p, "r")) != null)
		{
			p.rechts = n;
			addNodes3(n, t);
		}

		if ((n = Node.getNode(p, "o")) != null)
		{
			p.oben = n;
			addNodes3(n, t);
		}

		if ((n = Node.getNode(p, "l")) != null)
		{
			p.links = n;
			addNodes3(n, t);
		}
	}
}
