package ex05;

import java.util.Scanner;

abstract class Calc{
	protected int a;
	protected int b;
	abstract void setValue(int a, int b);
	abstract int calculate();
}
// 더하기 클래스
class Add extends Calc{

	@Override
	void setValue(int a, int b) {
		super.a=a;
		super.b=b;
	}

	@Override
	int calculate() {
		return a+b;
	}
	
}

// 빼기 클래스
class Sub extends Calc{

	@Override
	void setValue(int a, int b) {
		super.a=a;
		super.b=b;
	}

	@Override
	int calculate() {
		return a-b;
	}
	
}

// 곱하기 클래스
class Mul extends Calc{

	@Override
	void setValue(int a, int b) {
		super.a=a;
		super.b=b;
	}

	@Override
	int calculate() {
		return a*b;
	}
	
}

// 나누기 클래스
class Div extends Calc{

	@Override
	void setValue(int a, int b) {
		super.a=a;
		super.b=b;
	}

	@Override
	int calculate() {
		return a/b;
	}
	
}

public class ex05_11 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("두 정수와 연산자를 입력하시오>>");
		int a_input=scanner.nextInt();
		int b_input=scanner.nextInt();
		String operation_input=scanner.next();
		
		if(operation_input.equals("+")) {
			Add add=new Add();
			add.setValue(a_input, b_input);
			System.out.println(add.calculate()); 
		}
		if(operation_input.equals("-")) {
			Sub sub=new Sub();
			sub.setValue(a_input, b_input);
			System.out.println(sub.calculate()); 
		}
		if(operation_input.equals("*")) {
			Mul mul=new Mul();
			mul.setValue(a_input, b_input);
			System.out.println(mul.calculate()); 
		}
		if(operation_input.equals("/")) {
			Div div=new Div();
			div.setValue(a_input, b_input);
			System.out.println(div.calculate()); 
		}
		scanner.close();
	}
}
