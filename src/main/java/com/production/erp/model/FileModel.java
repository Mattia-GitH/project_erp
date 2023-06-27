package com.production.erp.model;

import java.util.Arrays;
import java.util.Objects;

public class FileModel {
    private Long id;
    private Long order_number;
    private String name;
    private String type;
    private byte[] data;
    private String format;

    public FileModel() {
    }

    public FileModel(Long id, Long order_number, String name, String type, byte[] data, String format) {
        this.id = id;
        this.order_number = order_number;
        this.name = name;
        this.type = type;
        this.data = data;
        this.format = format;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_number() {
        return order_number;
    }

    public void setOrder_number(Long order_number) {
        this.order_number = order_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileModel fileModel = (FileModel) o;
        return Objects.equals(id, fileModel.id) && Objects.equals(order_number, fileModel.order_number) && Objects.equals(name, fileModel.name) && Objects.equals(type, fileModel.type) && Arrays.equals(data, fileModel.data) && Objects.equals(format, fileModel.format);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, order_number, name, type, format);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "id=" + id +
                ", order_number=" + order_number +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", data=" + Arrays.toString(data) +
                ", format='" + format + '\'' +
                '}';
    }
}
