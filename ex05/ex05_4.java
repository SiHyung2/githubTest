package ex05;

import java.util.Scanner;

class Converter {
	double result;
	
	Converter(double k){
		System.out.println("Km을 mile로 바꿉니다.  \nKm을 입력하세요>>");
		Scanner scanner=new Scanner(System.in);
		double input=scanner.nextDouble();
		double output=input/k;
		SetResult(output);
		scanner.close();
	}
	public void SetResult(double result) {
		this.result = result;
	}
}
class Km2Mile extends Converter{
	
	Km2Mile(double k) {
		super(k);
	}
	
	void run() {
		System.out.println("변환 결과 : "+result+"mile입니다.");
	}
}

public class ex05_4 {
	public static void main(String args[]) {
		Km2Mile toMile=new Km2Mile(1.6);
		toMile.run();
	}
}
