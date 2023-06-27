package com.production.erp.ERPController;

import com.production.erp.container.PlanContainer;
import com.production.erp.model.PlanningModel;
import com.production.erp.model.PlanningPreviewModel;
import com.production.erp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class PlanningController {
    private final PlanningService planningService;
    private final PhoneService phoneService;
    private final PlanningPreviewService planningPreviewService;
    private final UserService userService;
    private final PhaseService phaseService;

    @Autowired
    public PlanningController(PlanningService planningService, PhoneService phoneService, PlanningPreviewService planningPreviewService, UserService userService, PhaseService phaseService) {
        this.planningService = planningService;
        this.phoneService = phoneService;
        this.planningPreviewService = planningPreviewService;
        this.userService = userService;
        this.phaseService = phaseService;
    }

    private void filter(Model model) {
        List<String> sku = phoneService.skuData();
        List<String> phoneModel = phoneService.modelData();
        List<Long> gb = phoneService.gbData();
        List<String> color = phoneService.colorData();
        model.addAttribute("sku", sku);
        model.addAttribute("phoneModel", phoneModel);
        model.addAttribute("gbPhone", gb);
        model.addAttribute("color", color);
    }

    @RequestMapping(value = {"/planned", "/planned/{id}"})
    public String planningHome(Model model, @PathVariable(value = "id", required = false) Long id, @RequestParam(value = "sfDate", required = false) String sfDate, @RequestParam(value = "fStatus", required = false) String fStatus, @RequestParam(value = "fSku", required = false) String fSku) throws ParseException {
        Date dateF;

        if (Objects.equals(sfDate, "")) sfDate = null;
        if (Objects.equals(fSku, "")) fSku = null;
        if (Objects.equals(fStatus, "")) fStatus = null;
        if (sfDate != null) {
            dateF = new SimpleDateFormat("yyyy-MM-dd").parse(sfDate);
        } else {
            dateF = null;
        }
        model.addAttribute("planned", planningService.planned(dateF, fStatus, fSku));
        model.addAttribute("planPreview", planningPreviewService.planList());


        if (id != null) {
            model.addAttribute("plan", new PlanContainer());
            model.addAttribute("users", userService.listUsers());
            model.addAttribute("id", id);

            PlanningModel plan = planningService.planById(id);
            model.addAttribute("plannedDetails", planningService.plannedDetail(plan.getDate(), plan.getStatus(), plan.getSku()));

            Date startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(plan.getDate().toString() + " 00:00:00");
            Date finishDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(plan.getDate().toString().substring(0, 10) + " 23:59:59");
            model.addAttribute("planProgress", planningService.planProgress(startDate, finishDate));

            System.out.println("progress " + startDate + "   " + finishDate + planningService.planProgress(startDate, finishDate));

            if (Objects.equals(plan.getStatus(), "")) plan.setStatus(null);
            if (Objects.equals(plan.getStatus(), "ITC")) {
                model.addAttribute("qtyAvailable", planningService.planningViewITC(plan.getSku()).get(0).getQty());
            } else {
                model.addAttribute("qtyAvailable", planningService.planningView(plan.getStatus(), plan.getSku()).get(0).getQty());
            }

        } else {
            model.addAttribute("id", null);
        }

        model.addAttribute("phases", phaseService.phases());

        return "ERP/planning/home";
    }

    @RequestMapping("/planned/editPlan/{id}")
    public String editPlan(@PathVariable("id") Long id, @RequestParam("qty") Long qty, @RequestParam("operator") String operator) {
        PlanningModel plan = planningService.planById(id);
        plan.setQty(qty);
        plan.setOperator(operator);

        planningService.createPlan(plan);

        return "redirect:/planned/" + id;
    }

    @RequestMapping("/planning")
    public String planning(Model model, @ModelAttribute(value = "plan") PlanningPreviewModel planningPreviewModel, @RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "status", required = false) String status) {
        filter(model);
        if (Objects.equals(status, "")) status = null;
        if (Objects.equals(status, "ITC")) {
            model.addAttribute("planningView", planningService.planningViewITC(filter));
        } else {
            model.addAttribute("planningView", planningService.planningView(status, filter));
        }

        if (planningPreviewModel.getSku() != null) planningPreviewService.createPlan(planningPreviewModel);

        model.addAttribute("planPreview", planningPreviewService.planList());
        model.addAttribute("plan", new PlanningPreviewModel());
        model.addAttribute("phases", phaseService.phases());

        return "ERP/planning/planning";
    }

    @RequestMapping("/planOperator/{id}")
    public String planOperator(@PathVariable("id") Long id, @ModelAttribute("plan") PlanContainer planContainer) {
        long qtyAssigned = 0;

        PlanningModel plan = planningService.planById(id);

        for (PlanningModel newPlan : planContainer.getPlanList()) {
            newPlan.setDate(plan.getDate());
            newPlan.setSku(plan.getSku());
            newPlan.setStatus(plan.getStatus());

            qtyAssigned = qtyAssigned + newPlan.getQty();

            if (qtyAssigned <= plan.getQty()) planningService.createPlan(newPlan);
        }

        if (qtyAssigned < plan.getQty()) {
            plan.setQty(plan.getQty() - qtyAssigned);
            planningService.createPlan(plan);
        } else {
            planningService.delete(id);
        }

        return "redirect:/planned";
    }

    @RequestMapping("/plan_preview")
    public String planPreview(Model model) {
        model.addAttribute("planPreview", planningPreviewService.planList());
        model.addAttribute("plan", new PlanContainer());
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("phases", phaseService.phases());

        return "ERP/planning/preview";
    }

    @RequestMapping("/create_plan")
    public String createPlan(@ModelAttribute("plan") PlanContainer planContainer, @RequestParam("sDate") String sDate) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);

        planContainer.getPlanList().forEach(plan -> plan.setDate(date));
        planContainer.getPlanList().forEach(plan -> planningService.isAlreadyPlanned(plan.getDate(), plan.getSku(), plan.getStatus()));

        for (int i = 0; i < planContainer.getPlanList().size(); i++) {
            if (!planningService.isAlreadyPlanned(planContainer.getPlanList().get(i).getDate(), planContainer.getPlanList().get(i).getSku(), planContainer.getPlanList().get(i).getStatus())) {
                planContainer.getPlanList().forEach(planningService::createPlan);
            }
        }

        return "redirect:/planning";
    }

    @RequestMapping("/delete/plan/{id}")
    public String deleteId(@PathVariable("id") Long id, Model model) {
        planningPreviewService.delete(id);

        return "redirect:/plan_preview";
    }

    @RequestMapping("/truncatePlanPreview")
    public String truncatePlanPreview() {
        planningPreviewService.truncate();

        return "redirect:/planning";
    }

    @RequestMapping("/deletePlan/{date}/{status}/{sku}")
    public String deletePlan(@PathVariable("date") String sDate, @PathVariable("status") String status, @PathVariable("sku") String sku) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(sDate);
        planningService.deletePlan(date, status, sku);
        return "redirect:/planned";
    }

    @RequestMapping("/editPlan/{date}/{status}/{sku}/{operator}")
    public String editPlan(Model model, @PathVariable("date") String sDate, @PathVariable("status") String status, @PathVariable("sku") String sku, @PathVariable("operator") String operator) throws ParseException {
        filter(model);
        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(sDate);

        model.addAttribute("users", userService.listUsers());
        model.addAttribute("planToEdit", planningService.findByDateAndStatusAndSkuAndOperator(date, status, sku, operator));
        model.addAttribute("phases", phaseService.phases());
        return "ERP/planning/edit";
    }

    @RequestMapping("saveEditedPlan")
    public String planEdited(@ModelAttribute("planToEdit") PlanningModel planEdited, @RequestParam("sDate") String sDate) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(sDate + " 00:00:00");
        planEdited.setDate(date);
        planningService.updatePlan(planEdited, planEdited.getId());

        return "redirect:/planned/" + sDate + "/" + planEdited.getStatus() + "/" + planEdited.getSku();
    }
}
