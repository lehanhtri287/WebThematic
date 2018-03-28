package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
	public static boolean checkEmail(String email) {
		Pattern pt1 = Pattern.compile("\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", Pattern.CASE_INSENSITIVE);
		Matcher mt1 = pt1.matcher(email);
		if (mt1.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkPhoneNumber(String number) {
		Pattern pattern1 = Pattern.compile("\\d{10}");
		Pattern pattern2 = Pattern.compile("\\d{11}");
		Matcher matcher1 = pattern1.matcher(number);
		Matcher matcher2 = pattern2.matcher(number);
		if (matcher1.matches() || matcher2.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkName(String name) {
		Pattern pattern = Pattern.compile("[A-Z]([a-z]+|\\s[a-z]+)");
		Matcher matcher = pattern.matcher(name);
		if (matcher.find()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// String test = "TrÃ­ LÃª";
		// String test2 = "";
		// try {
		// test2 =
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		// System.out.println(test2);
		// int no = 124750;
		// String str = String.format("%,d", no);
		//
		// int a = Integer.parseInt(str.replace(",", ""));
		//
		// System.out.println(str);
		// System.out.println(a);

	}
}
