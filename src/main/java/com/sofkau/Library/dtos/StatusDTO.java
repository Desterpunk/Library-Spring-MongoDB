package com.sofkau.Library.dtos;

import java.time.LocalDate;

public class StatusDTO {
    private String status;
    private Boolean available;
    private LocalDate date;

    public StatusDTO() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
