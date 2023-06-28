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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class OutputExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<OutputExportModel> outputExport;

    public OutputExporter(List<OutputExportModel> outputExport){
        this.outputExport = outputExport;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("OUTPUT");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "imei", style);
        createCell(row, 1, "color", style);
        createCell(row, 2, "grade", style);
        createCell(row, 3, "gb", style);
        createCell(row, 4, "sku", style);
        createCell(row, 5, "date", style);

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

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (OutputExportModel outputRow : outputExport) {
            Row row = sheet.createRow(rowCount++);

            createCell(row,0, outputRow.getImei(), style);
            createCell(row,1, outputRow.getColor(), style);
            createCell(row,2, outputRow.getGrade(), style);
            createCell(row,3, outputRow.getGb(), style);
            createCell(row,4, outputRow.getSku(), style);
            createCell(row,5, outputRow.getDate(), style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.flush();
        outputStream.close();
    }
}
