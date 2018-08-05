package ch.jmildner.syst.introspection;

public class Person
{
	private int id;
	private String name;


	public Person()
	{
	}


	protected Person(int i)
	{
		id = i;
	}


	public Person(int id, String name)
	{
		this.id = id;
		this.name = name;
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


	public int getId()
	{
		return id;
	}


	public String getName()
	{
		return name;
	}


	public void setId(int id)
	{
		this.id = id;
	}


	public void setName(String name)
	{
		this.name = name;
	}
}
