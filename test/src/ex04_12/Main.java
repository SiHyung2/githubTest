package ex04_12;
import ex04_12.Scanner_try;


public class Main {
	public static void main(String[] args) {
		int sit_type_input=0;
		String name_input="";
		int number_input=0;
		
		Check Check=new Check();
		Cencellation Cencellation=new Cencellation();
		Quit_select Quit_select=new Quit_select();
		Reservation Reservation=new Reservation();
		Check.name_reset();  //이름을 전부 --- 으로 초기화
		while(true)
		{
			int select_menu=Scanner_try.getInt("예약:1, 조회:2, 취소:3, 끝내기:4>>");
			if(select_menu==1)	
			{
//				sit_type_input변수를 reservation 객체에 넣는 메소드 sit_type_input이다
//				객체에 변수를 넣는 메소드와 그변수와 이름이 같다
				Reservation.sit_type_input();
				sit_type_input=Reservation.getSit_type();
				
				Check.sit_type_output(sit_type_input);
				Reservation.name_number_input();
				name_input=Reservation.getName();
				number_input=Reservation.getNumber();
				
				Check.input(sit_type_input, name_input, number_input);
			}
			if(select_menu==2)
				Check.output_all();
			if(select_menu==3)
			{
				Cencellation.sit_type_input();
				sit_type_input=Cencellation.getSit_type();
				
				Check.sit_type_output(sit_type_input);
				Cencellation.name_input();
				
				name_input=Cencellation.getName();
//				입력받은 이름과 좌석 타입에 맞는 사람을 "---"으로 초기화 시킨다
				Check.name_cencellation(sit_type_input, name_input);   
			}
			if(select_menu==4){
				if(Quit_select.run()){
					break;
				}
			}
				
		}
	}
}
