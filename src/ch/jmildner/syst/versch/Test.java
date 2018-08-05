package ch.jmildner.syst.versch;

public class Test
{
	public static void main(String[] args)
	{
		X original = new X(4711, "hugo");
		X copy = (X) original.kopieren();
		original.i = 815;
		original.s = "max";
		original.show();
		copy.show();
	}
}
