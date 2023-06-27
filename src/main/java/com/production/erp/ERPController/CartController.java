package com.production.erp.ERPController;

import com.production.erp.model.*;
import com.production.erp.service.*;
import com.production.erp.view.CartView;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Controller
@PreAuthorize("hasRole('ROLE_SHOP')")
public class CartController {
    private final ArticleService articleService;
    private final SuppliersService suppliersService;
    private final CartService cartService;
    private final OrderService orderService;
    private final PayService payService;

    @Autowired
    public CartController(ArticleService articleService, SuppliersService suppliersService, CartService cartService, OrderService orderService, PayService payService) {
        this.articleService = articleService;
        this.suppliersService = suppliersService;
        this.cartService = cartService;
        this.orderService = orderService;
        this.payService = payService;
    }

    @RequestMapping("/create_article")
    public String addArticle(Model model) {
        ArticleModel article = new ArticleModel();
        model.addAttribute("article", article);

        return "ERP/article/newArticle";
    }

    @RequestMapping(value = "/save_article", method = RequestMethod.POST)
    public String saveArticle(@ModelAttribute("article") ArticleModel article, Model model) {
        articleService.createArticle(article);
        List<SuppliersModel> suppliers = suppliersService.listSuppliers();
        model.addAttribute("suppliers", suppliers);

        ArticleModel articleModel = articleService.findIdArticle(article.getModel(), article.getGb(), article.getGrade_sup());

        OrderModel order = new OrderModel();
        order.setId_article(articleModel.getId());
        model.addAttribute("order", order);

        return "ERP/article/newArticle";
    }

    @RequestMapping("/cart/{id_article}")
    public String cart(@ModelAttribute("cart") CartModel cartModel, @PathVariable(name = "id_article") Long id, Model model) {
        cartModel.setId_article(id);
        cartService.createCart(cartModel);
        List<CartModel> list = cartService.cartList();
        model.addAttribute("cartList", list);
        ArticleModel articleModel = articleService.articleById(cartModel.getId_article());
        model.addAttribute("article", articleModel);

        return "redirect:/cart_view";
    }

    @RequestMapping("/toCart/{id}")
    public String toCart(@PathVariable(name = "id") Long id, Model model) {
        List<SuppliersModel> suppliers = suppliersService.listSuppliers();
        model.addAttribute("suppliers", suppliers);

        OrderModel order = new OrderModel();
        order.setId_article(id);
        model.addAttribute("order", order);

        return "ERP/supplier/supplier";

    }

    @RequestMapping("/cart_view")
    public String cartView(Model model, @ModelAttribute("date") OrderModel date1) {
        List<CartView> cartViews = cartService.cartView();
        CartView listCart = new CartView(cartViews);
        model.addAttribute("cartList", listCart);

        model.addAttribute("date", date1);

        return "ERP/cart/cartView";
    }

    @RequestMapping("/to_order/{date}")
    public String toOrder(@ModelAttribute("cartList") CartView list, @PathVariable("date") String date, Model model) {
        Long lastOrderNumber = orderService.findLastOrderNumber();

        model.addAttribute("date", date);

        if (list.getCartList() != null) {
            for (int i = 0; i < list.getCartList().size(); i++) {
                int tooQty = list.getCartList().get(i).getQty();

                OrderModel orderModel = new OrderModel();
                orderModel.setId_article(list.getCartList().get(i).getId_article());
                orderModel.setId_supplier(list.getCartList().get(i).getId_supplier());
                orderModel.setPrice(list.getCartList().get(i).getPrice());
                orderModel.setIva(list.getCartList().get(i).getIva());
                orderModel.setDate(date);
                orderModel.setNumber_order(lastOrderNumber + 1);
                do {
                    tooQty = checkQtyAndCreateOrder(tooQty, orderModel, list, i);
                } while (tooQty > 0);
            }
        }
        cartService.truncate();
        model.addAttribute("numberOrder", lastOrderNumber + 1);

        PayModel payModel = new PayModel();
        payModel.setNumber_order(lastOrderNumber + 1);

        model.addAttribute("pay", payModel);

        return "ERP/order/newPay";
    }

    public int checkQtyAndCreateOrder(int qty, OrderModel orderModel, CartView list, int i) {
        if (qty > 201) {
            orderModel.setQty(200);
            orderModel.setInit_qty(200);

            qty = qty - 200;
        } else {
            orderModel.setQty(qty);
            orderModel.setInit_qty(qty);
            qty = 0;
        }
        orderService.createOrder(orderModel);

        return qty;
    }


    @RequestMapping("/save_pay")
    public String savePay(@ModelAttribute("pay") PayModel payModel) {
        payService.createPay(payModel);
        return "redirect:/purchased";
    }

    @RequestMapping("/cart/delete/{id}")
    public String removeFromCart(@PathVariable("id") Long id) {
        cartService.delete(id);
        return "redirect:/cart_view";
    }

    @RequestMapping("/cart_make_order/delete/{id}")
    public String removeFromCartMakeOrder(@PathVariable("id") Long id) {
        cartService.delete(id);
        return "redirect:/cart_view";
    }

    @RequestMapping("/make_order")
    public String makeOrder(Model model) {
        if (suppliersService.supplierIdInCart().isEmpty()) {
            List<SuppliersModel> suppliers = suppliersService.listSuppliers();
            model.addAttribute("suppliers", suppliers);
        } else {
            List<SuppliersModel> suppliers = suppliersService.supplierIdInCart();
            List<SuppliersModel> list = new ArrayList<>();
            list.add(suppliers.get(0));
            model.addAttribute("suppliers", list);
        }

        List<ArticleModel> articles = articleService.articlesList();
        model.addAttribute("articles", articles);

        List<CartView> cartViews = cartService.cartView();
        CartView listCart = new CartView(cartViews);
        model.addAttribute("cartList", listCart);

        OrderModel order = new OrderModel();
        model.addAttribute("order", order);

        return "ERP/supplier/makeOrder";
    }

    @RequestMapping("/cart")
    public String cartMake(@ModelAttribute("cart") CartModel cartModel, Model model) {
        cartService.createCart(cartModel);
        System.out.println(cartModel);
        List<CartModel> list = cartService.cartList();
        model.addAttribute("cartList", list);
        ArticleModel articleModel = articleService.articleById(cartModel.getId_article());
        model.addAttribute("article", articleModel);

        return "redirect:/make_order";
    }
}
