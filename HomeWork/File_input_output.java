package HomeWork;
import java.io.IOException;
import java.util.List;

public class File_input_output {
    void run() throws IOException  {
    	FileManager FileManager=new FileManager();
    	FileManager.input();   //파일의 데이터를 가져오는 메서드이다.
    	 // 리스트 초기화
    	List<Student> students = FileManager.getStudents();
    	List<Professor> professors = FileManager.getProfessors();
    	List<Staff> staffs = FileManager.getStaffs();
    	List<String> person_order= FileManager.getPerson_order();   //텍스트파일에 적히는 순서를 저장한다
    	
    	
        while(true) {
	        int input_menu=HomeWork.Scanner_try.getInt("1.추가  2.수정  3.삭제  4출력  5.종료\n"
	        		+">>어떤 작업을 수행하시곘습니까?");
	        if(input_menu==1) {
	        	Student student = new Student();   //메뉴1의 객체 생성
    			Professor professor=new Professor();
    			Staff staff=new Staff();
	    		
    			
    			int input_person_type_int=HomeWork.Scanner_try.getInt(">>어떤 형식의 레코드를 추가할 것입니까? \n>>1.Student  2.Professor  3.Staff \n>>");
    			String input_person_type_String="";
    			
    			
    			int input_id=HomeWork.Scanner_try.getInt(">>추가하고자 하는 id를 입력하세요! \n>> id:");
	        	
	        	//입력 받은 id 에 해당하는 객체와 그객체의 인덱스를 찾는 반복문
	        	for(int i=0;i<students.size();i++){
    				if(input_id==students.get(i).id)  {
    					System.out.println(">>이미 존재하는 id입니다. 다른아이디를 넣으세요!");
    					input_id=HomeWork.Scanner_try.getInt(">>추가하고자 하는 id를 입력하세요! \n>> id:");
    					i=-1;
    				}
    				
    				if(i==0) {     // 학생 id 검색이 있는 반복문 안의 첫번째 반복에서 교수 id 와 직원 id 검색도 한다 
    					for(int j=0;j<professors.size();j++){
		    				if(input_id==professors.get(j).id)  {
		    					System.out.println(">>이미 존재하는 id입니다. 다른아이디를 넣으세요!");
		    					input_id=HomeWork.Scanner_try.getInt(">>추가하고자 하는 id를 입력하세요! \n>> id:");
		    					i=-1;
		    				}
		    			}
	    				for(int j=0;j<staffs.size();j++){
		    				if(input_id==staffs.get(j).id)  {
		    					System.out.println(">>이미 존재하는 id입니다. 다른아이디를 넣으세요!");
		    					input_id=HomeWork.Scanner_try.getInt(">>추가하고자 하는 id를 입력하세요! \n>> id:");
		    					i=-1;
		    				}
	    				}
    				}
    				if(i==students.size()-1) {
    					if(input_person_type_int==1) {
    						input_person_type_String="student";
    						System.out.println(">>[Student]레코드 추가를 시작합니다.");
    					}
		    			if(input_person_type_int==2) {
		    				input_person_type_String="professor";
		    				System.out.println(">>[Professor]레코드 추가를 시작합니다.");
		    			}
		    			if(input_person_type_int==3) {
		    				input_person_type_String="staff";
		    				System.out.println(">>[Staff]레코드 추가를 시작합니다.");
		    			}
		    			break;
    				}
    			}
	        	if(input_person_type_String.equals("student")) {
	        		student.id=input_id;
	        		student.name=HomeWork.Scanner_try.getString(">>name:");  
					student.age=HomeWork.Scanner_try.getInt(">>age:");
					student.address=HomeWork.Scanner_try.getString(">>address:");
					student.grade=HomeWork.Scanner_try.getInt(">>grade");
					student.studentNo=HomeWork.Scanner_try.getInt(">>studentNo:");
					student.major=HomeWork.Scanner_try.getString(">>major:");
	    			if (student.id > 0) {
	                    students.add(student);  // 리스트에 추가
	                    person_order.add("student_order");  //순서 입력
	                    System.out.println(">>레코드가 성공적으로 추가되었습니다.");
	    			} 
	    			else {
	    				System.out.println("Invalid student ID: " + student.id);
	    			}
	        	}
	        	else if(input_person_type_String.equals("professor")) {
	        		professor.id=input_id;
	        		professor.name=HomeWork.Scanner_try.getString(">>name:");  
	        		professor.age=HomeWork.Scanner_try.getInt(">>age:");
	        		professor.address=HomeWork.Scanner_try.getString(">>address:");
	        		professor.salary=HomeWork.Scanner_try.getInt(">>salary:");
	        		professor.position=HomeWork.Scanner_try.getString(">>position:");
	        		professor.course=HomeWork.Scanner_try.getString(">>course:");
	    			if (professor.id > 0) {
	                    professors.add(professor);  // 리스트에 추가
	                    person_order.add("professor_order");  //순서 입력
	                    System.out.println(">>레코드가 성공적으로 추가되었습니다.");
	    			} 
	    			else {
	    				System.out.println("Invalid student ID: " + professor.id);
	    			}
	        	}
	        	else if(input_person_type_String.equals("staff")) {
	        		staff.id=input_id;
	        		staff.name=HomeWork.Scanner_try.getString(">>name:");  
	        		staff.age=HomeWork.Scanner_try.getInt(">>age:");
	        		staff.address=HomeWork.Scanner_try.getString(">>address:");
	        		staff.salary=HomeWork.Scanner_try.getInt(">>salary:");
	        		staff.supervisor=HomeWork.Scanner_try.getString(">>supervisor:");
	        		staff.department=HomeWork.Scanner_try.getString(">>department:");
	    			if (staff.id > 0) {
	    				staffs.add(staff);  // 리스트에 추가
	                    person_order.add("staff_order");  //순서 입력
	                    System.out.println(">>레코드가 성공적으로 추가되었습니다.");
	    			} 
	    			else {
	    				System.out.println("Invalid student ID: " + staff.id);
	    			}
	        	}
    			student=null;  //메뉴1에서 사용했던 객체들 삭제
	    		professor=null;
	    		staff=null;	 
    		}	    	
	        else if(input_menu==2) {
	        	int input_id=HomeWork.Scanner_try.getInt(">>id는 무엇입니까? \n>>");    //난 id 만 입력해도 person 종류 찾도록 작성하였다
	        	String person_input = null;    //입력 받은 id 에 해당하는 객체를 저장한다
	        	int person_index_input = 0;   //입력 받은 id 에 해당하는 객체의 인덱스를 저장한다
	        	
	        	//입력 받은 id 에 해당하는 객체와 그객체의 인덱스를 찾는 반복문
	        	LOOP1:
	        	for(int i=0;i<students.size();i++){
    				if(input_id==students.get(i).id)  {
    					System.out.println(">>[Student]레코드 수정을 시작합니다.");
    					person_input="student";
    					person_index_input=i;
    					break;
    				}
    				
    				if(i==0) {     // 학생 id 검색이 있는 반복문 안의 첫번째 반복에서 교수 id 와 직원 id 검색도 한다 
    					for(int j=0;j<professors.size();j++){
		    				if(input_id==professors.get(j).id)  {
		    					System.out.println(">>[Professor]레코드 수정을 시작합니다.");
		    					person_input="professor";
		    					person_index_input=i;
		    					break LOOP1;
		    				}
		    			}
	    				for(int j=0;j<staffs.size();j++){
		    				if(input_id==staffs.get(j).id)  {
		    					System.out.println(">>[Staff]레코드 수정을 시작합니다.");
		    					person_input="staff";
		    					person_index_input=i;
		    					break LOOP1;
		    				}
	    				}
    				}
    				if(i==students.size()-1) {
    					input_id=HomeWork.Scanner_try.getInt("존재하지않는 id입니다 다시입력하세요\n>>");
    					i=-1;
    				}
    			}
	        	
	        	int field_input=HomeWork.Scanner_try.getInt(">>수정할 필드(항목)는 무엇입니까? \n>>1.name  2.age  3.address  4.grade   5.studentNo  6.major \n>>");
	        	String input_value=HomeWork.Scanner_try.getString(">>수정할 값을 입력하십시오 \n>>");
//	        	입력받은 항목의 숫자를 문자로 바꿔준다
	        	String input_key="";
        		if(field_input==1)
        			input_key="name";
        		if(field_input==2)
        			input_key="age";
        		if(field_input==3)
        			input_key="address";
        		if(field_input==4)
        			input_key="grade";
        		if(field_input==5)
        			input_key="studentNo";
        		if(field_input==6)
        			input_key="major";
	        	
        		Student student=new Student();   //밑의 조건문들에 사용할 객체 생성
        		Professor professor=new Professor();
        		Staff staff=new Staff();
        		
        		
//        		입력하는 조건문이다
	        	if(person_input.equals("student")) {
//	        		get 메서드로 가져온 것을 input 메서드에 넣어서 다시 객체를 생성해서 수정이 되는 원리
	        		student.input(students.get(person_index_input),input_key,input_value);
	        		student.display(students.get(person_index_input));
//	        		students.set(person_index_input,student);     리스트 객체배열에 set 을 사용하면 이상하게 바뀌는 버그가 있다 
	        		student.display(students.get(person_index_input));

	        	}
	        	if(person_input.equals("professor")) {
	        		professor.input(professors.get(person_index_input),input_key,input_value);
	        		professor.display(professors.get(person_index_input));
	        	}
	        	if(person_input.equals("staff")) {
	        		staff.input(staffs.get(person_index_input),input_key,input_value);
	        		staff.display(staffs.get(person_index_input));
	        	}
	        	System.out.println(">>id:"+input_id+"의 "+input_key+"가 성공적으로 수정되었습니다");
	        	System.out.println("==================================================================\n"
	        			+ "==================================================================\n");
	        	
//        		student=null; //객체 다 썼으니까 삭제
//        		professor=null; //객체 다 썼으니까 삭제
//        		staff=null; //객체 다 썼으니까 삭제
//	        	여기서 객체를 삭제하면 객체배열에 들어간 객체도 초기화가 되는 일이 생긴다.... 왜지???

	        }
	        else if(input_menu==3) {
	        	int input_id=HomeWork.Scanner_try.getInt(">> 삭제를 원하는 id를 입력 하십시오... ");
	        	String person_input="";
	        	int person_index_input=0;
			
	        	//입력 받은 id 에 해당하는 객체와 그객체의 인덱스를 찾는 반복문
	        	LOOP1:
	        	for(int i=0;i<students.size();i++){
    				
					if(input_id==students.get(i).id)  {
    					person_input="student";
    					person_index_input=i;
    					break;
    				}
    				
    				if(i==0) {     // 학생 id 검색이 있는 반복문 안의 첫번째 반복에서 교수 id 와 직원 id 검색도 한다 
    					for(int j=0;j<professors.size();j++){
		    				if(input_id==professors.get(j).id)  {
		    					person_input="professor";
		    					person_index_input=i;
		    					break LOOP1;
		    				}
		    			}
	    				for(int j=0;j<staffs.size();j++){
		    				if(input_id==staffs.get(j).id)  {
		    					person_input="staff";
		    					person_index_input=i;
		    					break LOOP1;
		    				}
	    				}
    				}
    				if(i==students.size()-1) {
    					input_id=HomeWork.Scanner_try.getInt("존재하지않는 id입니다 다시입력하세요");
    					i=-1;
    				}
    			}
	        		        	
	        	if(person_input.equals("student")) {
	        		Student Student=new Student();
	        		Student.display(students.get(person_index_input));
	        		Student=null; //객체 다 썼으니까 삭제
	        	}
	        	else if(person_input.equals("professor")) {
	        		Professor professor=new Professor();
	        		professor.display(professors.get(person_index_input));
	        		professor=null; //객체 다 썼으니까 삭제
	        	}
	        	else if(person_input.equals("staff")) {
	        		Staff staff=new Staff();
	        		staff.display(staffs.get(person_index_input));
	        		staff=null; //객체 다 썼으니까 삭제
	        	}
	        	
	        	int menu3_check=HomeWork.Scanner_try.getInt(">>정말 이 레코드를 삭제하시겠습니까? (1.Yes  2.No)>> ");
	        	boolean escape=true;
	        	while(escape) {
		        	if(menu3_check==1) {
		        		if(person_input.equals("student"))
		        			students.remove(person_index_input);
			        	if(person_input.equals("professor"))
			        		professors.remove(person_index_input);
			        	if(person_input.equals("staff"))
			        		staffs.remove(person_index_input);
			        	escape=false;
		        	}
		        	else if(menu3_check==2){
		        		System.out.println("삭제하지 않겠습니다");
		        		escape=false;
		        	}
		        	else {
		        		System.out.println("잘못된 입력입니다");
		        		escape=true;
		        	}
	        	}
	        	
	        }
	        else if(input_menu==4) {
	        	int choice=HomeWork.Scanner_try.getInt("1.파일출력  2.콘솔출력? ...");
	        	switch(choice) {
	        	case 1:
	        		// 프로그램의 데이터를 파일에 출력하는 메서드이다
//	        		마지막으로 구현할 부분이다!
	        		FileManager.output(person_order ,students, professors, staffs);  //데이터를 파일에 출력하는 메서드이다   
	        		break;
	        	case 2:
	        		FileManager.display(person_order ,students, professors, staffs);  // 데이터를 콘솔에 출력하는 메서드이다
	        	}
	        }
	        else if(input_menu==5) {
	        	Quit_select Quit_select=new Quit_select();
	        	if(Quit_select.run()) {
	        		break;
	        	}
	        		
	        }
	        else {
	        	System.out.println("잘못된 입력입니다");
	        }
        }
    }
}




