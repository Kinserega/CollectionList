package skypro.CollectionsList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.CollectionsList.Interface.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName){
        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping(path = "/remove")
    public void removeEmployee(@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName){
    }
    @GetMapping(path = "/find")
    public Employee findEmployee(@RequestParam ("firstName") String firstName, @RequestParam ("lastName") String lastName){
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

}

