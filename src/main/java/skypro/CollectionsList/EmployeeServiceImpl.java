package skypro.CollectionsList;

import org.springframework.stereotype.Service;
import skypro.CollectionsList.Exception.EmployeeAlreadyAddedException;
import skypro.CollectionsList.Exception.EmployeeNotFoundException;
import skypro.CollectionsList.Exception.EmployeeStorageIsFullException;
import skypro.CollectionsList.Exception.InvalidImputException;
import skypro.CollectionsList.Interface.EmployeeService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Map<String, Employee> employeesFullName = new HashMap<>();
    private final int STOP = 5;

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, float salary) {
        if (!examination(firstName, lastName)) {
            throw new InvalidImputException("Не прошла проверка");
        }
        if (employeesFullName.size() >= STOP) {
            throw new EmployeeStorageIsFullException("Мэп переполнен");
        }
        Employee newEmployee = new Employee(firstName, lastName,department,salary);
        String fullName = getFullName(newEmployee);
        if (employeesFullName.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть");
        }
        employeesFullName.put(fullName, newEmployee);
        return newEmployee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int department, float salary) {
        Employee newEmployee = new Employee(firstName, lastName,department,salary);
        String fullName = getFullName(newEmployee);

        if (!employeesFullName.containsKey(fullName)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
        return employeesFullName.get(fullName);
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int department, float salary) {
        Employee newEmployee = new Employee(firstName, lastName,department,salary);
        String fullName = getFullName(newEmployee);
        if (!employeesFullName.containsKey(fullName)) {
            throw new EmployeeNotFoundException("Такой сотрудник не найден");
        }
        employeesFullName.remove(fullName);
        return newEmployee;
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return employeesFullName.values();
    }

    private String getFullName(Employee employee) {
        return employee.getFirstName() + employee.getLastName();
    }

    private boolean examination(String firstName, String lastName) {
        return isAlpha(firstName) && isAlpha(lastName);
    }
}