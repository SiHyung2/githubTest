package ex04_12;
import ex04_12.Scanner_try;

public class Reservation {
	private String name;
	private int sit_type;
	private int number;
	
	
//	InputMismatchException을 try~catch 문으로 해결하자
	public void sit_type_input() {
		int sit_type=Scanner_try.getInt("좌석구분 S(1), A(2), B(3)>>");
		this.sit_type = sit_type;
	}
	public void name_number_input() {
		String name=Scanner_try.getString("이름>>>");
		int sit_number=Scanner_try.getInt("번호>>");
		this.name = name;
		this.number = sit_number;
	}
	
	public String getName() { return name; }
	public int getSit_type() {return sit_type;}
	public int getNumber() {return number;}
}
