package ex04_8;

public class PhoneBook {
	private String name;
	private String tel;
	PhoneBook(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	String getTel() {
		return tel;
	}

}
