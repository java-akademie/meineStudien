package ch.jmildner.syst.versch;

public class Mitarbeiter extends Person
{
	public int zaehler;

	protected Mitarbeiter(int i)
	{
		super(i);
		zaehler++;
	}

	void foo1(int i)
	{
		System.out.println(i);
	}

	int foo2(int i)
	{
		System.out.println(i);
		return i * i;
	}

	public Mitarbeiter()
	{
		super();
	}

	public Mitarbeiter(int id, String name)
	{
		super(id, name);
	}

	public void show()
	{
		System.out.println(this.toString());
	}

	public String toString()
	{
		return super.getId() + "/" + super.getName();
	}
}
