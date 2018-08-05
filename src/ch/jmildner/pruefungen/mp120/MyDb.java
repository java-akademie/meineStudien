
package ch.jmildner.pruefungen.mp120;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDb
{
    static String dbDriver = "";
    static String dbURL = "";
    static Connection con = null;
    static Statement stm = null;
    static ResultSet rs = null;


    String dbOpen()
    {
        if (con != null)
        {
            return "datenbank ist schon geoeffnet";
        }
        dbDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        dbURL = "jdbc:odbc:atest";
        try
        {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbURL);
            return "db geoeffnet";
        }
        catch (ClassNotFoundException e)
        {
            return "fehler bei treiber laden\n" + e;
        }
        catch (SQLException e)
        {
            return "fehler bei connect\n" + e;
        }
    }


    String dbClose()
    {
        if (con == null)
        {
            return "datenbank ist nicht geoeffnet";
        }
        try
        {
            con.close();
            con = null;
            return "db geschlossen";
        }
        catch (SQLException e)
        {
            return "connection kann nicht geschlossen werden\n" + e;
        }
    }


    String kCreate()
    {
        if (con == null)
        {
            return "datenbank ist nicht geoeffnet";
        }
        try
        {
            stm = con.createStatement();
            stm.executeUpdate("CREATE TABLE kunde " + "(nummer  INT NOT NULL"
                    + ",name 		CHAR(20)  " + ",addr 		CHAR(20)  "
                    + ",PRIMARY KEY (nummer)" + ");");
            stm.close();
            return "create kunde ok";
        }
        catch (SQLException e)
        {
            return "fehler bei create kunde" + e;
        }
    }


    String kDrop()
    {
        if (con == null)
        {
            return "datenbank ist nicht geoeffnet";
        }
        try
        {
            stm = con.createStatement();
            stm.executeUpdate("DROP TABLE kunde ");
            stm.close();
            return "drop kunde ok";
        }
        catch (SQLException e)
        {
            return "fehler bei drop kunde: " + e;
        }
    }


    String kInsert()
    {
        for (int i = 0; i < 100; i++)
        {
            kInsert("" + i, "name" + i, "addr" + i);
        }
        return "100 initrecords eingefuegt";
    }


    String kInsert(String nr, String name, String addr)
    {
        if (con == null)
        {
            return "datenbank ist nicht geoeffnet";
        }
        try
        {
            stm = con.createStatement();
            int nummer;
            try
            {
                nummer = Integer.parseInt(nr);
            }
            catch (Exception e)
            {
                nummer = 0;
            }
            stm.executeUpdate("INSERT INTO kunde " + "VALUES (" + nummer + ","
                    + "'" + name + "'" + "," + "'" + addr + "'" + ")");
            stm.close();
            return "insert kunde OK";
        }
        catch (SQLException e)
        {
            return "fehler bei insert kunde\n" + e;
        }
    }


    String kDelete(String nr)
    {
        if (con == null)
        {
            return "datenbank ist nicht geoeffnet";
        }
        try
        {
            stm = con.createStatement();
            stm.executeUpdate("DELETE FROM kunde WHERE nummer=" + nr);
            stm.close();
            return "delete kunde OK";
        }
        catch (SQLException e)
        {
            return "fehler bei delete kunde\n" + e;
        }
    }


    String kSelect()
    {
        if (con == null)
        {
            return "datenbank ist nicht geoeffnet";
        }
        try
        {
            stm = con.createStatement();
            rs = stm
                    .executeQuery("SELECT nummer,name,addr FROM kunde ORDER BY kunde.nummer");
            String s4 = "";
            while (rs.next())
            {
                String s1 = rs.getString(1);
                String s2 = rs.getString(2);
                String s3 = rs.getString(3);
                s4 = s4 + s1 + "  " + s2 + "  " + s3 + "\n";
                System.out.println(s1);
                System.out.print(s2);
                System.out.print(s3);
            }
            stm.close();
            return s4;
        }
        catch (SQLException e)
        {
            return "fehler bei anzeigenKunden\n" + e
                    + "\ndatenbank ist eventuell nicht geoeffnet"
                    + "\noder tabelle 'kunde' nicht vorhanden";
        }
    }
}
