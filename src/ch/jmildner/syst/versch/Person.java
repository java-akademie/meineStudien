package ch.jmildner.syst.versch;

public class Person
{
	private int id;
	private String name;

	protected Person(int i)
	{
		id = i;
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

	public Person()
	{
	}

	public Person(int id, String name)
	{
		this.id = id;
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
