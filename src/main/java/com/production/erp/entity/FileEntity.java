package com.production.erp.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "FILES_TBL")
public class FileEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORDER_NUMBER")
    private Long order_number;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @Lob
    @Column(name = "DATA")
    private byte[] data;

    @Column(name = "FORMAT")
    private String format;

    public FileEntity() {
    }

    public FileEntity(Long id, Long order_number, String name, String type, byte[] data, String format) {
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
        FileEntity that = (FileEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(order_number, that.order_number) && Objects.equals(name, that.name) && Objects.equals(type, that.type) && Arrays.equals(data, that.data) && Objects.equals(format, that.format);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, order_number, name, type, format);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "id=" + id +
                ", order_number=" + order_number +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", data=" + Arrays.toString(data) +
                ", format='" + format + '\'' +
                '}';
    }
}
