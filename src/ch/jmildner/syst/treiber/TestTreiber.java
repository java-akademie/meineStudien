package ch.jmildner.syst.treiber;

import ch.jmildner.tools.MyTools;

public class TestTreiber
{
	public static void main(String[] args)
			throws ClassNotFoundException
	{
		int random = MyTools.getRandom(1, 2);

		System.out.println("------------------------------");

		if (random == 1)
		{
			Class.forName("ch.jmildner.syst.treiber.Treiber1");
		}
		else
		{
			Class.forName("ch.jmildner.syst.treiber.Treiber2");
		}

		TreiberManager.show();

		System.out.println("------------------------------");
	}
}
