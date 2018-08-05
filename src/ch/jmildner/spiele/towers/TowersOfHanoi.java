package ch.jmildner.spiele.towers;

import ch.jmildner.tools.MyTools;

public class TowersOfHanoi
{

	static int i = 0;
	static int Turmhoehe = 5;


	static String t[] = { ""+
			"0            *           ",
			"1           ***          ", 
			"2          *****         ",
			"3         *******        ", 
			"4        *********       ",
			"5       ***********      ", 
			"6      *************     ",
			"7     ***************    ", 
			"8    *****************   ",
			"9   *******************  ", 
			"a  ********************* ",
			"b ***********************", 
			"                         ",
			"                         ", 
			"                         ",
			"                         ", 
			"                         ",
			"                         ", 
			"                         ",
			"                         ",
			"                         ",
			"                         ", 
			"                         ",
			"                         ", 
			"                         ",
			"                         ", 
			"                         ",
			"                         ", 
			"                         ",
			"                         ", 
			"                         ",
			"                         ", 
			"                         ",
			"                         ", 
			"                         ",
			"                         ", 
			"                         " };


	static int top[] = { -1, Turmhoehe, Turmhoehe };


	static void msg(int q, int z)
	{
		System.out.println("");
		System.out.println(++i + "  bewege " + q + " nach " + z);

		t[z * 12 + top[z]] = t[q * 12 + ++top[q]];
		t[q * 12 + top[q]] = t[36];

		top[z]--;

		showTowers();
	}


	static void showTowers()
	{
		if (Turmhoehe < 5)
			MyTools.pause();

		for (int j = 0; j <= Turmhoehe; j++)
		{
			System.out.println(t[j + 0] + t[j + 12] + t[j + 24]);
		}

		System.out.println("" + 
				  "             0           "
				+ "             1           "
				+ "             2           ");
	}


	static void tow(int Q, int H, int Z, int n)
	{
		if (n == 0)
		{
			msg(Q, Z);
		}
		else
		{
			tow(Q, Z, H, n - 1);
			msg(Q, Z);
			tow(H, Q, Z, n - 1);
		}
	}


	public static void main(String args[])
	{
		System.out.println("Tuerme von Hanoi Turmhoehe: " + Turmhoehe);
		showTowers();
		tow(0, 1, 2, Turmhoehe);
	}
}
