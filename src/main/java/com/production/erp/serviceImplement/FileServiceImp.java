package com.production.erp.serviceImplement;

import com.production.erp.converter.FileConverter;
import com.production.erp.entity.FileEntity;
import com.production.erp.model.FileModel;
import com.production.erp.repository.FileRepository;
import com.production.erp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileServiceImp implements FileService {
    private final FileRepository repository;
    private final FileConverter converter;

    @Autowired
    public FileServiceImp(FileRepository repository, FileConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public FileModel uploadFile(FileModel fileModel) {
        FileEntity toSave = repository.save(converter.toEntity(fileModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<FileModel> listFiles() {
        List<FileEntity> fileEntities = repository.findAll();
        return  converter.listToModels(fileEntities);
    }

    @Override
    public FileModel fileById(Long id) {
        Optional<FileEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return converter.toModel(optional.get());
        } else {
            return new FileModel(null, null, null, null, null, null);
        }
    }

    @Override
    public List<FileModel> fileByOrderNumber(Long order_number) {
        return converter.listToModels(repository.findByOrder_number(order_number));
    }

    @Override
    public FileModel updateFile(FileModel fileModel, Long id) {
        Optional<FileEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            FileEntity update = optional.get();
            update.setOrder_number(fileModel.getOrder_number());
            update.setName(fileModel.getName());
            update.setType(fileModel.getType());
            update.setData(fileModel.getData());
            update.setFormat(fileModel.getFormat());
            return converter.toModel(update);
        } else {
            return new FileModel(null, null, null, null, null, null);
        }
    }

    @Override
    public String delete(long id) {
        Optional<FileEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return "deleted " + optional.get();
        } else {
            return "not deleted " + id;
        }
    }
}
