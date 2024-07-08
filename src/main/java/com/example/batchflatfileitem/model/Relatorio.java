package com.example.batchflatfileitem.model;

public class Relatorio {

    private String dataHora;
    private String numero;
    private String status;
    private String cdStatus;
    private String evento;
    private String tentativas;

    public Relatorio() {
    }

    public Relatorio(String dataHora, String numero, String status, String cdStatus, String evento, String tentativas) {
        this.dataHora = dataHora;
        this.numero = numero;
        this.status = status;
        this.cdStatus = cdStatus;
        this.evento = evento;
        this.tentativas = tentativas;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCdStatus() {
        return cdStatus;
    }

    public void setCdStatus(String cdStatus) {
        this.cdStatus = cdStatus;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getTentativas() {
        return tentativas;
    }

    public void setTentativas(String tentativas) {
        this.tentativas = tentativas;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "dataHora='" + dataHora + '\'' +
                ", numero='" + numero + '\'' +
                ", status='" + status + '\'' +
                ", cdStatus='" + cdStatus + '\'' +
                ", evento='" + evento + '\'' +
                ", tentativas='" + tentativas + '\'' +
                '}';
    }
}
