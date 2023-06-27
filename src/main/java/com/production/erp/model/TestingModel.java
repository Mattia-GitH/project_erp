package com.production.erp.model;

import java.util.Date;
import java.util.Objects;

public class TestingModel {
    private Long id;
    private String operator;
    private Long imei;
    private Date date;
    private String iOS;
    private boolean TL0;
    private boolean TL1;
    private boolean TL2;
    private boolean TL2T;
    private boolean TL4;
    private boolean TL5;
    private boolean TL5A;
    private boolean TL5B;
    private boolean TL8;
    private boolean TL8P;
    private boolean TL9;
    private boolean TL9T;
    private boolean TL10;
    private boolean TL10G;
    private boolean TL10T;
    private boolean TL11G;
    private boolean TL11;
    private boolean TL12;
    private boolean TL13;
    private boolean TL14;
    private boolean TL14P;
    private boolean TL14A;
    private boolean TL14T;
    private boolean TL14B;
    private boolean TL15;
    private boolean TL16;
    private boolean TL17;
    private boolean TL18;
    private boolean TL19;
    private boolean TL19A;
    private boolean TL21;
    private boolean TL22;
    private boolean TL22T;
    private boolean TL24;
    private boolean TL26;
    private boolean TL26T;
    private boolean TL27;
    private boolean TL27T;
    private boolean TL28;
    private boolean TL28T;
    private boolean TL29;
    private boolean TL29A;
    private boolean TL29B;
    private boolean TL29C;
    private boolean TL30;
    private boolean TL32;
    private boolean TL36;
    private boolean TL36T;
    private boolean TL37;
    private boolean TL38;
    private boolean TL39;
    private boolean TL40;
    private boolean TL41;
    private boolean TL42;
    private boolean TL42A;

    public TestingModel() {
    }

    public TestingModel(Long imei, String operator) {
        this.imei = imei;
        this.operator = operator;
    }

    public TestingModel(Long id, String operator, Long imei, Date date, String iOS, boolean TL0, boolean TL1, boolean TL2, boolean TL2T, boolean TL4, boolean TL5, boolean TL5A, boolean TL5B, boolean TL8, boolean TL8P, boolean TL9, boolean TL9T, boolean TL10, boolean TL10G, boolean TL10T, boolean TL11G, boolean TL11, boolean TL12, boolean TL13, boolean TL14, boolean TL14P, boolean TL14A, boolean TL14T, boolean TL14B, boolean TL15, boolean TL16, boolean TL17, boolean TL18, boolean TL19, boolean TL19A, boolean TL21, boolean TL22, boolean TL22T, boolean TL24, boolean TL26, boolean TL26T, boolean TL27, boolean TL27T, boolean TL28, boolean TL28T, boolean TL29, boolean TL29A, boolean TL29B, boolean TL29C, boolean TL30, boolean TL32, boolean TL36, boolean TL36T, boolean TL37, boolean TL38, boolean TL39, boolean TL40, boolean TL41, boolean TL42 , boolean TL42A) {
        this.id = id;
        this.operator = operator;
        this.imei = imei;
        this.date = date;
        this.iOS = iOS;
        this.TL0 = TL0;
        this.TL1 = TL1;
        this.TL2 = TL2;
        this.TL2T = TL2T;
        this.TL4 = TL4;
        this.TL5 = TL5;
        this.TL5A = TL5A;
        this.TL5B = TL5B;
        this.TL8 = TL8;
        this.TL8P = TL8P;
        this.TL9 = TL9;
        this.TL9T = TL9T;
        this.TL10 = TL10;
        this.TL10G = TL10G;
        this.TL10T = TL10T;
        this.TL11G = TL11G;
        this.TL11 = TL11;
        this.TL12 = TL12;
        this.TL13 = TL13;
        this.TL14 = TL14;
        this.TL14P = TL14P;
        this.TL14A = TL14A;
        this.TL14T = TL14T;
        this.TL14B = TL14B;
        this.TL15 = TL15;
        this.TL16 = TL16;
        this.TL17 = TL17;
        this.TL18 = TL18;
        this.TL19 = TL19;
        this.TL19A = TL19A;
        this.TL21 = TL21;
        this.TL22 = TL22;
        this.TL22T = TL22T;
        this.TL24 = TL24;
        this.TL26 = TL26;
        this.TL26T = TL26T;
        this.TL27 = TL27;
        this.TL27T = TL27T;
        this.TL28 = TL28;
        this.TL28T = TL28T;
        this.TL29 = TL29;
        this.TL29A = TL29A;
        this.TL29B = TL29B;
        this.TL29C = TL29C;
        this.TL30 = TL30;
        this.TL32 = TL32;
        this.TL36 = TL36;
        this.TL36T = TL36T;
        this.TL37 = TL37;
        this.TL38 = TL38;
        this.TL39 = TL39;
        this.TL40 = TL40;
        this.TL41 = TL41;
        this.TL42 = TL42;
        this.TL42A = TL42A;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getiOS() {
        return iOS;
    }

    public void setiOS(String iOS) {
        this.iOS = iOS;
    }

    public boolean isTL0() {
        return TL0;
    }

    public void setTL0(boolean TL0) {
        this.TL0 = TL0;
    }

    public boolean isTL1() {
        return TL1;
    }

    public void setTL1(boolean TL1) {
        this.TL1 = TL1;
    }

    public boolean isTL2() {
        return TL2;
    }

    public void setTL2(boolean TL2) {
        this.TL2 = TL2;
    }

    public boolean isTL2T() {
        return TL2T;
    }

    public void setTL2T(boolean TL2T) {
        this.TL2T = TL2T;
    }

    public boolean isTL4() {
        return TL4;
    }

    public void setTL4(boolean TL4) {
        this.TL4 = TL4;
    }

    public boolean isTL5() {
        return TL5;
    }

    public void setTL5(boolean TL5) {
        this.TL5 = TL5;
    }

    public boolean isTL5A() {
        return TL5A;
    }

    public void setTL5A(boolean TL5A) {
        this.TL5A = TL5A;
    }

    public boolean isTL5B() {
        return TL5B;
    }

    public void setTL5B(boolean TL5B) {
        this.TL5B = TL5B;
    }

    public boolean isTL8() {
        return TL8;
    }

    public void setTL8(boolean TL8) {
        this.TL8 = TL8;
    }

    public boolean isTL8P() {
        return TL8P;
    }

    public void setTL8P(boolean TL8P) {
        this.TL8P = TL8P;
    }

    public boolean isTL9() {
        return TL9;
    }

    public void setTL9(boolean TL9) {
        this.TL9 = TL9;
    }

    public boolean isTL9T() {
        return TL9T;
    }

    public void setTL9T(boolean TL9T) {
        this.TL9T = TL9T;
    }

    public boolean isTL10() {
        return TL10;
    }

    public void setTL10(boolean TL10) {
        this.TL10 = TL10;
    }

    public boolean isTL10G() {
        return TL10G;
    }

    public void setTL10G(boolean TL10G) {
        this.TL10G = TL10G;
    }

    public boolean isTL10T() {
        return TL10T;
    }

    public void setTL10T(boolean TL10T) {
        this.TL10T = TL10T;
    }

    public boolean isTL11G() {
        return TL11G;
    }

    public void setTL11G(boolean TL11G) {
        this.TL11G = TL11G;
    }

    public boolean isTL11() {
        return TL11;
    }

    public void setTL11(boolean TL11) {
        this.TL11 = TL11;
    }

    public boolean isTL12() {
        return TL12;
    }

    public void setTL12(boolean TL12) {
        this.TL12 = TL12;
    }

    public boolean isTL13() {
        return TL13;
    }

    public void setTL13(boolean TL13) {
        this.TL13 = TL13;
    }

    public boolean isTL14() {
        return TL14;
    }

    public void setTL14(boolean TL14) {
        this.TL14 = TL14;
    }

    public boolean isTL14P() {
        return TL14P;
    }

    public void setTL14P(boolean TL14P) {
        this.TL14P = TL14P;
    }

    public boolean isTL14A() {
        return TL14A;
    }

    public void setTL14A(boolean TL14A) {
        this.TL14A = TL14A;
    }

    public boolean isTL14T() {
        return TL14T;
    }

    public void setTL14T(boolean TL14T) {
        this.TL14T = TL14T;
    }

    public boolean isTL14B() {
        return TL14B;
    }

    public void setTL14B(boolean TL14B) {
        this.TL14B = TL14B;
    }

    public boolean isTL15() {
        return TL15;
    }

    public void setTL15(boolean TL15) {
        this.TL15 = TL15;
    }

    public boolean isTL16() {
        return TL16;
    }

    public void setTL16(boolean TL16) {
        this.TL16 = TL16;
    }

    public boolean isTL17() {
        return TL17;
    }

    public void setTL17(boolean TL17) {
        this.TL17 = TL17;
    }

    public boolean isTL18() {
        return TL18;
    }

    public void setTL18(boolean TL18) {
        this.TL18 = TL18;
    }

    public boolean isTL19() {
        return TL19;
    }

    public void setTL19(boolean TL19) {
        this.TL19 = TL19;
    }

    public boolean isTL19A() {
        return TL19A;
    }

    public void setTL19A(boolean TL19A) {
        this.TL19A = TL19A;
    }

    public boolean isTL21() {
        return TL21;
    }

    public void setTL21(boolean TL21) {
        this.TL21 = TL21;
    }

    public boolean isTL22() {
        return TL22;
    }

    public void setTL22(boolean TL22) {
        this.TL22 = TL22;
    }

    public boolean isTL22T() {
        return TL22T;
    }

    public void setTL22T(boolean TL22T) {
        this.TL22T = TL22T;
    }

    public boolean isTL24() {
        return TL24;
    }

    public void setTL24(boolean TL24) {
        this.TL24 = TL24;
    }

    public boolean isTL26() {
        return TL26;
    }

    public void setTL26(boolean TL26) {
        this.TL26 = TL26;
    }

    public boolean isTL26T() {
        return TL26T;
    }

    public void setTL26T(boolean TL26T) {
        this.TL26T = TL26T;
    }

    public boolean isTL27() {
        return TL27;
    }

    public void setTL27(boolean TL27) {
        this.TL27 = TL27;
    }

    public boolean isTL27T() {
        return TL27T;
    }

    public void setTL27T(boolean TL27T) {
        this.TL27T = TL27T;
    }

    public boolean isTL28() {
        return TL28;
    }

    public void setTL28(boolean TL28) {
        this.TL28 = TL28;
    }

    public boolean isTL28T() {
        return TL28T;
    }

    public void setTL28T(boolean TL28T) {
        this.TL28T = TL28T;
    }

    public boolean isTL29() {
        return TL29;
    }

    public void setTL29(boolean TL29) {
        this.TL29 = TL29;
    }

    public boolean isTL29A() {
        return TL29A;
    }

    public void setTL29A(boolean TL29A) {
        this.TL29A = TL29A;
    }

    public boolean isTL29B() {
        return TL29B;
    }

    public void setTL29B(boolean TL29B) {
        this.TL29B = TL29B;
    }

    public boolean isTL29C() {
        return TL29C;
    }

    public void setTL29C(boolean TL29C) {
        this.TL29C = TL29C;
    }

    public boolean isTL30() {
        return TL30;
    }

    public void setTL30(boolean TL30) {
        this.TL30 = TL30;
    }

    public boolean isTL32() {
        return TL32;
    }

    public void setTL32(boolean TL32) {
        this.TL32 = TL32;
    }

    public boolean isTL36() {
        return TL36;
    }

    public void setTL36(boolean TL36) {
        this.TL36 = TL36;
    }

    public boolean isTL36T() {
        return TL36T;
    }

    public void setTL36T(boolean TL36T) {
        this.TL36T = TL36T;
    }

    public boolean isTL37() {
        return TL37;
    }

    public void setTL37(boolean TL37) {
        this.TL37 = TL37;
    }

    public boolean isTL38() {
        return TL38;
    }

    public void setTL38(boolean TL38) {
        this.TL38 = TL38;
    }

    public boolean isTL39() {
        return TL39;
    }

    public void setTL39(boolean TL39) {
        this.TL39 = TL39;
    }

    public boolean isTL40() {
        return TL40;
    }

    public void setTL40(boolean TL40) {
        this.TL40 = TL40;
    }

    public boolean isTL41() {
        return TL41;
    }

    public void setTL41(boolean TL41) {
        this.TL41 = TL41;
    }

    public boolean isTL42() {
        return TL42;
    }

    public void setTL42(boolean TL42) {
        this.TL42 = TL42;
    }

    public boolean isTL42A() {
        return TL42A;
    }

    public void setTL42A(boolean TL42A) {
        this.TL42A = TL42A;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestingModel that = (TestingModel) o;
        return TL0 == that.TL0 && TL1 == that.TL1 && TL2 == that.TL2 && TL2T == that.TL2T && TL4 == that.TL4 && TL5 == that.TL5 && TL5A == that.TL5A && TL5B == that.TL5B && TL8 == that.TL8 && TL8P == that.TL8P && TL9 == that.TL9 && TL9T == that.TL9T && TL10 == that.TL10 && TL10G == that.TL10G && TL10T == that.TL10T && TL11G == that.TL11G && TL11 == that.TL11 && TL12 == that.TL12 && TL13 == that.TL13 && TL14 == that.TL14 && TL14P == that.TL14P && TL14A == that.TL14A && TL14T == that.TL14T && TL14B == that.TL14B && TL15 == that.TL15 && TL16 == that.TL16 && TL17 == that.TL17 && TL18 == that.TL18 && TL19 == that.TL19 && TL19A == that.TL19A && TL21 == that.TL21 && TL22 == that.TL22 && TL22T == that.TL22T && TL24 == that.TL24 && TL26 == that.TL26 && TL26T == that.TL26T && TL27 == that.TL27 && TL27T == that.TL27T && TL28 == that.TL28 && TL28T == that.TL28T && TL29 == that.TL29 && TL29A == that.TL29A && TL29B == that.TL29B && TL29C == that.TL29C && TL30 == that.TL30 && TL32 == that.TL32 && TL36 == that.TL36 && TL36T == that.TL36T && TL37 == that.TL37 && TL38 == that.TL38 && TL39 == that.TL39 && TL40 == that.TL40 && TL41 == that.TL41 && TL42 == that.TL42 && TL42A == that.TL42A && Objects.equals(id, that.id) && Objects.equals(operator, that.operator) && Objects.equals(imei, that.imei) && Objects.equals(date, that.date) && Objects.equals(iOS, that.iOS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, operator, imei, date, iOS, TL0, TL1, TL2, TL2T, TL4, TL5, TL5A, TL5B, TL8, TL8P, TL9, TL9T, TL10, TL10G, TL10T, TL11G, TL11, TL12, TL13, TL14, TL14P, TL14A, TL14T, TL14B, TL15, TL16, TL17, TL18, TL19, TL19A, TL21, TL22, TL22T, TL24, TL26, TL26T, TL27, TL27T, TL28, TL28T, TL29, TL29A, TL29B, TL29C, TL30, TL32, TL36, TL36T, TL37, TL38, TL39, TL40, TL41, TL42, TL42A);
    }

    @Override
    public String toString() {
        return "TestingModel{" +
                "id=" + id +
                ", operator='" + operator + '\'' +
                ", imei=" + imei +
                ", date=" + date +
                ", iOS='" + iOS + '\'' +
                ", TL0=" + TL0 +
                ", TL1=" + TL1 +
                ", TL2=" + TL2 +
                ", TL2T=" + TL2T +
                ", TL4=" + TL4 +
                ", TL5=" + TL5 +
                ", TL5A=" + TL5A +
                ", TL5B=" + TL5B +
                ", TL8=" + TL8 +
                ", TL8P=" + TL8P +
                ", TL9=" + TL9 +
                ", TL9T=" + TL9T +
                ", TL10=" + TL10 +
                ", TL10G=" + TL10G +
                ", TL10T=" + TL10T +
                ", TL11G=" + TL11G +
                ", TL11=" + TL11 +
                ", TL12=" + TL12 +
                ", TL13=" + TL13 +
                ", TL14=" + TL14 +
                ", TL14P=" + TL14P +
                ", TL14A=" + TL14A +
                ", TL14T=" + TL14T +
                ", TL14B=" + TL14B +
                ", TL15=" + TL15 +
                ", TL16=" + TL16 +
                ", TL17=" + TL17 +
                ", TL18=" + TL18 +
                ", TL19=" + TL19 +
                ", TL19A=" + TL19A +
                ", TL21=" + TL21 +
                ", TL22=" + TL22 +
                ", TL22T=" + TL22T +
                ", TL24=" + TL24 +
                ", TL26=" + TL26 +
                ", TL26T=" + TL26T +
                ", TL27=" + TL27 +
                ", TL27T=" + TL27T +
                ", TL28=" + TL28 +
                ", TL28T=" + TL28T +
                ", TL29=" + TL29 +
                ", TL29A=" + TL29A +
                ", TL29B=" + TL29B +
                ", TL29C=" + TL29C +
                ", TL30=" + TL30 +
                ", TL32=" + TL32 +
                ", TL36=" + TL36 +
                ", TL36T=" + TL36T +
                ", TL37=" + TL37 +
                ", TL38=" + TL38 +
                ", TL39=" + TL39 +
                ", TL40=" + TL40 +
                ", TL41=" + TL41 +
                ", TL42=" + TL42 +
                ", TL42A=" + TL42A +
                '}';
    }
}
