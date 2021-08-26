package com.service.lazimu.web.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class BeritaDTO {

    @Size(max = 255, message = "JUDUL MAKSIMAL 255 KARAKTER")
    @NotBlank(message = "JUDUL NOT NULL")
    private String judul;

    @NotNull(message = "JUDUL NOT NULL")
    private Date createdDate;

    @Size(max = 255, message = "AUTHOR MAKSIMAL 255 KARAKTER")
    @NotBlank(message = "AUTHOR NOT NULL")
    private String author;

    @NotBlank(message = "KETERANGAN NOT NULL")
    private String keterangan;

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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
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
