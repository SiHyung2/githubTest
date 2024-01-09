package HomeWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
	
	// 리스트 초기화
    List<Student> students = new ArrayList<>();    //객체를 담을 배열을 선언한다 이때, 몇개 받을지 모르므로 list 를 사용한다
    List<Professor> professors = new ArrayList<>();
    List<Staff> staffs = new ArrayList<>();
    List<String> person_order=new ArrayList<>();   //텍스트파일에 적히는 순서를 저장한다
	public List<Student> getStudents() {	return students;	}  
	public List<Professor> getProfessors() {	return professors;	}
	public List<Staff> getStaffs() {	return staffs;	}
	public List<String> getPerson_order() {	return person_order;	}


	void input () throws FileNotFoundException {
		 // 파일 경로 설정
         String filePath = "C:\\Users\\it\\Desktop\\work\\파일 입출력 연습\\텍스트 파일\\inputFile.txt";
         File file = new File(filePath);

         // 파일 읽기
         FileReader fileReader = new FileReader(file);
         Scanner fileScanner = new Scanner(fileReader);
//         fileScanner.useDelimiter("\n");    // 개행 문자로 데이터를 읽어오도록 변경하지만 사실 없어도 되는 코드이다 
//         nextLine메소드가 있기때문이다

         // 파일 읽기
         while (fileScanner.hasNextLine()) {
             String line = fileScanner.nextLine();
             if (line.toLowerCase().startsWith("[student]")) {
                 // Student 객체 생성
                 Student student = new Student();
                 for (int i = 0; i < 7; i++) {
                     line = fileScanner.nextLine();
                     int index = line.indexOf(":");
                     String key = line.substring(0, index).trim().toLowerCase();
                     String value = line.substring(index + 1).trim();
                     student.input(student, key, value);   // student 객체에 데이터를 입력하는 메소드
                 }
                 if (student.id > 0) {
                     students.add(student);  // 리스트에 추가
                     person_order.add("student_order");   //순서 입력
                 }
             } else if (line.toLowerCase().startsWith("[professor]")) {
                 // Professor 객체 생성
            	 Professor professor = new Professor();
                 for (int i = 0; i < 8; i++) {
                     line = fileScanner.nextLine();
                     int index = line.indexOf(":");
                     String key = line.substring(0, index).trim().toLowerCase();
                     String value = line.substring(index + 1).trim();
                     professor.input(professor, key, value);  // professor 에 데이터 입력
                 }
                 if (professor.id > 0) {
                 	professors.add(professor);  // 리스트에 추가
                 	person_order.add("professor_order");  //순서 입력
                 }
             } else if (line.toLowerCase().startsWith("[staff]")) {
                 // Staff 객체 생성 
            	 Staff staff = new Staff();
                 for (int i = 0; i < 8; i++) {
                     line = fileScanner.nextLine();
                     int index = line.indexOf(":");
                     String key = line.substring(0, index).trim().toLowerCase();
                     String value = line.substring(index + 1).trim();
                     staff.input(staff, key, value);   //staff 에 데이터 입력
                     
                 }
                 if (staff.id > 0) {
	             	staffs.add(staff);  // 리스트에 추가
	             	person_order.add("staff_order");  //순서 입력
                 }
             }
             
         }
         // 파일 스캐너 닫기
         fileScanner.close();
     	
		 
	 }
	void display(List<String> person_order, List<Student> students, List<Professor> professors, List<Staff> staffs ) throws IOException {		
		System.out.println("id   name   age   address   grade   studentNo   major   salary   position   course   department");
		System.out.println("================================================================================================");
		int student_order_index=0, professor_order_index=0, staff_order_index=0;     
		
		for(int i=0;i<person_order.size();i++) {
			try {
    			if(person_order.get(i)=="student_order") {
    				System.out.printf("%1d",students.get(student_order_index).id);
    				System.out.printf("%5s",students.get(student_order_index).name);
    				System.out.printf("%7d",students.get(student_order_index).age);
    				System.out.printf("%-12s",students.get(student_order_index).address);
    				System.out.printf("%-4d",students.get(student_order_index).grade);
    				System.out.printf("%15d",students.get(student_order_index).studentNo);
    				System.out.printf("%6s\n",students.get(student_order_index).major);
    				student_order_index++;
    			}
    			if(person_order.get(i)=="professor_order") {
    				System.out.printf("%1d",professors.get(professor_order_index).id);
    				System.out.printf("%5s",professors.get(professor_order_index).name);
    				System.out.printf("%7d",professors.get(professor_order_index).age);
    				System.out.printf("%8s",professors.get(professor_order_index).address);
    				System.out.printf("%40d",professors.get(professor_order_index).salary);
    				System.out.printf("%7s",professors.get(professor_order_index).position);
    				System.out.printf("%10s",professors.get(professor_order_index).course);
    				System.out.printf("%10s\n",professors.get(professor_order_index).supervisor);
    				professor_order_index++;
    			}
    			if(person_order.get(i)=="staff_order") {
    				System.out.printf("%1d",staffs.get(staff_order_index).id);
    				System.out.printf("%5s",staffs.get(staff_order_index).name);
    				System.out.printf("%7d",staffs.get(staff_order_index).age);
    				System.out.printf("%8s",staffs.get(staff_order_index).address);
    				System.out.printf("%40d",staffs.get(staff_order_index).salary);
    				System.out.printf("%9s",staffs.get(staff_order_index).position);
    				System.out.printf("%10s",staffs.get(staff_order_index).supervisor);
    				System.out.printf("%10s\n",staffs.get(staff_order_index).department);
    				staff_order_index++;
    			}
			}catch(IndexOutOfBoundsException e) {	        			
//				메뉴3에서 인덱스를 삭제하기때문에 인덱스가 없을경우 출력하지않는다고 표시해야한다
//				try 문을 사용하지않으려면 person_order 인덱스를 수정해야할 것으로 보인다
			}
		} 
		System.out.println("================================================================================================\n");
		
	}
	
	
	void output(List<String> person_order2, List<Student> students2, List<Professor> professors2, List<Staff> staffs2) throws IOException {
		FileWriter fout=null;
		fout=new FileWriter("C:\\Users\\it\\Desktop\\work\\파일 입출력 연습\\텍스트 파일\\outputFile.txt");
		String line="";
		fout.write(line);
		
		
		
		int student_order_index=0, professor_order_index=0, staff_order_index=0;     
		for(int i=0;i<person_order.size();i++) {
			try {
    			if(person_order.get(i)=="student_order") {
    				fout.write("[student]\n");
    				fout.write("id: "+students.get(student_order_index).id+"\n");    
    				fout.write("name: "+students.get(student_order_index).name+"\n");   
    				fout.write("age: "+students.get(student_order_index).age+"\n");
    				fout.write("address: "+students.get(student_order_index).address+"\n");
    				fout.write("grade: "+students.get(student_order_index).grade+"\n");
    				fout.write("studentNo: "+students.get(student_order_index).studentNo+"\n");
    				fout.write("major: "+students.get(student_order_index).major+"\n\n");
    				student_order_index++;
    			}
    			if(person_order.get(i)=="professor_order") {
    				fout.write("[professor]\n");
    				fout.write("id: "+professors.get(professor_order_index).id+"\n");    
    				fout.write("name: "+professors.get(professor_order_index).name+"\n");   
    				fout.write("age: "+professors.get(professor_order_index).age+"\n");
    				fout.write("address: "+professors.get(professor_order_index).address+"\n");
    				fout.write("salary: "+professors.get(professor_order_index).salary+"\n");
    				fout.write("position: "+professors.get(professor_order_index).position+"\n");
    				fout.write("supervisor: "+professors.get(professor_order_index).supervisor+"\n\n");
    				professor_order_index++;
    			}
    			if(person_order.get(i)=="staff_order") {
    				fout.write("[student]\n");
    				fout.write("id: "+staffs.get(staff_order_index).id+"\n");    
    				fout.write("name: "+staffs.get(staff_order_index).name+"\n");   
    				fout.write("age: "+staffs.get(staff_order_index).age+"\n");
    				fout.write("address: "+staffs.get(staff_order_index).address+"\n");
    				fout.write("salary: "+staffs.get(staff_order_index).salary+"\n");
    				fout.write("position: "+staffs.get(staff_order_index).position+"\n");
    				fout.write("department: "+staffs.get(staff_order_index).department+"\n\n");
    				staff_order_index++;
    				
    				System.out.println(">>outputFile.txt 파일에 성공적으로 출력되었습니다!");
    			}
			}catch(IndexOutOfBoundsException e) {	        			
//				메뉴3에서 인덱스를 삭제하기때문에 인덱스가 없을경우 출력하지않는다고 표시해야한다
//				try 문을 사용하지않으려면 person_order 인덱스를 수정해야할 것으로 보인다
			}
		} 
		
		
		
		
		
		fout.close();
	}
}
