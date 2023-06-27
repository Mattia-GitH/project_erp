package com.production.erp.ERPController;

import com.production.erp.model.ReparationModel;
import com.production.erp.model.ReportModel;
import com.production.erp.model.StatusModel;
import com.production.erp.model.TestingModel;
import com.production.erp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
import java.util.Objects;

@RestController
public class RESTController {
    private final ReportService reportService;
    private final StatusService statusService;
    private final OrderService orderService;
    private final PhoneService phoneService;
    private final TestingService testingService;

    @Autowired
    public RESTController(ReportService reportService, StatusService statusService, OrderService orderService, PhoneService phoneService, TestingService testingService) {
        this.reportService = reportService;
        this.statusService = statusService;
        this.orderService = orderService;
        this.phoneService = phoneService;
        this.testingService = testingService;
    }

    @RequestMapping("/reportFixing/{imei}/{tl}")
    public void reportFixing(@PathVariable("tl")String tl, @PathVariable("imei")Long imei){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        StatusModel statusModel = statusService.findTop2ByImeiOrderByDateDesc(imei).get(1);

        if (reportService.alreadyReported(tl, statusModel.getOperator(), authentication.getName(), imei) == null){
            reportService.createReport(new ReportModel(new Date(), authentication.getName(), tl, statusModel.getOperator(), imei, statusModel.getActual_status()));
        }
    }

    @RequestMapping("/interrupt_rep/{status}/{imei}")
    public void interruptReparation(@PathVariable("status")String status, Model model, @PathVariable("imei")Long imei, @RequestParam("code")String code){
        if (Objects.equals(code, "UGCwdFJW")){
            statusService.deleteById(statusService.findByImeiOrderByDateDesc(imei).getId());
        }
    }

    @RequestMapping("/new_order_date/{orderNumber}")
    public void changeOrderDate(@PathVariable("orderNumber")Long orderNumber, @RequestParam("date")String date) throws ParseException {
        orderService.updateDate(orderNumber, date);
    }

    @RequestMapping("/createComment/{imei}/{issue}")
    public void createComment(@PathVariable("imei") Long imei, @PathVariable("issue") String issue, @RequestParam( value = "comments", required = false)String comment){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println(authentication.getName() + " " + imei  + " " + issue  + " " + comment);
    }

    @RequestMapping("/checkTest/{imei}")
    public String checkTest(@PathVariable("imei")Long imei){
        if (phoneService.isPresent(imei)){
            String issues = "";
            TestingModel test = testingService.lastTest(imei);

            if (test.isTL0()) issues = issues + "TL0,";
            if (test.isTL1()) issues = issues + "TL1,";
            if (test.isTL2()) issues = issues + "TL2,";
            if (test.isTL2T()) issues = issues + "TL2T,";
            if (test.isTL4()) issues = issues + "TL4,";
            if (test.isTL5()) issues = issues + "TL5,";
            if (test.isTL5A()) issues = issues + "TL5A,";
            if (test.isTL5B()) issues = issues + "TL5B,";
            if (test.isTL8P()) issues = issues + "TL8P,";
            if (test.isTL8()) issues = issues + "TL8,";
            if (test.isTL9()) issues = issues + "TL9,";
            if (test.isTL9T()) issues = issues + "TL9T,";
            if (test.isTL10()) issues = issues + "TL10,";
            if (test.isTL10G()) issues = issues + "TL10G,";
            if (test.isTL10T()) issues = issues + "TL10T,";
            if (test.isTL11()) issues = issues + "TL11,";
            if (test.isTL11G()) issues = issues + "TL11G,";
            if (test.isTL12()) issues = issues + "TL12,";
            if (test.isTL13()) issues = issues + "TL13,";
            if (test.isTL14()) issues = issues + "TL14,";
            if (test.isTL14P()) issues = issues + "TL14P,";
            if (test.isTL14A()) issues = issues + "TL14A,";
            if (test.isTL14B()) issues = issues + "TL14B,";
            if (test.isTL14T()) issues = issues + "TL14T,";
            if (test.isTL15()) issues = issues + "TL15,";
            if (test.isTL16()) issues = issues + "TL16,";
            if (test.isTL17()) issues = issues + "TL17,";
            if (test.isTL18()) issues = issues + "TL18,";
            if (test.isTL19()) issues = issues + "TL19,";
            if (test.isTL19A()) issues = issues + "TL19A,";
            if (test.isTL21()) issues = issues + "TL21,";
            if (test.isTL22()) issues = issues + "TL22,";
            if (test.isTL22T()) issues = issues + "TL22T,";
            if (test.isTL24()) issues = issues + "TL24,";
            if (test.isTL26()) issues = issues + "TL26,";
            if (test.isTL26T()) issues = issues + "TL26T,";
            if (test.isTL27()) issues = issues + "TL27,";
            if (test.isTL27T()) issues = issues + "TL27T,";
            if (test.isTL28()) issues = issues + "TL28,";
            if (test.isTL28T()) issues = issues + "TL28T,";
            if (test.isTL29()) issues = issues + "TL29,";
            if (test.isTL29A()) issues = issues + "TL29A,";
            if (test.isTL29B()) issues = issues + "TL29B,";
            if (test.isTL29C()) issues = issues + "TL29C,";
            if (test.isTL30()) issues = issues + "TL30,";
            if (test.isTL32()) issues = issues + "TL32,";
            if (test.isTL36()) issues = issues + "TL36,";
            if (test.isTL36T()) issues = issues + "TL36T,";
            if (test.isTL37()) issues = issues + "TL37,";
            if (test.isTL38()) issues = issues + "TL38,";
            if (test.isTL39()) issues = issues + "TL39,";
            if (test.isTL40()) issues = issues + "TL40,";
            if (test.isTL41()) issues = issues + "TL41,";
            if (test.isTL42()) issues = issues + "TL42,";
            if (test.isTL42A()) issues = issues + "TL42A,";
            if (issues.equals("")){
                return "No issues found";
            } else {
                return issues;
            }
        } else {
         return "Phone not inserted";
        }
    }
}
