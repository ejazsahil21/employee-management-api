package com.api.controller;

import com.api.dto.APIResponse;
import com.api.dto.EmployeeDto;
import com.api.entity.Employee;
import com.api.repository.EmployeeRepository;
import com.api.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService,
                              EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<APIResponse<EmployeeDto>> saveEmployee(
            @Valid @RequestBody EmployeeDto employeeDto,
            BindingResult result) {
        EmployeeDto emp = employeeService.add(employeeDto);
        APIResponse<EmployeeDto> response = new APIResponse<>();
        if(result.hasErrors()){
            String message = result.getFieldError().getDefaultMessage();
        }

        if (emp != null) {
            response.setMessage("Created");
            response.setStatus(201);
            response.setData(emp);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } else {
            response.setMessage("Something went Wrong");
            response.setStatus(500);
            response.setData(emp);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<APIResponse<String>> deleteEmployee(
            @RequestParam long id
    ){
        employeeService.deleteEmployee(id);
        APIResponse<String> response = new APIResponse<>();
        response.setMessage("Deleted");
        response.setStatus(201);
        response.setData(("Permanently deleted from Database"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<APIResponse<EmployeeDto>> getEmployeeById(
            @PathVariable long id
    ){
        EmployeeDto employeeDto = employeeService.findEmployeeById(id);
        APIResponse<EmployeeDto> response = new APIResponse<>();
        response.setMessage("Fetched Data");
        response.setStatus(200);
        response.setData(employeeDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse<List<EmployeeDto>>> getAllEmployees(){
        List<EmployeeDto> employeeDtos = employeeService.getAllEmployees();
        APIResponse<List<EmployeeDto>> response = new APIResponse<>();
        response.setMessage("Fetched Data");
        response.setStatus(200);
        response.setData(employeeDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Pagination and Sorting
    //http;//localhost:8080/api/v1/employee/all?pageNo=0&pageSize=3
    @GetMapping("/fetch")
    public ResponseEntity<APIResponse<List<EmployeeDto>>> fetchAllEmployees(
            @RequestParam(name="pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(name="pageSize", defaultValue = "2", required = false) int pageSize,
            @RequestParam(name="sortBy", defaultValue = "id", required = false) String sortBy
    ){
        List<EmployeeDto> employeeDtos = employeeService.fetchAllEmployees(pageNo, pageSize, sortBy);
        APIResponse<List<EmployeeDto>> response = new APIResponse<>();
        response.setMessage("Fetched Data");
        response.setStatus(200);
        response.setData(employeeDtos);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
