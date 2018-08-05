package ch.jmildner.datum;

public class TestDatum
{
	static public void test1()
	{
		for (int i = 2000; i < 2005; i++)
		{
			for (int j = 0; j <= 13; j++)
			{
				for (int k = 0; k <= 32; k++)
				{
					Datum d1 = null;
					try
					{
						d1 = new Datum(k, j, i);
						d1.show();
						d1.datumErmitteln();
					}
					catch (Exception e)
					{
						System.out.println(e);
					}
				}
			}
		}


		try
		{
			Datum d = new Datum(31, 12, 4);
			d.show();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static void main(String[] args) throws Exception
	{
		test1();
		// MyTools.pause();
	}
}
