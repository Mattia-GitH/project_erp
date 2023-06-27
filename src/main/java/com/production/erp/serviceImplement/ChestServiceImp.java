package com.production.erp.serviceImplement;

import com.production.erp.converter.ChestConverter;
import com.production.erp.entity.ChestEntity;
import com.production.erp.exception.ChestNotFoundException;
import com.production.erp.model.ChestModel;
import com.production.erp.repository.ChestRepository;
import com.production.erp.service.ChestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ChestServiceImp implements ChestService {
    private final ChestRepository repository;
    private final ChestConverter converter;

    public ChestServiceImp(ChestRepository repository, ChestConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public ChestModel createChest(ChestModel chestModel) {
        return converter.toModel(repository.save(converter.toEntity(chestModel)));
    }

    @Override
    public List<ChestModel> chestsList() {
        return converter.listToModels(repository.findAllByOrderByIdDesc());
    }

    @Override
    public ChestModel chestById(Long id) {
        Optional<ChestEntity> optional = repository.findById(id);
        if (optional.isPresent()){
            return converter.toModel(optional.get());
        } else {
            throw new ChestNotFoundException("Not found " + id);
        }
    }

    @Override
    public ChestModel updateChest(ChestModel chestModel, Long id) {
        Optional<ChestEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            ChestEntity update = optional.get();
            update.setImei(chestModel.getImei());
            update.setPhase(chestModel.getPhase());

            return converter.toModel(repository.save(update));
        } else {
            throw new ChestNotFoundException("Not found " + id);
        }
    }

    @Override
    public String delete(Long id) {
        Optional<ChestEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());

            return "Chest deleted: " + id;
        } else {
            throw new ChestNotFoundException("Not found " + id);
        }
    }

    @Override
    public Long findLastChestNumber() {
        Long number = repository.findLastChestNumber();
        if (number == null){
            number = 0L;
        }
        return number + 1L;
    }

    @Transactional
    @Override
    public void deleteChestNumber(Long number) {
        repository.deleteChestNumber(number);
    }

    @Override
    public List<ChestModel> findByNumber(Long number) {
        return converter.listToModels(repository.findByNumber(number));
    }

    @Override
    public ChestModel findFirstByIdOrderByIdDesc(Long id) {
        return converter.toModel(repository.findFirstByIdOrderByIdDesc(id));
    }
}
