package skypro.CollectionsList.Interface;

import skypro.CollectionsList.Employee;

import java.util.Map;

public interface EmployeeService {
    Map<String, Employee> getEmployees();

    Employee addEmployee(String firstName, String lastName, int office, float salary);

    Employee findEmployee(String firstName, String lastName, int office, float salary);

    Employee removeEmployee(String firstName, String lastName, int office, float salary);

}
