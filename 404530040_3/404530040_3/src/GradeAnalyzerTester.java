/*
 * [A]98
 * [TA's Advise]
 * 1. 程式沒什麼太大問題, 可惜在小地方.
 * */

import javax.swing.JOptionPane;

/**
 * This program is designed to calculate average and standard deviation of
 * user's input number.
 */
public class GradeAnalyzerTester {

	public static void main(String[] args) {
		GradeAnalyzer GA = new GradeAnalyzer();

		String inputNum = "";// user's input

		while (true) {
			inputNum = JOptionPane.showInputDialog(null, "Please enter one score.");
			if (inputNum.equalsIgnoreCase("Q")) {
				break;
			}
			try {

				GA.addGrade(Double.parseDouble(inputNum));// turn inputNum into
															// double

			} catch (Exception e) {
				System.out.println("Invalid input number!");

			}
		}
		// 缺少判斷是否個數<2, -2.
		GA.analyzeGrades();
		String output = GA.toString();
		System.out.println(output);// show the output
	}

}
