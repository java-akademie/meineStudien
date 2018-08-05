
package ch.jmildner.ndsi16.typsicher;

public class TestKontoArt
{
    public static void main(String[] args)
    {
        KontoArt ka1 = KontoArt.PRIVAT;
        System.out.println("ka1=" + ka1);

        KontoArt ka2 = KontoArt.PRIVAT;
        System.out.println("ka2=" + ka2);

        System.out.println("ka2=" + KontoArt.PRIVAT);

        if (ka1 == KontoArt.PRIVAT)
        {
            System.out.println("gleich1");
        }

        if (ka1 == ka2)
        {
            System.out.println("gleich2");
        }
    }
}
