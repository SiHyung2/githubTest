package java_ch3;
//import java.util.Scanner; 
public class ex03_11 { 
	public static void main(String[] args) { 
//		스캐너를 사용하는 문제가 아니다 
//		main()의 인자를 사용하는 문제이기 때문에 args를 받아오고 args의 인덱스마다 데이터를 
//		가져온 후 int형으로 바꿔주는 작업을 해야한다 		 
//		Scanner s=new Scanner(System.in); 
//		int n1=Integer.parseInt(s.next()); 
//		int n2=Integer.parseInt(s.next()); 
//		int n3=Integer.parseInt(s.next()); 
//		int avg=(n1+n2+n3)/3; 
		 
		int avg=0; 
		for(int i=0;i<args.length;i++) 
		{	 
			int n=Integer.parseInt(args[i]); 
			avg+=n; 
		} 
		avg=avg/args.length; 
		System.out.print(avg); 
	} 
} 
