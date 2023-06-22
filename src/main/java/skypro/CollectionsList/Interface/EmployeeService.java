package skypro.CollectionsList.Interface;

import org.springframework.stereotype.Service;
import skypro.CollectionsList.Employee;

import java.util.Collection;

@Service
public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> getAllEmployees();

}
