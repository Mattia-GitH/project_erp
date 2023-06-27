package com.production.erp.multiTest;

import java.util.Objects;

public class MultiTestImei {
    private String imei1;
    private String imei2;
    private String imei3;
    private String imei4;

    public MultiTestImei() {
    }

    public MultiTestImei(String imei1, String imei2, String imei3, String imei4) {
        this.imei1 = imei1;
        this.imei2 = imei2;
        this.imei3 = imei3;
        this.imei4 = imei4;
    }

    public String getImei1() {
        return imei1;
    }

    public void setImei1(String imei1) {
        this.imei1 = imei1;
    }

    public String getImei2() {
        return imei2;
    }

    public void setImei2(String imei2) {
        this.imei2 = imei2;
    }

    public String getImei3() {
        return imei3;
    }

    public void setImei3(String imei3) {
        this.imei3 = imei3;
    }

    public String getImei4() {
        return imei4;
    }

    public void setImei4(String imei4) {
        this.imei4 = imei4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultiTestImei multiTestImei = (MultiTestImei) o;
        return Objects.equals(imei1, multiTestImei.imei1) && Objects.equals(imei2, multiTestImei.imei2) && Objects.equals(imei3, multiTestImei.imei3) && Objects.equals(imei4, multiTestImei.imei4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imei1, imei2, imei3, imei4);
    }

    @Override
    public String toString() {
        return "MultiTest{" +
                "imei1=" + imei1 +
                ", imei2=" + imei2 +
                ", imei3=" + imei3 +
                ", imei4=" + imei4 +
                '}';
    }
}
