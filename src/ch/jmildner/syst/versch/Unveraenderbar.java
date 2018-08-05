package ch.jmildner.syst.versch;

public class Unveraenderbar
{

	public static void main(String[] args)
	{
		Personx p;
		p = Personx.getInstance(33, "hugo");
		p.show();
		p = Personx.getInstance(34, "hugo");
		p.show();
	}
}


final class Personx
{
	final int id;
	final String name;

	private Personx(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public static Personx getInstance(int id, String name)
	{
		return new Personx(id, name);
	}

	public void show()
	{
		System.out.println(id + " " + name);
	}
}
