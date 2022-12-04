package com.service.lazimu.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "infaqes")
public class Infaq {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", columnDefinition = "VARCHAR(255)", unique=true)
    private String id;

    @Column(name = "judul")
    private String judul;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "image")
    private String image;

    @Column(name = "donasi")
    private String donasi;

    @Column(name = "donatur")
    private String donatur;

    @Column(name = "kategori")
    private String kategori;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "kategori_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Kategori kategoriId;

    public Infaq() {
    }

    public Infaq(String judul, String image, String donasi, String donatur, String kategori) {
        this.judul = judul;
        this.image = image;
        this.donasi = donasi;
        this.donatur = donatur;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDonasi() {
        return donasi;
    }

    public void setDonasi(String donasi) {
        this.donasi = donasi;
    }

    public String getDonatur() {
        return donatur;
    }

    public void setDonatur(String donatur) {
        this.donatur = donatur;
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
        return "Infaq{" +
                "id='" + id + '\'' +
                ", judul='" + judul + '\'' +
                ", image='" + image + '\'' +
                ", donasi='" + donasi + '\'' +
                ", donatur='" + donatur + '\'' +
                ", kategori='" + kategori + '\'' +
                ", kategoriId=" + kategoriId +
                '}';
    }
}
