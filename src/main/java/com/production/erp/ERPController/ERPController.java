package com.production.erp.ERPController;

import com.production.erp.container.PhoneListContainer;
import com.production.erp.model.*;
import com.production.erp.service.*;
import com.production.erp.view.OrdersView;
import com.production.erp.view.Purchased;
import com.production.erp.view.PurchasedDetails;
import com.production.erp.view.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;
import java.util.List;

@Controller
public class ERPController {
    private final ArticleService articleService;
    private final SuppliersService suppliersService;
    private final OrderService orderService;
    private final PhoneService phoneService;
    private final FileService fileService;
    private final PayService payService;
    private final PhaseService phaseService;
    private final StatusService statusService;

    @Autowired
    public ERPController(ArticleService articleService, SuppliersService suppliersService, OrderService orderService, PhoneService phoneService, FileService fileService, PayService payService, PhaseService phaseService, StatusService statusService) {
        this.articleService = articleService;
        this.suppliersService = suppliersService;
        this.orderService = orderService;
        this.phoneService = phoneService;
        this.fileService = fileService;
        this.payService = payService;
        this.phaseService = phaseService;
        this.statusService = statusService;
    }

    @RequestMapping("/")
    public String index() {
        return "ERP/index";
    }

    @RequestMapping("/articles")
    public String articlesList(Model model) {
        List<ArticleModel> articlesList = articleService.articlesList();
        model.addAttribute("articleList", articlesList);

        return "ERP/article/articles";
    }

    @RequestMapping(value = "/save_order", method = RequestMethod.POST)
    public String saveArticle(@ModelAttribute("order") OrderModel orderModel) {
        orderService.createOrder(orderModel);

        return "redirect:/articles";
    }

    private void filter(Model model) {
        List<Long> orderNumber = phoneService.orderNumberData();
        List<String> sku = phoneService.skuData();
        List<String> phoneModel = phoneService.modelData();
        List<Long> gb = phoneService.gbData();
        List<String> color = phoneService.colorData();
        List<String> grade = phoneService.gradeData();
        List<String> supplier = phoneService.supplierData();
        List<String> tracking = orderService.trackingNumbers();
        model.addAttribute("tracking", tracking);
        model.addAttribute("orderNumber", orderNumber);
        model.addAttribute("sku", sku);
        model.addAttribute("phoneModel", phoneModel);
        model.addAttribute("gbPhone", gb);
        model.addAttribute("color", color);
        model.addAttribute("grade", grade);
        model.addAttribute("supplier", supplier);
    }

    @RequestMapping("/orders")
    public String ordersList(Model model, @ModelAttribute("filter") Warehouse filter) {
        System.out.println(filter.getGb());

        filter(model);
        if (filter.getModel() == "") {
            filter.setModel(null);
        }
        if (filter.getGrade() == "") {
            filter.setGrade(null);
        }
        if (filter.getSupplier() == "") {
            filter.setSupplier(null);
        }
        if (filter.getTracking() == "") {
            filter.setTracking(null);
        }

        Warehouse warehouse = new Warehouse();
        model.addAttribute("filter", warehouse);

        List<OrdersView> orders = orderService.ordersView(filter.getOrder_number(), filter.getModel(), filter.getGb(), filter.getGrade(), filter.getSupplier(), filter.getTracking());
        model.addAttribute("orders", orders);

        OrderModel orderModel = new OrderModel();
        model.addAttribute("order", orderModel);

        return "ERP/order/orders";
    }

    @RequestMapping("batchLabel/{supplier}/{order_number}/{status}/{phone}")
    public String batchLabel(Model model, @PathVariable("supplier") String supplier, @PathVariable("order_number") String order_number, @PathVariable("status") String status, @PathVariable("phone") String phone) {
        model.addAttribute("supplier", supplier);
        model.addAttribute("status", status);
        model.addAttribute("order_number", order_number);
        model.addAttribute("phone", phone);

        return "ERP/order/batchLabel";
    }

    @RequestMapping("/newQty")
    public String addQty(Model model, @Param("order_number") Long order_number, @Param("id_article") Long id_article, @Param("id_supplier") Long id_supplier, @Param("newQty") int newQty, @Param("date") String date) {
        OrderModel oldQtyOrder = orderService.findId(id_article, id_supplier, date, order_number);

        OrderModel orderModel = new OrderModel();
        orderModel.setNumber_order(order_number);
        orderModel.setInit_qty(newQty);
        orderModel.setQty(newQty);
        orderModel.setId_article(id_article);
        orderModel.setDate(oldQtyOrder.getDate());
        orderModel.setDate_purchase(oldQtyOrder.getDate_purchase());
        orderModel.setId_supplier(oldQtyOrder.getId_supplier());
        orderModel.setCourier(oldQtyOrder.getCourier());
        orderModel.setTracking(oldQtyOrder.getTracking());
        orderModel.setSup_order_number(oldQtyOrder.getSup_order_number());
        orderModel.setPrice(0);
        orderModel.setIva(0);
        orderService.createOrder(orderModel);

        ArticleModel articleModel = articleService.articleById(orderModel.getId_article());
        SuppliersModel suppliersModel = suppliersService.supplierByImei(orderModel.getId_supplier());

        List<PhoneModel> phones = new ArrayList<>();
        PhoneModel param = new PhoneModel();
        param.setId_article(Math.toIntExact(articleModel.getId()));
        param.setModel(articleModel.getModel());
        param.setGb(articleModel.getGb());

        System.out.println(newQty);

        for (int i = 0; i < oldQtyOrder.getQty() + newQty; i++) {
            phones.add(param);
        }

        PhoneListContainer phoneList = new PhoneListContainer();
        phoneList.setPhones(phones);

        orderModel.setInit_qty(oldQtyOrder.getQty() + newQty);
        orderModel.setQty(oldQtyOrder.getQty() + newQty);

        model.addAttribute("phones", phoneList);
        model.addAttribute("order", orderModel);
        model.addAttribute("article", articleModel);
        model.addAttribute("supplier", suppliersModel);

        String color = "";
        model.addAttribute("color", color);


        model.addAttribute("order", orderModel);

        return "ERP/phone/insertPhones";
    }

    @RequestMapping("/insert_imei")
    public String addImei(Model model, @ModelAttribute("order") OrderModel orderModel) {
        SuppliersModel suppliersModel = suppliersService.supplierByImei(orderModel.getId_supplier());
        ArticleModel articleModel = articleService.articleById(orderModel.getId_article());

        List<PhoneModel> phones = new ArrayList<>();
        PhoneModel param = new PhoneModel();
        param.setId_article(Math.toIntExact(articleModel.getId()));
        param.setModel(articleModel.getModel());
        param.setGb(articleModel.getGb());

        for (int i = 0; i < orderModel.getQty(); i++) {
            phones.add(param);
        }

        PhoneListContainer phoneList = new PhoneListContainer();
        phoneList.setPhones(phones);

        model.addAttribute("phones", phoneList);
        model.addAttribute("order", orderModel);
        model.addAttribute("article", articleModel);
        model.addAttribute("supplier", suppliersModel);

        String color = "";
        model.addAttribute("color", color);

        return "ERP/phone/insertPhones";
    }

    @RequestMapping(value = "/save_phones/{id_supplier}/{date}/{number_order}/{id}", method = RequestMethod.POST)
    public String savePhones(@ModelAttribute("phones") PhoneListContainer phoneList, @ModelAttribute("order") OrderModel orderModel, Model model, @PathVariable(name = "id_supplier") Long id_supplier, @PathVariable(name = "date") String date, @PathVariable(name = "number_order") Long number_order, @PathVariable(name = "id") Long id) throws ParseException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<PhoneModel> phones = phoneList.getPhones();
        int qty = 0;
        long id_article = 0L;
        List<PhoneModel> phoneExist = new ArrayList<>();

        for (PhoneModel phoneModel : phones) {
            if (phoneModel.getImei() != null) {
                if (phoneService.phoneAlreadyExist(phoneModel)) {
                    phoneExist.add(phoneModel);
                } else {
                    qty++;
                    phoneModel.setId_supplier(id_supplier);
                    phoneModel.setColor(phoneList.getColor());
                    ArticleModel grade = articleService.articleById((long) phoneModel.getId_article());
                    phoneModel.setOrder_number(number_order);
                    phoneModel.setSku(phoneModel.getModel().substring(7).replaceAll(" ", "").toUpperCase() + phoneModel.getGb() + phoneModel.getColor().replaceAll(" ", "").toUpperCase() + grade.getGrade_sup());
                    phoneService.createPhone(phoneModel);
                    id_article = phoneModel.getId_article();

                    StatusModel status = new StatusModel();
                    status.setImei(phoneModel.getImei());
                    status.setDate(new Date());
                    status.setActual_status("ENTRY");
                    status.setSend_to("ITC");
                    status.setOperator(authentication.getName());
                    status.setTimer(LocalTime.MIN);
                    statusService.createStatus(status);
                }
            }
        }
        orderService.updateQty(qty, id_article, id_supplier, date, number_order, id);
        if (phoneExist.isEmpty()) {
            Warehouse filter = new Warehouse();
            filter.setOrder_number(number_order);
            filter.setModel(phoneList.getPhones().get(0).getModel());
            filter.setGb(phoneList.getPhones().get(0).getGb());

            Warehouse warehouse = new Warehouse();
            model.addAttribute("filter", warehouse);

            List<OrdersView> orders = orderService.ordersView(filter.getOrder_number(), filter.getModel(), filter.getGb(), filter.getGrade(), filter.getSupplier(), filter.getTracking());
            model.addAttribute("orders", orders);

            OrderModel order = new OrderModel();
            model.addAttribute("order", order);
            return "ERP/order/orders";
        } else {
            PhoneListContainer phonesExist = new PhoneListContainer();
            phonesExist.setPhones(phoneExist);
            model.addAttribute("phones", phonesExist);
            return "ERP/phone/phoneAlredyExixst";
        }
    }

    @RequestMapping(value = "delete/article/{article_id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable Long article_id) {
        articleService.delete(article_id);
        return "redirect:/articles";
    }

    @RequestMapping(value = "/purchased")
    public String purchasedPost(Model model, @ModelAttribute("dataF") Purchased dataF, @RequestParam(value = "paid", required = false) boolean paid, @RequestParam(value = "order_number", required = false) Long order_number, @RequestParam(value = "order_number_filter", required = false) Long order_number_filter, @RequestParam(value = "order_numberCourrier", required = false) Long order_numberCourrier, @RequestParam(value = "courier", required = false) String courier, @RequestParam(value = "order_numberTracking", required = false) Long order_numberTracking, @RequestParam(value = "tracking", required = false) String tracking) throws ParseException {

        if (order_number != null) {
            PayModel payModel = payService.findByNumber_order(order_number);
            payModel.setPaid(paid);
            payService.updatePay(payModel, order_number);
            return "redirect:/purchased";
        }
        if (order_numberCourrier != null) {
            orderService.updateCourier(order_numberCourrier, courier);
            return "redirect:/purchased";
        }

        if (order_numberTracking != null) {
            orderService.updateTracking(order_numberTracking, tracking);
            return "redirect:/purchased";
        }

        List<Purchased> dataFilter = orderService.dataFilter();
        List<SuppliersModel> supplier = suppliersService.listSuppliers();
        model.addAttribute("dataFilter", dataFilter);

        if (dataF.getSupplier() == "") {
            dataF.setSupplier(null);
        }

        Date date;
        if (dataF.getDate() != null && dataF.getDate() != "") {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.parse(dataF.getDate());
        } else {
            date = null;
        }

        List<Purchased> purchasedList = orderService.filter(order_number_filter, date, dataF.getSupplier());
        model.addAttribute("purchasedList", purchasedList);
        model.addAttribute("supplier", supplier);
        return "ERP/order/purchased";
    }

    @RequestMapping(value = "/purchased-details/{number_order}")
    public String purchasedDetails(Model model, @PathVariable("number_order") Long number_order, @RequestParam(value = "paid", required = false) boolean paid, @RequestParam(value = "order_number", required = false) Long order_number) throws ParseException {
        if (order_number != null) {
            PayModel payModel = payService.findByNumber_order(order_number);
            payModel.setPaid(paid);
            payService.updatePay(payModel, order_number);
            return "redirect:/purchased-details/" + order_number;
        }

        List<PurchasedDetails> purchasedDetailsList = orderService.purchasedDetails(number_order);
        model.addAttribute("purchasedDetailsList", purchasedDetailsList);

        PayModel pay = payService.findByNumber_order(number_order);
        model.addAttribute("pay", pay);

        List<FileModel> files = fileService.fileByOrderNumber(number_order);
        model.addAttribute("files", files);

        return "ERP/order/purchasedDetails";
    }

    @RequestMapping(value = "/number_order_supplier/{number_order}")
    public String numberOrderSupplier(@PathVariable("number_order") Long number_order, @RequestParam("sup_order_number") String sup_order_number) {
        orderService.updateSupOrderNumber(number_order, sup_order_number);

        return "redirect:/purchased-details/" + number_order;
    }


    @RequestMapping("/create_supplier")
    public String createSupplier(Model model) {
        SuppliersModel supplier = new SuppliersModel();
        model.addAttribute("supplier", supplier);

        List<SuppliersModel> suppliers = suppliersService.listSuppliers();
        model.addAttribute("suppliers", suppliers);

        return "ERP/supplier/createSupplier";
    }

    @RequestMapping(value = "/save_supplier", method = RequestMethod.POST)
    public String saveSupplier(@ModelAttribute("supplier") SuppliersModel supplier) {
        suppliersService.createSupplier(supplier);

        return "redirect:/create_supplier";
    }

    @RequestMapping(value = "/warehouse")
    public String warehouse(Model model, @ModelAttribute("filter") Warehouse filter, @RequestParam(value = "sImei", defaultValue = "") String sImei) {

        if (!sImei.equals("")) {
            String[] arrayImei = sImei.split(",");
            Long imei = Long.valueOf(arrayImei[0]);
            filter.setImei(imei);
        }

        filter(model);
        if (filter.getSku() == "") {
            filter.setSku(null);
        }
        if (filter.getModel() == "") {
            filter.setModel(null);
        }
        if (filter.getColor() == "") {
            filter.setColor(null);
        }
        if (filter.getGrade() == "") {
            filter.setGrade(null);
        }
        if (filter.getSupplier() == "") {
            filter.setSupplier(null);
        }
        if (filter.getActual_status() == "") {
            filter.setActual_status(null);
        }

        Warehouse warehouse = new Warehouse();
        model.addAttribute("filter", warehouse);

        List<Warehouse> warehouses = phoneService.warehouseViewFiltered(filter.getOrder_number(), filter.getSku(), filter.getModel(), filter.getColor(), filter.getGrade(), filter.getSupplier(), filter.getGb(), filter.getActual_status(), filter.getImei());
        model.addAttribute("warehouses", warehouses);
        model.addAttribute("phases", phaseService.phases());

        return "ERP/warehouse/warehouseIMEI";
    }

    @RequestMapping(value = "/warehouseSku")
    public String warehouseSku(Model model, @ModelAttribute("filter") Warehouse filter) {
        filter(model);
        if (filter.getSku() == "") {
            filter.setSku(null);
        }
        if (filter.getModel() == "") {
            filter.setModel(null);
        }
        if (filter.getColor() == "") {
            filter.setColor(null);
        }
        Warehouse warehouse = new Warehouse();
        model.addAttribute("filter", warehouse);

        List<Warehouse> warehouses = phoneService.warehouseViewSkuFiltered(filter.getSku(), filter.getModel(), filter.getGb(), filter.getColor());
        model.addAttribute("warehouses", warehouses);
        return "ERP/warehouse/warehouseSKU";
    }

    @RequestMapping(value = "/warehouseSku/{sku}")
    public String warehouseSkuFind(Model model, @PathVariable("sku") String sku, @ModelAttribute("filter") Warehouse filter) {
        filter(model);
        if (filter.getModel() == "") {
            filter.setModel(null);
        }
        if (filter.getGrade() == "") {
            filter.setGrade(null);
        }
        if (filter.getSupplier() == "") {
            filter.setSupplier(null);
        }
        if (filter.getActual_status() == "") {
            filter.setActual_status(null);
        }

        model.addAttribute("sku", sku);
        List<Warehouse> warehouses = phoneService.warehouseViewFindSKUFiltered(sku, filter.getOrder_number(), filter.getModel(), filter.getGb(), filter.getGrade(), filter.getSupplier(), filter.getActual_status(), filter.getImei());
        model.addAttribute("warehouses", warehouses);
        model.addAttribute("phases", phaseService.phases());
        return "ERP/warehouse/warehouseSKUFind";
    }
}