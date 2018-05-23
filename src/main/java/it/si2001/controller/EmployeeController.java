package it.si2001.controller;

import it.si2001.model.Employee;
import it.si2001.model.Skill;
import it.si2001.model.UserProfile;
import it.si2001.service.EmployeeService;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController
{

    final
    EmployeeService employeeService;

    final
    SkillService skillService;

    final
    UserProfileService userProfileService;

    final
    MessageSource messageSource;

    final
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    final
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    public EmployeeController(EmployeeService employeeService, SkillService skillService, MessageSource messageSource, PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices, AuthenticationTrustResolver authenticationTrustResolver, UserProfileService userProfileService)
    {

        this.employeeService = employeeService;
        this.skillService = skillService;
        this.messageSource = messageSource;
        this.persistentTokenBasedRememberMeServices = persistentTokenBasedRememberMeServices;
        this.authenticationTrustResolver = authenticationTrustResolver;
        this.userProfileService = userProfileService;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(ModelMap model)
    {
        List<Employee> employees=employeeService.findAllEmployees();
        model.addAttribute("employees",employees);
        model.addAttribute("loggedIN",getPrincipal());
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
    public String saveNewEmployee (ModelMap model)
    {
        
        return "registration";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable int id, ModelMap model)
    {
        employeeService.deleteEmployeeById(id);

        List<Employee> employees=employeeService.findAllEmployees();
        model.addAttribute("employees",employees);

        List<Notification> notifications=new ArrayList<Notification>();
        notifications.add(new Notification("alert-success","Utente eliminato con successo"));
        model.addAttribute("notifications",notifications);

        return "index";
    }

    /**
     * This method handles Access-Denied redirect.
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model)
    {
        model.addAttribute("loggedinuser", getPrincipal());
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

}
