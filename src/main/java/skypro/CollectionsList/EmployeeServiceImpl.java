package skypro.CollectionsList;

import org.springframework.stereotype.Service;
import skypro.CollectionsList.Exception.EmployeeAlreadyAddedException;
import skypro.CollectionsList.Exception.EmployeeNotFoundException;
import skypro.CollectionsList.Exception.EmployeeStorageIsFullException;
import skypro.CollectionsList.Interface.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int STOPLIST = 5;
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() == STOPLIST) {
            throw new EmployeeStorageIsFullException("Хранилище полное!");
        }
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть!");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
        employees.remove(employee);

    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
        for (Employee employee1 : employees) {
            if (employee1.equals(employee)) {
                return employee1;
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

}