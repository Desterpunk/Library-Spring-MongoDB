package com.sofkau.Library.dtos;

import java.time.LocalDate;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusDTO statusDTO = (StatusDTO) o;
        return Objects.equals(status, statusDTO.status) && Objects.equals(available, statusDTO.available) && Objects.equals(date, statusDTO.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, available, date);
    }
}
