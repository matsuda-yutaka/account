package com.diworksdev.account.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeFromStringToDate {

	public static void main(String[] args) {

		try {
			String stDate = "registered_time";
			System.out.println("String型 = " + stDate);

			Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(stDate);
			System.out.println("Date型 = " + date);

		} catch (ParseException ex) {
			ex.printStackTrace();
		}
	}
}