package com.service.lazimu.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InfaqDTO {

    @Size(max = 255, message = "JUDUL MAKSIMAL 255 KARAKTER")
    @NotBlank(message = "JUDUL NOT NULL")
    private String judul;

    @Size(max = 255, message = "IMAGE MAKSIMAL 255 KARAKTER")
    @NotBlank(message = "IMAGE NOT NULL")
    private String image;

    @Size(max = 255, message = "DONASI MAKSIMAL 255 KARAKTER")
    @NotBlank(message = "DONASI NOT NULL")
    private String donasi;

    @Size(max = 255, message = "DONATUR MAKSIMAL 255 KARAKTER")
    @NotBlank(message = "DONATUR NOT NULL")
    private String donatur;

    @Size(max = 255, message = "KATEGORI MAKSIMAL 255 KARAKTER")
    @NotBlank(message = "KATEGORI NOT NULL")
    private String Kategori;

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
        return Kategori;
    }

    public void setKategori(String kategori) {
        Kategori = kategori;
    }
}
