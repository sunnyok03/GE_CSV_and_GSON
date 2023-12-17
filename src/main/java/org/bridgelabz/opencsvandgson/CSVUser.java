package org.bridgelabz.opencsvandgson;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {
    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email",required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phone;

    @CsvBindByName
    private String country;

    public CSVUser(String name, String email, String phone, String country) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.country =country;
    }

    @Override
    public String toString() {
        return "CSVUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhoneNo() {
        return this.phone;
    }

    public String getCountry() {
        return this.country;
    }
}
