package ch.jmildner.spiele.raetsel;

//---------------------------------------------
// programmname: Kryptarithmus
//
// autor: johann mildner, basel
//
// eve/div=.talktalktalk... periodisch
//
// Treffer: 242 / 303 = .7986798679867987
//---------------------------------------------

public class Kryptarithmus
{

	public static void main(String[] args)
	{
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.println("Kryptarithmus:");
		System.out.println("eve/div=.talktalktalk...  periodisch");
		System.out.println();

		for (int e = 0; e <= 9; e++)
		{
			for (int v = 0; v <= 9; v++)
			{
				for (int d = 0; d <= 9; d++)
				{
					for (int i = 0; i <= 9; i++)
					{
						berechnen(e, v, d, i);
					}
				}
			}
		}

		System.out.println("-----------------------------------------");
		System.out.println();
	}

	static int ggt(int eve, int did)
	{
		int g = eve, k = did;

		while (true)
		{
			if (g < k)
			{
				int zg = k, zk = g;
				g = zg;
				k = zk;
			}

			g = g - k;

			if (g == k)
			{
				return g;
			}
		}
	}

	static void berechnen(int e, int v, int d, int i)
	{
		int eve = e * 100 + v * 10 + e * 1;
		int did = d * 100 + i * 10 + d * 1;

		double ergebnis;

		if (did > 0 && eve > 0 && did > eve && ggt(eve, did) == 1)
		{
			ergebnis = (double) eve / (double) did;

			ergebnis = ergebnis * 10000;
			int p1 = (int) ergebnis;
			ergebnis = ergebnis - p1;

			ergebnis = ergebnis * 10000;
			int p2 = (int) ergebnis;
			ergebnis = ergebnis - p2;

			ergebnis = ergebnis * 10000;
			int p3 = (int) ergebnis;
			ergebnis = ergebnis - p3;

			if (p1 == p2 & p2 == p3) // periodisch
			{
				int t, a, l, k;

				t = p1 / 1000;
				p1 = p1 - t * 1000;

				a = p1 / 100;
				p1 = p1 - a * 100;

				l = p1 / 10;
				p1 = p1 - l * 10;

				k = p1 / 1;
				p1 = p1 - k * 1;

				if (verschieden(e, v, d, i, t, a, l, k))
				{
					System.out.println("Treffer:");
					System.out.println(eve + "/" + did + "=." + p2);
				}
			}
		}
	}

	static boolean verschieden(
		int e,
		int v,
		int d,
		int i,
		int t,
		int a,
		int l,
		int k)
	{
		if (e == v)
			return false;
		if (e == d)
			return false;
		if (e == i)
			return false;
		if (e == t)
			return false;
		if (e == a)
			return false;
		if (e == l)
			return false;
		if (e == k)
			return false;

		if (v == d)
			return false;
		if (v == i)
			return false;
		if (v == t)
			return false;
		if (v == a)
			return false;
		if (v == l)
			return false;
		if (v == k)
			return false;

		if (d == i)
			return false;
		if (d == t)
			return false;
		if (d == a)
			return false;
		if (d == l)
			return false;
		if (d == k)
			return false;

		if (i == t)
			return false;
		if (i == a)
			return false;
		if (i == l)
			return false;
		if (i == k)
			return false;

		if (t == a)
			return false;
		if (t == l)
			return false;
		if (t == k)
			return false;

		if (a == l)
			return false;
		if (a == k)
			return false;

		if (l == k)
			return false;

		return true;
	}

}
