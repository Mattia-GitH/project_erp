package com.production.erp.model;

import java.util.Date;
import java.util.Objects;

public class ReportModel {
    private Long id;
    private Date date;
    private String reporter;
    private String issue;
    private String operator;
    private Long imei;
    private String phase;


    public ReportModel() {
    }

    public ReportModel(Date date, String reporter, String issue, String operator, Long imei, String phase) {
        this.date = date;
        this.reporter = reporter;
        this.issue = issue;
        this.operator = operator;
        this.imei = imei;
        this.phase = phase;
    }

    public ReportModel(Long id, Date date, String reporter, String issue, String operator, Long imei) {
        this.id = id;
        this.date = date;
        this.reporter = reporter;
        this.issue = issue;
        this.operator = operator;
        this.imei = imei;
    }

    public ReportModel(Date date, String reporter, String issue, String operator, Long imei) {
        this.date = date;
        this.reporter = reporter;
        this.issue = issue;
        this.operator = operator;
        this.imei = imei;
    }

    public ReportModel(Long id, Date date, String reporter, String issue, String operator, Long imei, String phase) {
        this.id = id;
        this.date = date;
        this.reporter = reporter;
        this.issue = issue;
        this.operator = operator;
        this.imei = imei;
        this.phase = phase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
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

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportModel that = (ReportModel) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(reporter, that.reporter) && Objects.equals(issue, that.issue) && Objects.equals(operator, that.operator) && Objects.equals(imei, that.imei) && Objects.equals(phase, that.phase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, reporter, issue, operator, imei, phase);
    }

    @Override
    public String toString() {
        return "ReportModel{" +
                "id=" + id +
                ", date=" + date +
                ", reporter='" + reporter + '\'' +
                ", issue='" + issue + '\'' +
                ", operator='" + operator + '\'' +
                ", imei=" + imei +
                ", phase='" + phase + '\'' +
                '}';
    }
}
