package ch.jmildner.syst.wiederholer;

/**
 * Defines operations of interface Wiederholer.
 * 
 * @author Johann Mildner, Basel
 */
public interface Wiederholer
{
	/**
	 * gibt true zurueck falls noch ein String in der Tabelle vorhanden ist.
	 * 
	 * @return true falls noch ein String in der Tabelle vorhanden ist
	 */
	public boolean hatNochEinen();

	/**
	 * gibt den naechsten String aus der Tabelle zurueck
	 * 
	 * @return den naechsten String aus der Tabelle
	 */
	public String naechster();

	/**
	 * Loescht den String an der Cursorposition
	 */
	public void loeschen();
}
