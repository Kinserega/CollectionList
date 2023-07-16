package skypro.CollectionsList.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.CollectionsList.Employee;
import skypro.CollectionsList.Interface.EmployeeServiceSalary;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class EmployeeSalaryController {
    private EmployeeServiceSalary employeeServiceSalary;

    public EmployeeSalaryController(EmployeeServiceSalary employeeServiceSalary) {
        this.employeeServiceSalary = employeeServiceSalary;
    }

    @GetMapping("/max-salary")
    public Employee employeeWichMaxSalary(@RequestParam("department") int department) {
        return employeeServiceSalary.employeeWichMaxSalary(department);
    }
    @GetMapping("/min-salary")
    public Employee employeeWichMinSalary(@RequestParam("department") int department) {
        return employeeServiceSalary.employeeWichMinSalary(department);
    }
    @GetMapping(value = "/all", params = "office")
    public List<Employee> employeeByOffice(@RequestParam("department") int department) {
        return employeeServiceSalary.employeeByOffice(department);
    }
    @GetMapping("/all")
    public List<Employee> allEmployeeByOffice() {
        return (List<Employee>) employeeServiceSalary.allEmployeeByOffice();
    }

}
