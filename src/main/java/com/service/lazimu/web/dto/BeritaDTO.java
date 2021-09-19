package com.service.lazimu.web.dto;

import com.service.lazimu.web.model.KeteranganBerita;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;

public class BeritaDTO {

    @Size(max = 255, message = "JUDUL MAKSIMAL 255 KARAKTER")
    @NotBlank(message = "JUDUL NOT NULL")
    private String judul;

    @NotNull(message = "JUDUL NOT NULL")
    private Date createdDate;

    @Size(max = 255, message = "AUTHOR MAKSIMAL 255 KARAKTER")
    @NotBlank(message = "AUTHOR NOT NULL")
    private String author;

    private HashSet<KeteranganBerita> keteranganBerita;

    @NotBlank(message = "IMAGE NOT NULL")
    private String image;

    @NotBlank(message = "KATEGORI NOT NULL")
    private String kategori;

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

    public HashSet<KeteranganBerita> getKeteranganBerita() {
        return keteranganBerita;
    }

    public void setKeteranganBerita(HashSet<KeteranganBerita> keteranganBerita) {
        this.keteranganBerita = keteranganBerita;
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
}
