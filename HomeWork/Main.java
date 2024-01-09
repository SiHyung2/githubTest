package HomeWork;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		File_input_output file_input_output=new File_input_output();
		file_input_output.run();   //파일을 불러올때 예외처리가 필요하기에 throws 를 사용하였다
	}
}
