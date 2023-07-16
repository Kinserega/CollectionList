package skypro.CollectionsList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.CollectionsList.Interface.EmployeeService;
import skypro.CollectionsList.Interface.EmployeeServiceSalary;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class DepartamentServiceTest {
    private EmployeeServiceSalary employeeServiceSalary;
    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeServiceSalary = new EmployeeServiceSalaryImpl(employeeService);
    }

    @Test
    public void employeeWichMaxSalaryTest() {
        assertNotNull(employeeService);

        Employee employee1 = new Employee("Ivanov", "Ivan", 1,
                5984);
        Employee employee2 = new Employee("Ivanov", "Petr", 2,
                4500);
        Employee employee3 = new Employee("Ivanov", "Andrei", 1,
                4500);

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Ivanov Ivan", employee1);
        employees.put("Ivanov Petr", employee2);
        employees.put("Ivanov Andrei", employee3);

        Mockito.when(employeeService.getEmployees()).thenReturn(employees);

        Employee expected = employee1;

        Employee actual = employeeServiceSalary.employeeWichMaxSalary(1);

        assertEquals(expected, actual);
    }

    @Test
    public void employeeWichMinSalary() {
        assertNotNull(employeeService);

        Employee employee1 = new Employee("Ivanov", "Ivan", 1,
                5984);
        Employee employee2 = new Employee("Ivanov", "Petr", 2,
                4500);
        Employee employee3 = new Employee("Ivanov", "Andrei", 1,
                4400);

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Ivanov Ivan", employee1);
        employees.put("Ivanov Petr", employee2);
        employees.put("Ivanov Andrei", employee3);

        Mockito.when(employeeService.getEmployees()).thenReturn(employees);

        Employee expected = employee3;

        Employee actual = employeeServiceSalary.employeeWichMinSalary(1);

        assertEquals(expected, actual);
    }

    @Test
    public void employeeByOfficeTest() {
        assertNotNull(employeeService);

        Employee employee = new Employee("Ivanov", "Ivan", 1,
                5984);

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Ivanov Ivan", employee);

        Mockito.when(employeeService.getEmployees()).thenReturn(employees);

        List<Employee> expected = new ArrayList<>();
        expected.add(employee);

        List<Employee> actual = employeeServiceSalary.employeeByOffice(1);

        assertEquals(expected, actual);
    }

    @Test
    public void allEmployeeByOfficeTest() {
        Employee employee1 = new Employee("Ivanov", "Ivan", 1,
                5984);
        Employee employee2 = new Employee("Ivanov", "Petr", 2,
                4500);
        Employee employee3 = new Employee("Ivanov", "Andrei", 1,
                4500);

        Map<String, Employee> employees = new HashMap<>();
        employees.put("Ivanov Ivan", employee1);
        employees.put("Ivanov Petr", employee2);
        employees.put("Ivanov Andrei", employee3);

        Mockito.when(employeeService.getEmployees()).thenReturn(employees);
        Map<Integer, List<Employee>> expected = new HashMap<>();
        expected.put(1, Arrays.asList(employee1, employee3));
        expected.put(2, Arrays.asList(employee2));

        Map<Integer, List<Employee>> actual = employeeServiceSalary.allEmployeeByOffice();

        assertEquals(expected.keySet(), actual.keySet());
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(1).get(0), actual.get(1).get(1));
        assertEquals(expected.get(1).get(1), actual.get(1).get(0));
        assertEquals(expected.get(2).get(0), actual.get(2).get(0));
    }
}
