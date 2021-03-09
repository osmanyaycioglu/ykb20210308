package com.training.micro.rest;

import java.time.LocalDate;

public class Person {

    private String    name;
    private String    surname;
    private LocalDate birthDate;
    private EGender   gender;
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
