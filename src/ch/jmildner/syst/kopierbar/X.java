package ch.jmildner.syst.kopierbar;

public class X extends Objekt // implements Kopierbar
{
	public int i;
	public String s;


	public X()
	{
	}


	public X(int i, String s)
	{
		this.i = i;
		this.s = s;
	}


	@Override
	public Objekt kopieren()
	{
		X x = (X) super.kopieren();
		x.i = this.i;
		x.s = this.s;
		return x;
	}


	public void show()
	{
		System.out.println(i + "  " + s);
	}
}
