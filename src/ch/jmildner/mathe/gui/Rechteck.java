package ch.jmildner.mathe.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Rechteck extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	JButton rechnen = new JButton("RECHNEN");
	JButton clear = new JButton("CLEAR");
	JButton ende = new JButton("ENDE");

	JTextField tfLaenge = new JTextField("", 25);
	JTextField tfBreite = new JTextField("", 25);
	JTextArea taErgebnis = new JTextArea("", 10, 25);


	public Rechteck()
	{
		super("Rechteck");
		makeTheLayout();
		addTheListener();
		anzeigen();
	}


	private void addTheListener()
	{
		rechnen.addActionListener(this);
		clear.addActionListener(this);
		ende.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == ende)
		{
			System.exit(0);
		}

		if (e.getSource() == clear)
		{
			tfLaenge.setText("");
			tfBreite.setText("");
			taErgebnis.setText("");
		}

		if (e.getSource() == rechnen)
		{
			doRechnen();
		}
	}


	private void doRechnen()
	{
		// taErgebnis.setText("");

		double l = getWert(tfLaenge);
		double b = getWert(tfBreite);

		double f = l * b;
		double u = 2 * l + 2 * b;
		double d = Math.sqrt(l * l + b * b);


		taErgebnis.append("\n");
		taErgebnis.append("Umfang = " + u);
		taErgebnis.append("\n");
		taErgebnis.append("Flaeche = " + f);
		taErgebnis.append("\n");
		taErgebnis.append("Diagonale = " + d);
		taErgebnis.append("\n");

	}


	private double getWert(JTextField w)
	{
		double wert;

		try
		{
			return Double.parseDouble(w.getText());
		}
		catch (Exception e)
		{
			wert = (int) (Math.random() * 20);
			w.setText(wert + "");
			return wert;
		}
	}


	private void anzeigen()
	{
		setLocation(24, 200);
		pack();
		setVisible(true);
		setSize(333, 444);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private void makeTheLayout()
	{
		setLayout(new FlowLayout());

		add(new JLabel("Laenge: "));
		add(tfLaenge);
		add(new JLabel("Breite: "));
		add(tfBreite);
		add(taErgebnis);
		taErgebnis.setEditable(false);
		add(rechnen);
		add(clear);
		add(ende);
	}


	public static void main(String[] args)
	{
		new Rechteck();
	}
}
