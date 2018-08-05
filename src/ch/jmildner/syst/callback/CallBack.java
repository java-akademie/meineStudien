package ch.jmildner.syst.callback;

public class CallBack  implements CallBackInterface
{
	private CallBackTest ziel;

	CallBack(CallBackTest ziel)
	{
		System.out.println("dies ist der konstruktor von callback");
		this.ziel = ziel;
		ziel.cbFunktion("aufgerufen aus dem Callback-Konstruktor");
		run();
	}

	public void run()
	{
		if (ziel != null)
		{
			System.out.println("callback.run:");
			ziel.cbFunktion("aufgerfufen aus run (callback)");
		}
		else
		{
			System.out.println("kein target.run verfuegbar");
		}
	}
}
