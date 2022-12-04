package com.service.lazimu.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "beritaes")
public class Berita {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "user_id", columnDefinition = "VARCHAR(255)", unique=true)
    private String id;

    @Column(name = "judul", nullable = false)
    private String judul;

    @JsonSerialize
    @JsonDeserialize
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "create_date")
    private Date createdDate;

    @Column(name = "author", nullable = false)
    private String author;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "image", nullable = false)
    private  String image;

    @Column(name = "kategori")
    private String kategori;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "kategori_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Kategori kategoriId;

    public Berita() {
    }

    public Berita(String judul, Date createdDate, String author, String image, String kategori) {
        this.judul = judul;
        this.createdDate = createdDate;
        this.author = author;
        this.image = image;
        this.kategori = kategori;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Kategori getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(Kategori kategoriId) {
        this.kategoriId = kategoriId;
    }


    @Override
    public String toString() {
        return "Berita{" +
                "id='" + id + '\'' +
                ", judul='" + judul + '\'' +
                ", createdDate=" + createdDate +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", kategori='" + kategori + '\'' +
                ", kategoriId=" + kategoriId +
                '}';
    }
}
