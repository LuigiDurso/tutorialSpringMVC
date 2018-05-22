package it.si2001.controller;

import it.si2001.model.Employee;
import it.si2001.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EmployeeController
{

    final
    EmployeeService employeeService;

    final
    MessageSource messageSource;

    public EmployeeController(EmployeeService employeeService, MessageSource messageSource)
    {
        this.employeeService = employeeService;
        this.messageSource = messageSource;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(ModelMap model)
    {
        List<Employee> employees=employeeService.findAllEmployees();
        model.addAttribute("employees",employees);
        return "index";
    }

}
