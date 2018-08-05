package ch.jmildner.syst.properties;

import java.util.Enumeration;

public class SystemProperties
{
	public static void main(String[] args)
	{
		System.out.println("Java-Version: "
				+ System.getProperty("java.version"));
		// elements, keys, propertyNames
		for (Enumeration<?> e = System.getProperties().keys(); e
				.hasMoreElements();)
			// for (Enumeration
			// e=System.getProperties().elements();e.hasMoreElements();)
			// for (Enumeration
			// e=System.getProperties().propertyNames();e.hasMoreElements();)
			System.out.println(e.nextElement());
		System.getProperties().list(System.out);
	}
}
