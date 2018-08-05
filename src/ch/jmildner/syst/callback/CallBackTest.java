package ch.jmildner.syst.callback;

public class CallBackTest
{
	public static void main(String args[])
	{
		CallBackTest callbackTest = new CallBackTest();
		new CallBack(callbackTest);
	}

	public void cbFunktion(String s)
	{
		System.out.println("---callbackTest: " + s);
	}
}
