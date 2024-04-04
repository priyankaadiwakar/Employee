package com.priyanka.employeeproject;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class EmpController {

    //List<Employee> employees = new ArrayList<>();
   // EmployeeService employeeService = new EmployeeServiceImpl();

   @Autowired
   EmployeeService employeeService;
   @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
       return employeeService.readEmployee();
   }

   @PostMapping("/employee")
    public String createEmployee(@RequestBody Employee employee){
       //employees.add(employee);
       return employeeService.createEmployee(employee);
   }

//   @DeleteMapping("/employee/{id}")
//    public String deleteEmployee(@PathVariable Long id){
//       if(employeeService.deleteEmployee(id))
//           return "delete sucessfully";
//
//   }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id)) {
            return "Delete successful";
        } else {
            return "Failed to delete employee with ID: " + id;
        }
    }

}
