package ex05;

import java.util.Scanner;

interface Stack{
	int length(); //현재 스택에 저장된 개수 리턴
	int capacity();  //스택의 전체 저장 가능한 개수 리턴
	String pop(); //스택의 톱(top)에 저장된 문자열 리턴
	boolean push(String val);  //스택의 톱에 문자열 저장
}
class StringStack implements Stack{
	@SuppressWarnings("unused")
	private int length, capacity, input_size;
	@SuppressWarnings("unused")
	private String pop,val;
	@SuppressWarnings("unused")   // 조건식에 적어서 작동시켰는데 경고가 나오는 에러때문에 넣었음
	private boolean push;
	private String[] StackArray=new String[100];    //가변형 배열로 문자열을 저장하는 변수 생성
	private int stack_size=0;
	
	public StringStack(){
		System.out.println("총 스택 저장 공간의 크기 입력>> ");
		Scanner scanner=new Scanner(System.in);
		input_size=scanner.nextInt();
		while(true) {
			System.out.println("문자열 입력>> ");
//			System.out.println("length :"+length()+"      capacity : "+capacity());      //테스트용 코드
			
			val=scanner.next();  //여기서 val 은 push 메소드를 통해 저장된다
			if(push(val)) {   
				if(val.equals("그만")) {
					printStack();
					break;
				}
				
				
			}
			else { System.out.println("잘못된 입력."); }
			
//			System.out.println("pop : "+pop());  // 테스트용 코드2
		}
		
		scanner.close();
	}

	@Override
	public int length() { 
		int x=0;
		for(String i:StackArray) {
			if(i!=null) {
				x++;
			}
		}
		return x;
	}

	@Override
	public int capacity() {
		return input_size-length();
	}

	@Override
	public String pop() {
		return StackArray[stack_size-1];
	}
	
	public void printStack() {
		System.out.print("스택에 저장된 모든 문자열 팝 : ");
		for(int i=stack_size-1;i>=0;i--) {
			if(StackArray!=null)
				System.out.print(StackArray[i]+" ");
		}
	}

	@Override
	public boolean push(String val) {
		if(capacity()>0 && !val.equals("그만")) {
			StackArray[stack_size]=val; 
			stack_size++;
			return true;  
		}
		else if(val.equals("그만"))
			return true;  // 그만이라고 받으면 스택에 추가 안하고 바로 true 로 리턴
		else if(capacity()<=0) {
			System.out.println("스택이 꽉 차서 푸시 풀가!");
			System.out.println(pop());
			return true;
		}
		else
			return false;
	}
}

public class ex05_9 {
	public static void main(String[] args) {
		new StringStack();
	}
}
