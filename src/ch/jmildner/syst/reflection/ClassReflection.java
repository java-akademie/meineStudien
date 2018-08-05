package ch.jmildner.syst.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassReflection
{
	public static void main(String[] args)
			throws ClassNotFoundException
	{
		new ClassReflection();
	}


	ClassReflection() throws ClassNotFoundException
	{
		test1();
		test2("java.lang.Integer");
		test2("ch.jmildner.reflection.SuperClass");
		test2("ch.jmildner.reflection.SubClass");
		// test2("java.lang.Class");
	}


	private void printList(String s, Object[] o)
	{
		System.out.println("*** " + s + " ***");
		for (Object object : o)
		{
			System.out.println(object.toString());
		}
	}


	void test1()
	{
		System.out.println("Object    :" + Object.class);
		Number n;
		n = 555.5;
		System.out.println(n.getClass());
		n = 111;
		System.out.println(n.getClass());
	}


	void test2(String s) throws ClassNotFoundException
	{
		Class<?> c = Class.forName(s);

		@SuppressWarnings("rawtypes")
		Constructor[] constructors = c.getConstructors();
		printList("Constructors", constructors);

		Method[] methods = c.getMethods();
		printList("Methods", methods);

		Field[] fields = c.getFields();
		printList("Fields", fields);

		Field[] dfields = c.getDeclaredFields();
		printList("Declared Fields", dfields);
	}
}



class SubClass extends SuperClass
{
	int x;
	static int y;

}



class SuperClass
{
	public int a;
	protected static int b;
	final int fa = 0;
	final static int fb = 0;
	int[] aa = { 1, 2, 3 };
	String s = "hugo";
}
