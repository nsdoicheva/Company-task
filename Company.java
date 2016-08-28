import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Company implements ICompany {	
	// department name -> set of employees that work in this department
	private Map<String, Set<Employee>> employees;
	private String name;
	
	
	public Company(String name) throws CompanyException {
		this.employees = new LinkedHashMap<String, Set<Employee>>();
		if ( (name == null) || (name.length() == 0) ) {
			throw new CompanyException("Ami ne moga da ti napravq companiq. Syjalqvam.");
		}
		this.name = name;
	}
	
	@Override
	public void addEmployee(String department, Employee employee) {
		if ((employee != null) && (department != null) && (department.trim().length() > 0)) {
			if (!(this.employees.containsKey(department))) {
				this.employees.put(department, new HashSet<Employee>());
			} 
			
			Set<Employee> employeesThatWorksInThisDepartment = this.employees.get(department);
			employeesThatWorksInThisDepartment.add(employee);
		}
	}

	/* (non-Javadoc)
	 * @see ICompany#listAllEmployees()
	 */
	@Override
	public void listAllEmployees() {
		for (Entry<String, Set<Employee>> entry : employees.entrySet()) {
			String department = entry.getKey();
			
			System.out.println("Deparment : " + department);
			Set<Employee> employeesInThisDepartment = entry.getValue();
			System.out.println("Employees :");
			
			for (Employee e : employeesInThisDepartment) {
				System.out.println(e);
			}
		}
	}

	@Override
	public SortedSet<Employee> getEmployees(SortCriteria sortByWhat) {
		SortedSet<Employee> result = new TreeSet<Employee>(getComparator(sortByWhat));
		
		for (Entry<String, Set<Employee>> entry : employees.entrySet()) {
			Set<Employee> employeesInThisDepartment = entry.getValue();
			
			result.addAll(employeesInThisDepartment);
		}
		
		return result;
	}


	private Comparator<Employee> getComparator(SortCriteria sortByWhat) {
		switch (sortByWhat) {
		case AGE:
			return new AgeComparator();
		case SALARY:
			return new SalaryComparator();
		case NAME:
			return new NameComparator();
		default: 
			return new NameComparator();
		}
	}
	
	
	public SortedSet<Employee> sortAgain( Map<String, Set<Employee>> employees) {
		SortedSet<Employee> result = new TreeSet<Employee>(getComparator(SortCriteria.NAME));
		
		for (Entry<String, Set<Employee>> entry : employees.entrySet()) {
			Set<Employee> samoRabotnicite = entry.getValue();
			
			result.addAll(samoRabotnicite);
		}
		
		return result;
		
	}
	
}

