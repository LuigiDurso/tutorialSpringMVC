package it.si2001.controller;

import it.si2001.model.Employee;
import it.si2001.model.MaritalStatus;
import it.si2001.model.Skill;
import it.si2001.model.UserProfile;
import it.si2001.service.EmployeeService;
import it.si2001.service.MaritalStatusService;
import it.si2001.service.SkillService;
import it.si2001.service.UserProfileService;
import it.si2001.utils.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class EmployeeController
{

    final
    EmployeeService employeeService;

    final
    SkillService skillService;

    final
    MaritalStatusService maritalStatusService;

    final
    UserProfileService userProfileService;

    final
    MessageSource messageSource;

    final
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    final
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    public EmployeeController(EmployeeService employeeService, SkillService skillService, MaritalStatusService maritalStatusService, MessageSource messageSource, PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices, AuthenticationTrustResolver authenticationTrustResolver, UserProfileService userProfileService)
    {

        this.employeeService = employeeService;
        this.skillService = skillService;
        this.maritalStatusService = maritalStatusService;
        this.messageSource = messageSource;
        this.persistentTokenBasedRememberMeServices = persistentTokenBasedRememberMeServices;
        this.authenticationTrustResolver = authenticationTrustResolver;
        this.userProfileService = userProfileService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(ModelMap model)
    {
        return "index";
    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public String newEmployee (ModelMap model)
    {
        Employee e=new Employee();
        model.addAttribute("employee",e);

        model.addAttribute("edit",false);

        return "registration";
    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.POST)
    public String saveNewEmployee (@Valid Employee employee, BindingResult result, ModelMap model)
    {
        List<Notification> notifications=new ArrayList<Notification>();

        if (result.hasErrors())
        {
            notifications.add(new Notification("alert-danger","Utente non inserito!"));
            model.addAttribute("notifications",notifications);
            return "registration";
        }

        if(!employeeService.isUsernameUnique(employee.getId(), employee.getUsername()))
        {
            FieldError ssoError =new FieldError("employee","username",
                    messageSource.getMessage("non.unique.username", new String[]{employee.getUsername()}, Locale.getDefault()));
            result.addError(ssoError);
            return "registration";
        }

        employeeService.saveEmployee(employee);

        notifications.add(new Notification("alert-success","Utente inserito!"));
        model.addAttribute("notifications",notifications);
        return "registration";
    }

    @RequestMapping(value = "/edit/{username}", method =  RequestMethod.GET)
    public String editUser(@PathVariable String username, ModelMap model)
    {
        Employee e=employeeService.findByUsername(username);
        model.addAttribute("employee",e);
        return "registration";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable int id, ModelMap model)
    {
        List<Notification> notifications=new ArrayList<Notification>();

        Employee e=employeeService.findById(id);
        if (e==null)
        {
            notifications.add(new Notification("alert-danger","Utente non trovato"));
            model.addAttribute("notifications",notifications);
            return "index";
        }
        employeeService.deleteEmployeeById(id);

        notifications.add(new Notification("alert-success","Utente eliminato con successo"));
        model.addAttribute("notifications",notifications);
        model.addAttribute("employees",getEmployees());
        return "index";
    }

    /**
     * This method handles Access-Denied redirect.
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model)
    {
        return "accessDenied";
    }

    /**
     * This method handles login GET requests.
     * If users is already logged-in and tries to goto login page again, will be redirected to list page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage()
    {
        if (isCurrentAuthenticationAnonymous())
        {
            return "login";
        } else {
            return "redirect:/";
        }
    }

    /**
     * This method handles logout requests.
     * Toggle the handlers if you are RememberMe functionality is useless in your app.
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
        {
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }


    private String getPrincipal()
    {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
        {
            userName = ((UserDetails)principal).getUsername();
        }
        else {

            userName = principal.toString();
        }
        return userName;
    }


    private boolean isCurrentAuthenticationAnonymous()
    {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

    /**
     * This method will provide UserProfile list to views
     */
    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles()
    {
        return userProfileService.findAll();
    }

    @ModelAttribute("skills")
    public List<Skill> initializeSkills()
    {
        return skillService.findAllSkills();
    }

    @ModelAttribute("maritalStatues")
    public List<MaritalStatus> initializeMaritalStatus()
    {
        return maritalStatusService.findAllStatus();
    }

    @ModelAttribute("loggedIN")
    public String getLoggedIN()
    {
        if (isCurrentAuthenticationAnonymous())
        {
            return null;
        }
        return getPrincipal();
    }

    @ModelAttribute("employees")
    public List<Employee> getEmployees()
    {
        return employeeService.findAllEmployees();
    }

}
