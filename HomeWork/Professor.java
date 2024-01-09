package HomeWork;

class Professor extends Employee {
    String course;
    
    Professor input(Professor p, String key, String value) {
    	switch (key) {
        case "id":
            p.id = Integer.parseInt(value);
            break;
        case "name":
            p.name = value;
            break;
        case "age":
            p.age = Integer.parseInt(value);
            break;
        case "address":
            p.address = value;
            break;
        case "salary":
            p.salary = Integer.parseInt(value);
            break;
        case "position":
        case "posion": //텍스트 파일에 오타가 있어서,,
            p.position = value;
            break;
        case "supervisor":
            p.supervisor = value;
            break;
        case "course":
            p.course = value;
            break;
    }
    	
    	return p;
    }

	public void display(Professor professor) {
		System.out.println("+-----------------------------------+");
		System.out.printf("|Professor ID: %-21d|\n", professor.id);
        System.out.printf("|Professor Name: %-18s|\n" , professor.name);
        System.out.printf("|Professor Age: %-20d|\n" , professor.age);
        System.out.printf("|Professor Address: %-14s|\n" , professor.address);
        System.out.printf("|Professor Salary: %-17d|\n" , professor.salary);
        System.out.printf("|Professor Position: %-13s|\n" , professor.position);
        System.out.printf("|Professor Course: %-17s|\n" , professor.course);
        System.out.println("+-----------------------------------+\n");
		

		
	}
}