package com.production.erp.converter;

import com.production.erp.entity.UserEntity;
import com.production.erp.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public UserModel toModel(UserEntity entity){
        return new UserModel(entity.getUsername(), entity.getPassword(), entity.getRoles());
    }

    public UserEntity toEntity(UserModel model){
        return new UserEntity(model.getUsername(), model.getPassword(), model.getRoles());
    }

    public List<UserModel> listToModels(List<UserEntity> entityList) {
        return entityList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<UserEntity> listToEntities(List<UserModel> entityList) {
        return entityList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
