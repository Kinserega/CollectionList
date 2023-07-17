package skypro.CollectionsList.Interface;

import skypro.CollectionsList.Employee;
import java.util.List;
import java.util.Map;


public interface EmployeeServiceSalary {
    Employee employeeWichMaxSalary(int department);
    Employee employeeWichMinSalary(int department);
    List<Employee> employeeByOffice(int department);

    Map<Integer, List<Employee>> allEmployeeByOffice();

}
