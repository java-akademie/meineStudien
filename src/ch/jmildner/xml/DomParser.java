package ch.jmildner.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.helpers.DefaultHandler;

import ch.jmildner.tools.MyTools;

public class DomParser extends DefaultHandler
{
	public static void main(String[] args) throws Exception
	{
		MyTools.uebOut("DomParser", 2);

//		parse("src/ch/jmildner/xml/_myprofile.xml");
//		parse("src/ch/jmildner/xml/log4j.xml");
//		parse("src/ch/jmildner/xml/pom.xml");
		parse("src/ch/jmildner/xml/test.xml");

		System.out.println("Programmende");
	}


	private static void parse(String file) throws Exception
	{
		MyTools.uebOut(file, 2);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.parse(new File(file));

		new MyTreeTraverser(doc);
		
		MyTools.untOut(file, 2);
	}

}
