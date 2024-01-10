package ex05;

class PositivePoint{
	private int x,y;
	
	public PositivePoint() {}	
	public PositivePoint(int x, int y) {
		if(x>0 && y>0) {
			this.x=x;
			this.y=y;
		}
	}
	void move(int x, int y) {
		if(x>0 && y>0) {
			this.x=x;
			this.y=y;
		}
	}
	
	public String toString() {
		return (String) ("("+x+","+y+")"+"의 점"); 
	}
}

public class ex05_8 {
	public static void main(String[] args) {
		PositivePoint p=new PositivePoint();
		p.move(10,10);
		System.out.println(p.toString()+"입니다.");
		
		p.move(-5,5);  //객체 p는 음수 공간으로 이동되지 않음
		System.out.println(p.toString()+"입니다.");
		
		PositivePoint p2=new PositivePoint(-10,-10);
		System.out.println(p2.toString()+"입니다.");
	}
}
