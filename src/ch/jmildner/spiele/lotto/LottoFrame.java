package ch.jmildner.spiele.lotto;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class LottoFrame extends JFrame
{
	private static final long serialVersionUID = 1L;


	public LottoFrame()
	{
		super("Lotto");
		Container cont = getContentPane();
		cont.add(new LottoPanel(this));
		setLocation(200, 100);
		packAndShow();
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}


	public void packAndShow()
	{
		pack();
		setVisible(true);
	}


	public static void main(String[] args)
	{
		new LottoFrame();
	}
}
