/**
 * The class use Gauss's algorithm to calculate Easter Sunday
 */
public class Easter {

	public static String CalculateEaster(int aYear) {
		int a = aYear % 19;
		int b = aYear % 4;
		int c = aYear % 7;

		// 下面這個用法是一個很不錯的寫法! 有感覺到你自己查function的誠意! extra point +2!
		int k = Math.floorDiv(aYear, 100);
		int p = Math.floorDiv((13 + 8 * k), 25);
		int q = Math.floorDiv(k, 4);
		int M = (15 - p + k - q) % 30;
		int N = (4 + k - q) % 7;
		int d = (19 * a + M) % 30;
		int e = (2 * b + 4 * c + 6 * d + N) % 7;

		// calculate date and month
		int date = 22 + d + e;
		String month = "March";

		// if the date of March >31 then the month will be April
		if (date > 31) {
			date = date - 31;
			month = "April";
		}

		// Some exception

		// replace 26 April with 19 April
		if (d == 29 && e == 6) {
			date = 19;
		}

		// replace 25 April with 18 April
		if ((d == 28 && e == 6) && ((11 * M + 11) % 30 < 19)) {
			date = 18;
		}

		// return the month and date of Easter Sunday
		return "In " + aYear + ", Easter Sunday is: month = " + month + " and day = " + date;
	}
}
