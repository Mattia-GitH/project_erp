package com.production.erp.ERPController;

import com.production.erp.model.SuppliersModel;
import com.production.erp.service.PhoneService;
import com.production.erp.service.SuppliersService;
import com.production.erp.view.ITCView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ITCController {
    private final PhoneService phoneService;
    private final SuppliersService suppliersService;

    @Autowired
    public ITCController(PhoneService phoneService, SuppliersService suppliersService) {
        this.phoneService = phoneService;
        this.suppliersService = suppliersService;
    }

    @RequestMapping("/ITC")
    public String itcView(Model model, @ModelAttribute("itcView")ITCView supplier){
        if (supplier.getSupplier() == "" || supplier.getSupplier() == null){
            List<ITCView> phones = phoneService.itcView();
            model.addAttribute("phones", phones);
        } else {
            List<ITCView> phones = phoneService.itcViewFilter(supplier.getSupplier());
            model.addAttribute("phones",phones);
        }

        ITCView itcView = new ITCView();
        model.addAttribute("itcView",itcView);

        List<SuppliersModel> suppliersList = suppliersService.supplierList();
        model.addAttribute("supList", suppliersList);

        return "ERP/ITC/itc";
    }

    @PreAuthorize("hasRole('ROLE_SHOP')")
    @RequestMapping("/test")
    public String test(Model model, @ModelAttribute("itcView")ITCView supplier){
        if (supplier.getSupplier() == "" || supplier.getSupplier() == null){
            List<ITCView> phones = phoneService.test();
            model.addAttribute("phones", phones);
        }else {
            List<ITCView> phones = phoneService.testFilter(supplier.getSupplier());
            model.addAttribute("phones",phones);
        }
        List<SuppliersModel> suppliers = suppliersService.listSuppliers();
        model.addAttribute("suppliers", suppliers);

        List<SuppliersModel> suppliersList = suppliersService.supplierList();
        model.addAttribute("supList", suppliersList);

        return "ERP/test/phones";
    }
}
