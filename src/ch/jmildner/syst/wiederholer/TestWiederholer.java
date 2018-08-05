package ch.jmildner.syst.wiederholer;

import ch.jmildner.tools.MyTools;

/**
 * Testklasse zum Testen des Interfaces Wiederholer in einer
 * Tabellenklasse.
 * 
 * Siehe auch Enumeration, Iterator
 * 
 * Enumeration: erste Realisierung eines Iterators
 * 
 * for(Enumeration en=ds.elements(); it.hasMoreElements();) {
 * System.out.println(it.nextElement(); }
 * 
 * boolean hasMoreElements(), Object nextElement()
 * 
 * Iterator: neuere Realisierung eines Iterators (besser ?)
 * 
 * for(Iterator it=ds.iterator(); it.hasNext();)
 * {System.out.println(it.next(); }
 * 
 * boolean hasNext(), Object next(), void remove()
 * 
 * @author Johann Mildner, Basel
 */
public class TestWiederholer
{
	/**
	 * @param args args
	 */
	public static void main(String[] args)
	{
		Tabelle t = new Tabelle();

		for (int i = 101; i <= 110; i++)
		{
			t.zufuegen(i + " text " + i);
		}

		Wiederholer w;
		w = t.wiederholer(0);
		w.loeschen();
		while (w.hatNochEinen())
		{
			String z = w.naechster();
			System.out.println(z);
			if (z.equals("105 text 105"))
			{
				System.out.println("vor loeschen");
				w.loeschen();
				w.loeschen();
				System.out.println("nach loeschen");
			}
		}

		MyTools.pause();
		w = t.wiederholer(0);
		while (w.hatNochEinen())
		{
			String z = w.naechster();
			System.out.println(z);
		}
	}
}
