import java.text.DateFormatSymbols;
import java.util.*;

/**
 * @version 1.4 2007-04-07
 * @author Cay Horstmann
 */

public class CalendarTest {
	public static void main(String[] args) {
		// construct d as current date
		GregorianCalendar d = new GregorianCalendar();

		int today = d.get(Calendar.DAY_OF_MONTH);
		int month = d.get(Calendar.MONTH);

		// set d to start date of the month
		d.set(Calendar.DAY_OF_MONTH, 1);

		int weekday = d.get(Calendar.DAY_OF_WEEK);

		// get first day of week (Sunday in the U.S.)
		int firstDayOfWeek = d.getFirstDayOfWeek();

		// determine the required indentation for the first line
		int indent = 0;
		while (weekday != firstDayOfWeek) {
			indent++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}

		// print weekday names
		String[] weekdayNames = new DateFormatSymbols().getWeekdays();
		String[] monthNames = new DateFormatSymbols().getMonths();
		String monthName = monthNames[d.get(Calendar.MONTH)];
		String monthspaces = "";
		for (int i = 0; i < (90 - polMonths(monthName).length())/2; i++) {
			monthspaces += " ";
		}
		System.out.printf("%91s", polMonths(monthName) + monthspaces + "\n");
		do {
			String spaces = "";
			for (int i = 0; i < (13 - weekdayNames[weekday].length()) / 2; i++) {
				spaces += " ";
			}
			System.out.printf("%13s", weekdayNames[weekday] + spaces);
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		} while (weekday != firstDayOfWeek);
		System.out.println();

		for (int i = 1; i <= indent; i++)
			System.out.print("             ");

		d.set(Calendar.DAY_OF_MONTH, 1);
		do {
			// print day
			int day = d.get(Calendar.DAY_OF_MONTH);
			if (day != today) {
				System.out.printf("%13s", " " + day + "      ");
			} else {
				System.out.printf("%13s", "*" + day + "*     ");
			}

			// mark current day with *
			// if (day == today) System.out.print("*");
			// else System.out.print(" ");

			// advance d to the next day
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);

			// start a new line at the start of the week
			if (weekday == firstDayOfWeek)
				System.out.println();
		} while (d.get(Calendar.MONTH) == month);
		// the loop exits when d is day 1 of the next month

		// print final end of line if necessary
		if (weekday != firstDayOfWeek)
			System.out.println();
	}

	public static String polMonths(String month) {
		String result = "";
		switch (month) {
		case "stycznia": result = "STYCZEÑ"; break;
		case "lutego": result = "LUTY" ;break;
		case "marca": result = "MARZEC"; break;
		case "kwietnia": result = "KWIECIEÑ"; break;
		case "maja": result = "MAJ"; break;
		case "czerwca": result = "CZERWIEC"; break;
		case "lipca" : result = "LIPIEC"; break;
		case "sierpnia" : result = "SIERPIEÑ"; break;
		case "wrzeœnia" : result = "WRZESIEÑ"; break;
		case "paŸdziernika" : result = "PADZIERNIK"; break;
		case "listopada" : result = "LISTOPAD"; break;
		
		case "grudnia" : result = "GRUDZIEÑ"; break;
		case "" : result = "ERROR"; break;
		}
		return result;

	}
}
