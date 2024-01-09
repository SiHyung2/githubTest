package HomeWork;

class Staff extends Employee {
    String department;
    
    Staff input(Staff staff, String key, String value) {
    	switch (key) {
        case "id":
            staff.id = Integer.parseInt(value);
            break;
        case "name":
            staff.name = value;
            break;
        case "age":
            staff.age = Integer.parseInt(value);
            break;
        case "address":
            staff.address = value;
            break;
        case "salary":
            staff.salary = Integer.parseInt(value);
            break;
        case "position":
        case "posion": //텍스트 파일에 오타가 있어서,,
            staff.position = value;
            break;
        case "supervisor":
            staff.supervisor = value;
            break;
        case "department":
            staff.department = value;
            break; 
    	}

    	return staff;
    
    }

	void display(Staff staff) {
		System.out.println("+-----------------------------------+");
		System.out.printf("|Staff ID: %-25d|\n", staff.id);
        System.out.printf("|Staff Name: %-22s|\n" , staff.name);
        System.out.printf("|Staff Age: %-24d|\n" , staff.age);
        System.out.printf("|Staff Address: %-20s|\n" , staff.address);
        System.out.printf("|Staff Salary: %-21d|\n" , staff.salary);
        System.out.printf("|Staff Position: %-18s|\n" , staff.position);
        System.out.printf("|Staff Department: %-16s|\n" , staff.department);
        System.out.println("+-----------------------------------+\n");	
		
	}
}
