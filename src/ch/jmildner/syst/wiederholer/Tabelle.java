package ch.jmildner.syst.wiederholer;

class Tabelle
{
	String[] tab;
	int anzahl;

	/**
	 * konstruiert eine Tabelle
	 */
	Tabelle()
	{
		tab = new String[10000];
		anzahl = 0;
	}

	void show()
	{
		System.out.println("");
		System.out.println("anzahl Elemente = " + anzahl);
		for (int i = 0; i < anzahl; i++)
		{
			System.out.println(tab[i]);
		}
		System.out.println("---------------------------");
	}

	/**
	 * fuegt einen String in die Tabelle ein
	 */
	void zufuegen(String x)
	{
		tab[anzahl++] = x;
	}

	/**
	 * Returns eine Referenz auf Wiederholer
	 */
	Wiederholer wiederholer(final int i)
	{
		System.out.println("es waere sogar ein Argument");
		System.out.println("moeglich .... " + i);
		Wiederholer w;
		w = new Wiederholer()
		{
			boolean loeschenMoeglich=false;
			boolean nextMoeglich=false;
			int index, rest;
			/**
			 * Initialisierer
			 */
			{
				index = i;
				rest = anzahl;
			}

			public boolean hatNochEinen()
			{
				if (rest == 0)
				{
					loeschenMoeglich=false;
					nextMoeglich=false;
					return false;
				}
				else
				{
					loeschenMoeglich=false;
					nextMoeglich=true;
					return true;
				}
			}

			public String naechster()
			{
				if(!nextMoeglich)
				{
					System.out.println("next nicht moeglich ... ");
					return "next nicht moeglich";
				}
				rest--;
				loeschenMoeglich=true;
				nextMoeglich=false;
				return tab[index++];
			}

			public void loeschen()
			{
				if(!loeschenMoeglich)
				{
					System.out.println("loeschen nicht moeglich ... ");
					return;
				}
				loeschenMoeglich=false;
				int ni = 0;
				String[] ztab = new String[10000];
				int c = index-1;
				for (int i = 0; i < anzahl; i++)
				{
					if (i != c)
					{
						System.out.println(
							"ni="
								+ ni
								+ " i="
								+ i
								+ ", ztab="
								+ ztab[ni]);
						ztab[ni++] = tab[i];
					}
				}
				anzahl = ni;
				rest--;
				tab = ztab;
				index--;
			}
		};
		return w;
	}
}
