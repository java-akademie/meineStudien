package ch.jmildner.logging;

import org.apache.log4j.Logger;

import ch.jmildner.tools.MyTools;

public class Logging
{
	private static final Logger LOG = Logger.getLogger(Logging.class);


	public static void main(String[] args)
	{
		MyTools.uebOut("Logging - Start");

		LOG.info("App - eine Information");

		LOG.fatal("App - ein fataler Fehler");

		LOG.error("App - eine Errormeldung");

		LOG.warn("App - eine Warnmeldung");

		MyTools.untOut("Logging - Stopp");
	}
}
