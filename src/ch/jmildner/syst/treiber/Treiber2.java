package ch.jmildner.syst.treiber;

public class Treiber2 implements Treiber
{
	private static int x = 2222;

	static {
		System.out.println("static initialisierer Treiber2 ...");
		TreiberManager.registerTreiber(new Treiber2());
	}

	public int tuWas()
	{
		System.out.println("... aus Treiber1 ...");
		return x;
	}
}
