package ex05;

class Point2{
	private int x,y;
	public Point2(int x, int y) {this.x=x; this.y=y;}
	public int getX() {return x;}
	public int getY() {return y;}
	protected void move(int x, int y) {this.x=x; this.y=y;}
}

class ColorPoint2 extends Point2{
	private int x, y;
	private String color;
	
	
	
	public ColorPoint2(int x, int y, String color){
		super(x,y);
		setXY(x, y);
		setColor(color);
	}
	
	public String toString() {
		return (String) (color+"색의 "+"("+x+","+y+")");
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setColor(String color) {
		this.color = color;
	}
}

public class ex05_5 {
	public static void main(String[] args) {
		ColorPoint2 cp=new ColorPoint2(5,5,"YELLOW");
		cp.setXY(10,20);
		String str=cp.toString();
		System.out.println(str+"입니다.");
		cp.setXY(5, 5);
		cp.setColor("RED");
		System.out.println(cp.toString()+"입니다.");
	}
}
