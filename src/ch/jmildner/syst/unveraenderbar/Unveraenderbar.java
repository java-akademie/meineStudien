package ch.jmildner.syst.unveraenderbar;

final class Personx
{
	public static Personx getInstance(int id, String name)
	{
		return new Personx(id, name);
	}

	final int id;

	final String name;


	private Personx(int id, String name) // private oder nicht ?
	{
		this.id = id;
		this.name = name;
	}


	public void show()
	{
		System.out.println(id + " " + name);
	}
}



public class Unveraenderbar
{

	public static void main(String[] args)
	{
		Personx p;
		p = Personx.getInstance(33, "hugo");
		p.show();
		p = Personx.getInstance(34, "hugo");
		p.show();
		//p = new Personx(111, "xxx");
		//p.show();
	}
}
