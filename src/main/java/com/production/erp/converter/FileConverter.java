package com.production.erp.converter;

import com.production.erp.entity.FileEntity;
import com.production.erp.model.FileModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FileConverter {
    public FileModel toModel(FileEntity entity){
        FileModel model = new FileModel();
        model.setId(entity.getId());
        model.setOrder_number(entity.getOrder_number());
        model.setName(entity.getName());
        model.setType(entity.getType());
        model.setData(entity.getData());
        model.setFormat(entity.getFormat());
        return model;
    }

    public FileEntity toEntity(FileModel model){
        FileEntity entity = new FileEntity();
        entity.setId(model.getId());
        entity.setOrder_number(model.getOrder_number());
        entity.setName(model.getName());
        entity.setType(model.getType());
        entity.setData(model.getData());
        entity.setFormat(model.getFormat());
        return entity;
    }

    public List<FileModel> listToModels(List<FileEntity> fileEntities) {
        return fileEntities.stream().map(this::toModel).collect(Collectors.toList());
    }

    public List<FileEntity> listToEntities(List<FileModel> fileModels) {
        return fileModels.stream().map(this::toEntity).collect(Collectors.toList());
    }
}