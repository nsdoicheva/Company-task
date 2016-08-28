import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public interface ICompany {

	void addEmployee(String department, Employee employee);

	void listAllEmployees();

	SortedSet<Employee> getEmployees(SortCriteria sortByWhat);
	SortedSet<Employee> sortAgain( Map<String, Set<Employee>> employees);
}