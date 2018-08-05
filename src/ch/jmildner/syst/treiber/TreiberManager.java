package ch.jmildner.syst.treiber;

/**
 * dient dem Kennenlernen der Art und Weise wie TreiberManager diverse Treiber
 * zur Laufzeit laden und diese Treiber dann verwenden
 * 
 * @author Johann Mildner, Basel
 */
public class TreiberManager
{
	public static Treiber treiber;

	/**
	 * do not instantiate
	 */
	private TreiberManager()
	{
	}

	/**
	 * Registriert einen beliebigen Treiber der die 
	 * Schnittstelle "Treiber" implementiert
	 */
	static void registerTreiber(Treiber treiber)
	{
		TreiberManager.treiber = treiber;
		System.out.println("treiberManager: registerTreiber() ...");
	}

	/**
	 * Demonstration einer Methode eines Treibers
	 */
	static void show()
	{
		System.out.println(
			"... aus TreiberManager ... treiber.tuWas(): "
				+ treiber.tuWas()
				+ " ... "
				+ treiber);
	}
}
