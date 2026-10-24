package com.api.service;

import com.api.dto.EmployeeDto;
import com.api.entity.Employee;
import com.api.exception.RecordNotFoundException;
import com.api.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public EmployeeDto add(EmployeeDto employeeDto) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(employeeDto,emp);

        if(employeeRepository.existsByEmailId(employeeDto.getEmailId())){
            throw new RuntimeException("Email already exists");
        }
        if(employeeRepository.existsByMobile(employeeDto.getMobile())){
            throw new RuntimeException("Mobile already exists");
        }
        Employee savedEmployee = employeeRepository.save(emp);
        BeanUtils.copyProperties(savedEmployee, employeeDto);
        return employeeDto;
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public EmployeeDto findEmployeeById(long id){
        Optional<Employee> opEmp = employeeRepository.findById(id);
        if(opEmp.isPresent()){
            Employee employee = opEmp.get();
            EmployeeDto dto = new EmployeeDto();
            BeanUtils.copyProperties(employee,dto);
            return dto;
        }else{
            //Throw Record Not Found Exception
            throw new RecordNotFoundException("No record found");
        }
    }

    @Override
    public void updateEmployee(long id, EmployeeDto employeeDto) {

    }

    @Override
    public List<EmployeeDto> getAllEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeDto> dtos = new ArrayList<>();
        for(Employee e:employees){
            EmployeeDto dto=new EmployeeDto();
            BeanUtils.copyProperties(e,dto);
            dtos.add(dto);
        }
        return dtos;
    }

    //Pagination And Sorting
    @Override
    public List<EmployeeDto> fetchAllEmployees(int pageNo, int pageSize, String sortBy){
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Employee> pageEmp = employeeRepository.findAll(pageable);
        List<Employee> employees = pageEmp.getContent();
        List<EmployeeDto> dtos = new ArrayList<>();
        for(Employee e:employees){
            EmployeeDto dto=new EmployeeDto();
            BeanUtils.copyProperties(e,dto);
            dtos.add(dto);
        }
        return dtos;
    }
}
