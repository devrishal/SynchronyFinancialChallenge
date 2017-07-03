package com.synchrony.framework.common;

/**
 * Class to have all the constants used throughout the application.
 * 
 * @author Rishal_singh
 *
 */
public class SynchronyCommon {
	private SynchronyCommon() {
	}

	/* Database related Details */
	public static final String DB_CONNECTION_URL = "DB_CONNECTION_URL";
	public static final String DB_DRIVER = "DB_DRIVER";
	public static final String DB_USER = "DB_USER";
	public static final String DB_PWD = "DB_PWD";
	public static final String DB_CONNECTION = "DB_CONNECTION";
	public static final String USER_DETAILS = "USER_DETAILS";

	/* Key to Store Application data/User Details in the context */
	public static final String Application_Data = "APP_DATA";
	
	/* Application Date Format */
	public static final String DATE_FORMAT = "DD/MM/YYYY";
	
	/* Declared for handling pagination */
	public static final String NEXT_PAGE = "next";
	public static final String PREV_PAGE = "previous";
	public static final String LIST_OF_RECORDS_IN_PAGINATED = "LIST_OF_RECORDS_IN_PAGINATED";
	public static final String Pagination_Direction = "page";
	public static final String PAGE_NUM = "PAGE_NUM";
	/* Declared for handling pagination */
	
	public static final String APP_MESSAGE="APP_MESSAGE";
	public static final String ERROR_MESSAGE="Error_Message";
}
