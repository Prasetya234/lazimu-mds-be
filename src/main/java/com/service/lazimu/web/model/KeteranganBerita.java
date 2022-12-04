package com.service.lazimu.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "Keterangan_beritaes")
public class KeteranganBerita {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", unique=true)
    private String id;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    @Column(name = "keterangan")
    private String keteranganBerita;

    @Column(name = "sequence_number")
    private String sequenceNumber;

//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.MERGE)
    @JoinColumn(name = "berita_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Berita berita;

    public KeteranganBerita() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeteranganBerita() {
        return keteranganBerita;
    }

    public void setKeteranganBerita(String keteranganBerita) {
        this.keteranganBerita = keteranganBerita;
    }

    public String getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(String sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Berita getBerita() {
        return berita;
    }

    public void setBerita(Berita berita) {
        this.berita = berita;
    }

    @Override
    public String toString() {
        return "KeteranganBerita{" +
                "id='" + id + '\'' +
                ", keteranganBerita='" + keteranganBerita + '\'' +
                ", sequenceNumber='" + sequenceNumber + '\'' +
                '}';
    }
}
