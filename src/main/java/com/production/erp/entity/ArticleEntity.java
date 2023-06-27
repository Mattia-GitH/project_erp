package com.production.erp.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ARTICLE_TBL")
public class ArticleEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "GB")
    private int gb;

    @Column(name = "GRADE_SUP")
    private String grade_sup;

    public ArticleEntity() {
    }

    public ArticleEntity(Long id, String model, int gb, String grade_sup) {
        this.id = id;
        this.model = model;
        this.gb = gb;
        this.grade_sup = grade_sup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getGrade_sup() {
        return grade_sup;
    }

    public void setGrade_sup(String grade_sup) {
        this.grade_sup = grade_sup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArticleEntity that = (ArticleEntity) o;
        return gb == that.gb && Objects.equals(id, that.id) && Objects.equals(model, that.model) && Objects.equals(grade_sup, that.grade_sup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, gb, grade_sup);
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", gb=" + gb +
                ", grade_sup='" + grade_sup + '\'' +
                '}';
    }
}
