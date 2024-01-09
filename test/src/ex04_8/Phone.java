package ex04_8;
import java.util.Scanner;

public class Phone {
	
	void run() {
//		이름과 번호를 받는다
		String name_input="";
		String tel_input="";
		Scanner scanner=new Scanner(System.in);
		System.out.print("인원 수를 입력하세요.");
		int people_num=scanner.nextInt();
		PhoneBook[] PB_array=new PhoneBook[people_num];
		
		for(int i=0;i<people_num;i++) {
			System.out.print("이름과 전화번호(이름과 번호는 빈 칸 없이 입력)>>");
			name_input=scanner.next();
			tel_input=scanner.next();
			PB_array[i]=new PhoneBook(name_input,tel_input);
		}
		System.out.println("저장되었습니다...");
		
//		검색할 이름을 받고 해당이름을 가진 사람의 번호를 출력한다
		name_input="";  //input 변수들 재활용 
		tel_input="";
		String name_output="";
		String tel_output="";
		while(true) {
			System.out.print("검색할 이름>>");
			name_input=scanner.next();
			name_output=name_input;
//			잘못된 입력이거나 멈추게 만드는 변수들
			boolean miss_input=false;
			boolean stop_input=false;
			for(int i=0;i<people_num;i++) {
				if(name_input.equals(PB_array[i].getName()))
				{
					tel_output=PB_array[i].getTel();
					break;
				}
				else if(name_input.equals("종료"))
				{
//					종료라고 입력하면 해당이름과 같은 전화번호 찾는 루프 탈출
					scanner.close();
					stop_input=true;
					break;
				}
//				종료라고 입력되지않았는데 해당 이름이 없으면 잘못된 입력이라고 출력하게 만듦
				else if(i==people_num-1)
					miss_input=true;
			}
//			잘못된 입력이 아닐경우만 출력
			if(miss_input==true)
				System.out.println("잘못된 입력입니다.");
//			검색 중에 종료라고 입력시 꺼진다
			else if(stop_input==true)
				break;
			else
				System.out.println(name_output+"의 번호는 "+tel_output+"입니다.");

		}
	}
}
