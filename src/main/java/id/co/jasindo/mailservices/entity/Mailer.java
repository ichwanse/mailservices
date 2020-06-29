package id.co.jasindo.mailservices.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_mailer")
public class Mailer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "no_dokumen")
    private String noDokumen;

    @Column(name = "sumber")
    private String sumber;

    @Column(name = "pengirim")
    private String pengirim;

    @Column(name = "penerima")
    private String penerima;

    @Column(name = "body")
    private String body;

    @Column(name = "subjek")
    private String subjek;

    @Column(name = "status")
    private Short status;

    @Column(name = "error_log")
    private String errorLog;

    @Column(name = "is_auto")
    private Short isAuto;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoDokumen() {
        return noDokumen;
    }

    public void setNoDokumen(String noDokumen) {
        this.noDokumen = noDokumen;
    }

    public String getSumber() {
        return sumber;
    }

    public void setSumber(String sumber) {
        this.sumber = sumber;
    }

    public String getSubjek() {
        return subjek;
    }

    public void setSubjek(String subjek) {
        this.subjek = subjek;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getPenerima() {
        return penerima;
    }

    public void setPenerima(String penerima) {
        this.penerima = penerima;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getErrorLog() {
        return errorLog;
    }

    public void setErrorLog(String errorLog) {
        this.errorLog = errorLog;
    }

    public Short getIsAuto() {
        return isAuto;
    }

    public void setIsAuto(Short isAuto) {
        this.isAuto = isAuto;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mailer mailer = (Mailer) o;
        return Objects.equals(id, mailer.id) &&
                Objects.equals(noDokumen, mailer.noDokumen) &&
                Objects.equals(sumber, mailer.sumber) &&
                Objects.equals(pengirim, mailer.pengirim) &&
                Objects.equals(penerima, mailer.penerima) &&
                Objects.equals(subjek, mailer.subjek) &&
                Objects.equals(body, mailer.body) &&
                Objects.equals(status, mailer.status) &&
                Objects.equals(errorLog, mailer.errorLog) &&
                Objects.equals(isAuto, mailer.isAuto) &&
                Objects.equals(createdDate, mailer.createdDate) &&
                Objects.equals(lastUpdate, mailer.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, noDokumen, sumber, pengirim, penerima,subjek, body, status, errorLog, isAuto, createdDate, lastUpdate);
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("id", id)
                .append("noDokumen", noDokumen)
                .append("sumber", sumber)
                .append("pengirim", pengirim)
                .append("penerima", penerima)
                .append("body", body)
                .append("subjek", subjek)
                .append("status", status)
                .append("errorLog", errorLog)
                .append("isAuto", isAuto)
                .append("createdDate", createdDate)
                .append("lastUpdate", lastUpdate)
                .toString();
    }
}
