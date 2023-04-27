package com.eabm.tools;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IOTools {
	private static Logger log = LogManager.getLogger();
	
	public static void close(InputStream input) {
		try {
			if(input == null)
				return;
			input.close();
		} catch(Exception ex) {
			log.error("Error while closing InputStream", ex);
		} finally {
			input = null;
		}
	}
	
	public static void close(OutputStream output) {
		try {
			if(output == null)
				return;
			output.close();
		} catch(Exception ex) {
			log.error("Error while closing OutputStream...", ex);
		} finally {
			output = null;
		}
	}
	
	
}
