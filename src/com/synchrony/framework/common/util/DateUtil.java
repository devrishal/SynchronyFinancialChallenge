package com.synchrony.framework.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String formatDate(Date d) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String date = simpleDateFormat.format(d);
		return date;

	}

	public static java.sql.Timestamp getCurrentTimeStamp() {

		Date today = new Date();
		return new java.sql.Timestamp(today.getTime());

	}
}
