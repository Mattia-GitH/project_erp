package com.production.erp.service;

import com.production.erp.model.CartModel;
import com.production.erp.view.CartView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    CartModel createCart(CartModel cartModel);

    List<CartModel> cartList();

    CartModel cartById(Long id);

    CartModel updateCart(CartModel cartModel, Long id);

    String delete(Long id);

    List<CartView> cartView();

    void truncate();
}
