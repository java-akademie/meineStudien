package ch.jmildner.uhr;

import java.applet.Applet;
import java.awt.Label;
import java.util.Calendar;
import java.util.Date;

public class UhrApplet extends Applet implements Runnable
{

	private static final long serialVersionUID = 1L;
	Calendar cal = null;
	Label l = new Label("..............................");


	public void start()
	{
		System.out.println("start");
		add(l);

		cal = Calendar.getInstance();

		Thread th = new Thread(this);
		th.start();
	}


	public void run()
	{
		int h, m, s;

		while (true)
		{
			try
			{
				Thread.sleep(1000);
				cal.setTime(new Date());
				h = cal.get(Calendar.HOUR_OF_DAY);
				m = cal.get(Calendar.MINUTE);
				s = cal.get(Calendar.SECOND);
				String r = makeRoem(h, m, s);
				l.setText(r);
			}
			catch (Exception e)
			{
			}
		}
	}

	String[] roem = { "O", "I", "II", "III", "IV", "V", "VI", "VII",
			"VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI",
			"XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII",
			"XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
			"XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
			"XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII",
			"XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
			"LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII",
			"LIX", "LX" };


	private String makeRoem(int h, int m, int s)
	{
		return int2Roman(h) + " : " + int2Roman(m) + " : "
				+ int2Roman(s);
	}


	private String int2Roman(int i)
	{
		return roem[i];
	}

}
