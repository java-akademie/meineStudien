/*
 * Created on 30.12.2003
 * 
 * eine Klasse fuer typsichere Konstanten
 * 
 */

package ch.jmildner.ndsi16.typsicher;

/**
 * 
 * @author johann
 * 
 */
public class KontoArt
{
    public static final KontoArt PRIVAT = new KontoArt(1);
    public static final KontoArt GESCHAEFT = new KontoArt(2);
    private int id;


    private KontoArt(int id)
    {
        this.id = id;
    }


    public String toString()
    {
        return "" + id;
    }


    public static void main(String[] args)
    {
        KontoArt k = KontoArt.PRIVAT;
        KontoArt j = k;
        if (k == j)
        {
            System.out.println("yyy");
       }
        if (j == KontoArt.GESCHAEFT)
        {
            System.out.println("xxx");
        }
    }
}
