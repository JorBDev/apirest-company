package com.apirest.company.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "company")
public class CompanyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_company;

    @NotBlank(message = "El codigo de la empresa es obligatorio")
    private String codigo_company;

    @NotBlank(message = "El nombre de la empresa es obligatorio")
    private String name_company;

    @NotBlank(message = "La descripción de la empresa es obligatoria")
    private String description_company;

    public CompanyModel() {
    }

    public CompanyModel(String codigo_company, String name_company, String description_company) {
        this.codigo_company = codigo_company;
        this.name_company = name_company;
        this.description_company = description_company;
    }

    public int getId_company() {
        return this.id_company;
    }

    public void setId_company(int id_company) {
        this.id_company = id_company;
    }

    public String getCodigo_company() {
        return this.codigo_company;
    }

    public void setCodigo_company(String codigo_company) {
        this.codigo_company = codigo_company;
    }

    public String getName_company() {
        return this.name_company;
    }

    public void setName_company(String name_company) {
        this.name_company = name_company;
    }

    public String getDescription_company() {
        return this.description_company;
    }

    public void setDescription_company(String description_company) {
        this.description_company = description_company;
    }

}
