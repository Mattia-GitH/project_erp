package com.production.erp.ERPController;

import com.production.erp.helpers.ZXingHelper;
import com.production.erp.model.*;
import com.production.erp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Controller
@PreAuthorize("hasRole('ROLE_LINE')")
public class PackingController {
    private final PhoneService phoneService;
    private final LastStatusViewService lastStatusViewService;
    private final GradeService gradeService;
    private final BatteryService batteryService;
    private final StatusService statusService;
    private final IssueListService issueListService;
    private final TestingService testingService;
    private final OrderService orderService;
    private final PolishService polishService;

    @Autowired
    public PackingController(PhoneService phoneService, LastStatusViewService lastStatusViewService, GradeService gradeService, BatteryService batteryService, StatusService statusService, IssueListService issueListService, TestingService testingService, OrderService orderService, PolishService polishService) {
        this.phoneService = phoneService;
        this.lastStatusViewService = lastStatusViewService;
        this.gradeService = gradeService;
        this.batteryService = batteryService;
        this.statusService = statusService;
        this.issueListService = issueListService;
        this.testingService = testingService;
        this.orderService = orderService;
        this.polishService = polishService;
    }

    @RequestMapping("/packing")
    public String packing(Model model, @ModelAttribute("sendTechlab") TestingModel testing, @RequestParam(value = "status", required = false) String status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (testing.getImei() != null && status != null) {
            StatusModel statusModel = statusService.findByImeiOrderByDateDesc(testing.getImei());
            testing.setOperator(authentication.getName());
            testing.setDate(new Date());
            testingService.createTest(testing);
            statusModel.setSend_to(status);
            statusService.updateStatus(statusModel, statusModel.getId());
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR, -10);
        model.addAttribute("phoneDone", statusService.findByOperatorAndDateBetween(authentication.getName(), cal.getTime(), new Date()));

        return "ERP/packing/home";
    }

    @RequestMapping("/packingView")
    public String packingView(Model model, @RequestParam("imei") String sImei) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String[] arrayImei = sImei.split(",");
        Long imei = Long.valueOf(arrayImei[0]);

        if (phoneService.isPresent(imei)) {
            if (Objects.equals(lastStatusViewService.findByImei(imei).getSend_to(), "PACKING")) {
                int checkRev = orderService.checkRev(imei);

                boolean isRev = checkRev == 22;

                model.addAttribute("timesPolish", polishService.allPolishByImei(imei));
                model.addAttribute("rev", isRev);
                model.addAttribute("grade", gradeService.findFirstByImeiOrderByIdDesc(imei));
                model.addAttribute("info", phoneService.phoneInfos(imei));
                model.addAttribute("issues", issueListService.listIssues());
                model.addAttribute("pack", new PhoneModel());

                model.addAttribute("test", new TestingModel());
                model.addAttribute("sendTechlab", new TestingModel());

                statusService.createStatus(new StatusModel(imei, new Date(), "PACKING", authentication.getName()));

                return "ERP/packing/packing";
            } else {
                model.addAttribute("imei", "Phone sent to " + lastStatusViewService.findByImei(imei).getSend_to() + " from " + lastStatusViewService.findByImei(imei).getActual_status() + " by " + lastStatusViewService.findByImei(imei).getOperator() + " in date " + lastStatusViewService.findByImei(imei).getDate());
                return "ERP/packing/notFound";
            }
        } else {
            model.addAttribute("imei", "Not found: " + imei);
            return "ERP/packing/notFound";
        }
    }

    @RequestMapping("/packingReport")
    public String report(@ModelAttribute("sendTechlab") TestingModel testing, @RequestParam(value = "status", required = false) String status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        testing.setOperator(authentication.getName());
        testing.setDate(new Date());

        StatusModel toUpdate = statusService.findStatusToUpdate(testing.getImei(), "PACKING", SecurityContextHolder.getContext().getAuthentication().getName());
        statusService.deleteById(toUpdate.getId());

        statusService.createStatus(new StatusModel(testing.getImei(), new Date(), "PACKING", status, authentication.getName(), LocalTime.parse("00:01:00")));
        testingService.createTest(testing);

        return "redirect:/packing";
    }

    @RequestMapping("/packed")
    public String packed(@ModelAttribute("pack") PhoneModel pack, @RequestParam("grade") String grade, @RequestParam("send_to") String send_to, @RequestParam("hours") String hours, @RequestParam("mins") String mins, @RequestParam("seconds") String seconds) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        GradeModel gradeModel = gradeService.findFirstByImeiOrderByIdDesc(pack.getImei());
        gradeModel.setId(null);
        gradeModel.setPhase("PACKING");
        gradeModel.setOperator(authentication.getName());
        gradeModel.setGrade_check(grade);
        gradeService.createGrade(gradeModel);

        PhoneModel phoneModel = phoneService.phoneByImei(pack.getImei());
        phoneModel.setSku(phoneModel.getModel().substring(7).replaceAll(" ", "").toUpperCase() + pack.getGb() + pack.getColor().replaceAll(" ", "").toUpperCase() + grade);
        phoneModel.setColor(pack.getColor());
        phoneModel.setGb(pack.getGb());

        phoneService.updatePhone(phoneModel, phoneModel.getImei());

        StatusModel toUpdate = statusService.findStatusToUpdate(phoneModel.getImei(), "PACKING", SecurityContextHolder.getContext().getAuthentication().getName());
        toUpdate.setTimer(LocalTime.parse(hours + ":" + mins + ":" + seconds));
        toUpdate.setSend_to(send_to);
        statusService.updateStatus(toUpdate, toUpdate.getId());
        return "redirect:/print/" + pack.getImei();
    }

    @RequestMapping("/print/{imei}")
    public String print(Model model, @PathVariable("imei") Long imei) {
        PhoneModel phone = phoneService.phoneByImei(imei);

        model.addAttribute("battery", batteryService.findFirstByImeiOrderByDateDesc(phoneService.phoneInfos(phone.getImei()).getImei()));
        model.addAttribute("info", phoneService.phoneInfos(phone.getImei()));

        return "ERP/packing/print";
    }

    @RequestMapping(value = "/qrcode/{code}", method = RequestMethod.GET)
    public void qrcode(@PathVariable("code") String code, HttpServletResponse response) throws IOException {
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(Objects.requireNonNull(ZXingHelper.getQRCodeImage(code, 200, 200)));
        outputStream.flush();
        outputStream.close();
    }

    @GetMapping(value = "/ean13/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> barbecueEAN13Barcode(@PathVariable("barcode") String barcode)
            throws Exception {
        return ResponseEntity.ok(ZXingHelper.generateEAN13BarcodeImage(barcode));
    }
}
