package ch.jmildner.syst.versch;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Introspection2
{

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException
	{
		test1(new Person().getClass());
		test1(new Mitarbeiter().getClass());

		test2(new Mitarbeiter().getClass());
	}

	static void test2(Class<?> c)
	{
		System.out.println("\n\nTest2");
		System.out.println("Klasse     : " + c);
		System.out.println("SuperKlasse: " + c.getSuperclass());
	}

	static void test1(Class<?> c) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException
	{
		System.out.println("\n\nTest1");
		System.out.println("Klasse     : " + c);
		System.out.println("SuperKlasse: " + c.getSuperclass());

		testFields(c);
		testMethods(c);
		testConstructors(c);
	}

	static void testFields(Class<?> c)
	{
		Field[] x;
		System.out.println("\ngetFields()");
		x = c.getFields();
		for (int i = 0; i < x.length; i++)
		{
			System.out.println(x[i]);
		}
		System.out.println("\ngetDeclaredFields()");
		x = c.getDeclaredFields();
		for (int i = 0; i < x.length; i++)
		{
			System.out.println(x[i]);
		}
	}

	static void testMethods(Class<?> c) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException
	{
		Method[] x;
		System.out.println("\ngetMethods()");
		x = c.getMethods();
		for (int i = 0; i < x.length; i++)
		{
			System.out.println(x[i]);
		}
		System.out.println("\ngetDeclaredMethods()");
		x = c.getDeclaredMethods();
		for (int i = 0; i < x.length; i++)
		{
			System.out.println(i + ":" + x[i]);
			Object[] oa = new Object[1];

			x[3].invoke(new Object(), oa);
		}
	}

	static void testConstructors(Class<?> c)
	{
		@SuppressWarnings("rawtypes")
		Constructor[] x;
		System.out.println("\ngetConstructors()");
		x = c.getConstructors();
		for (int i = 0; i < x.length; i++)
		{
			System.out.println(x[i]);
		}
		System.out.println("\ngetDeclaredConstructors()");
		x = c.getDeclaredConstructors();
		for (int i = 0; i < x.length; i++)
		{
			System.out.println(x[i]);
		}
	}
}
