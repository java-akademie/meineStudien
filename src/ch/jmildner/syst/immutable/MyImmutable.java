package ch.jmildner.syst.immutable;

public class MyImmutable
{
	private int id;
	private String[] werte;


	public MyImmutable(int id, String[] werte)
	{
		this.id = id;
		if (werte == null)
			this.werte = null;
		else
			this.werte = werte.clone();
	}


	public int getId()
	{
		return id;
	}


	public String getWert(int index) throws Exception
	{
		if (werte.length < index)
			throw new Exception("index zu gross");

		return werte[index];
	}


	public void show()
	{
		System.out.println(id);
		for (String s : werte)
		{
			System.out.println(s);
		}
	}
}
