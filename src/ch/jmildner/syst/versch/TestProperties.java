package ch.jmildner.syst.versch;

import java.util.Enumeration;
import java.util.Properties;

public class TestProperties
{
	public static void main(String[] args)
	{
		Properties p = new Properties();

		p.put("x", "xwert");
		p.put("y", new Double(4.711));

		Object wert = null;

		for (Enumeration<Object> i = p.keys(); i.hasMoreElements();)
		{
			wert = i.nextElement();
			System.out.println(wert + " " + p.get(wert));
		}
	}
}
