package ch.jmildner.datum;

public class Datum
{
	private static int beginnZeitrechnung = 1;
	private static int endeZeitrechnung = 9999;
	private int t, m, j;
	private int d; // anzahl tage seit beginnZeitrechnung


	public Datum(int t, int m, int j) throws Exception
	{
		if (!datumOK(t, m, j))
		{
			throw new Exception("datum falsch " + "(" + t + "." + m
					+ "." + j + ")");
		}

		this.t = t;
		this.m = m;
		this.j = j;

		tagErmitteln();
	}


	public int getTag()
	{
		return d;
	}


	public static void show(int t, int m, int j, int d)
	{
		String tt, mm, jj;
		tt = ed(t, 2);
		mm = ed(m, 2);
		jj = ed(j, 4);
		System.out.println(tt + "." + mm + "." + jj + "  " + d);
	}


	public void show()
	{
		String tt, mm, jj;
		tt = ed(t, 2);
		mm = ed(m, 2);
		jj = ed(j, 4);
		System.out.println(tt + "." + mm + "." + jj + "  " + d);
	}


	private static String ed(int i, int a)
	{
		String s = "" + i;
		while (true)
		{
			if (s.length() >= a)
			{
				return s;
			}
			else
			{
				s = "0" + s;
			}
		}
	}


	public void datumErmitteln()
	{
		int zj = 0, zm = 0, zt = 0, zd = 0;
		zd = d;
		for (int i = beginnZeitrechnung; zd >= (schaltjahr(i) ? 366
				: 365); i++)
		{
			zj = i;
			zd = zd - (schaltjahr(i) ? 366 : 365);
		}
		if (zd == 0)
		{
			zm = 12;
			zt = 31;
		}
		else
		{
			zj++;
			zm++;
			for (int i = 1; zd >= (monatsLetzter(i, zj)); i++)
			{
				zm++;
				zd = zd - (monatsLetzter(i, zj));
			}
			if (zd > 0)
			{
				zt = zd;
				zd = 0;
			}
		}
		show(zt, zm, zj, d);
	}


	private void tagErmitteln()
	{
		d = 0;
		for (int i = beginnZeitrechnung; i < j; i++)
		{
			if (schaltjahr(i))
			{
				d = d + 366;
			}
			else
			{
				d = d + 365;
			}
		}
		for (int i = 1; i < m; i++)
		{
			d = d + monatsLetzter(i, j);
		}
		d = d + t;
	}


	public void addTage(int z)
	{
		for (int i = 1; i <= z; i++)
		{
			addTag();
		}
	}


	private void addTag()
	{
		d++;
		t++;
		if (!datumOK(t, m, j))
		{
			t = 1;
			m++;
			if (!datumOK(t, m, j))
			{
				m = 1;
				j++;
			}
		}
	}


	private boolean datumOK(int t, int m, int j)
	{
		if (j < beginnZeitrechnung)
		{
			return false;
		}
		if (j > endeZeitrechnung)
		{
			return false;
		}
		if (m < 1 || m > 12)
		{
			return false;
		}
		if (t < 1 || t > monatsLetzter(m, j))
		{
			return false;
		}
		return true;
	}


	private boolean schaltjahr(int j)
	{
		if (j % 400 == 0)
		{
			return true;
		}
		if (j % 100 == 0)
		{
			return false;
		}
		if (j % 4 == 0)
		{
			return true;
		}
		return false;
	}


	private int monatsLetzter(int m, int j)
	{
		int ml;
		switch (m)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				ml = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				ml = 30;
				break;
			default:
				if (schaltjahr(j))
				{
					ml = 29;
				}
				else
				{
					ml = 28;
				}
				break;
		}
		return ml;
	}
}
