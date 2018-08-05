
package ch.jmildner.pruefungen.mp120;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame
{
    Frame frame;


    public MyFrame(String f)
    {
        frame = new Frame(f);
        frame.add(new MyPanel());
        frame.setSize(600, 400);
        frame.setLocation(100, 300);
        frame.setVisible(true);
        frame.pack();
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
        new MyFrame("datenbank");
    }
}
