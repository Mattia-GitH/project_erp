package com.production.erp.ERPController;

import com.production.erp.model.*;
import com.production.erp.service.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.IntStream;

@RestController
public class ImportExcelController {
    private final ArticleService articleService;
    private final OrderService orderService;
    private final PhoneService phoneService;
    private final GradeService gradeService;
    private final StatusService statusService;
    private final BatteryService batteryService;
    private final IssueListService issueListService;
    private final TestingService testingService;

    @Autowired
    public ImportExcelController(ArticleService articleService, OrderService orderService, PhoneService phoneService, GradeService gradeService, StatusService statusService, BatteryService batteryService, IssueListService issueListService, TestingService testingService) {
        this.articleService = articleService;
        this.orderService = orderService;
        this.phoneService = phoneService;
        this.gradeService = gradeService;
        this.statusService = statusService;
        this.batteryService = batteryService;
        this.issueListService = issueListService;
        this.testingService = testingService;
    }


    @RequestMapping(value = "/import-excel", method = RequestMethod.POST)
    public ResponseEntity<List<String>> importExcelFile(@RequestParam("file") MultipartFile files) throws IOException {
        HttpStatus status = HttpStatus.OK;

        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());

//        Create Article
        XSSFSheet worksheet = workbook.getSheetAt(0);
        List<ArticleModel> articleList = addArticle(worksheet);

        for (ArticleModel article : articleList) {
            System.out.println("----------------------------------------------------------------- Article " + article.getId() + " -----------------------------------------------------------------");
            if (!articleService.articleAlreadyExist(article.getModel(), article.getGb(), article.getGrade_sup()))
                articleService.createArticle(article);
        }

//        Create order
        worksheet = workbook.getSheetAt(0);
        List<OrderModel> orderList = addOrder(worksheet);

        for (OrderModel order : orderList) {
            System.out.println("----------------------------------------------------------------- Order " + order.getNumber_order() + " -----------------------------------------------------------------");
            if (!orderService.orderAlreadyExist(order.getId_article(), order.getId_supplier(), order.getNumber_order()))
                orderService.createOrder(order);
        }

//        Create phone
        worksheet = workbook.getSheetAt(0);
        List<PhoneModel> phoneList = addPhone(worksheet);

        for (PhoneModel phone : phoneList) {
            System.out.println("----------------------------------------------------------------- Phone " + phone.getImei() + " -----------------------------------------------------------------");
            if (!phoneService.isPresent(phone.getImei())) phoneService.createPhone(phone);
        }

//        Create grade
        worksheet = workbook.getSheetAt(0);
        List<GradeModel> gradeList = addGrade(worksheet);

        for (GradeModel grade : gradeList) {
            System.out.println("----------------------------------------------------------------- Grade " + grade.getImei() + " -----------------------------------------------------------------");
            if (!gradeService.isPresent(grade.getImei())) gradeService.createGrade(grade);
        }


//        Create status
        worksheet = workbook.getSheetAt(0);
        List<StatusModel> statusList = addStatus(worksheet);

        for (StatusModel statusModel : statusList) {
            System.out.println("----------------------------------------------------------------- Status " + statusModel.getImei() + " -----------------------------------------------------------------");
            if (!statusService.isPresent(statusModel.getImei())) statusService.createStatus(statusModel);
        }


//        Create battery
        worksheet = workbook.getSheetAt(0);
        List<BatteryModel> batteryList = addBattery(worksheet);

        for (BatteryModel battery : batteryList) {
            System.out.println("----------------------------------------------------------------- Battery " + battery.getImei() + " -----------------------------------------------------------------");
            if (!batteryService.isPresent(battery.getImei())) batteryService.createBattery(battery);
        }

//        Check TL
        worksheet = workbook.getSheetAt(0);
        List<String> tlList = checkTL(worksheet);


        if (tlList.size() == 1) {
            //        Create test
            worksheet = workbook.getSheetAt(0);
            List<TestingModel> testingList = addTest(worksheet);

            for (TestingModel test : testingList) {
                System.out.println("----------------------------------------------------------------- Test " + test.getImei() + " -----------------------------------------------------------------");
                testingService.createTest(test);
            }
        }

        return new ResponseEntity<>(tlList, status);
    }

    public List<ArticleModel> addArticle(XSSFSheet worksheet) {
        List<ArticleModel> articleList = new ArrayList<>();
        for (int index = 0; index < worksheet.getPhysicalNumberOfRows() + 1; index++) {
            if (index > 0) {
                ArticleModel article = new ArticleModel();

                XSSFRow row = worksheet.getRow(index);

                System.out.println("----------------------------------------------------------------- ROW " + row.getRowNum() + " -----------------------------------------------------------------");

                article.setModel(row.getCell(3).getStringCellValue());
                article.setGb((int) row.getCell(4).getNumericCellValue());
                article.setGrade_sup(row.getCell(5).getStringCellValue());


                if (!articleService.articleAlreadyExist(article.getModel(), article.getGb(), article.getGrade_sup())) {
                    if (!articleList.contains(article)) articleList.add(article);
                }
            }
        }

        return articleList;
    }

    public List<OrderModel> addOrder(XSSFSheet worksheet) {
        List<OrderModel> orderList = new ArrayList<>();

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows() + 1; index++) {
            if (index > 0) {
                OrderModel order = new OrderModel();

                XSSFRow row = worksheet.getRow(index);

                System.out.println("----------------------------------------------------------------- ROW " + row.getRowNum() + " -----------------------------------------------------------------");

                ArticleModel article = articleService.findIdArticle(row.getCell(3).getStringCellValue(), (int) row.getCell(4).getNumericCellValue(), row.getCell(5).getStringCellValue());
                Long id_supplier = (long) row.getCell(1).getNumericCellValue();
                String date = row.getCell(7).getLocalDateTimeCellValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                Long number_order = (long) row.getCell(2).getNumericCellValue();

                order.setId_article(article.getId());
                order.setId_supplier(id_supplier);
                order.setDate(date);
                order.setNumber_order(number_order);

                OptionalInt indexOptional = IntStream.range(0, orderList.size())
                        .filter(i -> orderList.get(i).getId_article().equals(order.getId_article()))
                        .filter(i -> orderList.get(i).getDate().equals(order.getDate()))
                        .filter(i -> orderList.get(i).getNumber_order().equals(order.getNumber_order()))
                        .filter(i -> orderList.get(i).getId_supplier().equals(order.getId_supplier()))
                        .findFirst();

                if (indexOptional.isPresent()) {
                    //replace order qty;
                    OrderModel newOrder = new OrderModel();

                    newOrder.setId_article(article.getId());
                    newOrder.setId_supplier(id_supplier);
                    newOrder.setDate(date);
                    newOrder.setNumber_order(number_order);
                    newOrder.setQty(orderList.get(indexOptional.getAsInt()).getQty() + 1);
                    newOrder.setInit_qty(orderList.get(indexOptional.getAsInt()).getInit_qty() + 1);

                    orderList.remove(orderList.get(indexOptional.getAsInt()));
                    orderList.add(newOrder);
                } else {
                    order.setQty(1);
                    order.setInit_qty(1);
                    orderList.add(order);
                }


            }
        }
        return orderList;
    }

    public List<PhoneModel> addPhone(XSSFSheet worksheet) {
        List<PhoneModel> phoneList = new ArrayList<>();

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows() + 1; index++) {
            if (index > 0) {
                PhoneModel phone = new PhoneModel();
                XSSFRow row = worksheet.getRow(index);

                System.out.println("----------------------------------------------------------------- ROW " + row.getRowNum() + " -----------------------------------------------------------------");

                ArticleModel article = articleService.findIdArticle(row.getCell(3).getStringCellValue(), (int) row.getCell(4).getNumericCellValue(), row.getCell(5).getStringCellValue());
                Long number_order = (long) row.getCell(2).getNumericCellValue();
                Long id_supplier = (long) row.getCell(1).getNumericCellValue();
                String color = row.getCell(9).getStringCellValue();
                String grade = row.getCell(5).getStringCellValue();
                Long imei = (long) row.getCell(0).getNumericCellValue();

                phone.setId_article(Math.toIntExact(article.getId()));
                phone.setModel(article.getModel());
                phone.setGb(article.getGb());
                phone.setOrder_number(number_order);
                phone.setId_supplier(id_supplier);
                phone.setColor(color);
                phone.setSku(phone.getModel().substring(7).replaceAll(" ", "").toUpperCase() + phone.getGb() + phone.getColor().replaceAll(" ", "").toUpperCase() + grade);
                phone.setImei(imei);

                if (!phoneService.isPresent(phone.getImei())) if (!phoneList.contains(phone)) phoneList.add(phone);

            }
        }
        return phoneList;
    }

    public List<GradeModel> addGrade(XSSFSheet worksheet) {
        List<GradeModel> gradeList = new ArrayList<>();

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows() + 1; index++) {
            if (index > 0) {
                GradeModel grade = new GradeModel();
                XSSFRow row = worksheet.getRow(index);

                System.out.println("----------------------------------------------------------------- ROW " + row.getRowNum() + " -----------------------------------------------------------------");

                Long imei = (long) row.getCell(0).getNumericCellValue();
                String grade_sup = row.getCell(5).getStringCellValue();
                String grade_check = row.getCell(10).getStringCellValue();

                grade.setImei(imei);
                grade.setGrade_sup(grade_sup);
                grade.setGrade_check(grade_check);

                if (!gradeService.isPresent(grade.getImei())) if (!gradeList.contains(grade)) gradeList.add(grade);
            }
        }

        return gradeList;
    }

    public List<StatusModel> addStatus(XSSFSheet worksheet) {
        List<StatusModel> statusList = new ArrayList<>();

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows() + 1; index++) {
            if (index > 0) {
                StatusModel status = new StatusModel();
                XSSFRow row = worksheet.getRow(index);

                System.out.println("----------------------------------------------------------------- ROW " + row.getRowNum() + " -----------------------------------------------------------------");

                Long imei = (long) row.getCell(0).getNumericCellValue();
                Date date = row.getCell(7).getDateCellValue();
                String operator = row.getCell(8).getStringCellValue();
                String send_to = null;
                if (Objects.equals(row.getCell(25).getStringCellValue(), "TO REFURB")) {
                    send_to = "FIXING";
                } else if (Objects.equals(row.getCell(25).getStringCellValue(), "MARKET READY")) {
                    send_to = "PACKING";
                }

                status.setImei(imei);
                status.setActual_status("ITC");
                status.setSend_to(send_to);
                status.setDate(date);
                status.setOperator(operator);

                if (!statusService.isPresent(imei)) if (!statusList.contains(status)) statusList.add(status);
            }
        }

        return statusList;
    }

    public List<BatteryModel> addBattery(XSSFSheet worksheet) {
        List<BatteryModel> batteryList = new ArrayList<>();

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows() + 1; index++) {
            if (index > 0) {
                BatteryModel battery = new BatteryModel();
                XSSFRow row = worksheet.getRow(index);

                System.out.println("----------------------------------------------------------------- ROW " + row.getRowNum() + " -----------------------------------------------------------------");

                Long imei = (long) row.getCell(0).getNumericCellValue();
                Date date = row.getCell(7).getDateCellValue();
                int soh = (int) row.getCell(21).getNumericCellValue();
                int cycles = (int) row.getCell(22).getNumericCellValue();
                boolean replace = Objects.equals(row.getCell(24).getStringCellValue(), "REPLACE");

                battery.setImei(imei);
                battery.setDate(date);
                battery.setSoh(soh);
                battery.setCycles(cycles);
                battery.setReplace(replace);

                if (!batteryList.contains(battery)) batteryList.add(battery);
            }
        }

        return batteryList;
    }

    public List<String> checkTL(XSSFSheet worksheet) {
        List<String> tlList = new ArrayList<>();

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows() + 1; index++) {
            if (index > 0) {
                XSSFRow row = worksheet.getRow(index);

                System.out.println("----------------------------------------------------------------- ROW " + row.getRowNum() + " -----------------------------------------------------------------");

                for (int i = 11; i < 19; i++) {
                    if (row.getCell(i) != null) {
                        String issueTL = row.getCell(i).getStringCellValue();
                        if (issueTL.startsWith("TL8P")) issueTL = "TL8P";
                        if (!issueListService.findByTl(issueTL))
                            if (!tlList.contains(issueTL)) {
                                tlList.add(issueTL);
                            }
                    }
                }
            }
        }

        return tlList;
    }

    public List<TestingModel> addTest(XSSFSheet worksheet) {
        List<TestingModel> testList = new ArrayList<>();

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows() + 1; index++) {
            if (index > 0) {
                TestingModel test = new TestingModel();
                XSSFRow row = worksheet.getRow(index);

                System.out.println("----------------------------------------------------------------- ROW " + row.getRowNum() + " -----------------------------------------------------------------");

                String operator = row.getCell(8).getStringCellValue();
                Long imei = (long) row.getCell(0).getNumericCellValue();
                Date date = row.getCell(7).getDateCellValue();

                test.setImei(imei);
                test.setDate(date);
                test.setOperator(operator);

                if (!testList.contains(test)) {
                    for (int i = 11; i < 21; i++) {
                        if (row.getCell(i) != null) {
                            String issueTL = row.getCell(i).getStringCellValue();
                            if (issueTL.startsWith("TL8P")) issueTL = "TL8P";
                            if (issueTL.equals("TL0")) test.setTL0(true);
                            if (issueTL.equals("TL1")) test.setTL1(true);
                            if (issueTL.equals("TL2")) test.setTL2(true);
                            if (issueTL.equals("TL2T")) test.setTL2T(true);
                            if (issueTL.equals("TL4")) test.setTL4(true);
                            if (issueTL.equals("TL5")) test.setTL5(true);
                            if (issueTL.equals("TL5A")) test.setTL5A(true);
                            if (issueTL.equals("TL5B")) test.setTL5B(true);
                            if (issueTL.equals("TL8")) test.setTL8(true);
                            if (issueTL.equals("TL8P")) test.setTL8P(true);
                            if (issueTL.equals("TL9")) test.setTL9(true);
                            if (issueTL.equals("TL9T")) test.setTL9T(true);
                            if (issueTL.equals("TL10")) test.setTL10(true);
                            if (issueTL.equals("TL10G")) test.setTL10G(true);
                            if (issueTL.equals("TL10T")) test.setTL10T(true);
                            if (issueTL.equals("TL11")) test.setTL11(true);
                            if (issueTL.equals("TL11G")) test.setTL11G(true);
                            if (issueTL.equals("TL12")) test.setTL12(true);
                            if (issueTL.equals("TL13")) test.setTL13(true);
                            if (issueTL.equals("TL14")) test.setTL14(true);
                            if (issueTL.equals("TL14P")) test.setTL14P(true);
                            if (issueTL.equals("TL14A")) test.setTL14A(true);
                            if (issueTL.equals("TL14B")) test.setTL14B(true);
                            if (issueTL.equals("TL14T")) test.setTL14T(true);
                            if (issueTL.equals("TL15")) test.setTL15(true);
                            if (issueTL.equals("TL16")) test.setTL16(true);
                            if (issueTL.equals("TL17")) test.setTL17(true);
                            if (issueTL.equals("TL18")) test.setTL18(true);
                            if (issueTL.equals("TL19")) test.setTL19(true);
                            if (issueTL.equals("TL19A")) test.setTL19A(true);
                            if (issueTL.equals("TL21")) test.setTL21(true);
                            if (issueTL.equals("TL22")) test.setTL22(true);
                            if (issueTL.equals("TL22T")) test.setTL22T(true);
                            if (issueTL.equals("TL24")) test.setTL24(true);
                            if (issueTL.equals("TL26")) test.setTL26(true);
                            if (issueTL.equals("TL26T")) test.setTL26T(true);
                            if (issueTL.equals("TL27")) test.setTL27(true);
                            if (issueTL.equals("TL27T")) test.setTL27T(true);
                            if (issueTL.equals("TL28")) test.setTL28(true);
                            if (issueTL.equals("TL28T")) test.setTL28T(true);
                            if (issueTL.equals("TL29")) test.setTL29(true);
                            if (issueTL.equals("TL29A")) test.setTL29A(true);
                            if (issueTL.equals("TL29B")) test.setTL29B(true);
                            if (issueTL.equals("TL29C")) test.setTL29C(true);
                            if (issueTL.equals("TL30")) test.setTL30(true);
                            if (issueTL.equals("TL32")) test.setTL32(true);
                            if (issueTL.equals("TL36")) test.setTL36(true);
                            if (issueTL.equals("TL36T")) test.setTL36T(true);
                            if (issueTL.equals("TL37")) test.setTL37(true);
                            if (issueTL.equals("TL38")) test.setTL38(true);
                            if (issueTL.equals("TL39")) test.setTL39(true);
                            if (issueTL.equals("TL40")) test.setTL40(true);
                            if (issueTL.equals("TL41")) test.setTL41(true);
                            if (issueTL.equals("TL42")) test.setTL42(true);
                            if (issueTL.equals("TL42A")) test.setTL42A(true);
                        }
                    }
                    testList.add(test);
                }
            }
        }


        return testList;
    }

    @RequestMapping(value = "/import-supply", method = RequestMethod.POST)
    public ResponseEntity<List<OrderModel>> importSupply(@RequestParam("file") MultipartFile files) throws IOException {
        HttpStatus status = HttpStatus.OK;
        List<OrderModel> orderList = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                OrderModel order = new OrderModel();

                XSSFRow row = worksheet.getRow(index);

                System.out.println("----------------------------------------------------------------- ROW " + row.getRowNum() + " -----------------------------------------------------------------");

                String model = row.getCell(5).getStringCellValue();
                int gb = (int) row.getCell(6).getNumericCellValue();
                String grade_sup = row.getCell(7).getStringCellValue();

                String tracking;
                String courier;

                if (row.getCell(14) != null) {
                    tracking = row.getCell(14).getStringCellValue();
                } else {
                    tracking = "";
                }

                if (row.getCell(13) != null) {
                    courier = row.getCell(13).getStringCellValue();
                } else {
                    courier = "";
                }

                order.setSup_order_number(row.getCell(0).getStringCellValue());
                order.setId_supplier((long) row.getCell(3).getNumericCellValue());
                order.setNumber_order((long) row.getCell(4).getNumericCellValue());
                order.setId_article(articleService.findIdArticle(model, gb, grade_sup).getId());
                order.setPrice(row.getCell(10).getNumericCellValue());
                order.setCourier(courier);
                order.setTracking(tracking);

                if (!orderList.contains(order) && order.getNumber_order() < 44) orderList.add(order);

                orderList.add(order);
            }
        }

        for (OrderModel order : orderList) {
            orderService.updateSupOrderNumber(order.getNumber_order(), order.getSup_order_number());
            orderService.updateTracking(order.getNumber_order(), order.getTracking());
            orderService.updateCourier(order.getNumber_order(), order.getCourier());
            orderService.updatePrice(order.getNumber_order(), order.getId_article(), order.getPrice());
        }

        return new ResponseEntity<>(orderList, status);
    }

    @RequestMapping(value = "/import-testing", method = RequestMethod.POST)
    public ResponseEntity<List<TestingModel>> importTesting(@RequestParam("file") MultipartFile files) throws IOException {
        HttpStatus status = HttpStatus.OK;
        List<TestingModel> testingList = new ArrayList<>();
        List<StatusModel> statusList = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {
                StatusModel statusModel = new StatusModel();
                TestingModel test = new TestingModel();

                XSSFRow row = worksheet.getRow(index);

                System.out.println("----------------------------------------------------------------- ROW " + row.getRowNum() + " -----------------------------------------------------------------");

                Long imei = (long) row.getCell(0).getNumericCellValue();
                Date date = row.getCell(1).getDateCellValue();
                String operator = row.getCell(2).getStringCellValue();
                String send_to = "PACKING";
                if (Objects.equals(row.getCell(2).getStringCellValue(), "NO PASS")) send_to = "FIXING";
                statusModel.setActual_status("TESTING");
                statusModel.setImei(imei);
                statusModel.setDate(date);
                statusModel.setOperator(operator);
                statusModel.setSend_to(send_to);

                if (!statusList.contains(statusModel)) statusList.add(statusModel);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                calendar.add(Calendar.HOUR_OF_DAY, 1);
                test.setImei(imei);
                test.setDate(calendar.getTime());
                test.setOperator(operator);

                for (int i = 3; i < 13; i++) {
                    if (row.getCell(i) != null) {
                        String issueTL = row.getCell(i).getStringCellValue();
                        if (issueTL.startsWith("TL8P")) issueTL = "TL8P";
                        if (issueTL.equals("TL0")) test.setTL0(true);
                        if (issueTL.equals("TL1")) test.setTL1(true);
                        if (issueTL.equals("TL2")) test.setTL2(true);
                        if (issueTL.equals("TL2T")) test.setTL2T(true);
                        if (issueTL.equals("TL4")) test.setTL4(true);
                        if (issueTL.equals("TL5")) test.setTL5(true);
                        if (issueTL.equals("TL5A")) test.setTL5A(true);
                        if (issueTL.equals("TL5B")) test.setTL5B(true);
                        if (issueTL.equals("TL8")) test.setTL8(true);
                        if (issueTL.equals("TL8P")) test.setTL8P(true);
                        if (issueTL.equals("TL9")) test.setTL9(true);
                        if (issueTL.equals("TL9T")) test.setTL9T(true);
                        if (issueTL.equals("TL10")) test.setTL10(true);
                        if (issueTL.equals("TL10G")) test.setTL10G(true);
                        if (issueTL.equals("TL10T")) test.setTL10T(true);
                        if (issueTL.equals("TL11")) test.setTL11(true);
                        if (issueTL.equals("TL11G")) test.setTL11G(true);
                        if (issueTL.equals("TL12")) test.setTL12(true);
                        if (issueTL.equals("TL13")) test.setTL13(true);
                        if (issueTL.equals("TL14")) test.setTL14(true);
                        if (issueTL.equals("TL14P")) test.setTL14P(true);
                        if (issueTL.equals("TL14A")) test.setTL14A(true);
                        if (issueTL.equals("TL14B")) test.setTL14B(true);
                        if (issueTL.equals("TL14T")) test.setTL14T(true);
                        if (issueTL.equals("TL15")) test.setTL15(true);
                        if (issueTL.equals("TL16")) test.setTL16(true);
                        if (issueTL.equals("TL17")) test.setTL17(true);
                        if (issueTL.equals("TL18")) test.setTL18(true);
                        if (issueTL.equals("TL19")) test.setTL19(true);
                        if (issueTL.equals("TL19A")) test.setTL19A(true);
                        if (issueTL.equals("TL21")) test.setTL21(true);
                        if (issueTL.equals("TL22")) test.setTL22(true);
                        if (issueTL.equals("TL22T")) test.setTL22T(true);
                        if (issueTL.equals("TL24")) test.setTL24(true);
                        if (issueTL.equals("TL26")) test.setTL26(true);
                        if (issueTL.equals("TL26T")) test.setTL26T(true);
                        if (issueTL.equals("TL27")) test.setTL27(true);
                        if (issueTL.equals("TL27T")) test.setTL27T(true);
                        if (issueTL.equals("TL28")) test.setTL28(true);
                        if (issueTL.equals("TL28T")) test.setTL28T(true);
                        if (issueTL.equals("TL29")) test.setTL29(true);
                        if (issueTL.equals("TL29A")) test.setTL29A(true);
                        if (issueTL.equals("TL29B")) test.setTL29B(true);
                        if (issueTL.equals("TL29C")) test.setTL29C(true);
                        if (issueTL.equals("TL30")) test.setTL30(true);
                        if (issueTL.equals("TL32")) test.setTL32(true);
                        if (issueTL.equals("TL36")) test.setTL36(true);
                        if (issueTL.equals("TL36T")) test.setTL36T(true);
                        if (issueTL.equals("TL37")) test.setTL37(true);
                        if (issueTL.equals("TL38")) test.setTL38(true);
                        if (issueTL.equals("TL39")) test.setTL39(true);
                        if (issueTL.equals("TL40")) test.setTL40(true);
                        if (issueTL.equals("TL41")) test.setTL41(true);
                        if (issueTL.equals("TL42")) test.setTL42(true);
                        if (issueTL.equals("TL42A")) test.setTL42A(true);
                    }
                }
                if (!testingList.contains(test)) testingList.add(test);
            }
        }

        statusList.forEach(statusService::createStatus);
        testingList.forEach(testingService::createTest);

        return null;
    }
}



