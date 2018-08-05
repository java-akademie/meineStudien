package ch.jmildner.syst.treiber;

public class Treiber1 implements Treiber
{
	private static int x = 1111;

	static
	{
		System.out.println("static initialisierer Treiber1 ...");
		TreiberManager.registerTreiber(new Treiber1());
	}


	public int tuWas()
	{
		System.out.println("... aus Treiber1 ...");
		return x;
	}
}
