
//rectangle class 
//create to calculate area and perimeter of the rectangle 
//and to present their information

public class Rectangle {
	
	int x;
	int y;
	private int heightValue;
	private int widthValue;
	double area;
	double perimeter;
	
	public Rectangle(){
		
	}
	//constructor
	public Rectangle(int xPosition,int yPosition,int height,int width){
		
		x=xPosition;
		y=yPosition;
		heightValue=height;
		widthValue=width;
		
	}
	public int getHeight(){
		
		return heightValue;
		
	}
	public int getWidth(){
		
		return widthValue;
		
	}
	//return the value of X
	public int getX(){
		
		return x;
		
	}
	//return the value of Y
	public int getY(){
		
		return y;
		
	}
	public void getArea(){
		
		area= heightValue*widthValue;
		if(area<0){
			area=0;
		}
	}
	public void getPerimeter(){
		
		perimeter=2*(heightValue+widthValue);
		if(perimeter<0){
			perimeter=0;
		}
	}
	
	//print out the final outcome
	public String toString(){
		getArea();
		getPerimeter();
		return "Java.Rectangle [" + "x =" +x+", y =" +y+ ", Height=" +heightValue+", Width="+widthValue+"]"
				+"\nArea=" +area+"\nPerimeter="+perimeter;
		
	}
}
