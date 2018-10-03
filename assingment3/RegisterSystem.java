import java.util.ArrayList;

class Student {
	private String name;
	private int id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Student(int id, String name) {
		this.name = name;
		this.id = id;
	}
	
}

class Course {
	private String title;
	private int numberOfStduent;
	private Student[] students;
	
	static final private int MaxStudentNum = 10;
	
	public Course(String title) {
		this.setTitle(title);
		this.numberOfStduent = 0;
		this.students = new Student[MaxStudentNum];
	}
	
	public Student[] getStudents() {
		return this.students;
	}
	
	public boolean isFull() {
		return getNumberOfStduent() >= MaxStudentNum;
	}
	
	public boolean registerStudent(Student t) {
		if (this.isFull())
			return false;
		
		students[numberOfStduent] = t;
		numberOfStduent++;
		
		return true;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumberOfStduent() {
		return numberOfStduent;
	}

	public void setNumberOfStduent(int numberOfStduent) {
		this.numberOfStduent = numberOfStduent;
	}
	
	
	
}


public class RegisterSystem {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int num = 11;
		Student ss[] = new Student[num];
		for(int i = 0; i < num; i++)
			ss[i] = new Student(i, "student"+i);
		
		Course course = new Course("Course1");
		
		for (int i = 0; i < num; i++) {
			boolean isRegister = course.registerStudent(ss[i]);
			
			System.out.println(ss[i].getName() + " RegisterResult: " + isRegister);
		}
			
	}

}
