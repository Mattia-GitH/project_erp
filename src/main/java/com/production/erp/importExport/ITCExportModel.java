package com.production.erp.importExport;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class ITCExportModel {
    private Long imei;
    private String supplier;
    private Long order_number;
    private String model;
    private int gb;
    private String grade_supplier;
    private String sku;
    private Date date;
    private String operator;
    private String color;
    private String grade_check;
    private String firstTL;
    private String secondTL;
    private String thirdTL;
    private String fourthTL;
    private String fifthTL;
    private String sixthTL;
    private String seventhTL;
    private String eighthTL;
    private String ninthTL;
    private String tenthTL;
    private int soh;
    private int cycles;
    private LocalTime fix;

    public ITCExportModel() {
    }

    public ITCExportModel(Long imei, String supplier, Long order_number, String model, int gb, String grade_supplier, String sku, String color, String grade_check) {
        this.imei = imei;
        this.supplier = supplier;
        this.order_number = order_number;
        this.model = model;
        this.gb = gb;
        this.grade_supplier = grade_supplier;
        this.sku = sku;
        this.color = color;
        this.grade_check = grade_check;
    }

    public ITCExportModel(Long imei, String supplier, Long order_number, String model, int gb, String grade_supplier, String sku, Date date, String operator, String color, String grade_check, String firstTL, String secondTL, String thirdTL, String fourthTL, String fifthTL, String sixthTL, String seventhTL, String eighthTL, String ninthTL, String tenthTL, int soh, int cycles, LocalTime fix) {
        this.imei = imei;
        this.supplier = supplier;
        this.order_number = order_number;
        this.model = model;
        this.gb = gb;
        this.grade_supplier = grade_supplier;
        this.sku = sku;
        this.date = date;
        this.operator = operator;
        this.color = color;
        this.grade_check = grade_check;
        this.firstTL = firstTL;
        this.secondTL = secondTL;
        this.thirdTL = thirdTL;
        this.fourthTL = fourthTL;
        this.fifthTL = fifthTL;
        this.sixthTL = sixthTL;
        this.seventhTL = seventhTL;
        this.eighthTL = eighthTL;
        this.ninthTL = ninthTL;
        this.tenthTL = tenthTL;
        this.soh = soh;
        this.cycles = cycles;
        this.fix = fix;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    public String getGrade_supplier() {
        return grade_supplier;
    }

    public void setGrade_supplier(String grade_supplier) {
        this.grade_supplier = grade_supplier;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGrade_check() {
        return grade_check;
    }

    public void setGrade_check(String grade_check) {
        this.grade_check = grade_check;
    }

    public String getFirstTL() {
        return firstTL;
    }

    public void setFirstTL(String firstTL) {
        this.firstTL = firstTL;
    }

    public String getSecondTL() {
        return secondTL;
    }

    public void setSecondTL(String secondTL) {
        this.secondTL = secondTL;
    }

    public String getThirdTL() {
        return thirdTL;
    }

    public void setThirdTL(String thirdTL) {
        this.thirdTL = thirdTL;
    }

    public String getFourthTL() {
        return fourthTL;
    }

    public void setFourthTL(String fourthTL) {
        this.fourthTL = fourthTL;
    }

    public String getFifthTL() {
        return fifthTL;
    }

    public void setFifthTL(String fifthTL) {
        this.fifthTL = fifthTL;
    }

    public String getSixthTL() {
        return sixthTL;
    }

    public void setSixthTL(String sixthTL) {
        this.sixthTL = sixthTL;
    }

    public String getSeventhTL() {
        return seventhTL;
    }

    public void setSeventhTL(String seventhTL) {
        this.seventhTL = seventhTL;
    }

    public String getEighthTL() {
        return eighthTL;
    }

    public void setEighthTL(String eighthTL) {
        this.eighthTL = eighthTL;
    }

    public String getNinthTL() {
        return ninthTL;
    }

    public void setNinthTL(String ninthTL) {
        this.ninthTL = ninthTL;
    }

    public String getTenthTL() {
        return tenthTL;
    }

    public void setTenthTL(String tenthTL) {
        this.tenthTL = tenthTL;
    }

    public int getSoh() {
        return soh;
    }

    public void setSoh(int soh) {
        this.soh = soh;
    }

    public int getCycles() {
        return cycles;
    }

    public void setCycles(int cycles) {
        this.cycles = cycles;
    }

    public LocalTime getFix() {
        return fix;
    }

    public void setFix(LocalTime fix) {
        this.fix = fix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITCExportModel that = (ITCExportModel) o;
        return gb == that.gb && soh == that.soh && cycles == that.cycles && Objects.equals(imei, that.imei) && Objects.equals(supplier, that.supplier) && Objects.equals(order_number, that.order_number) && Objects.equals(model, that.model) && Objects.equals(grade_supplier, that.grade_supplier) && Objects.equals(sku, that.sku) && Objects.equals(date, that.date) && Objects.equals(operator, that.operator) && Objects.equals(color, that.color) && Objects.equals(grade_check, that.grade_check) && Objects.equals(firstTL, that.firstTL) && Objects.equals(secondTL, that.secondTL) && Objects.equals(thirdTL, that.thirdTL) && Objects.equals(fourthTL, that.fourthTL) && Objects.equals(fifthTL, that.fifthTL) && Objects.equals(sixthTL, that.sixthTL) && Objects.equals(seventhTL, that.seventhTL) && Objects.equals(eighthTL, that.eighthTL) && Objects.equals(ninthTL, that.ninthTL) && Objects.equals(tenthTL, that.tenthTL) && Objects.equals(fix, that.fix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imei, supplier, order_number, model, gb, grade_supplier, sku, date, operator, color, grade_check, firstTL, secondTL, thirdTL, fourthTL, fifthTL, sixthTL, seventhTL, eighthTL, ninthTL, tenthTL, soh, cycles, fix);
    }

    @Override
    public String toString() {
        return "ITCExportModel{" +
                "imei=" + imei +
                ", supplier='" + supplier + '\'' +
                ", order_number=" + order_number +
                ", model='" + model + '\'' +
                ", gb=" + gb +
                ", grade_supplier='" + grade_supplier + '\'' +
                ", sku='" + sku + '\'' +
                ", date=" + date +
                ", operator='" + operator + '\'' +
                ", color='" + color + '\'' +
                ", grade_check='" + grade_check + '\'' +
                ", firstTL='" + firstTL + '\'' +
                ", secondTL='" + secondTL + '\'' +
                ", thirdTL='" + thirdTL + '\'' +
                ", fourthTL='" + fourthTL + '\'' +
                ", fifthTL='" + fifthTL + '\'' +
                ", sixthTL='" + sixthTL + '\'' +
                ", seventhTL='" + seventhTL + '\'' +
                ", eighthTL='" + eighthTL + '\'' +
                ", ninthTL='" + ninthTL + '\'' +
                ", tenthTL='" + tenthTL + '\'' +
                ", soh=" + soh +
                ", cycles=" + cycles +
                ", fix=" + fix +
                '}';
    }
}
