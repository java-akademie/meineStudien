package ch.jmildner.spiele.lotto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class LottoPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	LottoFrame lottoFrame;
	boolean test = false;
	int zZiehungen, zDreier, zVierer, zFuenfer, zSechser = 0;
	boolean gewonnen = false;
	int stufe = 4; // ende bei welcher gewinnstufe
	int zeige = 3; // zeige ab welcher gewinnstufe
	int[] tipp = new int[45];
	int[] ziehung = new int[45];
	int[] statistik = new int[45];
	int zaehler3 = 0;
	int zaehler4 = 0;
	int zaehler5 = 0;
	int zaehler6 = 0;
	JTextField t1 = new JTextField("");
	JTextField t2 = new JTextField("");
	JTextField t3 = new JTextField("");
	JTextField t4 = new JTextField("");
	JTextField t5 = new JTextField("");
	JTextField t6 = new JTextField("");
	JTextField t7 = new JTextField("");
	JTextField t8 = new JTextField("");
	JTextField t9 = new JTextField("");
	JTextArea ta;
	JTextArea ta1 = new JTextArea("", 15, 75);
	JTextArea ta2 = new JTextArea("", 25, 75);
	JButton motif = new JButton("motif");
	JButton metal = new JButton("metal");
	JButton windows = new JButton("windows");
	JButton zufall = new JButton("Zufall");
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	ButtonGroup esGroup = new ButtonGroup();
	JRadioButton es3 = new JRadioButton("3", false);
	JRadioButton es4 = new JRadioButton("4", true);
	JRadioButton es5 = new JRadioButton("5", false);
	JRadioButton es6 = new JRadioButton("6", false);
	ButtonGroup zsGroup = new ButtonGroup();
	JRadioButton zs3 = new JRadioButton("3", true);
	JRadioButton zs4 = new JRadioButton("4", false);
	JRadioButton zs5 = new JRadioButton("5", false);
	JRadioButton zs6 = new JRadioButton("6", false);
	JButton ende = new JButton("Ende");


	public LottoPanel()
	{
		this(null);
	}


	public LottoPanel(LottoFrame lottoFrame)
	{
		this.lottoFrame = lottoFrame;
		makeTheLayout();
		setToolTipps();
		addTheListener();
	}


	private void setToolTipps()
	{
		start.setToolTipText("starten Sie den Testlauf");
		stop.setToolTipText("stoppen Sie den Testlauf");
		zufall.setToolTipText("erstellen Sie zufaellige Lottozahlen");
		motif.setToolTipText("Look and Feel umschalten (Motif)");
		windows.setToolTipText("Look and Feel umschalten (Windwos)");
		metal.setToolTipText("Look and Feel umschalten (Metal)");
		ende.setToolTipText("Beenden Sie die Anwendung");
		zs3.setToolTipText("zeige alle Dreier");
		zs4.setToolTipText("zeige alle Vierer");
		zs5.setToolTipText("zeige alle Fuenfer");
		zs6.setToolTipText("zeige alle Sechser");
		es3.setToolTipText("ende wenn ein Dreier erreicht ist");
		es4.setToolTipText("ende wenn ein Vierer erreicht ist");
		es5.setToolTipText("ende wenn ein Fuenfer erreicht ist");
		es6.setToolTipText("ende wenn ein Sechser erreicht ist");
	}


	private void setLF(String plaf)
	{
		System.out.println("look and feel: " + plaf);
		try
		{
			UIManager.setLookAndFeel(plaf);
			SwingUtilities.updateComponentTreeUI(this);
			System.out.println("ok");
		}
		catch (Exception e)
		{
			System.out.println("l und f fehler");
		}
		if (lottoFrame != null)
		{
			lottoFrame.packAndShow();
		}
	}


	private void makeTheLayout()
	{
		if (test)
		{
			ta = ta1;
		}
		else
		{
			ta = ta2;
		}
		JPanel pKopf = makeKopf(); // Ueberschrift: Lottomat ....
		JPanel pDaten = makeDaten();
		// Einbabebereich, Ausgabebereich
		JPanel pFuss = makeFuss(); // copyright, Autor
		setLayout(new BorderLayout());
		add("North", pKopf);
		add("Center", pDaten);
		add("South", pFuss);
		oeffnen();
		// setLF("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
	}


	private JPanel makeKopf()
	{
		JLabel n = new JLabel("", SwingConstants.CENTER);
		JLabel s = new JLabel("", SwingConstants.CENTER);
		JLabel o = new JLabel("", SwingConstants.RIGHT);
		JLabel w = new JLabel("", SwingConstants.LEFT);
		JLabel c = new JLabel("Lottomat", SwingConstants.CENTER);
		c.setFont(new Font("Serif", Font.BOLD, 32));
		JPanel p = new JPanelx("kopf");
		p.setLayout(new BorderLayout());
		p.add("North", n);
		p.add("South", s);
		p.add("East", o);
		p.add("West", w);
		p.add("Center", c);
		return p;
	}


	private JPanel makeFuss()
	{
		JPanel p = new JPanelx("fuss");
		JPanel lf = new JPanelx("look and feel links");
		JPanel cr = new JPanelx("copyright rechts");
		JLabel n = new JLabel("", SwingConstants.CENTER);
		JLabel s = new JLabel("", SwingConstants.CENTER);
		JLabel o = new JLabel("", SwingConstants.RIGHT);
		JLabel w = new JLabel("", SwingConstants.LEFT);
		JLabel c = new JLabel("", SwingConstants.CENTER);
		JLabel x = new JLabel("johann mildner, basel ",
				SwingConstants.RIGHT);
		cr.setLayout(new BorderLayout());
		cr.add(BorderLayout.NORTH, n);
		cr.add(BorderLayout.SOUTH, s);
		cr.add(BorderLayout.EAST, o);
		cr.add(BorderLayout.WEST, w);
		cr.add(BorderLayout.CENTER, c);
		cr.add(BorderLayout.EAST, x);
		lf.add(motif);
		lf.add(metal);
		lf.add(windows);
		lf.add(ende);
		p.setLayout(new BorderLayout());
		p.add(BorderLayout.WEST, lf);
		p.add(BorderLayout.EAST, cr);
		return p;
	}


	private JPanel makeDaten()
	{
		JPanel pEingabe = makeEingabe();
		JPanel pAusgabe = makeAusgabe();
		JPanel p = new JPanelx("daten");
		p.setLayout(new BorderLayout());
		p.add("North", pEingabe);
		p.add("South", pAusgabe);
		return p;
	}


	private JPanel makeAusgabe()
	{
		JPanel p = new JPanelx("ausgabe sued");
		ta.setLineWrap(true);
		ta.setFont(new Font("Courier New", Font.PLAIN, 14));
		p.add(new JScrollPane(ta));
		return p;
	}


	private JPanel makeEingabe()
	{
		// North
		// Tippen Sie sechs Zahlen ein
		// 1 2 3 4 5 6 7 11 12 13
		JPanel n = makeEingabeNorth();
		// South
		// Treffer ab Stufe 3 4 5 6 Ende bei Stufe 3 4 5 6 Start
		// Stop
		JPanel s = makeEingabeSouth();
		JPanel p = new JPanelx("eingabe nord");
		p.setLayout(new BorderLayout());
		p.add(BorderLayout.NORTH, n);
		p.add(BorderLayout.SOUTH, s);
		return p;
	}


	private JPanel makeEingabeNorth()
	{
		JPanel n = new JPanelx("eingabe tipps text nord");
		n.add(new JLabel("Tippen Sie Ihre Wunschzahlen ein oder"
				+ " druecken Sie auf ..... "));
		n.add(zufall);
		JPanel s = new JPanelx("eingabe tipps sued");
		s.setLayout(new GridLayout(1, 20));
		s.add(new JLabel(" "));
		s.add(new JLabel(" "));
		s.add(new JLabel(" "));
		s.add(t1);
		s.add(t2);
		s.add(t3);
		s.add(t4);
		s.add(t5);
		s.add(t6);
		s.add(new JLabel(" "));
		s.add(new JLabel(" "));
		s.add(t7);
		s.add(t8);
		s.add(t9);
		s.add(new JLabel(" "));
		s.add(new JLabel(" "));
		s.add(new JLabel(" "));
		s.add(new JLabel(" "));
		s.add(new JLabel(" "));
		s.add(new JLabel(" "));
		JPanel p = new JPanelx("eingabe ");
		p.setLayout(new BorderLayout());
		p.add(BorderLayout.NORTH, n);
		p.add(BorderLayout.SOUTH, s);
		return p;
	}


	private JPanel makeEingabeSouth()
	{
		JPanel p = new JPanelx("knoepfe");
		p.add(new JLabel("Zeige Treffer ab Stufe"));
		zsGroup.add(zs3);
		zsGroup.add(zs4);
		zsGroup.add(zs5);
		zsGroup.add(zs6);
		p.add(zs3);
		p.add(zs4);
		p.add(zs5);
		p.add(zs6);
		p.add(new JLabel("      "));
		p.add(new JLabel("Ende bei Stufe"));
		esGroup.add(es3);
		esGroup.add(es4);
		esGroup.add(es5);
		esGroup.add(es6);
		p.add(es3);
		p.add(es4);
		p.add(es5);
		p.add(es6);
		p.add(new JLabel(" "));
		p.add(start);
		p.add(stop);
		return p;
	}


	private void addTheListener()
	{
		ende.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				System.exit(0);
			}
		});

		motif.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setLF("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			}
		});

		metal.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setLF("javax.swing.plaf.metal.MetalLookAndFeel");
			}
		});

		windows.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				setLF("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			}
		});

		zufall.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				fuelleEingabeMitZufallszahlen();
			}
		});

		start.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if (!tippGueltig())
				{
					ta.setText("Ihr Tipp ist falsch");
				}
				else
				{
					ta.setText("");
					sperren();
					new Thread(new ZiehungsThread()).start();
				}
			}
		});

		stop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				gewonnen = true;
				oeffnen();
			}
		});
	}


	void fuelleEingabeMitZufallszahlen()
	{
		for (int i = 0; i < 45; i++)
		{
			ziehung[i] = 0;
		}

		int g = 0; // gezogene zahlen

		while (g < 6)
		{
			int zufall = (int) (Math.random() * 45);
			if (ziehung[zufall] == 0)
			{
				ziehung[zufall] = 1;
				g++;
			}
		}

		for (int i = 0, j = 0; i < 45; i++)
		{
			if (ziehung[i] == 1)
			{
				j++;
				fuellenEingabe(j, i);
			}
		}

		while (g < 9)
		{
			int zufall = (int) (Math.random() * 45);
			if (ziehung[zufall] == 0)
			{
				ziehung[zufall] = 1;
				g++;
				fuellenEingabe(g, zufall);
			}
		}
	}


	void fuellenEingabe(int g, int zufall)
	{
		switch (g)
		{
			case 1:
				t1.setText("" + (zufall + 1));
				break;
			case 2:
				t2.setText("" + (zufall + 1));
				break;
			case 3:
				t3.setText("" + (zufall + 1));
				break;
			case 4:
				t4.setText("" + (zufall + 1));
				break;
			case 5:
				t5.setText("" + (zufall + 1));
				break;
			case 6:
				t6.setText("" + (zufall + 1));
				break;
			case 7:
				t7.setText("" + (zufall + 1));
				break;
			case 8:
				t8.setText("" + (zufall + 1));
				break;
			case 9:
				t9.setText("" + (zufall + 1));
				break;
		}
	}

	class ZiehungsThread implements Runnable
	{
		public void run()
		{
			if (es3.isSelected())
				stufe = 3;
			else
				if (es4.isSelected())
					stufe = 4;
				else
					if (es5.isSelected())
						stufe = 5;
					else
						if (es6.isSelected())
							stufe = 6;

			if (zs3.isSelected())
				zeige = 3;
			else
				if (zs4.isSelected())
					zeige = 4;
				else
					if (zs5.isSelected())
						zeige = 5;
					else
						if (zs6.isSelected())
							zeige = 6;

			zZiehungen = zDreier = zVierer = zFuenfer = zSechser = 0;

			for (int i = 0; i < 45; i++)
			{
				statistik[i] = 0;
			}

			gewonnen = false;

			while (!gewonnen)
			{
				int i = 0;
				doZiehung();
				if (++i == 5000)
				{
					i = 0;
					try
					{
						Thread.sleep(1);
					}
					catch (InterruptedException e)
					{
					}
				}
			}

			protokoll();
		}
	}


	private boolean tippGueltig()
	{
		int anzahlTipps = 0;
		int anzahlRegulaereTipps = 0;
		int anzahlZusatzTipps = 0;

		if (t1.getText().equals(""))
			;
		else
			anzahlRegulaereTipps++;

		if (t2.getText().equals(""))
			;
		else
			anzahlRegulaereTipps++;

		if (t3.getText().equals(""))
			;
		else
			anzahlRegulaereTipps++;

		if (t4.getText().equals(""))
			;
		else
			anzahlRegulaereTipps++;

		if (t5.getText().equals(""))
			;
		else
			anzahlRegulaereTipps++;

		if (t6.getText().equals(""))
			;
		else
			anzahlRegulaereTipps++;

		if (t7.getText().equals(""))
			;
		else
			anzahlZusatzTipps++;

		if (t8.getText().equals(""))
			;
		else
			anzahlZusatzTipps++;

		if (t9.getText().equals(""))
			;
		else
			anzahlZusatzTipps++;

		anzahlTipps = anzahlRegulaereTipps + anzahlZusatzTipps;

		for (int i = 0; i < 45; i++)
		{
			tipp[i] = 0;
		}

		fuelleTipp(t1);
		fuelleTipp(t2);
		fuelleTipp(t3);
		fuelleTipp(t4);
		fuelleTipp(t5);
		fuelleTipp(t6);
		fuelleTipp(t7);
		fuelleTipp(t8);
		fuelleTipp(t9);

		int richtigeTipps = 0;

		for (int i = 0; i < 45; i++)
		{
			richtigeTipps = richtigeTipps + tipp[i];
		}

		if (richtigeTipps == anzahlTipps && anzahlRegulaereTipps == 6)
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	void fuelleTipp(JTextField t)
	{
		try
		{
			tipp[Integer.parseInt(t.getText()) - 1] = 1;
		}
		catch (Exception e)
		{
		}
	}


	private void doZiehung()
	{
		zZiehungen++;

		for (int i = 0; i < 45; i++)
		{
			ziehung[i] = 0;
		}

		int g = 0; // gezogene zahlen

		while (g < 6)
		{
			int zufall = (int) (Math.random() * 45);
			if (ziehung[zufall] == 0)
			{
				ziehung[zufall] = 1;
				statistik[zufall]++;
				g++;
			}
		}

		int anzTreffer = 0;

		for (int i = 0; i < 45; i++)
		{
			if (ziehung[i] + tipp[i] == 2)
			{
				anzTreffer++;
			}
		}

		if (anzTreffer == 3)
			zDreier++;

		if (anzTreffer == 4)
			zVierer++;

		if (anzTreffer == 5)
			zFuenfer++;

		if (anzTreffer == 6)
			zSechser++;

		if (anzTreffer == 3 && zeige <= 3)
			zeigeZiehung("DREIER  ");
		else
			if (anzTreffer == 4 && zeige <= 4)
				zeigeZiehung("VIERER  ");
			else
				if (anzTreffer == 5 && zeige <= 5)
					zeigeZiehung("FUENFER ");
				else
					if (anzTreffer == 6 && zeige <= 6)
						zeigeZiehung("SECHSER ");

		if (anzTreffer >= stufe)
		{
			gewonnen = true;
			oeffnen();
		}
	}


	private void zeigeZiehung(String txt)
	{
		String s = "";

		s = "Ziehung " + (ed7(zZiehungen)) + ": " + txt;

		for (int i = 0; i < 45; i++)
		{
			if (ziehung[i] == 1)
			{
				s = s + "   " + (ed2(i + 1));
			}
		}

		s = s + "\n";

		ausgeben(s);
	}


	private void protokoll()
	{
		String s = "";

		s = "Anzahl der Ziehungen:" + ed7(zZiehungen) + "  "
				+ ed7((int) (Math.round(zZiehungen / 52.0)))
				+ " Jahre\n" + "          Anzahl 3er:" + ed7(zDreier)
				+ "\n" + "          Anzahl 4er:" + ed7(zVierer) + "\n"
				+ "          Anzahl 5er:" + ed7(zFuenfer) + "\n"
				+ "          Anzahl 6er:" + ed7(zSechser) + "\n" + "\n";

		ausgeben(s);

		ausgeben("\n");

		for (int i = 45; i >= 1; i--)
		{
			if (i % 5 == 0)
			{
				ausgeben("\n");
			}

			ausgeben(ed7(statistik[i - 1]) + "/" + ed2(i));
		}
	}


	void ausgeben(String s)
	{
		ta.insert(s, 0);
	}


	private void sperren()
	{
		motif.setEnabled(false);
		metal.setEnabled(false);
		windows.setEnabled(false);
		zufall.setEnabled(false);
		start.setEnabled(false);
		stop.setEnabled(true);
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		t7.setEditable(false);
		t8.setEditable(false);
		t9.setEditable(false);
		t1.setEnabled(false);
		t2.setEnabled(false);
		t3.setEnabled(false);
		t4.setEnabled(false);
		t5.setEnabled(false);
		t6.setEnabled(false);
		t7.setEnabled(false);
		t8.setEnabled(false);
		t9.setEnabled(false);
		zs3.setEnabled(false);
		zs4.setEnabled(false);
		zs5.setEnabled(false);
		zs6.setEnabled(false);
		es3.setEnabled(false);
		es4.setEnabled(false);
		es5.setEnabled(false);
		es6.setEnabled(false);
	}


	private void oeffnen()
	{
		motif.setEnabled(true);
		metal.setEnabled(true);
		windows.setEnabled(true);
		zufall.setEnabled(true);
		start.setEnabled(true);
		stop.setEnabled(false);
		ta.setEditable(false);
		t1.setEditable(true);
		t2.setEditable(true);
		t3.setEditable(true);
		t4.setEditable(true);
		t5.setEditable(true);
		t6.setEditable(true);
		t7.setEditable(true);
		t8.setEditable(true);
		t9.setEditable(true);
		t1.setEnabled(true);
		t2.setEnabled(true);
		t3.setEnabled(true);
		t4.setEnabled(true);
		t5.setEnabled(true);
		t6.setEnabled(true);
		t7.setEnabled(true);
		t8.setEnabled(true);
		t9.setEnabled(true);
		zs3.setEnabled(true);
		zs4.setEnabled(true);
		zs5.setEnabled(true);
		zs6.setEnabled(true);
		es3.setEnabled(true);
		es4.setEnabled(true);
		es5.setEnabled(true);
		es6.setEnabled(true);
	}


	static private String ed2(int i)
	{
		String str;

		if (i < 10)
			str = " " + i;
		else
			str = "" + i;

		return str;
	}


	static private String ed7(int i)
	{
		String str, neu = "";

		if (i < 10)
			str = "        " + i;
		else
			if (i < 100)
				str = "       " + i;
			else
				if (i < 1000)
					str = "      " + i;
				else
					if (i < 10000)
						str = "     " + i;
					else
						if (i < 100000)
							str = "    " + i;
						else
							if (i < 1000000)
								str = "   " + i;
							else
								if (i < 10000000)
									str = "  " + i;
								else
									if (i < 100000000)
										str = " " + i;
									else
										str = "" + i;

		for (int x = str.length() - 1, y = 0; x >= 0; x--)
		{
			String strich;

			y++;

			if (y > 1 && y % 3 == 1)
			{
				if (str.charAt(x) != ' ')
				{
					strich = "'";
				}
				else
				{
					strich = " ";
				}
				neu = strich + neu;
			}

			neu = str.charAt(x) + neu;
		}

		return neu;
	}

	class JPanelx extends JPanel
	{
		private static final long serialVersionUID = 1L;


		JPanelx()
		{
			if (test)
			{
				Border border;
				border = BorderFactory.createEtchedBorder();
				border = BorderFactory.createTitledBorder("titel");
				setBackground(Color.yellow);
				setBorder(border);
			}
		}


		JPanelx(String x)
		{
			if (test)
			{
				Border border;
				border = BorderFactory.createEtchedBorder();
				border = BorderFactory.createTitledBorder(x);
				setBackground(Color.green);
				setBorder(border);
			}
		}
	}
}
