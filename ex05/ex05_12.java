//package ex05;
//import java.util.Scanner;
//
//abstract class Shape{
//	private Shape next;
//	public Shape() { next=null; }
//	public void setNext(Shape obj) {next=obj;}
//	public Shape getNext() {return next;}
//	public abstract void draw();
//}
//
//}
//class Line extends Shape {
//	public void draw() {
//		
//		
//		System.out.println("Line");
//	}
//}
//class Rect extends Shape {
//	public void draw() { // 메소드 오버라이딩
//		System.out.println("Rect");
//	}
//}
//class Circle extends Shape {
//	public void draw() { // 메소드 오버라이딩
//		System.out.println("Circle");
//	}
//}
//
//public class ex05_12 {
//	public static void main(String[] args) {	
//		int menu_1st;
//		int menu_2nd;
//		Shape[] shape=new Shape[100];    // 최대 100개의 도형이 저장가능하다
//		while(true) {
//			//첫번째 메뉴 선택
//			System.out.println("그래픽 에디터 G-v1.0을 실행합니다.");
//			System.out.println("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
//			Scanner scanner=new Scanner(System.in);
//			menu_1st=scanner.nextInt();
//			
//			//두번째 메뉴 선택
//			System.out.println();
//			menu_2nd=scanner.nextInt();
//			
//				// 여기서 shape 객체에 데이터를 담자...
//			
//			
//			//미구현
//			
//			scanner.close();
//		}
//	}
//}
