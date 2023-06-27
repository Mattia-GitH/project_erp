package com.production.erp.ERPController;

import com.production.erp.model.ShippingModel;
import com.production.erp.model.StatusModel;
import com.production.erp.service.*;
import com.production.erp.view.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Controller
@PreAuthorize("hasRole('ROLE_LINE')")
public class OutputController {
    private final PhoneService phoneService;
    private final OrderService orderService;
    private final PhaseService phaseService;
    private final ShippingService shippingService;
    private final StatusService statusService;

    @Autowired
    public OutputController(PhoneService phoneService, OrderService orderService, PhaseService phaseService, ShippingService shippingService, StatusService statusService) {
        this.phoneService = phoneService;
        this.orderService = orderService;
        this.phaseService = phaseService;
        this.shippingService = shippingService;
        this.statusService = statusService;
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

    @RequestMapping(value = "/output")
    public String output(Model model, @ModelAttribute("filter") Warehouse filter) {
        filter(model);
        if (Objects.equals(filter.getSku(), "")) {
            filter.setSku(null);
        }
        if (Objects.equals(filter.getModel(), "")) {
            filter.setModel(null);
        }
        if (Objects.equals(filter.getColor(), "")) {
            filter.setColor(null);
        }

        Warehouse warehouse = new Warehouse();
        model.addAttribute("filter", warehouse);

        List<Warehouse> warehouses = phoneService.outputHomeView(filter.getSku(), filter.getModel(), filter.getGb(), filter.getColor());
        model.addAttribute("warehouses", warehouses);
        return "ERP/warehouse/outputHome";
    }

    @RequestMapping(value = "/outputImeiSku/{sku}")
    public String outputImeiSku(Model model, @ModelAttribute("filter") Warehouse filter, @PathVariable(value = "sku", required = false) String sku, @RequestParam(value = "imei", required = false) Long imei) {
        if (imei != null) {
            sku = phoneService.phoneByImei(imei).getSku();
            filter.setImei(imei);
        }

        filter(model);
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
        List<Warehouse> warehouses = phoneService.outputSkuView(sku, filter.getOrder_number(), filter.getSupplier(), filter.getImei());
        model.addAttribute("warehouses", warehouses);
        model.addAttribute("phases", phaseService.phases());

        return "ERP/warehouse/outputImeiSku";
    }

    @RequestMapping(value = "/shipping")
    public String shipping(Model model, @RequestParam("imei") Long imei, @RequestParam("tracking") String tracking, @RequestParam("order_id") Long order_id, @RequestParam("market") String market, @RequestParam("courier") String courier, @RequestParam("price") double price) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        ShippingModel shipping = new ShippingModel();

        java.util.Date utilDate = new java.util.Date();
        shipping.setDate(new Date(utilDate.getTime()));
        shipping.setOrder_number(order_id);
        shipping.setTracking(tracking);
        shipping.setCourier(courier);
        shipping.setImei(imei);
        shipping.setMarket(market);
        shipping.setOperator(authentication.getName());
        shipping.setPrice(price);

        shippingService.createShipping(shipping);

        StatusModel status = new StatusModel();
        status.setImei(imei);
        status.setDate(utilDate);
        status.setActual_status("STOCK");
        status.setSend_to("SENT");
        status.setOperator(authentication.getName());

        statusService.createStatus(status);

        model.addAttribute("imei", imei);
        model.addAttribute("filter", new Warehouse());

        return "redirect:/output";
    }
}
