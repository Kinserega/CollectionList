package skypro.CollectionsList.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.CollectionsList.Employee;
import skypro.CollectionsList.Interface.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName, @RequestParam ("office") int department, @RequestParam ("salary") float salary){
        return employeeService.addEmployee(firstName, lastName,department, salary);
    }
    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName, @RequestParam ("office") int department, @RequestParam ("salary") float salary){
        return employeeService.removeEmployee(firstName, lastName, department, salary);
    }
    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName, @RequestParam ("office") int department, @RequestParam ("salary") float salary){
        return employeeService.findEmployee(firstName, lastName, department, salary);
    }
    @GetMapping(path = "/get")
    public Map<String, Employee> getEmployees(){
        return employeeService.getEmployees();
    }

}

