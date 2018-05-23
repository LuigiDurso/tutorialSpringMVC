package it.si2001.service;

import it.si2001.dao.UserProfileDao;
import it.si2001.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService
{

    final
    UserProfileDao dao;

    @Autowired
    public UserProfileServiceImpl(UserProfileDao dao)
    {
        this.dao = dao;
    }

    public UserProfile findById(int id)
    {
        return dao.findById(id);
    }

    public UserProfile findByType(String type)
    {
        return dao.findByType(type);
    }

    public List<UserProfile> findAll()
    {
        return dao.findAll();
    }
}