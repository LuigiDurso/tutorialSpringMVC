package it.si2001.converter;

import it.si2001.model.MaritalStatus;
import it.si2001.service.MaritalStatusService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MaritalStatusConverter implements Converter<Object,MaritalStatus>
{
    final
    MaritalStatusService maritalStatusService;

    public MaritalStatusConverter(MaritalStatusService maritalStatusService)
    {
        this.maritalStatusService = maritalStatusService;
    }

    public MaritalStatus convert(Object o)
    {
        return maritalStatusService.findById(Integer.parseInt((String) o));
    }
}
