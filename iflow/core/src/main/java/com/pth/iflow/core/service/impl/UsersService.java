package com.pth.iflow.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pth.iflow.core.model.User;
import com.pth.iflow.core.service.IUsersService;
import com.pth.iflow.core.storage.dao.IUserDao;

@Service
public class UsersService implements IUsersService {
  
  private final IUserDao userDao;
  
  UsersService(@Autowired final IUserDao userDao) {
    this.userDao = userDao;
  }
  
  @Override
  public User getUserById(final Long id) {
    
    return userDao.getById(id);
  }
  
  @Override
  public User getUserByEmail(final String email) {
    
    return userDao.getByEmail(email);
  }
  
}
