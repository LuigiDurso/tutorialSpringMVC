package it.si2001.converter;

import it.si2001.model.Skill;
import it.si2001.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class SkillConverter implements Converter<Object, Skill>
{

    final
    SkillService skillService;

    @Autowired
    public SkillConverter(SkillService skillService)
    {
        this.skillService = skillService;
    }

    /**
     * Gets Skill by Id
     *
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Skill convert(Object element)
    {
        return skillService.findById(Integer.parseInt((String)element));
    }
}
