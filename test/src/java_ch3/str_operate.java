package java_ch3;
import java.util.Scanner;

public class str_operate {
	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		String a=s.next();
		String b=s.next();
		
		
		String c=new String("abc");
		System.out.println(a.equals(b));
		System.out.println(a==b);
	}
}
