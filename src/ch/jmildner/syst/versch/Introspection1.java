package ch.jmildner.syst.versch;

import ch.jmildner.tools.MyTools;

public class Introspection1 {
	public static void main(String[] args) {
		test1();
	}

	static void test1() {
		System.out.println("");
		System.out.println("------");
		System.out.println("Test 1");
		System.out.println("------");
		Dame d = new Dame();
		Verehrer h = new Herr();
		t.getKlassenpfad("dame          : ", d);
		t.getKlassenpfad("verehrer/herr : ", h);
		d.addVerehrer(h);
		d.eventuellAnruf();
		d.eventuellAnruf();
		d.eventuellAnruf();
		MyTools.pause();
	}

	void test2() {
		System.out.println("");
		System.out.println("------");
		System.out.println("Test 2");
		System.out.println("------");
		Dame d = new Dame();
		class innerVerehrer implements Verehrer {
			void meth() {
				System.out.println("eine methode");
			}

			public void anruf(int z) {
				System.out.println("anruf Nr: " + z);
			}
		}
		innerVerehrer iv = new innerVerehrer(); // kann meth aufrufen
		iv.meth();
		d.addVerehrer(iv);
		Verehrer viv = new innerVerehrer(); // kann meth nicht aufrufen
		d.addVerehrer(viv);
		// oder
		d.addVerehrer(new innerVerehrer());
		d.eventuellAnruf();
		d.eventuellAnruf();
		d.eventuellAnruf();
		MyTools.pause();
	}

	void test3() {
		System.out.println("");
		System.out.println("------");
		System.out.println("Test 3");
		System.out.println("------");
		Dame d = new Dame();
		d.addVerehrer(new Verehrer() {
			public void anruf(int z) {
				System.out.println("anruf Nr: " + z);
			}
		});
		d.eventuellAnruf();
		d.eventuellAnruf();
		d.eventuellAnruf();
		MyTools.pause();
	}

}

class Dame {
	Verehrer verehrer = null;
	int zaehler = 0;

	void addVerehrer(Verehrer v) {
		this.verehrer = v;
		t.getKlassenpfad("v       :", v);
		t.getKlassenpfad("verehrer:", verehrer);
		System.out.println(v instanceof Herr ? "v ist io Herr"
				: "v ist nicht io Herr");
		System.out.println(v instanceof Verehrer ? "v ist io Verehrer"
				: "v ist nicht io Verehrer");
		System.out.println(v instanceof Dame ? "v ist io Dame"
				: "v ist nicht io Dame");
	}

	void eventuellAnruf() {
		zaehler++;
		verehrer.anruf(zaehler);
	}
}

class Herr implements Verehrer {
	void aMethod() {
		System.out.println("eine Methode");
	}

	public void anruf(int z) {
		System.out.println("anruf Nr: " + z);
	}
}

interface Verehrer {
	void anruf(int z);
}

class t {

	@SuppressWarnings("rawtypes")
	static void getKlassenpfad(String t, Object o) {
		Class c1 = o.getClass();
		Class c2 = c1.getSuperclass();
		Class c3 = c2.getSuperclass();
		System.out.println("");
		System.out.println(t);
		System.out.println("--------------");
		System.out.println("" + c1);
		System.out.println("" + c2);
		System.out.println("" + c3);
		System.out.println("");
	}
}
