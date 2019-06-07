package com.pth.iflow.core.service;

import com.pth.iflow.core.model.User;

public interface IUsersService {
  
  User getUserById(final Long id);
  
  User getUserByEmail(final String email);
}
