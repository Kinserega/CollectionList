package skypro.CollectionsList.Interface;

import skypro.CollectionsList.Employee;
import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int office, float salary);

    Employee findEmployee(String firstName, String lastName, int office, float salary);

    Employee removeEmployee(String firstName, String lastName, int office, float salary);

    Collection<Employee> getAllEmployees();

}
