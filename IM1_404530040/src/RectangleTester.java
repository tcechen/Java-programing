/*
 * [A]98
 * [TA's advise]
 * 1.我已經將你的程式檔案合併成一個了喔, 之後像是這種小程式如果沒有特別需求的話, 希望可以寫成一個檔案.
 * 2.你的properties都設定成integer沒什麼問題, 但可以想想如果今天改成user input的方式, 是不是會需要作一些修正呢?
 * 3.你build兩個method:getArea(),getPerimeter(),但這兩個method其實可以被getHeight(),getWidth()取代, 然這部分老師的要求是必須要使用到getHeight()及getWidth(), 所以這部分酌量扣2分.
 * 基本上不建議build method而這個method可以透過已經build完成的method所達成(getArea()=getHeight()*getWidth(), right?).
 * */

//rectangle class 
//create to calculate area and perimeter of the rectangle 
//and to present their information
class Rectangle {

	int x;
	int y;
	private int heightValue;
	private int widthValue;
	double area;
	double perimeter;

	public Rectangle() {
		//建議可以寫個類別呼叫以初始化物件
		//this(-1,-1,-1,-1);
	}

	// constructor
	public Rectangle(int xPosition, int yPosition, int height, int width) {

		x = xPosition;
		y = yPosition;
		heightValue = height;
		widthValue = width;

	}

	public int getHeight() {

		return heightValue;

	}

	public int getWidth() {

		return widthValue;

	}

	// return the value of X
	public int getX() {

		return x;

	}

	// return the value of Y
	public int getY() {

		return y;

	}

	public void getArea() {

		area = heightValue * widthValue;
		if (area < 0) {
			area = 0;
		}
	}

	public void getPerimeter() {

		perimeter = 2 * (heightValue + widthValue);
		if (perimeter < 0) {
			perimeter = 0;
		}
	}

	// print out the final outcome
	public String toString() {
		getArea();
		getPerimeter();
		return "Java.Rectangle [" + "x =" + x + ", y =" + y + ", Height=" + heightValue + ", Width=" + widthValue + "]"
				+ "\nArea=" + area + "\nPerimeter=" + perimeter;

	}
}

//main class 
public class RectangleTester {
	public static void main(String[] args) {

		// create 2 new rectangle objects and their values
		Rectangle rectangle1 = new Rectangle(15, 25, 18, 57);
		Rectangle rectangle2 = new Rectangle(0, 12, 47, 60);

		// print out the information of rectangle 1 & 2
		System.out.println(rectangle1);
		System.out.println("\n" + rectangle2);
		System.out.println("\nEnd of Output!");
	}
}
