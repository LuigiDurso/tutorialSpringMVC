package it.si2001.service;

import it.si2001.model.UserProfile;

import java.util.List;

public interface UserProfileService
{

    UserProfile findById(int id);

    UserProfile findByType(String type);

    List<UserProfile> findAll();

}
