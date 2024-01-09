package HomeWork;

class Student extends Person {
    int grade;
    int studentNo;
    String major;
    
    Student input(Student s, String key, String value) {
    	 switch (key) {
         case "id":
             s.id = Integer.parseInt(value);
             break;
         case "name":
             s.name = value;
             break;
         case "age":
             s.age = Integer.parseInt(value);
             break;
         case "address":
         case "addres s":       //inputFile파일에서 오타 있는것도 받기 위해서
             s.address = value;
             break;
         case "grade":
             s.grade = Integer.parseInt(value);
             break;
         case "studentno":
             s.studentNo = Integer.parseInt(value);
             break;
         case "major":
             s.major = value;
             break;
     }
    	
		return s;
    	
    }

	void display(Student student) {
		System.out.println("+-----------------------------------+");
		System.out.printf("|Student ID: %-23d|\n", student.id);
        System.out.printf("|Student Name: %-20s|\n" , student.name);
        System.out.printf("|Student Age: %-22d|\n" , student.age);
        System.out.printf("|Student Address: %-18s|\n" , student.address);
        System.out.printf("|Student Grade: %-20d|\n" , student.grade);
        System.out.printf("|Student StudentNo: %-16d|\n" , student.studentNo);
        System.out.printf("|Student Major: %-19s|\n" , student.major);
        System.out.println("+-----------------------------------+\n");
		
	}
}