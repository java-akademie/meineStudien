
package ch.jmildner.spiele.lotto;

import java.awt.Container;

import javax.swing.JApplet;

public class LottoApplet
        extends JApplet
{
    private static final long serialVersionUID = 1L;


    public void init()
    {
        Container cont = getContentPane();
        cont.add(new LottoPanel());
    }
}
