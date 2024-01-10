package ex05;
import java.util.Scanner;

public class GraphicEditor {
	private String name;
	private Shape start;
	private Shape last;
	private Scanner sc1;
	
	public GraphicEditor()
	{
		start=null;
		last=null;
		sc1=new Scanner(System.in);
	}
	
	void run() {
		System.out.println("그래픽 에디터 실행합니다.");
		int type, position;
		while(true) {
			System.out.println("삽입(1), 삭제(2), 모두보기(3), 종료(4) >>");
			int option=sc1.nextInt();
			
			switch(option) {
				case 1:
					System.out.println("Line(1), Rect(2), Circle(3) >>");
					type=sc1.nextInt();
					insert(type);
					break;
				case 2:
					System.out.println("삭제할 도형의 위치>>");
					position=sc1.nextInt();
					delete(position);
					break;
				case 3:
					view();
					break;
				case 4:
					quit();
				default:
			}
		}
	}

	void insert(int type) {
		Shape obj=null;
		switch(type) {
			case 1:
				obj=new Line();
				break;
			case 2:
				obj=new Rect();
				break;
			case 3:
				obj=new Circle();
				break;
		}
		
		if(start==null) {
			start=obj;
			last=obj;
		}
		else {
			last.setNext(obj);
			last=obj;
		}
		
	}
	
	void delete(int position) {
		int i=0;
		Shape current=start;  //원래 링크드 리스트의 순서대로 저장
		Shape prev=start;   //삭제하고 나서 원래 리스트에서 한칸 전의 데이터    (재정렬하기위해서 필요함)
		
		if(position==0) { //첫번째 값을 지울때
			current=start.getNext();
			start.setNext(null);
			start=current;   //start 를 지웠으니 start 다음 객체를 start 로 지정
		}
		
		while(prev!=null && position>0) {   // 첫번째 이후의 값을 지울 때
			
			if(i==position) {
	            prev.setNext(current.getNext());    // (중요!!) prev 객체에 다음번에 오는 객체를 넣는 부분
//				prev=prev.getNext();
	            current.setNext(null);   // current 객체는 삭제할 부분을 삭제
	            view();
	            return;
	            
//	            잘못된 코드... (삽질 했음)
//				prev.setNext(null);
//				prev=prev.getNext();   // prev 에 null 데이터를 건너뛰고 다음 객체로 접근
			}
			
			prev=current;  // null 데이터가 생겼으므로 재정렬
			current=current.getNext();
			i++;
		}
	}


	void view() {
		Shape current=start;
		
		while(current!=null) {
			current.draw();
			current=current.getNext();
		}
	}
	
	void quit() {
		System.out.println("시스템을 종료합니다.");
		System.exit(0);
	}
}







class Line extends Shape {
	public void draw() {
		System.out.println("Line");
	}
}
class Rect extends Shape {
	public void draw() { // 메소드 오버라이딩
		System.out.println("Rect");
	}
}
class Circle extends Shape {
	public void draw() { // 메소드 오버라이딩
		System.out.println("Circle");
	}
}

