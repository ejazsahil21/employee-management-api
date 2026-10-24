package com.api.service;

import com.api.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto add(EmployeeDto employeeDto);
    public void deleteEmployee(long id);
    public EmployeeDto findEmployeeById(long id);
    public void updateEmployee(long id, EmployeeDto employeeDto);
    public List<EmployeeDto> getAllEmployees();
    public List<EmployeeDto> fetchAllEmployees(int pageNo, int pageSize, String sortBy);
}
