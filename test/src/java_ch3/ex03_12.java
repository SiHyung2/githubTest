package java_ch3;

public class ex03_12 {
	public static boolean isInteger(String strValue) {
	    try {
	      Integer.parseInt(strValue);
	      return true;
	    } catch (NumberFormatException ex) {
	      return false;
	    }
	  }
	
	public static void main(String[] args) {
		int sum=0;
		
		
		for(int i=0,n=0;i<args.length;i++) 
		{
			if(isInteger(args[i])==true)
			{
				n=Integer.parseInt(args[i]);
				sum+=n;
				
			}
			
		} 
		System.out.print(sum);
	}

}