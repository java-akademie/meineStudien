package ch.jmildner.syst.immutable;

public class TestMyImmutable
{
	public static void main(String[] args)
	{
		double erg = 1 / 0.0;

		erg = Math.pow(-1, 0.5);
		if (Double.isNaN(erg))
			System.out.println("1111nanananana");
		else
			System.out.println("2222nanananana");

		System.out.println(erg);

		int id = 4711;
		String[] werte = { "hugo", "max", "moritz" };

		MyImmutable mi = new MyImmutable(id, werte);
		werte[0] = "xxx";

		mi.show();

		try
		{
			System.out.println("wert: " + mi.getWert(0));
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
