package ch.jmildner.syst.introspection;

public class Mitarbeiter extends Person
{
	public int zaehler;


	public Mitarbeiter()
	{
		super();
	}


	protected Mitarbeiter(int i)
	{
		super(i);
		zaehler++;
	}


	public Mitarbeiter(int id, String name)
	{
		super(id, name);
	}


	@Override
	void foo1(int i)
	{
		System.out.println(i);
	}


	@Override
	int foo2(int i)
	{
		System.out.println(i);
		return i * i;
	}


	public void show()
	{
		System.out.println(this.toString());
	}


	@Override
	public String toString()
	{
		return super.getId() + "/" + super.getName();
	}
}
