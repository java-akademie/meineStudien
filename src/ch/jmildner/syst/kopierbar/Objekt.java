package ch.jmildner.syst.kopierbar;

public class Objekt
{
	protected Objekt kopieren()
	{
		if (this instanceof Kopierbar)
		{
			System.out.println("kopieren moeglich");
		}
		else
		{
			System.out.println("kopieren nicht moeglich");
		}
		return new X();
	}
}
