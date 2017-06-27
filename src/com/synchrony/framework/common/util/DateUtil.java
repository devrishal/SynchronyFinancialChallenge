package com.synchrony.framework.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String formatDate(Date d) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String date = simpleDateFormat.format(d);
		return date;

	}

}
