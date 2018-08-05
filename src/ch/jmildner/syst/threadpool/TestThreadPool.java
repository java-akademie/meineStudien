package ch.jmildner.syst.threadpool;

public class TestThreadPool implements Runnable
{
	int id = 0;
	int zaehler = 0;
	static TestThreadPool ttp;

	public static void main(String[] args)
	{
		ttp=new TestThreadPool();
		ttp.go();
	}


	private void go()
	{
		ThreadPool tp = new ThreadPool(2);
		id++;	for (int i = 1; i <= 10; i++)
		{
			
			zaehler++;
			 tp.execute(ttp);
		}		
	}


	public TestThreadPool()
	{
	

	}


	@Override
	public void run()
	{
		for (int i = 1; i <= 5; i++)
			System.out.println(id + "/" + zaehler);

	}

}
