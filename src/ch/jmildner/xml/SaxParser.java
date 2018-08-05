package ch.jmildner.xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ch.jmildner.tools.MyTools;

public class SaxParser extends DefaultHandler
{
	private int level = 0;


	public static void main(String[] args) throws Exception
	{
		MyTools.uebOut("SaxParser", 2);

		parse("src/ch/jmildner/xml/_myprofile.xml");
		parse("src/ch/jmildner/xml/log4j.xml");
		parse("src/ch/jmildner/xml/pom.xml");
		parse("src/ch/jmildner/xml/test.xml");

		System.out.println("Programmende");
	}


	private static void parse(String file) throws Exception
	{
		MyTools.uebOut(file, 2);

		DefaultHandler handler = new SaxParser();

		File datei = new File(file);

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(datei, handler);
	}


	public void startDocument()
	{
		MyTools.uebOut("Start Dokument", 2);
	}


	public void endDocument()
	{
		MyTools.untOut("End Dokument", 2);
	}


	private Object leerzeichen(int level)
	{
		StringBuffer sb = new StringBuffer();

		int leerzeichen = 4 * (level - 1);

		for (int i = 1; i <= leerzeichen; i++)
			sb.append(" ");

		return sb.toString();
	}



	private String showUri(String s)
	{
		if (s == null || s.equals(""))
			return "";

		return " uri=" + s + " ";
	}


	private String showLocalName(String s)
	{
		if (s == null || s.equals(""))
			return "";

		return " localName=" + s + " ";
	}


	private String showSName(String s)
	{
		if (s == null || s.equals(""))
			return "";

		return " sName=" + s + " ";
	}



	private Object showAttributes(Attributes a)
	{
		if (a.getLength() == 0)
			return "";

		String ret = "";

		for (int i = 0; i < a.getLength(); i++)
		{
			ret += " " + a.getQName(i);
			ret += "=\"" + a.getValue(i) + "\"";
		}

		return ret;
	}


	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException
	{
		level++;

		System.out.printf("%s<%s%s%s%s> %n", leerzeichen(level), qName, showUri(uri),
				showLocalName(localName), showAttributes(attributes));
	}


	public void endElement(String uri, String sName, String qName) throws SAXException
	{

		System.out.printf("%s</%s%s%s> %n", leerzeichen(level), qName, showSName(sName),
				showUri(uri));
		level--;

	}


	public void characters(char[] ch, int start, int length)
	{
		String string = new String(ch, start, length);
		string = string.trim();

		if (string.equals(""))
		{
			System.out.println();
		}
		else
		{
			String[] a = string.split("(\\n)+");

			level++;
			for (String s : a)
			{
				s = s.trim();
				System.out.printf("%s%s %n", leerzeichen(level), s);
			}
			level--;
		}
	}


}
