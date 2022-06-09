package com.company;

public class Contact {
    public String name;
    public String phone;
    public String address;
    public Contact next;
    public  Contact(String name, String phone, String address){
        this.name=name;
        this.phone=phone;
        this.address=address;
    }

}


