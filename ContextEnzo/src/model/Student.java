package model;

public class Student {
	private String name;
	private String add;
	
	/**
	 * Constructor
	 * @param name Name of the student
	 * @param add Address of the student
	 */
	public Student(String name, String add) {
		this.name = name;
		this.add = add;
	}	// Student
	
	public String getName() {
		return name;
	}
	
	public String getAdd() {
		return add;
	}
}
