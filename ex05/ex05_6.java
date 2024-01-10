package ex05;
//point2 클래스는 ex05_5에 존재
class ColorPoint3 extends Point2{
	private int x,y;
	private String color="BLACK";
	
	public ColorPoint3(int x, int y, String color){
		super(x,y);
		setXY(x, y);
		setColor(color);
	}
	public ColorPoint3() {
		super(0,0);
	}
	public ColorPoint3(int x, int y){
		super(x,y);
		setXY(x, y);
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

public class ex05_6 {
	public static void main(String[] args) {
		ColorPoint3 zeroPoint=new ColorPoint3();
		System.out.println(zeroPoint.toString()+"입니다.");
		
		ColorPoint3 cp =new ColorPoint3(10,10);
		cp.setXY(5, 5);
		cp.setColor("RED");
		System.out.println(cp.toString()+"입니다.");
		
	}
}
