package it.si2001.security;

import java.util.ArrayList;
import java.util.List;

import it.si2001.model.Employee;
import it.si2001.model.UserProfile;
import it.si2001.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService
{

    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    private final EmployeeService userService;

    @Autowired
    public CustomUserDetailsService(EmployeeService userService)
    {
        this.userService = userService;
    }

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException
    {
        Employee user = userService.findByUsername(id);
        logger.info("User : {}", user);
        if(user==null)
        {
            logger.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                        true, true, true, true,
                                                                                    getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(Employee user)
    {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(UserProfile userProfile : user.getUserProfiles())
        {
            logger.info("UserProfile : {}", userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        logger.info("authorities : {}", authorities);
        return authorities;
    }

}
