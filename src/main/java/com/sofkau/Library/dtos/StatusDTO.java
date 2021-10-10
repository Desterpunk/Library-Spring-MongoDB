package com.sofkau.Library.dtos;

import java.time.LocalDate;

public class StatusDTO {
    private String Status;
    private Boolean avaible;
    private LocalDate date;

    public StatusDTO() {

    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Boolean getAvaible() {
        return avaible;
    }

    public void setAvaible(Boolean avaible) {
        this.avaible = avaible;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
