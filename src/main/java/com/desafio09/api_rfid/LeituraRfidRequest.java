package com.desafio09.api_rfid;

public class LeituraRfidRequest {
    private String rfid_tag;
    private String leitor_id;

    // Getters e Setters
    public String getRfid_tag() { return rfid_tag; }
    public void setRfid_tag(String rfid_tag) { this.rfid_tag = rfid_tag; }
    public String getLeitor_id() { return leitor_id; }
    public void setLeitor_id(String leitor_id) { this.leitor_id = leitor_id; }
}
