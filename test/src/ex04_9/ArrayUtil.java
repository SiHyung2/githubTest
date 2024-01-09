package ex04_9;

public class ArrayUtil {
	static int[] A;
	static int[] B; 
	static int[] C; 
	public static int[] concat(int[] a,int[] b) {
//		일단 a 배열과 b 배열이 필요할지도 모르니 A 배열과 B 배열에 저장
		A =new int[a.length];
		for(int i=0;i<a.length;i++){
			A[i]=a[i];
		}
		B =new int[b.length];
		for(int i=0;i<b.length;i++){
			B[i]=b[i];
		}
//		C의 배열의 크기와 A와 B를 합친 크기와 같아야함
//		첫번쨰 for 문에서 C에 A를 넣고
//		두번째 for 문에서 A를 넣은 C에 B도 마저 넣는다.
		C=new int [A.length+B.length];
		for(int i=0;i<A.length;i++){
			C[i]=a[i];
		}
		for(int i=A.length;i<A.length+B.length;i++) {
			C[i]=b[i-A.length];
		}
		return C;
	}
	public static void print(int[] array3) {
		for(int i : array3)
			System.out.print(i+" ");
	}
	public static void main(String[] args)
	{
		int [] array1= {1,5,7,9};
		int [] array2= {3,6,-1,100,77};
		int [] array3=ArrayUtil.concat(array1, array2);
		ArrayUtil.print(array3);
	}

}
