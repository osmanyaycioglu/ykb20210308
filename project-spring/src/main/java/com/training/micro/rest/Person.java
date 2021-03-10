package com.training.micro.rest;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.training.micro.validation.StartWith;

@XmlRootElement
public class Person {

    @NotEmpty(message = "name boş olamaz")
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    private String    name;
    @NotEmpty(message = "surname boş olamaz")
    @Size(min = 3, max = 25, message = "surname 3 ile 25 arasında olmalı")
    @StartWith("soy")
    private String    surname;
    @Past
    private LocalDate birthDate;
    @NotNull
    private EGender   gender;
    @Positive
    @Min(70)
    @Max(300)
    private Integer   weight;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(final LocalDate birthDateParam) {
        this.birthDate = birthDateParam;
    }

    public EGender getGender() {
        return this.gender;
    }

    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", birthDate="
               + this.birthDate
               + ", gender="
               + this.gender
               + ", weight="
               + this.weight
               + "]";
    }


}
