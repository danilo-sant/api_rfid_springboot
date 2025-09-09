package com.desafio09.api_rfid;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.Instant;

@Entity
@Table(name = "leituras_rfid")
public class LeituraRfid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rfid_tag", nullable = false)
    private String rfidTag;

    @Column(name = "leitor_id", nullable = false)
    private String leitorId;

    @CreationTimestamp
    @Column(name = "data_hora_leitura")
    private Instant dataHoraLeitura;

    // Getters e Setters (necessários para o JPA)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRfidTag() { return rfidTag; }
    public void setRfidTag(String rfidTag) { this.rfidTag = rfidTag; }
    public String getLeitorId() { return leitorId; }
    public void setLeitorId(String leitorId) { this.leitorId = leitorId; }
    public Instant getDataHoraLeitura() { return dataHoraLeitura; }
    public void setDataHoraLeitura(Instant dataHoraLeitura) { this.dataHoraLeitura = dataHoraLeitura; }
}