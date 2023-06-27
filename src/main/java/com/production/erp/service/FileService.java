package com.production.erp.service;

import com.production.erp.model.FileModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FileService {
    FileModel uploadFile(FileModel fileModel);

    List<FileModel> listFiles();

    FileModel fileById(Long id);

    List<FileModel> fileByOrderNumber(Long order_number);

    FileModel updateFile(FileModel fileModel, Long id);

    String delete (long id);
}
