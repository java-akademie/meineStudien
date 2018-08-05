package ch.jmildner.spiele.schiebespiel;

import java.util.Set;

final public class Tool
{
	private static boolean debug=false;

	private Tool(){}

	final static int getRandom(int min, int max)
	{
		if (!(max > min) || max - min + 1 < 0)
		{
			max = 0x7fffffff;
			min = 1;
		}

		return (int) (min + (Math.random() * (max - min + 1)));
	}

	final static String getZufall()
	{
		String z="";
		for(int i=1; i<=8; i++)
		{
			while(true)
			{
				int x=getRandom(1,8);
				int ix=z.indexOf(x+"");
				if(ix==-1)
				{
					z=z+x;
					break;
				}
			}
		}
		z=z+" ";
		return z;
	}


	final static boolean debug(String s)
	{
		if(debug)
		{
			System.out.print(s);
		}
		return debug;
	}


	final static void debug1(String s)
	{
			System.out.println(s);
	}

	final static void debug2(String s)
	{
			System.out.print(s);
	}


	final static boolean debugln(String s)
	{
		if(debug)
		{
			System.out.println(s);
		}
		return debug;
	}


	static boolean vorhanden(Set<?> set, String neu)
	{
		if (set.contains(neu))
			return true;
		else
			return false;
	}


	static String schiebe(String s, int v, int n)
	{
		n--;
		v--;
		char c = s.charAt(n);
		StringBuffer sb = new StringBuffer(s);
		sb.setCharAt(v, c);
		sb.setCharAt(n, ' ');
		return sb.toString();
	}
}