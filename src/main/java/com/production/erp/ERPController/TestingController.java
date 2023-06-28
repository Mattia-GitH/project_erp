package com.production.erp.ERPController;

import com.production.erp.container.*;
import com.production.erp.model.*;
import com.production.erp.multiTest.MultiTestImei;
import com.production.erp.service.*;
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

import java.time.LocalTime;
import java.util.*;

@Controller
@PreAuthorize("hasRole('ROLE_LINE')")
public class TestingController {
    private final TestingService testingService;
    private final IssueListService issueListService;
    private final PhoneService phoneService;
    private final StatusService statusService;
    private final GradeService gradeService;
    private final BatteryService batteryService;
    private final LastStatusViewService lastStatusViewService;
    private final ReparationService reparationService;
    private final PhaseService phaseService;

    @Autowired
    public TestingController(TestingService testingService, IssueListService issueListService, PhoneService phoneService, StatusService statusService, GradeService gradeService, BatteryService batteryService, LastStatusViewService lastStatusViewService, ReparationService reparationService, PhaseService phaseService) {
        this.testingService = testingService;
        this.issueListService = issueListService;
        this.phoneService = phoneService;
        this.statusService = statusService;
        this.gradeService = gradeService;
        this.batteryService = batteryService;
        this.lastStatusViewService = lastStatusViewService;
        this.reparationService = reparationService;
        this.phaseService = phaseService;
    }

    @RequestMapping("/testing{status}")
    public String multipleTest(Model model, @PathVariable(value = "status", required = false) String actual_status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("status", actual_status);
        MultiTestImei imei = new MultiTestImei();
        model.addAttribute("imei", imei);

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, -10);

        model.addAttribute("phoneDone", statusService.findByOperatorAndDateBetween(authentication.getName(), cal.getTime(), new Date()));

        return "ERP/testing/selectDevices";
    }

    @RequestMapping("/grading")
    public String grading(Model model, @ModelAttribute("imei") MultiTestImei sImei, @ModelAttribute("status") String status) {
        GradeContainer grades = new GradeContainer();
        model.addAttribute("grading", grades);
        model.addAttribute("status", status);

        List<GradeModel> gradeList = new ArrayList<>();

        System.out.println(sImei.getImei1() + "-" + sImei.getImei2() + "-" + sImei.getImei3() + "-" + sImei.getImei4());

        if (sImei.getImei1() == null) sImei.setImei1("");
        if (sImei.getImei2() == null) sImei.setImei2("");
        if (sImei.getImei3() == null) sImei.setImei3("");
        if (sImei.getImei4() == null) sImei.setImei4("");

        if (!sImei.getImei1().equals("")) {
            String[] arrayImei1 = sImei.getImei1().split(",");
            Long imei1 = Long.valueOf(arrayImei1[0]);
            if (phoneService.isPresent(imei1)) {
                gradeList.add(new GradeModel(imei1, phoneService.getGradeSup(imei1)));
            } else {
                model.addAttribute("msg0", "Not Found imei: " + imei1);
            }
        }
        if (!sImei.getImei2().equals("")) {
            String[] arrayImei2 = sImei.getImei2().split(",");
            Long imei2 = Long.valueOf(arrayImei2[0]);
            if (phoneService.isPresent(imei2)) {
                gradeList.add(new GradeModel(imei2, phoneService.getGradeSup(imei2)));
            } else {
                model.addAttribute("msg1", "Not Found imei: " + imei2);
            }
        }
        if (!sImei.getImei3().equals("")) {
            String[] arrayImei3 = sImei.getImei3().split(",");
            Long imei3 = Long.valueOf(arrayImei3[0]);
            if (phoneService.isPresent(imei3)) {
                gradeList.add(new GradeModel(imei3, phoneService.getGradeSup(imei3)));
            } else {
                model.addAttribute("msg2", "Not Found imei: " + imei3);
            }
        }
        if (!sImei.getImei4().equals("")) {
            String[] arrayImei4 = sImei.getImei4().split(",");
            Long imei4 = Long.valueOf(arrayImei4[0]);
            if (phoneService.isPresent(imei4)) {
                gradeList.add(new GradeModel(imei4, phoneService.getGradeSup(imei4)));
            } else {
                model.addAttribute("msg3", "Not Found imei: " + imei4);
            }
        }

        model.addAttribute("gradeList", gradeList);

        return "ERP/testing/grading";
    }

    @RequestMapping("/test/{status}")
    public String testNew(Model model, @PathVariable("status") String status, @ModelAttribute(value = "grading") GradeContainer grades, @RequestParam(name = "hours", required = false) String hours, @RequestParam(name = "mins", required = false) String mins, @RequestParam(name = "seconds", required = false) String seconds) {
        model.addAttribute("status", status);
        model.addAttribute("iOS", testingService.iOS());
        System.out.println(testingService.iOS());

        if (status.equals("TESTING")) {
            ReparationContainer reparationContainer = new ReparationContainer();

            List<ReparationModel> reparationModelList = new ArrayList<>();

            grades.gradeList.forEach(g -> reparationModelList.addAll(reparationService.findByImeiAndDateAfter(g.getImei(), lastStatusViewService.findByImei(g.getImei()).getDate())));

            reparationContainer.setReparations(reparationModelList);

            model.addAttribute("reparations", reparationContainer);
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        TestContainer testForm = new TestContainer();
        model.addAttribute("test", testForm);

        List<TestingModel> list = new ArrayList<>();
//        if (!Objects.equals(status, "TESTING")) {
        for (GradeModel g : grades.getGradeList()) {
            g.setOperator(authentication.getName());
            g.setPhase(status);
            gradeService.createGrade(g);
            PhoneModel phoneModel = phoneService.phoneByImei(g.getImei());
            phoneService.updateSku(g.getImei(), phoneModel.getModel().substring(7).replaceAll(" ", "").toUpperCase() + phoneModel.getGb() + phoneModel.getColor().replaceAll(" ", "").toUpperCase() + g.getGrade_check());
        }
//        grades.gradeList.forEach(g -> phoneService.updateSku(g.getImei(), phoneService.phoneByImei(g.getImei()).getModel().substring(7).replaceAll(" ", "").toUpperCase() + phoneService.phoneByImei(g.getImei()).getGb() + phoneService.phoneByImei(g.getImei()).getColor().replaceAll(" ", "").toUpperCase() + g.getGrade_check()));
//        }

        if (grades.getGradeList() != null) {
            grades.getGradeList().forEach(g -> list.add(new TestingModel(g.getImei(), authentication.getName())));
        }

        Date date = new Date();

        List<StatusModel> statusModelList = new ArrayList<>();
        grades.getGradeList().forEach(g -> statusModelList.add(new StatusModel(g.getImei(), date, status, authentication.getName())));
        statusModelList.forEach(statusService::createStatus);

        model.addAttribute("multiTest", list);
        model.addAttribute("actual_status", status);
        model.addAttribute("issueList", issueListService.listIssues());

        model.addAttribute("hours", hours);
        model.addAttribute("mins", mins);
        model.addAttribute("seconds", seconds);

        return "ERP/testing/testing";
    }

    @RequestMapping("/status/{status}")
    public String status(Model model, @PathVariable("status") String actual_status, @ModelAttribute("test") TestContainer testNewModel, @RequestParam(name = "hours", required = false) String hours, @RequestParam(name = "mins", required = false) String mins, @RequestParam(name = "seconds", required = false) String seconds,
                         @RequestParam(name = "soh0", required = false) Integer soh0,
                         @RequestParam(name = "soh1", required = false) Integer soh1,
                         @RequestParam(name = "soh2", required = false) Integer soh2,
                         @RequestParam(name = "soh3", required = false) Integer soh3,
                         @RequestParam(name = "cycles0", required = false) Integer cycles0,
                         @RequestParam(name = "cycles1", required = false) Integer cycles1,
                         @RequestParam(name = "cycles2", required = false) Integer cycles2,
                         @RequestParam(name = "cycles3", required = false) Integer cycles3) {

        testNewModel.getTestList().forEach(t -> t.setDate(new Date()));
        testNewModel.getTestList().forEach(testingService::createTest);

        model.addAttribute("test", testNewModel.getTestList());

        List<BatteryModel> batteryModels = new ArrayList<>();
        testNewModel.getTestList().forEach(t -> batteryModels.add(new BatteryModel(t.getImei(), new Date())));

        if (soh0 != null) batteryModels.get(0).setSoh(soh0);
        if (soh1 != null) batteryModels.get(1).setSoh(soh1);
        if (soh2 != null) batteryModels.get(2).setSoh(soh2);
        if (soh3 != null) batteryModels.get(3).setSoh(soh3);
        if (cycles0 != null) batteryModels.get(0).setCycles(cycles0);
        if (cycles1 != null) batteryModels.get(1).setCycles(cycles1);
        if (cycles2 != null) batteryModels.get(2).setCycles(cycles2);
        if (cycles3 != null) batteryModels.get(3).setCycles(cycles3);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<StatusModel> statusModels = new ArrayList<>();

        for (BatteryModel batteryModel : batteryModels) {
            batteryService.createBattery(batteryModel);
            statusModels.add(statusService.findStatusToUpdate(batteryModel.getImei(), actual_status, authentication.getName()));
        }

        model.addAttribute("statuses", statusModels);

        model.addAttribute("hours", hours);
        model.addAttribute("mins", mins);
        model.addAttribute("seconds", seconds);
        model.addAttribute("actual_status", actual_status);

        StatusContainer statusContainer = new StatusContainer();
        model.addAttribute("status", statusContainer);
        model.addAttribute("phases", phaseService.phases());

        return "ERP/testing/statuses";
    }

    @RequestMapping("/save/{status}")
    public String save(Model model, @ModelAttribute("status") StatusContainer statusContainer, @PathVariable("status") String actual_status, @RequestParam(name = "hours", required = false) String hours, @RequestParam(name = "mins", required = false) String mins, @RequestParam(name = "seconds", required = false) String seconds) {

        int i = statusContainer.statusList.size();
        LocalTime time = LocalTime.parse(hours + ":" + mins + ":" + seconds);
        int hh = time.getHour() / i;
        int mm = time.getMinute() / i;
        int ss = time.getSecond() / i;
        time = LocalTime.of(hh, mm, ss);
        LocalTime finalTime = time;

        statusContainer.statusList.forEach(s -> s.setTimer(finalTime));
        statusContainer.statusList.forEach(s -> statusService.updateStatus(s, s.getId()));

        model.addAttribute("status", actual_status);

        return "redirect:/testing" + actual_status;
    }
}
