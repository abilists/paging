package jp.ameba.sg2.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jp.ameba.sg2.common.utility.DateUtility;

public class DateMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// System.out.println("abcd>>>>1>>>>>" + DateUtility.getStartToday(2011, 05, 24, 11));
		// System.out.println("abcd>>>>2>>>>>" + DateUtility.getEndToday(2011, 05, 24, 11));
//		long currentMillis = System.currentTimeMillis();
//		Calendar calSevenDay = Calendar.getInstance();
//		Date aaa = calSevenDay.getTime();
//		Date bbb = new Date(aaa.getTime());
//
//		System.out.println("abcd>>>>2>>>>>" + aaa);
//		System.out.println("abcd>>>>3>>>>>" + DateUtility.getHourOfDayMoveTime(bbb, -1));
//		System.out.println("abcd>>>>4>>>>>" + aaa);
//		Calendar calDay = Calendar.getInstance();
//		


		SimpleDateFormat sdfa = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String nowTime = sdfa.format(DateUtility.getEndBeforeDay(1));
		
		System.out.println(">>>>" + nowTime);
	}

}