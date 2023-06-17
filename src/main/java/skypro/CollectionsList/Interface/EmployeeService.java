package skypro.CollectionsList.Interface;

import org.springframework.stereotype.Service;
import skypro.CollectionsList.Employee;

import java.util.List;
@Service
public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> getAllEmployees();

}
