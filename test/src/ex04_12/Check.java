package ex04_12;

public class Check {
	private String[][] name_data=new String[10][3];
	
//	좌석의 인덱스는 0부터 시작하므로 i 는 i-1로 j 는 j-1로 입력 반복문에서 1부터 시작
//	모든 좌석의 이름을 --- 으로 초기화
	void name_reset() {
		for(int i=1;i<=10;i++) {
			for(int j=1;j<=3;j++) {
				name_data[i-1][j-1]=" --- ";
			}
		}
	}
	
//	해당 좌석타입의 열만 출력
	public void sit_type_output(int sit_type_input) {
		int i=sit_type_input;
		if(sit_type_input==1)
			System.out.print("S>>");
		if(sit_type_input==2)
			System.out.print("A>>");
		if(sit_type_input==3)
			System.out.print("B>>");
		for(int j=1;j<=10;j++) {
			System.out.print(" "+name_data[j-1][i-1]+" ");
		}
		System.out.println();
	}

//	모든 좌석 출력
	void output_all() {
		for(int i=1;i<=3;i++) {
			if(i==1)
				System.out.print("S>>");
			if(i==2)
				System.out.print("A>>");
			if(i==3)
				System.out.print("B>>");
			for(int j=1;j<=10;j++) {
				if(name_data.equals(null))
					System.out.print(" - - - ");
				else
					System.out.print(" "+name_data[j-1][i-1]+" ");
			}
			System.out.println("");
		}
		System.out.println("<<<조회를 완료하였습니다.>>>");
	}
	
//	해당 좌석에 입력받은 이름을 클래스 안의 전역변수에 입력
	void input(int sit_type_input, String name_input, int number_input) {
		name_data[number_input-1][sit_type_input-1]=name_input;
	}

//	이름을 취소(초기화)시키는 메소드
	public void name_cencellation(int sit_type_input, String name_input) {
		for(int i=1;i<=10;i++) {
			if(name_data[i-1][sit_type_input-1].equals(name_input))
			{
					name_data[i-1][sit_type_input]="---";
			}
//			이부분 버그만 수정하면 끝이다...
			System.out.println("입력된 이름 : "+name_input+name_data[i-1][sit_type_input-1]);
		}
	}
}
