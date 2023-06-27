package com.production.erp.importExport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;


public class ITCExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<ITCExportModel> itcExportModels;

    public ITCExporter(List<ITCExportModel> itcExportModels) {
        this.itcExportModels = itcExportModels;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("ITC");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "imei", style);
        createCell(row, 1, "supplier", style);
        createCell(row, 2, "order number", style);
        createCell(row, 3, "model", style);
        createCell(row, 4, "gb", style);
        createCell(row, 5, "grade", style);
        createCell(row, 6, "sku", style);
        createCell(row, 7, "date", style);
        createCell(row, 8, "operator", style);
        createCell(row, 9, "color", style);
        createCell(row, 10, "grade check", style);
        createCell(row, 11, "1°TL", style);
        createCell(row, 12, "2°TL", style);
        createCell(row, 13, "3°TL", style);
        createCell(row, 14, "4°TL", style);
        createCell(row, 15, "5°TL", style);
        createCell(row, 16, "6°TL", style);
        createCell(row, 17, "7°TL", style);
        createCell(row, 18, "8°TL", style);
        createCell(row, 19, "9°TL", style);
        createCell(row, 20, "10°TL", style);
        createCell(row, 21, "SoH", style);
        createCell(row, 22, "Cycles", style);
        createCell(row, 28, "Time", style);
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Timestamp) {
            cell.setCellValue((Timestamp) value);
        } else if (value instanceof LocalDate) {
            cell.setCellValue((LocalDate) value);
        } else if (value instanceof LocalTime) {
            cell.setCellValue(LocalDateTime.from((LocalTime) value));
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() throws ParseException {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        LocalDate date = LocalDate.now().minusDays(1);

        Date formatter = new SimpleDateFormat("yyyy-MM-dd").parse(date.toString());

        for (ITCExportModel itcRow : itcExportModels) {
            Row row = sheet.createRow(rowCount++);
            System.out.println(itcRow);
            String sDate;

            if (itcRow.getDate() == null) {
                sDate = "";
                itcRow.setDate(new Date());
            } else {
                sDate = itcRow.getDate().toString();
            }

            System.out.println(rowCount);
                    LocalTime fix = itcRow.getFix();
                    if (fix == null) {
                        fix = LocalTime.now();
                    }
                    if (itcRow.getImei() == null) {
                        itcRow.setImei(222222222222222L);
                    }
                    if (itcRow.getSupplier() == null) {
                        itcRow.setSupplier("");
                    }
                    if (itcRow.getOperator() == null) {
                        itcRow.setOperator("");
                    }
                    if (itcRow.getOrder_number() == null) {
                        itcRow.setOrder_number(404L);
                    }
                    if (itcRow.getGb() == 0) {
                        itcRow.setGb(0);
                    }
                    if (itcRow.getModel() == null) {
                        itcRow.setModel("");
                    }
                    if (itcRow.getSku() == null) {
                        itcRow.setSku("");
                    }
                    if (itcRow.getColor() == null) {
                        itcRow.setColor("");
                    }
                    if (itcRow.getGrade_supplier() == null) {
                        itcRow.setGrade_supplier("");
                    }
                    if (itcRow.getGrade_check() == null) {
                        itcRow.setGrade_check("");
                    }
                    if (itcRow.getFirstTL() == null) {
                        itcRow.setFirstTL("");
                    }
                    if (itcRow.getSecondTL() == null) {
                        itcRow.setSecondTL("");
                    }
                    if (itcRow.getThirdTL() == null) {
                        itcRow.setThirdTL("");
                    }
                    if (itcRow.getFourthTL() == null) {
                        itcRow.setFourthTL("");
                    }
                    if (itcRow.getFifthTL() == null) {
                        itcRow.setFifthTL("");
                    }
                    if (itcRow.getSixthTL() == null) {
                        itcRow.setSixthTL("");
                    }
                    if (itcRow.getSeventhTL() == null) {
                        itcRow.setSeventhTL("");
                    }
                    if (itcRow.getEighthTL() == null) {
                        itcRow.setEighthTL("");
                    }
                    if (itcRow.getNinthTL() == null) {
                        itcRow.setNinthTL("");
                    }
                    if (itcRow.getTenthTL() == null) {
                        itcRow.setTenthTL("");
                    }
                    if (itcRow.getSoh() == 0) {
                        itcRow.setSoh(0);
                    }
                    if (itcRow.getCycles() == 0) {
                        itcRow.setCycles(0);
                    }
                    if (itcRow.getFix() == null) {
                        itcRow.setFix(LocalTime.now());
                    }

                    System.out.println(itcRow);

                    createCell(row, 0, itcRow.getImei(), style);
                    createCell(row, 1, itcRow.getSupplier(), style);
                    createCell(row, 2, "000" + itcRow.getOrder_number() + "/23", style);//     000X/23
                    createCell(row, 3, itcRow.getModel(), style);
                    createCell(row, 4, itcRow.getGb(), style);
                    createCell(row, 5, itcRow.getGrade_supplier(), style);
                    createCell(row, 6, itcRow.getSku(), style);
                    createCell(row, 7, sDate, style);
                    createCell(row, 8, itcRow.getOperator(), style);
                    createCell(row, 9, itcRow.getColor(), style);
                    createCell(row, 10, itcRow.getGrade_check(), style);
                    createCell(row, 11, itcRow.getFirstTL(), style);
                    createCell(row, 12, itcRow.getSecondTL(), style);
                    createCell(row, 13, itcRow.getThirdTL(), style);
                    createCell(row, 14, itcRow.getFourthTL(), style);
                    createCell(row, 15, itcRow.getFifthTL(), style);
                    createCell(row, 16, itcRow.getSixthTL(), style);
                    createCell(row, 17, itcRow.getSeventhTL(), style);
                    createCell(row, 18, itcRow.getEighthTL(), style);
                    createCell(row, 19, itcRow.getNinthTL(), style);
                    createCell(row, 20, itcRow.getTenthTL(), style);
                    createCell(row, 21, itcRow.getSoh(), style);
                    createCell(row, 22, itcRow.getCycles(), style);
                    createCell(row, 28, fix.toString(), style);
                }
    }

    public void export(HttpServletResponse response) throws IOException, ParseException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }


}
