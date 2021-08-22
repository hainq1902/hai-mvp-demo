package com.mvp.product.repository.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "attribute")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Attribute implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "attribute", cascade = CascadeType.ALL)
    private List<AttributeValue> values;

    public Attribute() {
    }

    public Attribute(String name, String description) {
        this.name= name;
        this.description = description;
    }

    public void setValues(List<AttributeValue> values) {
        this.values = values;
    }

    public List<AttributeValue> getValues() {
        return values;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(id, attribute.id) && Objects.equals(name, attribute.name) && Objects.equals(description, attribute.description) && Objects.equals(values, attribute.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}