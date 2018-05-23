package it.si2001.dao;

import it.si2001.model.UserProfile;

import java.util.List;


public interface UserProfileDao
{

    List<UserProfile> findAll();

    UserProfile findByType(String type);

    UserProfile findById(int id);
}