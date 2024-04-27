package dascalu.common;

public class Utils {

	public static String convertDate(String element) {
		int start = element.indexOf("dataNascita")+ "dataNascita".length()+3;
		int end = start+12;
		String date = element.substring(start, end);
		return element.replace(date, date.replace("Z", ""));
	}
}
