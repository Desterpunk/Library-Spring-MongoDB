package com.sofkau.Library.dtos;

import java.time.LocalDate;
import java.util.Objects;

public class ResourceDTO {
    private String id;
    private String name;
    private String type;
    private String area;
    private LocalDate date;
    private Boolean avaible;

    public ResourceDTO() {

    }

    public ResourceDTO(String name, String type, String area, LocalDate date, Boolean avaible) {
        this.name = name;
        this.type = type;
        this.area = area;
        this.date = date;
        this.avaible = avaible;
    }

    public ResourceDTO(String id, String name, String type, String area, LocalDate date, Boolean avaible) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.area = area;
        this.date = date;
        this.avaible = avaible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getAvaible() {
        return avaible;
    }

    public void setAvaible(Boolean avaible) {
        this.avaible = avaible;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceDTO that = (ResourceDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(area, that.area) && Objects.equals(date, that.date) && Objects.equals(avaible, that.avaible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, area, date, avaible);
    }
}
