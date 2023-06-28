package com.production.erp.ERPController;

import com.production.erp.importExport.*;
import com.production.erp.model.BatteryModel;
import com.production.erp.model.GradeModel;
import com.production.erp.model.StatusModel;
import com.production.erp.model.TestingModel;
import com.production.erp.service.*;
import com.production.erp.view.PhoneInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Controller
public class ExportController {

    private final PhoneService phoneService;
    private final TestingService testingService;
    private final BatteryService batteryService;
    private final StatusService statusService;
    private final GradeService gradeService;
    private final SuppliersService suppliersService;

    @Autowired
    public ExportController(PhoneService phoneService, TestingService testingService, BatteryService batteryService, StatusService statusService, GradeService gradeService, SuppliersService suppliersService) {
        this.phoneService = phoneService;
        this.testingService = testingService;
        this.batteryService = batteryService;
        this.statusService = statusService;
        this.gradeService = gradeService;
        this.suppliersService = suppliersService;
    }

    @GetMapping("/itc/export/excel")
    public void itcToExcel(HttpServletResponse response) throws IOException, ParseException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=ITC_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        String strDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate + " 00:00:00");
        java.util.Date utilDate2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate + " 23:00:00");

        List<ITCExportModel> exportModels = new ArrayList<>();

        List<StatusModel> status = statusService.findAllItcToExport(utilDate, utilDate2);
        for (StatusModel i : status) {
            ITCExportModel itc = new ITCExportModel();
            itc.setImei(i.getImei());
            LocalTime time;
            if (i.getTimer() == null) {
                time = LocalTime.MIN;
            } else {
                time = i.getTimer();
            }
            itc.setFix(time);

            PhoneInfo phone = phoneService.phoneInfos(i.getImei());
            itc.setColor(phone.getColor());
            itc.setModel(phone.getModel());
            itc.setGb(phone.getGb());
            itc.setSku(phone.getSku());
            itc.setOrder_number(phone.getOrder_number());
            String supplier = suppliersService.supplierFromOrderNumber(phone.getOrder_number());
            itc.setSupplier(supplier);
            BatteryModel batteryModel = batteryService.findFirstByImeiOrderByDateDesc(i.getImei());
            itc.setCycles(batteryModel.getCycles());
            itc.setSoh(batteryModel.getSoh());
            GradeModel grade = gradeService.findFirstByImeiOrderByIdDesc(i.getImei());
            itc.setGrade_supplier(grade.getGrade_sup());
            itc.setGrade_check(grade.getGrade_check());
            TestingModel test = testingService.findFirstByImeiAndDate(i.getImei(), utilDate, utilDate2);
            itc.setOperator(test.getOperator());
            itc.setDate(test.getDate());

            List<String> values = new ArrayList<>();

            if (test.isTL0()) values.add("0");
            if (test.isTL1()) values.add("1");
            if (test.isTL2()) values.add("2");
            if (test.isTL2T()) values.add("2T");
            if (test.isTL4()) values.add("4");
            if (test.isTL5()) values.add("5");
            if (test.isTL5A()) values.add("5A");
            if (test.isTL5B()) values.add("5B");
            if (test.isTL8()) values.add("8");
            if (test.isTL8P()) values.add("8P");
            if (test.isTL9()) values.add("9");
            if (test.isTL9T()) values.add("9T");
            if (test.isTL10()) values.add("10");
            if (test.isTL10G()) values.add("10G");
            if (test.isTL10T()) values.add("10T");
            if (test.isTL11()) values.add("11");
            if (test.isTL11G()) values.add("11G");
            if (test.isTL12()) values.add("12");
            if (test.isTL13()) values.add("13");
            if (test.isTL14()) values.add("14");
            if (test.isTL14P()) values.add("14P");
            if (test.isTL14A()) values.add("14A");
            if (test.isTL14B()) values.add("14B");
            if (test.isTL14T()) values.add("14T");
            if (test.isTL15()) values.add("15");
            if (test.isTL16()) values.add("16");
            if (test.isTL17()) values.add("17");
            if (test.isTL18()) values.add("18");
            if (test.isTL19()) values.add("19");
            if (test.isTL19A()) values.add("19A");
            if (test.isTL21()) values.add("21");
            if (test.isTL22()) values.add("22");
            if (test.isTL22T()) values.add("22T");
            if (test.isTL24()) values.add("24");
            if (test.isTL26()) values.add("26");
            if (test.isTL26T()) values.add("26T");
            if (test.isTL27()) values.add("27");
            if (test.isTL27T()) values.add("27T");
            if (test.isTL28()) values.add("28");
            if (test.isTL28T()) values.add("28T");
            if (test.isTL29()) values.add("29");
            if (test.isTL29A()) values.add("29A");
            if (test.isTL29B()) values.add("29B");
            if (test.isTL29C()) values.add("29C");
            if (test.isTL30()) values.add("30");
            if (test.isTL32()) values.add("32");
            if (test.isTL36()) values.add("36");
            if (test.isTL36T()) values.add("36T");
            if (test.isTL37()) values.add("37");
            if (test.isTL38()) values.add("38");
            if (test.isTL39()) values.add("39");
            if (test.isTL40()) values.add("40");
            if (test.isTL41()) values.add("41");
            if (test.isTL42()) values.add("42");
            if (test.isTL42A()) values.add("42A");

            for (String value : values) {
                if (itc.getFirstTL() == null) {
                    itc.setFirstTL(value);
                } else if (!Objects.equals(itc.getFirstTL(), value) && itc.getSecondTL() == null) {
                    itc.setSecondTL(value);
                } else if (!Objects.equals(itc.getSecondTL(), value) && !Objects.equals(itc.getFirstTL(), value) && itc.getThirdTL() == null) {
                    itc.setThirdTL(value);
                } else if (!Objects.equals(itc.getThirdTL(), value) && !Objects.equals(itc.getSecondTL(), value) && !Objects.equals(itc.getFirstTL(), value) && itc.getFourthTL() == null) {
                    itc.setFourthTL(value);
                } else if (!Objects.equals(itc.getFourthTL(), value) && !Objects.equals(itc.getThirdTL(), value) && !Objects.equals(itc.getSecondTL(), value) && !Objects.equals(itc.getFirstTL(), value) && itc.getFifthTL() == null) {
                    itc.setFifthTL(value);
                } else if (!Objects.equals(itc.getSixthTL(), value) && !Objects.equals(itc.getFourthTL(), value) && !Objects.equals(itc.getThirdTL(), value) && !Objects.equals(itc.getSecondTL(), value) && !Objects.equals(itc.getFirstTL(), value) && itc.getSixthTL() == null) {
                    itc.setSixthTL(value);
                } else if (!Objects.equals(itc.getSeventhTL(), value) && !Objects.equals(itc.getSixthTL(), value) && !Objects.equals(itc.getFourthTL(), value) && !Objects.equals(itc.getThirdTL(), value) && !Objects.equals(itc.getSecondTL(), value) && !Objects.equals(itc.getFirstTL(), value) && itc.getSeventhTL() == null) {
                    itc.setSeventhTL(value);
                } else if (!Objects.equals(itc.getEighthTL(), value) && !Objects.equals(itc.getSeventhTL(), value) && !Objects.equals(itc.getSixthTL(), value) && !Objects.equals(itc.getFourthTL(), value) && !Objects.equals(itc.getThirdTL(), value) && !Objects.equals(itc.getSecondTL(), value) && !Objects.equals(itc.getFirstTL(), value) && itc.getEighthTL() == null) {
                    itc.setEighthTL(value);
                } else if (!Objects.equals(itc.getNinthTL(), value) && !Objects.equals(itc.getEighthTL(), value) && !Objects.equals(itc.getSeventhTL(), value) && !Objects.equals(itc.getSixthTL(), value) && !Objects.equals(itc.getFourthTL(), value) && !Objects.equals(itc.getThirdTL(), value) && !Objects.equals(itc.getSecondTL(), value) && !Objects.equals(itc.getFirstTL(), value) && itc.getNinthTL() == null) {
                    itc.setNinthTL(value);
                } else if (!Objects.equals(itc.getTenthTL(), value) && !Objects.equals(itc.getNinthTL(), value) && !Objects.equals(itc.getEighthTL(), value) && !Objects.equals(itc.getSeventhTL(), value) && !Objects.equals(itc.getSixthTL(), value) && !Objects.equals(itc.getFourthTL(), value) && !Objects.equals(itc.getThirdTL(), value) && !Objects.equals(itc.getSecondTL(), value) && !Objects.equals(itc.getFirstTL(), value) && itc.getTenthTL() == null) {
                    itc.setTenthTL(value);
                }
            }
            exportModels.add(itc);
        }
        ITCExporter excelExporter = new ITCExporter(exportModels);
        excelExporter.export(response);
    }

    @GetMapping("/output/export")
    public void exportOutputToExcel(HttpServletResponse response, Model model) throws IOException, ParseException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=OUTPUT_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        String strDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strDate + " 00:00:00");

        List<OutputExportModel> outputExport = phoneService.outputExport(new java.sql.Date(utilDate.getTime()));

        OutputExporter exporter = new OutputExporter(outputExport);

        exporter.export(response);
    }

    @GetMapping("/shipping/export")
    public void exportShippingToExcel(HttpServletResponse response, Model model) throws IOException, ParseException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=SHIPPING_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<ShippingExportModel> shippingExport = phoneService.shippingExporter();

        ShippingExporter exporter = new ShippingExporter(shippingExport);

        exporter.export(response);
    }

}
