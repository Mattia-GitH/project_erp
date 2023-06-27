package com.production.erp.ERPController;

import com.production.erp.container.ReparationContainer;
import com.production.erp.entity.LastStatusViewEntity;
import com.production.erp.model.*;
import com.production.erp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.*;

@Controller
@PreAuthorize("hasRole('ROLE_LINE')")
public class FixingController {
    private final PhoneService phoneService;
    private final TestingService testingService;
    private final CommentsService commentsService;
    private final StatusService statusService;
    private final ReparationService reparationService;
    private final IssueListService issueListService;
    private final BatteryService batteryService;
    private final LastStatusViewService lastStatusViewService;
    private final ReportService reportService;
    private final ComponentService componentService;

    @Autowired
    public FixingController(PhoneService phoneService, TestingService testingService, CommentsService commentsService, StatusService statusService, ReparationService reparationService, IssueListService issueListService, BatteryService batteryService, LastStatusViewService lastStatusViewService, ReportService reportService, ComponentService componentService) {
        this.phoneService = phoneService;
        this.testingService = testingService;
        this.commentsService = commentsService;
        this.statusService = statusService;
        this.reparationService = reparationService;
        this.issueListService = issueListService;
        this.batteryService = batteryService;
        this.lastStatusViewService = lastStatusViewService;
        this.reportService = reportService;
        this.componentService = componentService;
    }

    @RequestMapping("/fixing{status}")
    public String fixing(Model model, @PathVariable(value = "status", required = false) String actual_status, @ModelAttribute("sendTechlab") TestingModel testing) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (testing.getImei() != null) {
            StatusModel statusModel = statusService.findByImeiOrderByDateDesc(testing.getImei());
            testing.setOperator(authentication.getName());
            testing.setDate(new Date());
            testingService.createTest(testing);
            statusModel.setSend_to("TECHLAB");
            statusService.updateStatus(statusModel, statusModel.getId());
        }

        model.addAttribute("status", actual_status);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, -10);
        model.addAttribute("phoneDone", statusService.findByOperatorAndDateBetween(authentication.getName(), cal.getTime(), new Date()));

        return "ERP/Fixing/home";
    }

    @RequestMapping("/fixingView")
    public String fixingView(@RequestParam String sImei, Model model, @RequestParam(value = "status", required = false) String status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String[] arrayImei = sImei.split(",");
        Long imei = Long.valueOf(arrayImei[0]);
        LastStatusViewEntity lastStatusViewEntity = lastStatusViewService.findByImei(imei);
        if (Objects.equals(lastStatusViewEntity.getSend_to(), status)) {
            model.addAttribute("sendTechlab", new TestingModel());
            model.addAttribute("issueList", issueListService.listIssues());

            model.addAttribute("componentSKU", componentService.componentsList());
            model.addAttribute("info", phoneService.phoneInfos(imei));

            TestingModel test = testingService.lastTest(imei);

            model.addAttribute("test", test);
            model.addAttribute("comments", commentsService.loadComments(imei, lastStatusViewEntity.getDate(), test.getDate()));
            model.addAttribute("issueList", issueListService.listIssues());
            model.addAttribute("status", status);
            model.addAttribute("battery", batteryService.findFirstByImeiOrderByDateDesc(imei));

            List<ReparationModel> toRepair = new ArrayList<>();

            statusService.createStatus(new StatusModel(imei, new Date(), status, authentication.getName()));

            if (test.isTL0()) toRepair.add(new ReparationModel(imei, "TL0"));
            if (test.isTL1()) toRepair.add(new ReparationModel(imei, "TL1"));
            if (test.isTL2()) toRepair.add(new ReparationModel(imei, "TL2"));
            if (test.isTL2T()) toRepair.add(new ReparationModel(imei, "TL2T"));
            if (test.isTL4()) toRepair.add(new ReparationModel(imei, "TL4"));
            if (test.isTL5()) toRepair.add(new ReparationModel(imei, "TL5"));
            if (test.isTL5A()) toRepair.add(new ReparationModel(imei, "TL5A"));
            if (test.isTL5B()) toRepair.add(new ReparationModel(imei, "TL5B"));
            if (test.isTL8P()) toRepair.add(new ReparationModel(imei, "TL8P"));
            if (test.isTL8()) toRepair.add(new ReparationModel(imei, "TL8"));
            if (test.isTL9()) toRepair.add(new ReparationModel(imei, "TL9"));
            if (test.isTL9T()) toRepair.add(new ReparationModel(imei, "TL9T"));
            if (test.isTL10()) toRepair.add(new ReparationModel(imei, "TL10"));
            if (test.isTL10G()) toRepair.add(new ReparationModel(imei, "TL10G"));
            if (test.isTL10T()) toRepair.add(new ReparationModel(imei, "TL10T"));
            if (test.isTL11()) toRepair.add(new ReparationModel(imei, "TL11"));
            if (test.isTL11G()) toRepair.add(new ReparationModel(imei, "TL11G"));
            if (test.isTL12()) toRepair.add(new ReparationModel(imei, "TL12"));
            if (test.isTL13()) toRepair.add(new ReparationModel(imei, "TL13"));
            if (test.isTL14()) toRepair.add(new ReparationModel(imei, "TL14"));
            if (test.isTL14P()) toRepair.add(new ReparationModel(imei, "TL14P"));
            if (test.isTL14A()) toRepair.add(new ReparationModel(imei, "TL14A"));
            if (test.isTL14B()) toRepair.add(new ReparationModel(imei, "TL14B"));
            if (test.isTL14T()) toRepair.add(new ReparationModel(imei, "TL14T"));
            if (test.isTL15()) toRepair.add(new ReparationModel(imei, "TL15"));
            if (test.isTL16()) toRepair.add(new ReparationModel(imei, "TL16"));
            if (test.isTL17()) toRepair.add(new ReparationModel(imei, "TL17"));
            if (test.isTL18()) toRepair.add(new ReparationModel(imei, "TL18"));
            if (test.isTL19()) toRepair.add(new ReparationModel(imei, "TL19"));
            if (test.isTL19A()) toRepair.add(new ReparationModel(imei, "TL19A"));
            if (test.isTL21()) toRepair.add(new ReparationModel(imei, "TL21"));
            if (test.isTL22()) toRepair.add(new ReparationModel(imei, "TL22"));
            if (test.isTL22T()) toRepair.add(new ReparationModel(imei, "TL22T"));
            if (test.isTL24()) toRepair.add(new ReparationModel(imei, "TL24"));
            if (test.isTL26()) toRepair.add(new ReparationModel(imei, "TL26"));
            if (test.isTL26T()) toRepair.add(new ReparationModel(imei, "TL26T"));
            if (test.isTL27()) toRepair.add(new ReparationModel(imei, "TL27"));
            if (test.isTL27T()) toRepair.add(new ReparationModel(imei, "TL27T"));
            if (test.isTL28()) toRepair.add(new ReparationModel(imei, "TL28"));
            if (test.isTL28T()) toRepair.add(new ReparationModel(imei, "TL28T"));
            if (test.isTL29()) toRepair.add(new ReparationModel(imei, "TL29"));
            if (test.isTL29A()) toRepair.add(new ReparationModel(imei, "TL29A"));
            if (test.isTL29B()) toRepair.add(new ReparationModel(imei, "TL29B"));
            if (test.isTL29C()) toRepair.add(new ReparationModel(imei, "TL29C"));
            if (test.isTL30()) toRepair.add(new ReparationModel(imei, "TL30"));
            if (test.isTL32()) toRepair.add(new ReparationModel(imei, "TL32"));
            if (test.isTL36()) toRepair.add(new ReparationModel(imei, "TL36"));
            if (test.isTL36T()) toRepair.add(new ReparationModel(imei, "TL36T"));
            if (test.isTL37()) toRepair.add(new ReparationModel(imei, "TL37"));
            if (test.isTL38()) toRepair.add(new ReparationModel(imei, "TL38"));
            if (test.isTL39()) toRepair.add(new ReparationModel(imei, "TL39"));
            if (test.isTL40()) toRepair.add(new ReparationModel(imei, "TL40"));
            if (test.isTL41()) toRepair.add(new ReparationModel(imei, "TL41"));
            if (test.isTL42()) toRepair.add(new ReparationModel(imei, "TL42"));
            if (test.isTL42A()) toRepair.add(new ReparationModel(imei, "TL42A"));

            ReparationContainer reparationList = new ReparationContainer();
            reparationList.setReparations(toRepair);

            model.addAttribute("toRepair", reparationList);

            return "ERP/Fixing/fixing";
        } else {
            model.addAttribute("phone", lastStatusViewService.findByImei(imei));

            return "ERP/Fixing/wrongSend";
        }
    }

    @RequestMapping("/fixed/{actual_status}")
    public String fixed(@ModelAttribute("toRepair") ReparationContainer reparationList, @PathVariable("actual_status") String actual_status, Model model) {
        StatusModel toUpdate = statusService.findStatusToUpdate(reparationList.getReparations().get(0).getImei(), actual_status, SecurityContextHolder.getContext().getAuthentication().getName());
        toUpdate.setTimer(LocalTime.parse(reparationList.getHours() + ":" + reparationList.getMins() + ":" + reparationList.getSeconds()));
        toUpdate.setSend_to(reparationList.getSend_to());
        statusService.updateStatus(toUpdate, toUpdate.getId());

        for (ReparationModel r : reparationList.getReparations()) {
            r.setDate(new Date());
            reparationService.createReparation(r);

            ComponentModel componentModel = componentService.findBySku(r.getComponent());
            if (componentModel != null) {
                ComponentModel component = componentService.findBySku(r.getComponent());
                componentService.updateQty(component.getSku(), component.getQty() - 1);
            }
        }
        return "redirect:/fixing" + actual_status;
    }
}
