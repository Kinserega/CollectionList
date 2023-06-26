package skypro.CollectionsList;

import org.springframework.stereotype.Service;
import skypro.CollectionsList.Interface.EmployeeService;
import skypro.CollectionsList.Interface.EmployeeServiceSalary;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class EmployeeServiceSalaryImpl implements EmployeeServiceSalary {
    private final EmployeeService employeeService;

    public EmployeeServiceSalaryImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee employeeWichMaxSalary(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow(RuntimeException::new);

    }

    @Override
    public Employee employeeWichMinSalary(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Employee> employeeByOffice(int department) {
        return employeeService.getAllEmployees().stream()
                .filter(e->e.getDepartment() == department)
                .sorted(Comparator.comparingDouble(employee -> employee.getSalary()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeeByOffice() {
        return employeeService.getAllEmployees().stream()
                .sorted(Comparator.comparingDouble(employee -> employee.getSalary()))
                .collect(groupingBy(Employee::getDepartment));
    }
}
