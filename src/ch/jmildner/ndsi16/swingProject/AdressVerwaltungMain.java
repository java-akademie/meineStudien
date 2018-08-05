/**
 * Grafikprogrammierung mit Swing 
 * NDS-I/16, 4. Quartal 2004
 * 
 * Kleinprojekt
 * 
 * Autor  : Johann Mildner
 * Dozent : Diego Schmidlin
 * Datum  : 16. September 2004
 */

package ch.jmildner.ndsi16.swingProject;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdressVerwaltungMain
{
    AdressVerwaltungFrame frame;


    private AdressVerwaltungMain()
    {
        frame = new AdressVerwaltungFrame("Adressverwaltung");
        frame.setLocation(100, 100);
        frame.setSize(880, 500);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }


    public static void main(String[] args)
    {
        new AdressVerwaltungMain();
    }
}
