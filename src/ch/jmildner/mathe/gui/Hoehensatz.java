package ch.jmildner.mathe.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Hoehensatz extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	JButton rechnen = new JButton("RECHNEN");
	JButton clear = new JButton("CLEAR");
	JButton ende = new JButton("ENDE");

	JTextField tf1 = new JTextField("", 25);
	JTextField tf2 = new JTextField("", 25);
	JTextArea taErgebnis = new JTextArea("", 10, 25);


	public Hoehensatz()
	{
		super("Hoehensatz");
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
			tf1.setText("");
			tf2.setText("");
			taErgebnis.setText("");
		}

		if (e.getSource() == rechnen)
		{
			doRechnen();
		}
	}


	private void doRechnen()
	{
		taErgebnis.setText("");

		try
		{
			double q = Double.parseDouble(tf1.getText());
			double p = Double.parseDouble(tf2.getText());

			doWeiterrechnen(q, p);
		}
		catch (Exception e)
		{
			taErgebnis.append("Fehlerhafte Eingabe");
			return;
		}
	}


	private void doWeiterrechnen(double q, double p)
	{
		double h = Math.sqrt(p * q);
		taErgebnis.append("Hoehe = " + h + "\n");
		double c = p + q;
		double a = Math.sqrt(p * c);
		taErgebnis.append("a = " + a + "\n");
		double b = Math.sqrt(q * c);
		taErgebnis.append("b = " + b + "\n");

		double A1 = a * b / 2;
		taErgebnis.append("A1 = " + A1 + "\n");

		double A2 = c * h / 2;
		taErgebnis.append("A2 = " + A2 + "\n");
	}


	private void anzeigen()
	{
		setLocation(10, 100);
		pack();
		setVisible(true);
		setSize(320, 450);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	private void makeTheLayout()
	{
		setLayout(new FlowLayout());

		add(new JLabel("q: "));
		add(tf1);
		add(new JLabel("p: "));
		add(tf2);
		add(taErgebnis);
		taErgebnis.setEditable(false);
		add(rechnen);
		add(clear);
		add(ende);
	}


	public static void main(String[] args)
	{
		new Hoehensatz();
	}
}
