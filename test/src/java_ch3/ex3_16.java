package java_ch3;
import java.util.Scanner;

public class ex3_16 {
	public static void main(String[] args) {
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		
		while(true)
		{
			System.out.print("가위 바위 보!>>");
			Scanner s=new Scanner(System.in);
			String user_input=s.next();
			int computer_input=(int)(Math.random()*3+1);
			String computer_str="";    
			//랜덤으로 받은 값으로 컴퓨터가 받을 값 생성
			if(computer_input==1)
				computer_str="가위";
			if(computer_input==2)
				computer_str="바위";
			if(computer_input==3)
				computer_str="보";
			System.out.println(computer_str);
			
			if(user_input.equals(computer_str))
				System.out.println("사용자="+user_input+", 컴퓨터= "+computer_str+", 비겼습니다.");
			
			if(user_input.equals("가위")&&computer_str.equals("바위"))
				System.out.println("사용자="+user_input+", 컴퓨터= "+computer_str+", 다시 하세요.");
			if(user_input.equals("바위")&&computer_str.equals("가위"))
				System.out.println("사용자="+user_input+", 컴퓨터= "+computer_str+", 다시 하세요.");
			if(user_input.equals("보")&&computer_str.equals("가위"))
				System.out.println("사용자="+user_input+", 컴퓨터= "+computer_str+", 다시 하세요.");

			if(user_input.equals("가위")&&computer_str.equals("보"))
				System.out.println("사용자="+user_input+", 컴퓨터= "+computer_str+", 컴퓨터가 이겼습니다.");
			if(user_input.equals("바위")&&computer_str.equals("가위"))
				System.out.println("사용자="+user_input+", 컴퓨터= "+computer_str+", 컴퓨터가 이겼습니다.");
			if(user_input.equals("보")&&computer_str.equals("바위"))
				System.out.println("사용자="+user_input+", 컴퓨터= "+computer_str+", 컴퓨터가 이겼습니다.");
			
			if(user_input.equals("그만"))
			{
				System.out.println("게임을 종료합니다...");
				break;
			}
		}			
	}
}

//사용자 입력도 가위=1, 바위=2, 보=3으로 만든 알고리즘
//숫자가 같으면 비김, 
//if((사용자입력에서 2번 더한 수)%3==0)    이라면 사용자가 이겼다
//if((사용자입력에서 1번 더한 수)%3==0)    이라면 사용자가 졌다
//사용자 입력이 "그만"이라면 게임 종료
