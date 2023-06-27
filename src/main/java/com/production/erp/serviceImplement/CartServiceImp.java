package com.production.erp.serviceImplement;

import com.production.erp.converter.CartConverter;
import com.production.erp.entity.CartEntity;
import com.production.erp.exception.CartNotFoundException;
import com.production.erp.model.CartModel;
import com.production.erp.view.CartView;
import com.production.erp.repository.CartRepository;
import com.production.erp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImp implements CartService {
    private final CartRepository repository;
    private final CartConverter converter;

    @Autowired
    public CartServiceImp(CartRepository repository, CartConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public CartModel createCart(CartModel cartModel) {
        CartEntity toSave = repository.save(converter.toEntity(cartModel));
        return converter.toModel(toSave);
    }

    @Override
    public List<CartModel> cartList() {
        List<CartEntity> cartEntities = repository.findAll();
        return converter.listToModels(cartEntities);
    }

    @Override
    public CartModel cartById(Long id) {
        Optional<CartEntity> optional = repository.findById(id);
        if (optional.isPresent()){
            return converter.toModel(optional.get());
        } else {
            throw new CartNotFoundException("Cart not found " + id);
        }
    }

    @Override
    public CartModel updateCart(CartModel cartModel, Long id) {
        Optional<CartEntity> optional = repository.findById(id);
        if (optional.isPresent()){
            CartEntity update = new CartEntity();
            update.setId(cartModel.getId());
            update.setId_supplier(cartModel.getId_supplier());
            update.setId_article(cartModel.getId_article());
            update.setQty(cartModel.getQty());
            update.setPrice(cartModel.getPrice());
            update.setIva(cartModel.getIva());
            repository.save(update);
            return converter.toModel(update);
        } else {
            throw new CartNotFoundException("Cart not found " + cartModel);
        }
    }

    @Override
    public String delete(Long id) {
        Optional<CartEntity> optional = repository.findById(id);
        if (optional.isPresent()){
            repository.delete(optional.get());
            return "Deleted " + optional.get();
        } else {
            throw new CartNotFoundException("Cart not found " + id);
        }
    }

    @Override
    public List<CartView> cartView() {
        return repository.cartView();
    }

    @Transactional
    @Override
    public void truncate() {
        repository.truncate();
    }
}
