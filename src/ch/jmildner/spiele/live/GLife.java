package ch.jmildner.spiele.live;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class GLifeOptionenDialog extends java.awt.Dialog 
		implements AdjustmentListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	Scrollbar h, v;
	TextField ht, vt;
	Button o, c;
	int nRows, nCols;


	public GLifeOptionenDialog(Frame f, int nRows, int nCols)
	{
		super(f, true);
		this.nRows = nRows;
		this.nCols = nCols;
		setTitle("Options for Game of Life");
		setLayout(new BorderLayout());
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(2, 3));
		p1.add(new Label("Anzahl Zeilen:"));
		p1.add(h = new Scrollbar(Scrollbar.HORIZONTAL, nRows, 10, 30, 100));
		p1.add(ht = new TextField("" + nRows));
		p1.add(new Label("Anzahl Spalten:"));
		p1.add(v = new Scrollbar(Scrollbar.HORIZONTAL, nCols, 10, 30, 100));
		p1.add(vt = new TextField("" + nCols));
		add("Center", p1);
		Panel p2 = new Panel();
		p2.add(o = new Button("OK"));
		p2.add(c = new Button("Cancel"));
		add("South", p2);
		o.addActionListener(this);
		c.addActionListener(this);
		h.addAdjustmentListener(this);
		v.addAdjustmentListener(this);
		this.addWindowListener(new MyWindowAdapter());
		pack(); // Minimalgroesse
		setVisible(true); // Anzeige Dialog
	}


	public void adjustmentValueChanged(AdjustmentEvent event)
	{
		switch (event.getAdjustmentType())
		{
			case AdjustmentEvent.UNIT_INCREMENT:
			case AdjustmentEvent.UNIT_DECREMENT:
			case AdjustmentEvent.BLOCK_INCREMENT:
			case AdjustmentEvent.BLOCK_DECREMENT:
			case AdjustmentEvent.TRACK:
				if (event.getSource() == h)
				{
					nRows = h.getValue();
				}
				else
				{
					nCols = v.getValue();
				}
				ht.setText("" + nRows);
				vt.setText("" + nCols);
				System.out.println(event.paramString());
		}
	}

	class MyWindowAdapter extends WindowAdapter
	{
		public void windowClosing(WindowEvent event)
		{
			dispose();
		}
	}


	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();
		System.out.println("Dialog " + " " + event);
		if (source == o)
		{
			dispose();
		}
		if (source == c)
		{
			dispose();
		}
	}
}



public class GLife extends Frame
{
	private static final long serialVersionUID = 1L;
	MyCanvas c;
	MyToolbar t;
	final static int START = 0, STOP = 1, NEXT = 2, LOAD = 3, OPTIONEN = 4, CLICK = 10,
			NOTHING = -1;


	public GLife()
	{
		super("Game of Life");
		init();
		setVisible(true);
		addWindowListener(new MyWindowAdapter());
	}


	public void init()
	{
		setSize(600, 400);
		setLayout(new BorderLayout());
		add("West", t = new MyToolbar());
		add("Center", c = new MyCanvas(t, this));
		c.init();
		t.setActionListener(c);
	}


	public void start()
	{
	}


	public void paint(Graphics g)
	{
	}


	public void stop()
	{
	}

	class MyWindowAdapter extends WindowAdapter
	{
		public void windowClosing(WindowEvent event)
		{
			System.exit(0);
		}
	}


	public static void main(String[] args)
	{
		new GLife();
	}
}



// MyToolbar steuert: Leite alle Events von den Buttons auf MyCanvas

class MyToolbar extends Panel
{
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	Button[] controls;


	public MyToolbar()
	{
		controls = new Button[5];
		setLayout(new GridLayout(controls.length, 1));
		int i = 0;
		// Controls entsprechend der Codes anordnen
		// final static int START = 0, STOP = 1, NEXT = 2, LOAD = 3,
		// CLICK = 10,
		// NOTHING=-1;
		add(controls[i++] = new Button("start"));
		add(controls[i++] = new Button("stop"));
		add(controls[i++] = new Button("next"));
		add(controls[i++] = new Button("load"));
		add(controls[i++] = new Button("options"));
	}


	public void setActionListener(ActionListener listener)
	{
		for (int i = 0; i < controls.length; i++)
		{
			controls[i].addActionListener(listener);
		}
	}


	public int getCommand(Object c)
	{
		for (int i = 0; i < controls.length; i++)
			if (controls[i] == c)
				return i; // Ein uebler Trick... Entschuldigung
		return -1;
	}
}



class MyCanvas extends Canvas implements ActionListener
{
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	MyToolbar t;
	Frame frame; // Fuer FileDialog
	int command = -1;
	int nRows = 32, nCols = 64;
	int nMax = 1, nPixelx, nPixely;
	int iRow, iCol;
	byte[][] field;


	public void initField()
	{
		field = new byte[nRows + 2][nCols + 2];
		clearField();
	}


	public void initField(int nRows, int nCols)
	{
		this.nRows = nRows;
		this.nCols = nCols;
		initField();
	}


	public void changeFieldDimensions(int newRows, int newCols)
	{
		byte f[][] = field;
		int iRow = nRows <= newRows ? nRows : newRows;
		int jCol = nCols <= newCols ? nCols : newCols;
		initField(newRows, newCols);
		for (int i = 1; i <= iRow; i++)
			for (int j = 1; j <= jCol; j++)
				field[i][j] = f[i][j];
	}


	public void clearField()
	{
		for (int i = 0; i < field.length; i++)
			for (int j = 0; j < field[i].length; j++)
				field[i][j] = 0;
	}


	public void initGleiter(int ix, int iy)
	{
		field[ix][iy] = 1; // lebend;
		field[ix + 1][iy] = 1; // lebend;
		field[ix + 1][iy + 1] = 1; // lebend;
		field[ix + 2][iy - 1] = 1; // lebend;
		field[ix + 2][iy + 1] = 1; // lebend;
	}


	public void setCell(int x, int y)
	{
		field[x + 1][y + 1] = 1; // 1 = lebend 0 = tot
	}


	public byte getCell(int x, int y)
	{
		return field[x + 1][y + 1];
	}


	int count(byte[][] field, int i, int j)
	{
		int r = field[i - 1][j - 1];
		r += field[i - 1][j];
		r += field[i - 1][j + 1];
		r += field[i][j - 1];
		// r += field[i ][j ];
		r += field[i][j + 1];
		r += field[i + 1][j - 1];
		r += field[i + 1][j];
		r += field[i + 1][j + 1];
		return r;
	}


	public void nextGeneration()
	{
		int ni = field.length;
		int nj = field[0].length;
		byte f[][] = new byte[ni][nj];
		for (int i = 1; i < ni - 1; i++)
			for (int j = 1; j < nj - 1; j++)
				f[i][j] = field[i][j];
		// 0-te Zeile == 1.Zeile
		// Kopiere unterste Zeile
		for (int j = 1; j < nj - 1; j++)
		{
			f[0][j] = f[ni - 2][j];
			f[ni - 1][j] = f[1][j];
		}
		// Kopiere 1. Spalte
		for (int i = 1; i < ni - 1; i++)
		{
			f[i][0] = f[i][nj - 2];
			f[i][nj - 1] = f[i][1];
		}
		f[0][0] = f[ni - 2][nj - 2];
		f[ni - 1][0] = f[1][nj - 2];
		f[0][nj - 1] = f[ni - 2][1];
		f[ni - 1][nj - 1] = f[1][1];
		// clearField();
		for (int i = 1; i < ni - 1; i++)
			for (int j = 1; j < nj - 1; j++)
			{
				int n = count(f, i, j);
				if (f[i][j] > 0)
				{
					if ((n < 2 || n > 3))
						field[i][j] = 0;
				}
				else
				{
					if (n == 3)
					{
						field[i][j] = 1;
					}
				}
			}
	}


	public void init()
	{
	}


	int x2Index(int x)
	{
		return x / nPixelx;
	}


	int y2Index(int y)
	{
		return y / nPixely;
	}


	public void readData(String FileName)
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(FileName));
			String s = null;
			int i = 0;
			clearField();
			while ((s = br.readLine()) != null)
			{
				for (int j = 0; j < s.length(); j++)
					if (s.charAt(j) != ' ')
						setCell(i, j);
				i++;
			}
			br.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}


	public void update(Graphics g)
	{
		g.clearRect(0, 0, getSize().width, getSize().height);
		nPixelx = getSize().width / nCols;
		nPixely = getSize().height / nRows;
		for (int i = 0; i <= nRows; i++)
			g.drawLine(0, nPixely * i, nPixelx * nCols, nPixely * i);
		for (int j = 0; j <= nCols; j++)
			g.drawLine(j * nPixelx, 0, j * nPixelx, nPixely * nRows);
		g.setColor(Color.blue);
		for (int i = 0; i < nRows; i++)
			for (int j = 0; j < nCols; j++)
				if (getCell(i, j) > 0)
				{
					int iy = i * nPixely;
					int ix = j * nPixelx;
					g.fillRect(ix, iy, nPixelx, nPixely);
				}
	}


	public void paint(Graphics g)
	{
		update(g);
	}

	int test = 77;
	Kicker kicker = null;


	public void actionPerformed(ActionEvent e)
	{
		switch (command = t.getCommand(e.getSource()))
		{
			case GLife.NEXT:
				nextGeneration();
				repaint();
				break;
			case GLife.START:
				if (kicker == null)
					kicker = new Kicker();
				kicker.start();
				break;
			case GLife.LOAD:
				java.awt.FileDialog f = new java.awt.FileDialog(frame, "Filename?",
						FileDialog.LOAD);
				f.setDirectory(".");
				f.setVisible(true);
				String Name = f.getFile();
				if (Name != null)
				{
					System.out.println(f.getDirectory() + Name);
					readData(f.getDirectory() + Name);
					repaint();
				}
				break;
			case GLife.OPTIONEN:
				GLifeOptionenDialog d = new GLifeOptionenDialog(frame, nRows, nCols);
				changeFieldDimensions(d.nRows, d.nCols);
				repaint();
				break;
		}
	}


	public MyCanvas(MyToolbar t, Frame f)
	{
		this.t = t;
		frame = f;
		initField();
		initGleiter(10, 20);
		// initGleiter(10, 10);
		// readData ("Gleiter");
		addMouseListener(new MyMouseAdapter());
	}

	class MyMouseAdapter extends MouseAdapter
	{
		public void mouseClicked(MouseEvent event)
		{
			iCol = x2Index(event.getX());
			iRow = y2Index(event.getY());
			setCell(iRow, iCol);
			command = GLife.CLICK;
			repaint();
		}
	}

	class Kicker extends Thread
	{
		public void run()
		{
			while (command != GLife.STOP)
			{
				try
				{
					sleep(20);
					nextGeneration();
					repaint();
				}
				catch (InterruptedException e)
				{
				}
			}
			kicker = null;
		}
	}
}
