package skypro.CollectionsList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skypro.CollectionsList.Interface.EmployeeService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeBookServiceTest {
    EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void addEmployeeTest() {
        Employee employee = new Employee("Petr", "Petrov", 1, 25);
        Map<String, Employee> expected = new HashMap<>();
        expected.put("PetrPetrov", employee);
        employeeService.addEmployee("Petr", "Petrov", 1, 25);
        Map<String, Employee> actual = employeeService.getEmployees();
        assertEquals(expected, actual);
    }

    @Test
    public void addEmployeeTestException() {
        employeeService.addEmployee("Ivanov", "Ivan", 1,
                5);

        assertThrows(RuntimeException.class, () -> employeeService.addEmployee("Ivanov", "Ivan",
                1, 5));
    }

    @Test
    public void removeEmployeeTest() {
        Employee employee1 = new Employee("Petr", "Petrov", 1, 25);

        Employee employee2 = new Employee("Ivan", "Ivanov", 1, 5);

        Map<String, Employee> expected = new HashMap<>();
        expected.put("PetrPetrov", employee1);

        employeeService.addEmployee("Petr", "Petrov", 1, 25);

        employeeService.addEmployee("Ivan", "Ivanov", 1, 5);

        employeeService.removeEmployee("Ivan", "Ivanov", 1, 5);

        Map<String, Employee> actual = employeeService.getEmployees();

        assertEquals(expected, actual);
    }
    @Test
    public void removeEmployeeTestException() {

        assertThrows(RuntimeException.class, () -> employeeService.removeEmployee("Ivanov", "Ivan", 1,5));
    }
    @Test
    public void findEmployeeTest() {

        Employee expected = new Employee("Ivanov", "Ivan", 1, 5);

        employeeService.addEmployee("Ivanov", "Ivan", 1, 5);

        Employee actual = employeeService.findEmployee("Ivanov", "Ivan", 1,5);

        assertEquals(expected, actual);
    }
    @Test
    public void findEmployeeTestException() {

        assertThrows(RuntimeException.class, () -> employeeService.findEmployee("Ivanov", "Ivan", 1,5));
    }
}

