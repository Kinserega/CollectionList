package skypro.CollectionsList.Interface;

import skypro.CollectionsList.Employee;
import java.util.List;
import java.util.Map;


public interface EmployeeServiceSalary {
    Employee employeeWichMaxSalary(int office);
    Employee employeeWichMinSalary(int office);
    List<Employee> employeeByOffice(int office);

    Map<Integer, List<Employee>> allEmployeeByOffice();

}
