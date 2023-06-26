package skypro.CollectionsList.Interface;

import skypro.CollectionsList.Employee;
import java.util.List;


public interface EmployeeServiceSalary {
    Employee employeeWichMaxSalary(int office);
    Employee employeeWichMinSalary(int office);
    List<Employee> employeeByOffice(int office);

    List<Employee> allEmployeeByOffice();

}
