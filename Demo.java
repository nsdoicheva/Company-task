import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Demo {
	public static void main(String[] args) {
		try {
			ICompany vinkelOOD = new Company("Vinkel OOD");
			
			vinkelOOD.addEmployee("Vinkeli ot jelqzo", new Employee("Ivan Vinkela", 5000, 20));
			vinkelOOD.addEmployee("Vinkeli ot jelqzo", new Employee("Pesho", 2000, 60));
			vinkelOOD.addEmployee("Vinkeli ot jelqzo", new Employee("Stoqna", 1000, 19));
			
			vinkelOOD.addEmployee("Vinkeli za Golf(kolata)", new Employee("Gosho Vinkela", 300, 60));
			vinkelOOD.addEmployee("Vinkeli za Golf(kolata)", new Employee("Bojidar Golfadjiqta", 9000, 22));
			
			vinkelOOD.addEmployee("Otdel na shefchetata", new Employee("Bai Mitio Golemiq Vinkel", 18800, 90));
			
			Set<Employee> proba = new HashSet<Employee>() ;
			proba.add(new Employee("mimi", 50, 18));
			proba.add(new Employee("ani", 500, 18));
			proba.add(new Employee("vanchieto", 555, 12));
			
		//	Calendar dnes = Calendar.getInstance();
		//	System.out.println(dnes.getTime());
			
			LocalDate den = LocalDate.now();
			System.out.println(den);
			
			LocalTime vreme = LocalTime.now();
			System.out.println(vreme);
			
			System.out.println(vreme.getHour());
			System.out.println("Mesec: " +  den.getMonthValue());
			
			Period periodi = Period.ofMonths(5);
			System.out.println(den.plus(periodi));
			
			
			System.out.println(vinkelOOD.getEmployees(SortCriteria.SALARY));
		} catch (CompanyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
