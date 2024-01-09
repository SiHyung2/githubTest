package ex04_12;
import ex04_12.Scanner_try;

public class Cencellation {
	private String name;
	private int sit_type;
	private int number;

	public void sit_type_input() {
		int sit_type=Scanner_try.getInt("좌석구분 S(1), A(2), B(3)>>");
		this.sit_type = sit_type;
	}
	public void name_input() {
		String name=Scanner_try.getString("이름>>>");
		this.name = name;
	}

	
	public String getName()   {return name;	}
	public int getSit_type()    {return sit_type;}
	public int getNumber()    {return number;}
}
