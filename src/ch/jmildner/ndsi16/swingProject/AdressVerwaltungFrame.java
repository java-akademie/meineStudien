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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import ch.jmildner.tools.SwingTools;

@SuppressWarnings("deprecation")
public class AdressVerwaltungFrame extends JFrame implements ActionListener
{

    private static final long serialVersionUID = 1L;

    MyDb mdb = new MyDb();
    Container container = getContentPane();
    JPanel contentPanel;

    public AdressVerwaltungFrame(String s)
    {
        super(s);
        JMenuBar menuBar = new JMenuBar();
        JMenuItem menuItem;
        // Datenbank
        JMenu menuDatenbank = new JMenu("Datenbank");
        menuItem = new JMenuItem("Connect");
        menuDatenbank.add(menuItem);
        menuItem.addActionListener(this);
        menuItem = new JMenuItem("Create Adressen");
        menuDatenbank.add(menuItem);
        menuItem.addActionListener(this);
        menuItem = new JMenuItem("Drop Adressen");
        menuDatenbank.add(menuItem);
        menuItem.addActionListener(this);
        menuItem = new JMenuItem("Insert Adressen");
        menuDatenbank.add(menuItem);
        menuItem.addActionListener(this);
        menuItem = new JMenuItem("Disconnect");
        menuDatenbank.add(menuItem);
        menuItem.addActionListener(this);
        menuItem = new JMenuItem("exit");
        menuDatenbank.add(menuItem);
        menuItem.addActionListener(this);
        menuBar.add(menuDatenbank);
        // Adressen
        JMenu menuAdressen = new JMenu("Adressen");
        menuItem = new JMenuItem("alle anzeigen");
        menuAdressen.add(menuItem);
        menuItem.addActionListener(this);
        menuItem = new JMenuItem("einfuegen/aendern/loeschen");
        menuAdressen.add(menuItem);
        menuItem.addActionListener(this);
        menuBar.add(menuAdressen);
        // Hilfe
        JMenu menuHilfe = new JMenu("Hilfe");
        menuItem = new JMenuItem("Tips");
        menuHilfe.add(menuItem);
        menuItem.addActionListener(this);
        menuItem = new JMenuItem("About");
        menuHilfe.add(menuItem);
        menuItem.addActionListener(this);
        menuBar.add(menuHilfe);
        setJMenuBar(menuBar);
    }

    private void addTheToolBox(JPanel container)
    {
        JToolBar toolBar;
        JButton bFirst = new JButton("<<");
        JButton bPrev = new JButton("<");
        JButton bNext = new JButton(">");
        JButton bLast = new JButton(">>");
        bFirst.setToolTipText("first");
        bPrev.setToolTipText("prev");
        bNext.setToolTipText("next");
        bLast.setToolTipText("last");
        bFirst.removeActionListener(this);
        bPrev.removeActionListener(this);
        bNext.removeActionListener(this);
        bLast.removeActionListener(this);
        bFirst.addActionListener(this);
        bPrev.addActionListener(this);
        bNext.addActionListener(this);
        bLast.addActionListener(this);
        toolBar = new JToolBar();
        toolBar.add(bFirst);
        toolBar.add(bPrev);
        toolBar.add(bNext);
        toolBar.add(bLast);
        container.add(toolBar, "South");
    }

    private void addTips()
    {
        removeContentPanel();
        contentPanel = new JPanel();
        contentPanel.add(new JLabel("Tipps"));
        contentPanel.add(new JLabel("Tipps"));
        contentPanel.add(new JLabel("Tipps"));
        container.add(contentPanel, "Center");
        setVisible(true);
        pack();
    }

    private void addAbout()
    {
        removeContentPanel();
        contentPanel = new JPanel();
        contentPanel.add(new JLabel("About"));
        contentPanel.add(new JLabel("About"));
        contentPanel.add(new JLabel("About"));
        container.add(contentPanel, "Center");
        setVisible(true);
        pack();
    }

    private void dbConnect()
    {
        removeContentPanel();
        JTextArea textArea = new JTextArea(10, 50);
        textArea.append("dbConnect \n\n");
        textArea.append(mdb.dbOpen());
        contentPanel = new JPanel();
        contentPanel.add(textArea);
        container.add(contentPanel, "Center");
        setVisible(true);
        pack();
    }

    private void dbDisconnect()
    {
        removeContentPanel();
        JTextArea textArea = new JTextArea(10, 50);
        textArea.append("dbDisconnect \n\n");
        textArea.append(mdb.dbClose());
        contentPanel = new JPanel();
        contentPanel.add(textArea);
        container.add(contentPanel, "Center");
        setVisible(true);
        pack();
    }

    private void createAdressen()
    {
        removeContentPanel();
        JTextArea textArea = new JTextArea(10, 50);
        textArea.append("create Adressen \n\n");
        textArea.append(mdb.tbCreate());
        contentPanel = new JPanel();
        contentPanel.add(textArea);
        container.add(contentPanel, "Center");
        setVisible(true);
        pack();
    }

    private void dropAdressen()
    {
        removeContentPanel();
        JTextArea textArea = new JTextArea(10, 50);
        textArea.append("create Adressen \n\n");
        textArea.append(mdb.tbDrop());
        contentPanel = new JPanel();
        contentPanel.add(textArea);
        container.add(contentPanel, "Center");
        setVisible(true);
        pack();
    }

    private void insertAdressen()
    {
        removeContentPanel();
        JTextArea textArea = new JTextArea(10, 30);
        textArea.append("create Adressen \n\n");
        textArea.append(mdb.tbMassInsert(40));
        contentPanel = new JPanel();
        contentPanel.add(textArea);
        container.add(contentPanel, "Center");
        setVisible(true);
        pack();
    }

    private void anzeigenAdressen()
    {
        removeContentPanel();
        Vector<?> data = mdb.fuellenData();
        Vector<?> colHeader = mdb.fuellenColHeader();
        JTable tab = new JTable(data, colHeader);
        contentPanel = new JPanel();
        contentPanel.add(new JScrollPane(tab));
        container.add(contentPanel, "Center");
        setVisible(true);
        pack();
    }

    JTextField tfId = new JTextField(5);
    JTextField tfName = new JTextField(25);
    JTextField tfAddr = new JTextField(25);
    JTextArea taErg = new JTextArea(10, 35);

    private void addErfassungsmaske()
    {
        removeContentPanel();
        JPanel p1 = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        p1.setLayout(gbl);
        JLabel lbUeberschr = new JLabel("anzeigen/erfassen/aendern/loeschen");
        JLabel lbLeerzeile = new JLabel("");
        JLabel lbId = new JLabel("Id:");
        JLabel lbName = new JLabel("Name:");
        JLabel lbAddr = new JLabel("Addr:");
        SwingTools.addComponent(p1, gbl, lbUeberschr, 1, 1, 2, 1, 0, 5);
        SwingTools.addComponent(p1, gbl, lbLeerzeile, 2, 1, 2, 1, 0, 5);
        SwingTools.addComponent(p1, gbl, lbId, 3, 1, 1, 1, 0, 4);
        SwingTools.addComponent(p1, gbl, tfId, 3, 2, 1, 1, 0, 4);
        SwingTools.addComponent(p1, gbl, lbName, 4, 1, 1, 1, 0, 4);
        SwingTools.addComponent(p1, gbl, tfName, 4, 2, 1, 1, 0, 4);
        SwingTools.addComponent(p1, gbl, lbAddr, 5, 1, 1, 1, 0, 4);
        SwingTools.addComponent(p1, gbl, tfAddr, 5, 2, 1, 1, 0, 4);
        SwingTools.addComponent(p1, gbl, taErg, 6, 1, 2, 1, 0, 5);
        JButton btSelect = new JButton("select");
        JButton btInsert = new JButton("insert");
        JButton btUpdate = new JButton("update");
        JButton btDelete = new JButton("delete");
        btSelect.addActionListener(this);
        btInsert.addActionListener(this);
        btUpdate.addActionListener(this);
        btDelete.addActionListener(this);
        JPanel pButtons = new JPanel();
        pButtons.add(btSelect);
        pButtons.add(btInsert);
        pButtons.add(btUpdate);
        pButtons.add(btDelete);
        SwingTools.addComponent(p1, gbl, pButtons, 7, 1, 2, 1, 0, 6);
        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(p1, "Center");
        addTheToolBox(p2);
        contentPanel = new JPanel();
        contentPanel.add(p2);
        container.add(contentPanel, "Center");
        setVisible(true);
        firstRecord();
        pack();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("exit"))
        {
            System.exit(0);
            return;
        }
        if (e.getActionCommand().equals("einfuegen/aendern/loeschen"))
        {
            System.out.println("einfuegen/aendern/loeschen aufgerufen");
            addErfassungsmaske();
            return;
        }
        if (e.getActionCommand().equals("<<"))
        {
            firstRecord();
            return;
        }
        if (e.getActionCommand().equals("<"))
        {
            prevRecord();
            return;
        }
        if (e.getActionCommand().equals(">"))
        {
            nextRecord();
            return;
        }
        if (e.getActionCommand().equals(">>"))
        {
            lastRecord();
            return;
        }
        if (e.getActionCommand().equals("select"))
        {
            select();
            return;
        }
        if (e.getActionCommand().equals("insert"))
        {
            insert();
            return;
        }
        if (e.getActionCommand().equals("update"))
        {
            update();
            return;
        }
        if (e.getActionCommand().equals("delete"))
        {
            delete();
            return;
        }
        if (e.getActionCommand().equals("Tips"))
        {
            addTips();
            return;
        }
        if (e.getActionCommand().equals("About"))
        {
            addAbout();
            return;
        }
        if (e.getActionCommand().equals("Connect"))
        {
            dbConnect();
            return;
        }
        if (e.getActionCommand().equals("Disconnect"))
        {
            dbDisconnect();
            return;
        }
        if (e.getActionCommand().equals("Create Adressen"))
        {
            createAdressen();
            return;
        }
        if (e.getActionCommand().equals("Drop Adressen"))
        {
            dropAdressen();
            return;
        }
        if (e.getActionCommand().equals("Insert Adressen"))
        {
            insertAdressen();
            return;
        }
        if (e.getActionCommand().equals("alle anzeigen"))
        {
            anzeigenAdressen();
            return;
        }
    }

    private void firstRecord()
    {
        taErg.setText(mdb.tbFirstRecord(tfId, tfName, tfAddr));
    }

    private void lastRecord()
    {
        taErg.setText(mdb.tbLastRecord(tfId, tfName, tfAddr));
    }

    private void nextRecord()
    {
        taErg.setText(mdb.tbNextRecord(tfId, tfName, tfAddr));
    }

    private void prevRecord()
    {
        taErg.setText(mdb.tbPrevRecord(tfId, tfName, tfAddr));
    }

    private void select()
    {
        if (isNumeric(tfId.getText()))
        {
            taErg.setText(mdb.tbSelect(tfId, tfName, tfAddr));
        }
        else
        {
            taErg.setText("id ist nicht numerisch");
        }
    }

    private void insert()
    {
        if (isNumeric(tfId.getText()))
        {
            taErg.setText(mdb.tbInsert(tfId, tfName, tfAddr));
        }
        else
        {
            taErg.setText("id ist nicht numerisch");
        }
    }

    private void delete()
    {
        if (isNumeric(tfId.getText()))
        {
            taErg.setText(mdb.tbDelete(tfId, tfName, tfAddr));
        }
        else
        {
            taErg.setText("id ist nicht numerisch");
        }
    }

    private void update()
    {
        if (!isNumeric(tfId.getText()))
        {
            taErg.setText("id ist nicht numerisch");
            return;
        }
        taErg.setText(mdb.update(tfId.getText(), tfName.getText(), tfAddr.getText()));
    }

    private static boolean isNumeric(String x)
    {
        try
        {
            Integer.parseInt(x);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    private void removeContentPanel()
    {
        if (contentPanel == null)
        {
        }
        else
        {
            container.remove(contentPanel);
        }
    }
}
