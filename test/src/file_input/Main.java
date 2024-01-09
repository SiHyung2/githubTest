package file_input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Person {
    public int id;
    String name;
    int age;
    String address;
}

class Employee extends Person {
    int salary;
    String position;
    String supervisor;
}

class Student extends Person {
    int grade;
    int studentNo;
    String major;
}

class Professor extends Employee {
    String course;
}

class Staff extends Employee {
    String department;
}

public class Main {
    public static void main(String[] args) {
        try {
            // 파일 경로 설정
            String filePath = "C:\\Users\\tlgud\\OneDrive\\바탕 화면\\work\\파일 입출력 연습\\텍스트 파일\\inputFile.txt";
            File file = new File(filePath);

            // 파일 읽기
//            FileReader fileReader = new FileReader(file);
            FileInputStream fileInputStream = new FileInputStream(file);
            Scanner fileScanner = new Scanner(fileInputStream, "UTF-8");
            fileScanner.useDelimiter("\n");  // 개행 문자로 데이터를 읽어오도록 변경

            // 리스트 초기화
            List<Student> students = new ArrayList<>();
            Professor professor = new Professor();
            Staff staff = new Staff();

            // 파일 읽기
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.toLowerCase().startsWith("[student]")) {
                    // Student 객체 생성
                    Student student = new Student();
                    for (int i = 0; i < 7; i++) {
                        line = fileScanner.nextLine();
                        String[] info = line.split(":");
                        info[0] = info[0].toLowerCase().trim();
                        info[1]=info[1].trim();
                        switch (info[0]) {
                            case "id":
                                student.id = Integer.parseInt(info[1]);
                                break;
                            case "name":
                                student.name = info[1];
                                break;
                            case "age":
                                student.age = Integer.parseInt(info[1]);
                                break;
                            case "address s":
                            case "address":
                            	student.address = info[1];
                                break;
                            case "grade":
                                student.grade = Integer.parseInt(info[1]);
                                break;
                            case "studentno":
                                student.studentNo = Integer.parseInt(info[1]);
                                break;
                            case "major":
                                student.major = info[1];
                                break;
                        }
                    }
                    students.add(student);  // 리스트에 추가
                } else if (line.toLowerCase().startsWith("[professor]")) {
                    // Professor 객체 생성
                    for (int i = 0; i < 6; i++) {
                        line = fileScanner.nextLine();
                        String[] info = line.split(": ");
                        info[0] = info[0].toLowerCase();
                        switch (info[0]) {
                            case "id":
                                professor.id = Integer.parseInt(info[1]);
                                break;
                            case "name":
                                professor.name = info[1];
                                break;
                            case "age":
                                professor.age = Integer.parseInt(info[1]);
                                break;
                            case "address s":
                            case "address":
                            	professor.address = info[1];
                                break;
                            case "salary":
                                professor.salary = Integer.parseInt(info[1]);
                                break;
                            case "position":
                                professor.position = info[1];
                                break;
                            case "course":
                                professor.course = info[1];
                                break;
                        }
                    }
                } else if (line.toLowerCase().startsWith("[staff]")) {
                    // Staff 객체 생성
                    for (int i = 0; i < 6; i++) {
                        line = fileScanner.nextLine();
                        String[] info = line.split(": ");
                        info[0] = info[0].toLowerCase();
                        switch (info[0]) {
                            case "id":
                                staff.id = Integer.parseInt(info[1]);
                                break;
                            case "name":
                                staff.name = info[1];
                                break;
                            case "age":
                                staff.age = Integer.parseInt(info[1]);
                                break;
                            case "address s":
                            case "address":
                            	staff.address = info[1];
                                break;
                            case "salary":
                                staff.salary = Integer.parseInt(info[1]);
                                break;
                            case "position":
                                staff.position = info[1];
                                break;
                            case "department":
                                staff.department = info[1];
                                break;
                        }
                    }
                }
            }

            // 출력 예시
            for (Student student : students) {
                System.out.println("Student ID: " + student.id);
                System.out.println("Student Name: " + student.name);
                System.out.println("Student Age: " + student.age);
                System.out.println("Student Address: " + student.address);
                System.out.println("Student Grade: " + student.grade);
                System.out.println("Student StudentNo: " + student.studentNo);
                System.out.println("Student Major: " + student.major);
                System.out.println("--------------------------");
            }

            System.out.println("Professor ID: " + professor.id);
            System.out.println("Professor Name: " + professor.name);
            System.out.println("Professor Age: " + professor.age);
            System.out.println("Professor Address: " + professor.address);
            System.out.println("Professor Salary: " + professor.salary);
            System.out.println("Professor Position: " + professor.position);
            System.out.println("Professor Course: " + professor.course);
            System.out.println("--------------------------");

            System.out.println("Staff ID: " + staff.id);
            System.out.println("Staff Name: " + staff.name);
            System.out.println("Staff Age: " + staff.age);
            System.out.println("Staff Address: " + staff.address);
            System.out.println("Staff Salary: " + staff.salary);
            System.out.println("Staff Position: " + staff.position);
            System.out.println("Staff Department: " + staff.department);

            // 파일 스캐너 닫기
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
