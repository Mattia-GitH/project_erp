package com.production.erp.ERPController;

import com.production.erp.analytic.Analytics;
import com.production.erp.entity.LastStatusViewEntity;
import com.production.erp.model.StatusModel;
import com.production.erp.service.LastStatusViewService;
import com.production.erp.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
public class AnalyticsController {

    private final StatusService statusService;
    private final LastStatusViewService lastStatusViewService;

    @Autowired
    public AnalyticsController(StatusService statusService, LastStatusViewService lastStatusViewService) {
        this.statusService = statusService;
        this.lastStatusViewService = lastStatusViewService;
    }

    @RequestMapping(value = "/reports")
    public String reports(Model model, @RequestParam(value = "start", required = false) String start, @RequestParam(value = "end", required = false) String end) throws ParseException {
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        if (start == null) {
            c.setTime(Calendar.getInstance().getTime());
            c.set(Calendar.HOUR_OF_DAY, 0);
            c.set(Calendar.MINUTE, 0);
            c.set(Calendar.SECOND, 0);
            c.set(Calendar.MILLISECOND, 0);
            c2.setTime(new Date());
        } else {
            c.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(start + " 00:00:00"));
            c2.setTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(end + " 23:59:59"));
        }

        long diff = TimeUnit.DAYS.convert(c2.getTimeInMillis() - c.getTimeInMillis(), TimeUnit.MILLISECONDS);
        long weekends = getWorkingDaysBetweenTwoDates(c.getTime(), c2.getTime());
        long workDays = diff - weekends;
        if (workDays == 0) workDays = 1;
        model.addAttribute("workDays", workDays);

        List<StatusModel> status = statusService.findByDateGroupByImei(c.getTime(), c2.getTime());

        int entryDone = 0;
        int itcDone = 0;
        int fixingDone = 0;
        int testingDone = 0;
        int techlabDone = 0;
        int packingDone = 0;
        int scrapsDone = 0;
        int stockDone = 0;

        for (StatusModel s : status) {
            switch (s.getActual_status()) {
                case "ENTRY":
                    entryDone = entryDone + 1;
                    break;
                case "ITC":
                    itcDone = itcDone + 1;
                    break;
                case "FIXING":
                    fixingDone = fixingDone + 1;
                    break;
                case "TESTING":
                    testingDone = testingDone + 1;
                    break;
                case "TECHLAB":
                    techlabDone = techlabDone + 1;
                    break;
                case "PACKING":
                    packingDone = packingDone + 1;
                    break;
                case "SCRAPS":
                    scrapsDone = scrapsDone + 1;
                    break;
                case "STOCK":
                    stockDone = stockDone + 1;
                    break;
            }
        }

        model.addAttribute("entryDone", entryDone);
        model.addAttribute("itcDone", itcDone);
        model.addAttribute("fixingDone", fixingDone);
        model.addAttribute("testingDone", testingDone);
        model.addAttribute("techlabDone", techlabDone);
        model.addAttribute("packingDone", packingDone);
        model.addAttribute("scrapsDone", scrapsDone);
        model.addAttribute("stockDone", stockDone);

        List<LastStatusViewEntity> lastStatusViewEntities = lastStatusViewService.findByNumberOrderBigger();

        int entryToDo = 0;
        int itcToDo = 0;
        int fixingToDo = 0;
        int testingToDo = 0;
        int techlabToDo = 0;
        int packingToDo = 0;
        int scrapsToDo = 0;
        int stockToDo = 0;

        for (LastStatusViewEntity s : lastStatusViewEntities) {
            switch (s.getSend_to()) {
                case "ENTRY":
                    entryToDo = entryToDo + 1;
                    break;
                case "ITC":
                    itcToDo = itcToDo + 1;
                    break;
                case "FIXING":
                    fixingToDo = fixingToDo + 1;
                    break;
                case "TESTING":
                    testingToDo = testingToDo + 1;
                    break;
                case "TECHLAB":
                    techlabToDo = techlabToDo + 1;
                    break;
                case "PACKING":
                    packingToDo = packingToDo + 1;
                    break;
                case "SCRAPS":
                    scrapsToDo = scrapsToDo + 1;
                    break;
                case "STOCK":
                    stockToDo = stockToDo + 1;
                    break;
            }
        }

        model.addAttribute("entryToDo", entryToDo);
        model.addAttribute("itcToDo", itcToDo);
        model.addAttribute("fixingToDo", fixingToDo);
        model.addAttribute("testingToDo", testingToDo);
        model.addAttribute("techlabToDo", techlabToDo);
        model.addAttribute("packingToDo", packingToDo);
        model.addAttribute("scrapsToDo", scrapsToDo);
        model.addAttribute("stockToDo", stockToDo);

        List<Analytics> analyticsPhaseQty = new ArrayList<>();

        for (StatusModel s : status) {
            Analytics phaseQty = new Analytics(s.getActual_status(), 1L);

            if (analyticsPhaseQty.stream().anyMatch(o -> o.getParam().equals(s.getActual_status()))) {

                int index = analyticsPhaseQty.indexOf(analyticsPhaseQty.stream().filter(o -> o.getParam().equals(s.getActual_status())).findAny().get());
                phaseQty.setQty(analyticsPhaseQty.get(index).getQty() + 1L);
                analyticsPhaseQty.remove(index);
                analyticsPhaseQty.add(phaseQty);
            } else {
                analyticsPhaseQty.add(phaseQty);
            }
        }

        List<String> phaseList = new ArrayList<>();
        List<Long> pQty = new ArrayList<>();

        for (Analytics a : analyticsPhaseQty) {
            phaseList.add("'" + a.getParam() + "'");
            pQty.add(a.getQty());
        }

        model.addAttribute("pQty", pQty);
        model.addAttribute("phaseList", phaseList);

        List<Analytics> analyticsOperatorQtyITC = new ArrayList<>();
        List<Analytics> analyticsOperatorQtyFixing = new ArrayList<>();
        List<Analytics> analyticsOperatorQtyTesting = new ArrayList<>();
        List<Analytics> analyticsOperatorQtyTechlab = new ArrayList<>();
        List<Analytics> analyticsOperatorQtyPacking = new ArrayList<>();

        for (StatusModel s : status) {
            Analytics phaseQty = new Analytics(s.getOperator(), 1L);
            switch (s.getActual_status()) {
                case "ITC":
                    if (analyticsOperatorQtyITC.stream().anyMatch(o -> o.getParam().equals(s.getOperator()))) {
                        int index = analyticsOperatorQtyITC.indexOf(analyticsOperatorQtyITC.stream().filter(o -> o.getParam().equals(s.getOperator())).findAny().get());

                        phaseQty.setQty(analyticsOperatorQtyITC.get(index).getQty() + 1L);
                        analyticsOperatorQtyITC.remove(index);
                        analyticsOperatorQtyITC.add(phaseQty);
                    } else {
                        analyticsOperatorQtyITC.add(phaseQty);
                    }
                    break;
                case "FIXING":
                    if (analyticsOperatorQtyFixing.stream().anyMatch(o -> o.getParam().equals(s.getOperator()))) {
                        int index = analyticsOperatorQtyFixing.indexOf(analyticsOperatorQtyFixing.stream().filter(o -> o.getParam().equals(s.getOperator())).findAny().get());

                        phaseQty.setQty(analyticsOperatorQtyFixing.get(index).getQty() + 1L);
                        analyticsOperatorQtyFixing.remove(index);
                        analyticsOperatorQtyFixing.add(phaseQty);
                    } else {
                        analyticsOperatorQtyFixing.add(phaseQty);
                    }
                    break;
                case "TESTING":
                    if (analyticsOperatorQtyTesting.stream().anyMatch(o -> o.getParam().equals(s.getOperator()))) {
                        int index = analyticsOperatorQtyTesting.indexOf(analyticsOperatorQtyTesting.stream().filter(o -> o.getParam().equals(s.getOperator())).findAny().get());

                        phaseQty.setQty(analyticsOperatorQtyTesting.get(index).getQty() + 1L);
                        analyticsOperatorQtyTesting.remove(index);
                        analyticsOperatorQtyTesting.add(phaseQty);
                    } else {
                        analyticsOperatorQtyTesting.add(phaseQty);
                    }
                    break;
                case "TECHLAB":
                    if (analyticsOperatorQtyTechlab.stream().anyMatch(o -> o.getParam().equals(s.getOperator()))) {
                        int index = analyticsOperatorQtyTechlab.indexOf(analyticsOperatorQtyTechlab.stream().filter(o -> o.getParam().equals(s.getOperator())).findAny().get());

                        phaseQty.setQty(analyticsOperatorQtyTechlab.get(index).getQty() + 1L);
                        analyticsOperatorQtyTechlab.remove(index);
                        analyticsOperatorQtyTechlab.add(phaseQty);
                    } else {
                        analyticsOperatorQtyTechlab.add(phaseQty);
                    }
                    break;
                case "PACKING":
                    if (analyticsOperatorQtyPacking.stream().anyMatch(o -> o.getParam().equals(s.getOperator()))) {
                        int index = analyticsOperatorQtyPacking.indexOf(analyticsOperatorQtyPacking.stream().filter(o -> o.getParam().equals(s.getOperator())).findAny().get());

                        phaseQty.setQty(analyticsOperatorQtyPacking.get(index).getQty() + 1L);
                        analyticsOperatorQtyPacking.remove(index);
                        analyticsOperatorQtyPacking.add(phaseQty);
                    } else {
                        analyticsOperatorQtyPacking.add(phaseQty);
                    }
                    break;
            }
        }

        updateAnalytics(status, analyticsOperatorQtyITC, "ITC");
        updateAnalytics(status, analyticsOperatorQtyFixing, "FIXING");
        updateAnalytics(status, analyticsOperatorQtyTesting, "TESTING");
        updateAnalytics(status, analyticsOperatorQtyTechlab, "TECHLAB");
        updateAnalytics(status, analyticsOperatorQtyPacking, "PACKING");

        updateAnalyticsData(analyticsOperatorQtyITC, model, "operatorListITC");
        updateAnalyticsData(analyticsOperatorQtyFixing, model, "operatorListFixing");
        updateAnalyticsData(analyticsOperatorQtyTesting, model, "operatorListTesting");
        updateAnalyticsData(analyticsOperatorQtyTechlab, model, "operatorListTechlab");
        updateAnalyticsData(analyticsOperatorQtyPacking, model, "operatorListPacking");

        List<Analytics> analyticsFistLast = new ArrayList<>();

        for (StatusModel s : status) {
            if (analyticsFistLast.stream().anyMatch(o -> o.getParam().equals(s.getOperator()))) {
            } else {
                List<StatusModel> firstLastTime = statusService.findFirstAndLastTimeOperator(c.getTime(), s.getOperator(), c2.getTime());
                Analytics firstLast = new Analytics(s.getOperator(), firstLastTime.get(0).getDate().toString(), firstLastTime.get(1).getDate().toString());
                analyticsFistLast.add(firstLast);
            }
        }

        model.addAttribute("analyticsFistLast", analyticsFistLast);

        List<Analytics> analyticsAvg = new ArrayList<>();

        for (StatusModel s : status) {

            if (analyticsAvg.stream().anyMatch(o -> o.getParam().equals(s.getOperator()))) {
            } else {
                StatusModel firstLastTime = statusService.findAvgTimeOperator(new java.sql.Date(c.getTimeInMillis()), s.getOperator());
                Analytics avgTime = new Analytics(s.getOperator(), firstLastTime.getTimer().toString());
                analyticsAvg.add(avgTime);
            }
        }

        model.addAttribute("analyticsAvg", analyticsAvg);

        return "ERP/reports";
    }

    public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        int weekends = 0;

        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return 0;
        }

        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        do {
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                ++weekends;
            }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());
        return weekends;
    }

    private void updateAnalyticsData(List<Analytics> analyticsList, Model model, String attributeName) {
        List<String> operatorList = new ArrayList<>();
        List<Long> oQty = new ArrayList<>();
        for (Analytics a : analyticsList) {
            operatorList.add("'" + a.getParam() + "'");
            oQty.add(a.getQty() / 2);
        }
        model.addAttribute(attributeName, operatorList);
        model.addAttribute("oQty" + attributeName.substring(12), oQty);
    }

    private void updateAnalytics(List<StatusModel> status, List<Analytics> analyticsList, String actualStatus) {
        for (StatusModel s : status) {
            if (s.getActual_status().equals(actualStatus)) {
                Optional<Analytics> existingAnalytics = analyticsList.stream()
                        .filter(o -> o.getParam().equals(s.getOperator()))
                        .findFirst();

                if (existingAnalytics.isPresent()) {
                    Analytics phaseQty = existingAnalytics.get();
                    phaseQty.setQty(phaseQty.getQty() + 1L);
                } else {
                    Analytics phaseQty = new Analytics(s.getOperator(), 1L);
                    analyticsList.add(phaseQty);
                }
            }
        }
    }
}
