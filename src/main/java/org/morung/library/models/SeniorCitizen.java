package org.morung.library.models;

public class SeniorCitizen extends User {

    public SeniorCitizen(String name, String address, String email, String phoneNumber, long age) {
        super(name, address, email, phoneNumber, age);
        set_MAX_LOAN_PERIOD(30);
    }
}
