package ch.jmildner.spiele.schiebespiel;

import java.util.Set;
import java.util.TreeSet;

public class Node
{
	static Set<String> set;
	static int zaehler;
	static String ziel;
	static Node root;

	String wert = "";
	String richtung = "x";
	int tiefe;

	Node parent, links, rechts, oben, unten;


	private Node(Node parent, String wert, String richtung, int tiefe)
	{
		Node.set.add(wert);

		this.parent = parent;
		this.wert = wert;
		this.richtung = richtung;
		this.tiefe = tiefe;

		// if(Tool.debug(" ...")){ show();}
	}


	Node(String wert, String ziel)
	{
		Node.root = this;
		Node.set = new TreeSet<String>();
		Node.set.add(wert);
		Node.zaehler = 0;
		Node.ziel = ziel;

		this.wert = wert;

		// if(Tool.debug("x...")){ show();}
	}


	void show()
	{
		String tx = "";

		for (int i = 0; i < tiefe; i++)
		{
			tx = tx + "  ";
		}

		System.out.println(richtung + " " + tiefe + " " + tx + "."
				+ wert);
	}


	void showTree()
	{
		System.out.println("-----");
		showTree(this);
	}


	static void showPath(Node n)
	{
		n.show();

		if (n.parent != null)
		{
			showPath(n.parent);
		}
	}


	static void showTree(Node n)
	{
		n.show();

		if (n.links != null)
			showTree(n.links);

		if (n.rechts != null)
			showTree(n.rechts);

		if (n.oben != null)
			showTree(n.oben);

		if (n.unten != null)
			showTree(n.unten);
	}


	static void checkTree(Node n, String ziel)
	{
		if (n.wert.equals(ziel))
		{
			System.out.println();
			Node.showPath(n);

			// int x=MyTools.getInteger("weiter 1=ja, 2=nein > ");

			// if(x!=1)
			System.exit(1);
		}
		else
		{
			// System.out.println(ziel);
			// n.show();
			if (n.links != null)
				checkTree(n.links, ziel);

			if (n.rechts != null)
				checkTree(n.rechts, ziel);

			if (n.oben != null)
				checkTree(n.oben, ziel);

			if (n.unten != null)
				checkTree(n.unten, ziel);
		}
	}


	static Node getNode(Node parent, String richtung)
	{
		int tiefe = parent.tiefe + 1;
		String alt = parent.wert;
		String neu = null;

		int i = alt.indexOf(" ");

		switch (i + 1)
		{
			case 1:
				if (richtung == "r" || richtung == "u")
				{
					if (richtung == "r")
					{
						neu = Tool.schiebe(alt, 1, 2);
					}
					if (richtung == "u")
					{
						neu = Tool.schiebe(alt, 1, 4);
					}
				}
				break;

			case 2:
				if (richtung == "l" || richtung == "r"
						|| richtung == "u")
				{
					if (richtung == "l")
					{
						neu = Tool.schiebe(alt, 2, 1);
					}
					if (richtung == "r")
					{
						neu = Tool.schiebe(alt, 2, 3);
					}
					if (richtung == "u")
					{
						neu = Tool.schiebe(alt, 2, 5);
					}
				}
				break;

			case 3:
				if (richtung == "l" || richtung == "u")
				{
					if (richtung == "l")
					{
						neu = Tool.schiebe(alt, 3, 2);
					}
					if (richtung == "u")
					{
						neu = Tool.schiebe(alt, 3, 6);
					}
				}
				break;

			case 4:
				if (richtung == "r" || richtung == "o"
						|| richtung == "u")
				{
					if (richtung == "r")
					{
						neu = Tool.schiebe(alt, 4, 5);
					}
					if (richtung == "o")
					{
						neu = Tool.schiebe(alt, 4, 1);
					}
					if (richtung == "u")
					{
						neu = Tool.schiebe(alt, 4, 7);
					}
				}
				break;

			case 5:
				if (richtung == "l" || richtung == "r"
						|| richtung == "o" || richtung == "u")
				{
					if (richtung == "l")
					{
						neu = Tool.schiebe(alt, 5, 4);
					}
					if (richtung == "r")
					{
						neu = Tool.schiebe(alt, 5, 6);
					}
					if (richtung == "o")
					{
						neu = Tool.schiebe(alt, 5, 2);
					}
					if (richtung == "u")
					{
						neu = Tool.schiebe(alt, 5, 8);
					}
				}
				break;

			case 6:
				if (richtung == "l" || richtung == "o"
						|| richtung == "u")
				{
					if (richtung == "l")
					{
						neu = Tool.schiebe(alt, 6, 5);
					}
					if (richtung == "o")
					{
						neu = Tool.schiebe(alt, 6, 3);
					}
					if (richtung == "u")
					{
						neu = Tool.schiebe(alt, 6, 9);
					}
				}
				break;

			case 7:
				if (richtung == "r" || richtung == "o")
				{
					if (richtung == "r")
					{
						neu = Tool.schiebe(alt, 7, 8);
					}
					if (richtung == "o")
					{
						neu = Tool.schiebe(alt, 7, 4);
					}
				}
				break;

			case 8:
				if (richtung == "l" || richtung == "r"
						|| richtung == "o")
				{
					if (richtung == "l")
					{
						neu = Tool.schiebe(alt, 8, 7);
					}
					if (richtung == "r")
					{
						neu = Tool.schiebe(alt, 8, 9);
					}
					if (richtung == "o")
					{
						neu = Tool.schiebe(alt, 8, 5);
					}
				}
				break;

			case 9:
				if (richtung == "l" || richtung == "o")
				{
					if (richtung == "l")
					{
						neu = Tool.schiebe(alt, 9, 8);
					}
					if (richtung == "o")
					{
						neu = Tool.schiebe(alt, 9, 6);
					}
				}
				break;

			default:
				break;
		}

		/**
		 * wenn neu nicht gefuellt ist, null zurueckgeben.
		 */
		if (neu == null)
		{
			return null;
		}

		/**
		 * neu ist gefuellt!
		 * 
		 * wenn es noch keinen Knoten mit dem neuen wert gibt, so ist
		 * der ein neuer Knoten zu erzeugen und zurueckzugeben. (suche
		 * im String-Vector wegen Geschwindigkeit)
		 */
		if (!Tool.vorhanden(set, neu))
		{
			return new Node(parent, neu, richtung, tiefe);
		}

		return null;


		/**
		 * neu ist gefuellt aber es gibt schon einen Knoten mit diesem
		 * Wert
		 * 
		 * es muss eventuell der schon vorhandene Knoten geloescht
		 * werden oder der neue Knoten nicht erzeugt werden.
		 * 
		 * Bedingung: ist der vorhandene Knoten tiefer als der neue
		 * Knoten, so ist der vorhandene Knoten zu loeschen und der neue
		 * Knoten zu erzeugen sonst ist der neue Knoten nicht zu
		 * erzeugen.
		 * 
		 */

		// if(tiefe(neu)>tiefe)
		// {
		// loeschen alten Knoten
		// loeschenKnoten(neu);
		// neuen Knoten erzeugen und zurueckgeben
		// return new Node(parent, neu, richtung, tiefe);
		// }
		// else
		// {
		// // alter Knoten bleibt bestehen
		// return null;
		// }
	}

	private static Node zwVater;
	private static Node zwSohn;
	private static int tf;


	static void checkTiefe(Node n, String wert)
	{
		if (n.wert.equals(wert))
		{
			tf = n.tiefe;
			zwVater = n.parent;
			zwSohn = n;
			return;
		}
		else
		{
			if (n.links != null)
				checkTiefe(n.links, wert);

			if (n.rechts != null)
				checkTiefe(n.rechts, wert);

			if (n.oben != null)
				checkTiefe(n.oben, wert);

			if (n.unten != null)
				checkTiefe(n.unten, wert);
		}

	}


	static int tiefe(String wert)
	{
		// aehnlich checkTree durchlaufen
		// moeglicherweise soll dieser Knoten
		// im naechsten Schritt geloescht werden
		// dazu muss der Vater zwischengespeichert werden
		// ebenso ist im naechsten Schritt der Sohn erforderlich
		// wegen o/u/l/r

		zwVater = null;
		zwSohn = null;
		tf = -1;

		checkTiefe(root, wert);

		// Tool.debugln("tiefe(" + wert + ")=" + tf);

		// if(tf==-1)
		// System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		return tf;
	}


	static void loeschenKnoten(String wert)
	{
		// Tool.debug1("knoten(" + wert + ") wird geloescht");
		// zwVater.show();
		// zwSohn.show();

		if (zwSohn.richtung.equals("l"))
		{
			zwVater.links = null;
		}
		if (zwSohn.richtung.equals("r"))
		{
			zwVater.rechts = null;
		}
		if (zwSohn.richtung.equals("o"))
		{
			zwVater.oben = null;
		}
		if (zwSohn.richtung.equals("u"))
		{
			zwVater.unten = null;
		}
		set.remove(wert);
	}
}
