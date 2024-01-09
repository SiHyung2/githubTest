package HomeWork;
import java.util.Scanner;
public class Quit_select {
	
	
	boolean run() {
		while(true) {
			System.out.println("종료하시겠습니까? (y/n)");
			try (Scanner scanner = new Scanner(System.in)) {
				String k=scanner.next();
				if(k.equals("y"))
					return true;
				else if(k.equals("n"))
					return false;
				else
					System.out.println("잘못된 입력입니다");
				scanner.nextLine();
			}
			
		}
	}
}
