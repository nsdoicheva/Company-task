
public class Employee {	
	private String name;
	private int salary;
	private int age;
	private int id;
	private static int lastId = 1;
	
	
	public Employee(String name, int salary, int age) {
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.id = lastId++;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (!(obj instanceof Employee)) )
			return false;
		
		return this.id == ((Employee)obj).id;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", age=" + age + ", id=" + id + "] \n";
	}
}
