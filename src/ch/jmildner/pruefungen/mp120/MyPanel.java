
package ch.jmildner.pruefungen.mp120;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel
        extends Panel
{
    private static final long serialVersionUID = 1L;

    Button dbOpen = new Button("dbOpen");
    Button dbClose = new Button("dbClose");
    Button kCreate = new Button("createKunde");
    Button kDrop = new Button("dropKunde");
    Button kInsert = new Button("insertKunde");
    Button kDelete = new Button("deleteKunde");
    Button kSelect = new Button("selectKunde");
    Button clear = new Button("clear");
    TextField tfNummer = new TextField("", 8);
    TextField tfName = new TextField("", 24);
    TextField tfAddr = new TextField("", 24);
    TextArea ta = new TextArea(12, 88);
    MyDb mdb = new MyDb();


    public MyPanel()
    {
        makeTheLayout();
        addTheListener();
    }


    private void makeTheLayout()
    {
        Panel p1 = makePanel1();
        Panel p2 = makePanel2();
        Panel p3 = makePanel3();
        setLayout(new BorderLayout());
        add("North", p1);
        add("Center", p2);
        add("South", p3);
    }


    private Panel makePanel1()
    {
        Panel p = new Panel();
        p.add(new Label("Modulpruefung 120 Vorname Zuname"));
        return p;
    }


    private Panel makePanel2()
    {
        Panel p = new Panel();
        p.setLayout(new GridLayout(4, 4));
        p.add(new Label(""));
        p.add(dbOpen);
        p.add(dbClose);
        p.add(new Label(""));
        p.add(new Label(""));
        p.add(kCreate);
        p.add(kDrop);
        p.add(new Label(""));
        p.add(new Label(""));
        p.add(kInsert);
        p.add(kDelete);
        p.add(new Label(""));
        p.add(new Label(""));
        p.add(kSelect);
        p.add(clear);
        p.add(new Label(""));
        return p;
    }


    private Panel makePanel3()
    {
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout());
        p1.add(new Label("Nr:"));
        p1.add(tfNummer);
        p1.add(new Label("Name:"));
        p1.add(tfName);
        p1.add(new Label("Addr:"));
        p1.add(tfAddr);
        Panel p2 = new Panel();
        p2.add(ta);
        Panel p = new Panel();
        p.setLayout(new BorderLayout());
        p.add("North", p1);
        p.add("South", p2);
        return p;
    }


    private void addTheListener()
    {
        dbOpen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                ta.setText(mdb.dbOpen());
            }
        });
        dbClose.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                ta.setText(mdb.dbClose());
            }
        });
        kCreate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                ta.setText(mdb.kCreate());
            }
        });
        kDrop.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                ta.setText(mdb.kDrop());
            }
        });
        kSelect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                ta.setText(mdb.kSelect());
            }
        });
        kDelete.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                ta.setText(mdb.kDelete(tfNummer.getText()));
            }
        });
        kInsert.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                if (tfNummer.getText().equals(""))
                {
                    System.out.println("tfNummer.getText()"
                            + tfNummer.getText() + "x");
                    ta.setText(mdb.kInsert());
                }
                else
                {
                    ta.setText(mdb.kInsert(tfNummer.getText(),
                            tfName.getText(), tfAddr.getText()));
                }
            }
        });
        clear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                tfNummer.setText("");
                tfName.setText("");
                tfAddr.setText("");
                ta.setText("");
            }
        });
    }
}
