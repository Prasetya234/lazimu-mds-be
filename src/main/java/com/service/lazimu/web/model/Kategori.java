package com.service.lazimu.web.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "kategoris")
public class Kategori {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", columnDefinition = "VARCHAR(255)", unique=true)
    private String kategoriId;

    @Column(name = "kategori_name", nullable = false)
    private String kategoriName;

    public Kategori() {
    }

    public String getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(String kategoriId) {
        this.kategoriId = kategoriId;
    }

    public String getKategoriName() {
        return kategoriName;
    }

    public void setKategoriName(String kategoriName) {
        this.kategoriName = kategoriName;
    }

    @Override
    public String toString() {
        return "Kategori{" +
                "kategoriId='" + kategoriId + '\'' +
                ", kategoriName='" + kategoriName + '\'' +
                '}';
    }
}
