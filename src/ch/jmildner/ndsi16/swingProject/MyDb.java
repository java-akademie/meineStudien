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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JTextField;

public class MyDb
{
	 static String dbDriver = "";
	private static String dbURL = "";
	 static String usr;
	 static String pwd;
	private static Connection con = null;
	private static Statement stm = null;
	private static ResultSet rs = null;
	private static String sql;


	private void fuellenDatenbank()
	{
		// fuellenOracle();
		fuellenH2();

	}


	private void fuellenH2()
	{
		dbDriver = "h2.jar";
		dbURL = "jdbc:h2:tcp://localhost:9092/~/test;USER=sa;PASSWORD=sa";
		usr = "sa";
		pwd = "sa";
	}


	void fuellenOracle()
	{

		dbDriver = "sun.jdbc.odbc.JdbcOdbcDriver";
		dbURL = "jdbc:odbc:otest";
		dbDriver = "oracle.jdbc.driver.OracleDriver";
		dbURL = "jdbc:oracle:thin:@ztxw20:1521:student";
		dbURL = "jdbc:oracle:thin:@merkur:1521:mytest";
		dbURL = "jdbc:oracle:thin:@merkur:1521:orcl";
		usr = "production";
		pwd = "production";
		usr = "johann";
		pwd = "johann";
	}


	public String dbOpen()
	{
		if (con != null)
		{
			return "datenbank ist schon geoeffnet";
		}
	

			fuellenDatenbank();
			// fuellenAccess();
			//Class.forName(dbDriver);
			try
			{
				con = DriverManager.getConnection(dbURL);
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "DB geoeffnet";
		

	}


	public String dbClose()
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


	public String tbCreate()
	{
		if (con == null)
		{
			return "datenbank ist nicht geoeffnet";
		}
		try
		{
			sql = "CREATE TABLE adressen " + "(id      INT NOT NULL " + ",name    VARCHAR(128) "
					+ ",addr    VARCHAR(128) " + ",PRIMARY KEY (id)" + ")";
			stm = con.createStatement();
			stm.executeUpdate(sql);
			stm.close();
			return "create adresse ok";
		}
		catch (SQLException e)
		{
			return "fehler bei create adresse\n" + sql + "\n" + e;
		}
	}


	public String tbDrop()
	{
		if (con == null)
		{
			return "datenbank ist nicht geoeffnet";
		}
		try
		{
			sql = "DROP TABLE adressen";
			stm = con.createStatement();
			stm.executeUpdate(sql);
			stm.close();
			return "drop adresse ok";
		}
		catch (SQLException e)
		{
			return "fehler bei drop adresse\n" + sql + "\n" + e;
		}
	}


	public String tbMassInsert(int max)
	{
		System.out.println("anfang insert");
		if (con == null)
		{
			return "datenbank ist nicht geoeffnet";
		}
		try
		{
			stm = con.createStatement();
			String name;
			String addr;
			int id;
			sql = "INSERT INTO adressen VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, 2410);
			ps.setString(2, "Mildner Johann");
			ps.setString(3, "Basel");
			ps.execute();
			for (int i = 1; i <= max; i++)
			{
				try
				{
					id = getZufallId();
					name = getZufallZuName() + " " + getZufallVorName();
					addr = getZufallAddr();
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setString(3, addr);
					ps.execute();
				}
				catch (Exception e)
				{
				}
			}
			stm.close();
			System.out.println("ende insert");
			return "insert adresse OK";
		}
		catch (SQLException e)
		{
			return "fehler bei insert adresse\n" + e;
		}
	}


	public String tbSelect(JTextField tfId, JTextField tfName, JTextField tfAddr)
	{
		String id = tfId.getText();
		String sql = "SELECT id,name,addr FROM adressen WHERE id=" + id;
		if (con == null)
		{
			return "datenbank ist nicht geoeffnet";
		}
		try
		{
			stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
			if (rs.next())
			{
				tfName.setText(rs.getString(2));
				tfAddr.setText(rs.getString(3));
			}
			return "select ok";
		}
		catch (SQLException e)
		{
			return "fehler bei select\n" + sql + "\n" + e;
		}
	}


	public String tbInsert(JTextField tfId, JTextField tfName, JTextField tfAddr)
	{
		String id = tfId.getText();
		String name = tfName.getText();
		String addr = tfAddr.getText();
		String sql = "INSERT INTO adressen VALUES(" + id + ",'" + name + "','" + addr + "')";
		if (con == null)
		{
			return "datenbank ist nicht geoeffnet";
		}
		try
		{
			stm = con.createStatement();
			stm.executeUpdate(sql);
			stm.close();
			return "insert OK";
		}
		catch (SQLException e)
		{
			return "fehler bei insert\n" + sql + "\n" + e;
		}
	}


	public String tbDelete(JTextField tfId, JTextField tfName, JTextField tfAddr)
	{
		String id = tfId.getText();
		String sql = "DELETE FROM adressen WHERE id=" + id;
		if (con == null)
		{
			return "datenbank ist nicht geoeffnet";
		}
		try
		{
			stm = con.createStatement();
			stm.executeUpdate(sql);
			stm.close();
			tfId.setText("");
			tfName.setText("");
			tfAddr.setText("");
			return "delete OK";
		}
		catch (SQLException e)
		{
			return "fehler bei delete\n" + sql + "\n" + e;
		}
	}


	public String update(String id, String name, String addr)
	{
		if (con == null)
		{
			return "datenbank ist nicht geoeffnet";
		}
		String sql = "UPDATE adressen SET name='" + name + "',addr='" + addr + "' WHERE id=" + id;
		try
		{
			stm = con.createStatement();
			stm.executeUpdate(sql);
			stm.close();
			return "update OK";
		}
		catch (SQLException e)
		{
			return "fehler bei update\n" + sql + "\n" + e;
		}
	}


	public Vector<String> fuellenColHeader()
	{
		Vector<String> colHeader = new Vector<String>();
		colHeader.add("id");
		colHeader.add("name");
		colHeader.add("addr");
		return colHeader;
	}


	public Vector<Vector<String>> fuellenData()
	{
		Vector<Vector<String>> data = new Vector<Vector<String>>();
		Vector<String> zeile;
		if (con == null)
		{
			zeile = new Vector<String>();
			zeile.add("db nicht geoeffnet");
			zeile.add("");
			zeile.add("");
			data.add(zeile);
			return data;
		}
		try
		{
			sql = "SELECT id,name,addr FROM adressen ORDER BY 1";
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next())
			{
				zeile = new Vector<String>();
				zeile.add(rs.getString(1));
				zeile.add(rs.getString(2));
				zeile.add(rs.getString(3));
				data.add(zeile);
			}
			stm.close();
		}
		catch (SQLException e)
		{
		}
		return data;
	}


	public String tbFirstRecord(JTextField tfId, JTextField tfName, JTextField tfAddr)
	{
		if (con == null)
		{
			return "datenbank ist nicht geoeffnet";
		}
		try
		{
			sql = "SELECT id,name,addr FROM adressen ORDER BY 1";
			stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
			if (rs.first())
			{
				tfId.setText(rs.getString(1));
				tfName.setText(rs.getString(2));
				tfAddr.setText(rs.getString(3));
				return "erster Satz";
			}
			else
			{
				tfId.setText("");
				tfName.setText("");
				tfAddr.setText("");
				return "kein satz vorhanden";
			}
		}
		catch (SQLException e)
		{
			return "" + "fehler\n" + sql + "\n" + e;
		}
	}


	public String tbLastRecord(JTextField tfId, JTextField tfName, JTextField tfAddr)
	{
		if (con == null)
		{
			return "datenbank ist nicht geoeffnet";
		}
		try
		{
			sql = "SELECT id,name,addr FROM adressen ORDER BY 1";
			stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
			if (rs.last())
			{
				tfId.setText(rs.getString(1));
				tfName.setText(rs.getString(2));
				tfAddr.setText(rs.getString(3));
				return "letzter Satz";
			}
			else
			{
				tfId.setText("");
				tfName.setText("");
				tfAddr.setText("");
				return "kein satz vorhanden";
			}
		}
		catch (SQLException e)
		{
			return "" + "fehler\n" + sql + "\n" + e;
		}
	}


	public String tbNextRecord(JTextField tfId, JTextField tfName, JTextField tfAddr)
	{
		if (con == null)
		{
			return "datenbank ist nicht geoeffnet";
		}
		try
		{
			if (rs == null)
			{
				return tbFirstRecord(tfId, tfName, tfAddr);
			}
			else
			{
				if (rs.next())
				{
					tfId.setText(rs.getString(1));
					tfName.setText(rs.getString(2));
					tfAddr.setText(rs.getString(3));
					return "ok";
				}
				else
				{
					rs = null;
					return "letzter Satz";
				}
			}
		}
		catch (SQLException e)
		{
			return "" + "fehler\n" + e;
		}
	}


	public String tbPrevRecord(JTextField tfId, JTextField tfName, JTextField tfAddr)
	{
		if (con == null)
		{
			return "datenbank ist nicht geoeffnet";
		}
		try
		{
			if (rs == null)
			{
				return tbLastRecord(tfId, tfName, tfAddr);
			}
			else
			{
				if (rs.previous())
				{
					tfId.setText(rs.getString(1));
					tfName.setText(rs.getString(2));
					tfAddr.setText(rs.getString(3));
					return "ok";
				}
				else
				{
					rs = null;
					return "erster Satz";
				}
			}
		}
		catch (SQLException e)
		{
			return "" + "fehler\n" + e;
		}
	}


	private static int getZufallId()
	{
		return getRandom(1000, 9999);
	}


	private static String getZufallVorName()
	{
		String x;
		int i = getRandom(0, 20);
		switch (i)
		{
			case 1:
				x = "Johanna";
				break;
			case 2:
				x = "Fritz";
				break;
			case 3:
				x = "Hubert";
				break;
			case 4:
				x = "Moritz";
				break;
			case 5:
				x = "Gerda";
				break;
			case 6:
				x = "Hannelore";
				break;
			case 7:
				x = "Edith";
				break;
			case 8:
				x = "Claudia";
				break;
			case 9:
				x = "Ferdi";
				break;
			case 10:
				x = "Annemarie";
				break;
			case 11:
				x = "Joerg";
				break;
			case 12:
				x = "Ute";
				break;
			case 13:
				x = "Lorelei";
				break;
			case 14:
				x = "Juergen";
				break;
			case 15:
				x = "Martin";
				break;
			case 16:
				x = "Gloria";
				break;
			case 18:
				x = "Maximilian";
				break;
			case 19:
				x = "Holger";
				break;
			case 20:
				x = "Sepp";
				break;
			default:
				x = "Max";
				break;
		}
		return x;
	}


	private static String getZufallZuName()
	{
		String x;
		int i = getRandom(0, 20);
		switch (i)
		{
			case 1:
				x = "Witt";
				break;
			case 2:
				x = "Wepper";
				break;
			case 3:
				x = "Meier";
				break;
			case 4:
				x = "Gruber";
				break;
			case 5:
				x = "Stolzenbein";
				break;
			case 6:
				x = "Mueller";
				break;
			case 7:
				x = "Ahorn";
				break;
			case 8:
				x = "Behorn";
				break;
			case 9:
				x = "Lauper";
				break;
			case 10:
				x = "Friedenreich";
				break;
			case 11:
				x = "Utter";
				break;
			case 12:
				x = "Milek";
				break;
			case 13:
				x = "Waeltli";
				break;
			case 14:
				x = "Horch";
				break;
			case 15:
				x = "Sauber";
				break;
			case 16:
				x = "Thun";
				break;
			case 18:
				x = "Schihin";
				break;
			case 19:
				x = "Blauer";
				break;
			case 20:
				x = "Hermann";
				break;
			default:
				x = "Froehlich";
				break;
		}
		return x;
	}


	private static String getZufallAddr()
	{
		String x;
		int i = getRandom(0, 20);
		switch (i)
		{
			case 1:
				x = "Basel";
				break;
			case 2:
				x = "Zuerich";
				break;
			case 3:
				x = "Zug";
				break;
			case 4:
				x = "Genf";
				break;
			case 5:
				x = "Biel";
				break;
			case 6:
				x = "Muenchen";
				break;
			case 7:
				x = "Frankfurt";
				break;
			case 8:
				x = "Berlin";
				break;
			case 9:
				x = "Bern";
				break;
			case 10:
				x = "Graz";
				break;
			case 11:
				x = "Wien";
				break;
			case 12:
				x = "Laufen";
				break;
			case 13:
				x = "Luzern";
				break;
			case 14:
				x = "St.Gallen";
				break;
			case 15:
				x = "Schffhausen";
				break;
			case 16:
				x = "Aarau";
				break;
			case 18:
				x = "Brigg";
				break;
			case 19:
				x = "Brugg";
				break;
			case 20:
				x = "Baden";
				break;
			default:
				x = "Winterthur";
				break;
		}
		return x;
	}


	private static int getRandom(int min, int max)
	{
		return (int) (min + (Math.random() * (max - min + 1)));
	}
}
