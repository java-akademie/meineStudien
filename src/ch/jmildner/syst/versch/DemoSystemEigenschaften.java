package ch.jmildner.syst.versch;

import java.util.Properties;

public class DemoSystemEigenschaften
{
	public static void main(String[] args)
	{
		System.out.println("Systemeigenschaften");
		System.out.println("-------------------");
		Properties p = System.getProperties();
		p.list(System.out);
		System.out.println("-------------------");
	}
}
