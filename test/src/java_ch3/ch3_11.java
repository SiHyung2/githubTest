package java_ch3;

public class ch3_11 {
	public static void main(String[] args) {
		
		//비 정방형 배열의 생성과 접근
		int intArray[][]=new int[4][];
		
		//1번째 줄은 3열을 생성
		intArray[0]=new int[3];
		//2번쨰 줄은 2열을 생성
		intArray[1]=new int[2];
		intArray[2]=new int[3];
		intArray[3]=new int[2];
		
		for(int i=0;i<intArray.length;i++)
			for(int j=0;j<intArray[i].length;j++)
				intArray[i][j]=(i+1)*10+j;
		for(int i=0;i<intArray.length;i++){
			for(int j=0;j<intArray[i].length;j++) 
				System.out.print(intArray[i][j]+" ");
			System.out.println();
		}
			
	}
}
