package com.production.erp.service;

import com.production.erp.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserModel createUser(UserModel userModel);

    List<UserModel> listUsers();

    UserModel userByUsername(String username);

    UserModel updateUser(UserModel userModel, String username);

    String delete (String username);
}
