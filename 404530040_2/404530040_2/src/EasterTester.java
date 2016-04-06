
/*
 * [A]103
 * [TA's Advise]
 * 1.很有趣的寫法, while裡面去做user input的檢查是個很不錯的方法, 不過建議可以跳出提視窗表示程式終止, 或許檢核條件可以在精確一些, 好比檢查是否<=0.
 * 2.Math.floorDiv()是個很棒的表現, 相信是你自己延伸學習的成果, 這部分有給予你額外的分數! 寫得很好!
 * 3.Good JOB! 不過輸出格式記得依照作業要求喔!
 * */

/**
* This program is to calculate the Easter Sunday in the specified year
*/
import java.util.*;

public class EasterTester {

	public static void main(String[] args) {
		// HW requirements
		System.out.println(Easter.CalculateEaster(2001));
		System.out.println(Easter.CalculateEaster(2012));

		boolean flag = true;// if flag = false end of output

		// users input
		while (flag != false) {
			System.out.println("Please enter a year to calculate Easter Sunday.");
			Scanner sc = new Scanner(System.in);

			// check if user enter the number
			while (!sc.hasNextInt()) {
				System.out.println("Please enter a year.(Do not enter any letter)");
				sc.next();
			}
			int year = sc.nextInt();

			System.out.println(Easter.CalculateEaster(year));
			
			
			//NICE PROFORMANCE! +1 
			System.out.println("Continuous?(Yes/No)");
			String input = sc.next();

			if (input.equals("no") || input.equals("No")) {
				flag = false;
				sc.close();
			}
			//How about exception? continue or break?

		}
		System.out.println("End of output!");

	}

}
