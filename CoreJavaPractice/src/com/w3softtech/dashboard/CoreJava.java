package com.w3softtech.dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
class Student{
	public Student(Integer age,String name) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	private String name;
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	private Integer age;
}
class Employee{
	private Integer age;
	private String empName;
	public String getEmpName() {
		return empName;
	}
	public Integer getAge() {
		return age;
	}
	public Employee() {
		super();
	}
	public Employee(Integer age, String empName) {
		super();
		this.age = age;
		this.empName = empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
public class CoreJava {

	public static void main(String[] args) {
		
		
		List<Student> studentList = List.of(new Student(101,"shailaja"),
				new Student(10,"shailaja"),
				new Student(10,"shailaja"),
				new Student(1,"shailaja"),
				new Student(23,"shailaja"));
		
		List<Employee> list = studentList.stream().map(student->{
			Employee emp =new Employee(student.getAge(), student.getName());
			return emp;
		}).collect(Collectors.toList());
		
		list.forEach(e->System.out.println(e.getAge()));
		

	/*	String empName1="kundan";
		String empName2="kundan";
		System.out.println(empName1.equals(empName2));
		System.out.println(empName1==empName2);
		
			String empName3=empName1;
			System.out.println(empName3.equals(empName1));
			System.out.println(empName3==empName1);
		
			empName1 ="radhika";
		
			System.out.println(empName3.equals(empName1));
			System.out.println(empName3==empName1);
			
			
			
			
			
	System.out.println("===============================");	
	String eName1= new String("kundan");
	String eName2= new String("kundan");
	System.out.println(eName1.equals(eName2));
	System.out.println(eName1==eName2);
	String eName3=eName1;
	System.out.println(eName3.equals(eName1));
	System.out.println(eName3==eName1);
	
	eName1="radhika";
	System.out.println(eName3.equals(eName1));
	System.out.println(eName3==eName1);
	
		Employee emp1 = new Employee("Kundan");
		Employee emp2 = new Employee("Kundan");
		System.out.println(emp1.getEmpName().equals(emp2.getEmpName()));
		System.out.println(emp1.getEmpName()==emp2.getEmpName());
		System.out.println(emp1.hashCode()+"   "+emp2.hashCode());*/
	}
	//System.out.println();

}
