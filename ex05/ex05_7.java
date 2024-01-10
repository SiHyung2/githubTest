package ex05;
//point2 클래스는 ex05_5에 존재

class Point3D extends Point2{
	private int x,y,z;
	public Point3D(int x, int y, int z) {
		super(x,y);
		this.x=x;
		this.y=y;
		this.z=z;
	}

	public String toString() {
		return (String) ("("+x+","+y+","+z+")"+"의 점입니다."); 
	}
	public void moveUp() {
		this.z++;
	}
	public void moveDown() {
		this.z--;
	}
	public void move(int x, int y, int z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}
}

public class ex05_7 {
	public static void main(String[] args) {
		Point3D p = new Point3D(1,2,3);
		System.out.println(p.toString()+"입니다.");
		
		p.moveUp();
		System.out.println(p.toString()+"입니다.");

		p.moveDown();
		System.out.println(p.toString()+"입니다.");
		
		p.move(100,200,300);
		System.out.println(p.toString()+"입니다.");
	}
}
