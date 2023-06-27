package com.production.erp.serviceImplement;

import com.production.erp.converter.UserConverter;
import com.production.erp.entity.UserEntity;
import com.production.erp.model.UserModel;
import com.production.erp.repository.UserRepository;
import com.production.erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository repository;
    private final UserConverter converter;
    private final PasswordEncoder encoder;

    @Autowired
    public UserServiceImp(UserRepository repository, UserConverter converter, PasswordEncoder encoder) {
        this.repository = repository;
        this.converter = converter;
        this.encoder = encoder;
    }

    @Override
    public UserModel createUser(UserModel userModel) {
        userModel.setPassword(encoder.encode(userModel.getPassword()));
        return converter.toModel(repository.save(converter.toEntity(userModel)));
    }

    @Override
    public List<UserModel> listUsers() {
        return converter.listToModels(repository.findAll());
    }

    @Override
    public UserModel userByUsername(String username) {
        return converter.toModel(repository.findByUsername(username).map(UserEntity::new).orElseThrow(() -> new UsernameNotFoundException("Username not found" + username)));
    }

    @Override
    public UserModel updateUser(UserModel userModel, String username) {
        userModel.setPassword(encoder.encode(userModel.getPassword()));
        return converter.toModel(repository.findByUsername(username).map(u -> repository.save(converter.toEntity(userModel))).orElseThrow(() -> new UsernameNotFoundException("Username not found" + username)));
    }

    @Override
    public String delete(String username) {
        Optional<UserEntity> userEntityOptional = repository.findByUsername(username);
        if (userEntityOptional.isPresent()) {
            repository.delete(userEntityOptional.get());
            return "User deleted " + userEntityOptional.get();
        } else {
            throw new UsernameNotFoundException("User not found id: " + username);
        }
    }
}
