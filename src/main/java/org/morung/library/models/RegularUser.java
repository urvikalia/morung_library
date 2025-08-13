package org.morung.library.models;

public class RegularUser extends User {



    public RegularUser(String name, String address, String email, String phoneNumber, long age) {
        super(name, address, email, phoneNumber, age);
        set_MAX_LOAN_PERIOD(10);
    }
}
