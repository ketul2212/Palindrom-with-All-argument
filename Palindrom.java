import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Palindrom {
	public static void main(String args[]) {

		String another = "";

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter a number what you want");

		long num = scan.nextLong();

		List<Object> list = new ArrayList<Object>();

		for (long i = 0; i < num; i++) {
			long lnum = 0;
			try {
				another = scan.next();

				if (another.substring((another.length() - 1)).equals("l")
						|| another.substring((another.length() - 1)).equals("L"))
					lnum = Long.parseLong(another.substring(0, another.length() - 1));
				else
					lnum = Long.parseLong(another);

				list.add(lnum);
			} catch (NumberFormatException exception) {
				double ldouble = 0.0;
				try {
					if (another.substring((another.length() - 1)).equals("d")
							|| another.substring((another.length() - 1)).equals("D")
							|| another.substring((another.length() - 1)).equals("f")
							|| another.substring((another.length() - 1)).equals("F"))
						ldouble = Double.parseDouble(another.substring(0, another.length() - 1));
					else
						ldouble = Double.parseDouble(another);
					list.add("double");
				} catch (Exception finalException) {
					list.add(another);
				}
			}

			scan.close();
		}

		for (Object listObject : list) {

			if (isPalindrom(listObject))
				System.out.println("Your Number " + listObject + " is Palindrom.");
			else if (listObject.toString().equals("double"))
				System.out.println("Your Number is Not Palindrom because double and float numbers are not palindrom.");
			else
				System.out.println("Your Number " + listObject + " is Not Palindrom.");
		}
	}

	public static boolean isPalindrom(Object listObject) {

		if (listObject.toString().equals("double"))
			return false;

		if (listObject instanceof String) {

			for (int i = 0, j = listObject.toString().length() - 1; i < j; i++, j--) {
				if (listObject.toString().charAt(i) != listObject.toString().charAt(j))
					return false;
			}
			return true;
		} else {
			String s = listObject.toString();
			for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
				if (s.charAt(i) != s.charAt(j))
					return false;
			}
			return true;
		}

	}
}
