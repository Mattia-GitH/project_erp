package com.production.erp.analytic;

import java.util.Objects;

public class Analytics {
    String param;
    Long qty;
    String first;
    String last;
    String avgTime;

    public Analytics() {
    }

    public Analytics(String param, Long qty) {
        this.param = param;
        this.qty = qty;
    }

    public Analytics(String param, String avgTime) {
        this.param = param;
        this.avgTime = avgTime;
    }

    public Analytics(String param, String first, String last) {
        this.param = param;
        this.first = first;
        this.last = last;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(String avgTime) {
        this.avgTime = avgTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Analytics analytics = (Analytics) o;
        return Objects.equals(param, analytics.param) && Objects.equals(qty, analytics.qty) && Objects.equals(first, analytics.first) && Objects.equals(last, analytics.last) && Objects.equals(avgTime, analytics.avgTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(param, qty, first, last, avgTime);
    }

    @Override
    public String toString() {
        return "Analytics{" +
                "param='" + param + '\'' +
                ", qty=" + qty +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", avgTime='" + avgTime + '\'' +
                '}';
    }
}
