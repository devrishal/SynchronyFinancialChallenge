package com.synchrony.framework.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;

import com.synchrony.framework.exception.ApplicationFatalException;

/**
 * Class to read property files useful in application.
 * 
 * @author Rishal_Singh
 *
 */
public class PropertyUtil {
	private PropertyUtil() {
	}

	/**
	 * Reterieve property from property files.
	 * 
	 * @param propertyName
	 * @param context
	 * @return
	 * @throws ApplicationFatalException
	 */
	public static String getProperty(String propertyName, ServletContext context) throws ApplicationFatalException {
		Properties prop = new Properties();
		InputStream input = null;
		input = context.getResourceAsStream("/data/ApplicationConfiguration.properties");

		try {
			prop.load(input);

		} catch (IOException e) {
			throw new ApplicationFatalException(e.getMessage(), e.getCause());
		}
		return prop.getProperty(propertyName);

	}
}
