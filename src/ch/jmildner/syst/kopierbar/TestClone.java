package ch.jmildner.syst.kopierbar;

import ch.jmildner.tools.StoppUhr;

class Person implements Cloneable
{
	String name;


	Person(String name)
	{
		this.name = name;
	}


	public Person clone()
	{

		try
		{
			return (Person) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			throw new InternalError();
		}

	}
}



public class TestClone
{

	/**
	 * @param args args
	 */
	public static void main(String[] args)
	{
		StoppUhr su1 = new StoppUhr();
		su1.start("1. messung");

		for (int i = 1; i <= 10000000; i++)
		{
			new Person("hugo");
		}
		System.out.println(111);
		double d=su1.getDauer();
		System.out.println(d);

		Person p = new Person("hugo");
		StoppUhr su2 = new StoppUhr();

		for (int i = 1; i <= 10000000; i++)
		{
			p.clone();
		}

		System.out.println(222);
		su2.getDauer();
	}

}
