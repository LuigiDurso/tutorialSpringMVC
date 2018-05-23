package it.si2001.converter;

import it.si2001.model.UserProfile;
import it.si2001.service.UserProfileService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<Object,UserProfile>
{
    final
    UserProfileService userProfileService;

    public RoleConverter(UserProfileService userProfileService)
    {
        this.userProfileService = userProfileService;
    }

    public UserProfile convert(Object element)
    {
        return userProfileService.findByType((String) element);
    }
}
