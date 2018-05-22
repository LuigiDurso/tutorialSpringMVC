package it.si2001.service;

import it.si2001.model.MaritalStatus;

import java.util.List;

public interface MaritalStatusService
{
    MaritalStatus findById(int id);

    MaritalStatus findByName(String name);

    List<MaritalStatus> findAllStatus();
}
