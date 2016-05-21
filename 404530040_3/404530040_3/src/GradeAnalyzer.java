
import java.util.ArrayList;

public class GradeAnalyzer implements GradeAnalyzerInterface {

	final static int Maximum_Grade = 110;
	final static int Minimum_Grade = 0;
	ArrayList<Double> score = new ArrayList<Double>();
	int userInputCounter = 0;// how many grade did user enter
	int[] counter = new int[11];// letter category from A to F
	double avg = 0, SD = 0, sum = 0;

	/**
	 * Check if user's input number between Maximum and minimum
	 * 
	 * @return boolean
	 */
	public Boolean isValidGrade(double grade) {
		if (grade < Minimum_Grade || grade > Maximum_Grade) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Increments the appropriate letter grade counter
	 */
	public void addGrade(double grade) {

		// valid number input
		if (isValidGrade(grade)) {
			userInputCounter++;// user enter grade +1
			sum += grade;
			score.add(grade);// add grade to the arraylist
			if (grade >= 90) {// A
				if (grade >= 98) {// A+
					counter[0]++;
				} else if (grade >= 92) {// A
					counter[1]++;
				} else {// A-
					counter[2]++;
				}
			}

			else if (grade >= 80) {// B
				if (grade >= 88) {// B+
					counter[3]++;
				} else if (grade >= 82) {// B
					counter[4]++;
				} else {// B-
					counter[5]++;
				}
			}

			else if (grade >= 70) {// C
				if (grade >= 78) {// C+
					counter[6]++;
				} else if (grade >= 72) {// C
					counter[7]++;
				} else {// C-
					counter[8]++;
				}

			}

			else if (grade >= 60) {// D
				counter[9]++;
			} else {// F
				counter[10]++;
			}

		}

	}

	/**
	 * Calculates the average and standard deviation
	 * 
	 * @param square
	 *            the square of every valid number minus average
	 */
	public void analyzeGrades() {
		avg = sum / userInputCounter;
		double square = 0;
		for (int i = 0; i < score.size(); i++) {
			square += (score.get(i) - avg) * (score.get(i) - avg);
		}
		SD = Math.sqrt(square / userInputCounter);
	}

	/**
	 * print out the output
	 * 
	 * @param output
	 *            show the output
	 */
	public String toString() {
		String outPut = "You enter " + userInputCounter + " valid grades from 0 to 110."
				+ " Invalid grades are ignored!\n\nThe average =" + avg + " with a " + "standard deviation =" + SD
				+ ".\n\nThe grade distribution is:\n" + "A+ = " + counter[0] + "\nA = " + counter[1] + "\nA- = "
				+ counter[2] + "\nB+ = " + counter[3] + "\nB = " + counter[4] + "\nB- = " + counter[5] + "\nC+ = "
				+ counter[6] + "\nC = " + counter[7] + "\nC- = " + counter[8] + "\nD = " + counter[9] + "\nF = "
				+ counter[10];
		return outPut;
	}

}
