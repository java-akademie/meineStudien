package ch.jmildner.message;

public class Test
{
	public static void main(String[] args)
	{

		System.out.println((Messages.getString("start"))); //$NON-NLS-1$
		String s = Messages.getString("hallo"); //$NON-NLS-1$
		String x = Messages.getString("fritz"); //$NON-NLS-1$
		String y = Messages.getString("franz"); //$NON-NLS-1$
		System.out.println(s);
		System.out.println(x);
		System.out.println(y);
	}

}
