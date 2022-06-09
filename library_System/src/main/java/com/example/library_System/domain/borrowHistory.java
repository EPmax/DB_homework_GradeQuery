package com.example.library_System.domain;

public class borrowHistory {

    int b_h_id;

    String reader_name;

    String account_number;

    String b_name;

    String borrow_date;

    int statu;

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public int getB_h_id() {
        return b_h_id;
    }

    public void setB_h_id(int b_h_id) {
        this.b_h_id = b_h_id;
    }

    public String getReader_name() {
        return reader_name;
    }

    public void setReader_name(String reader_name) {
        this.reader_name = reader_name;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    @Override
    public String toString() {
        return "borrowHistory{" +
                "b_h_id=" + b_h_id +
                ", reader_name='" + reader_name + '\'' +
                ", account_number='" + account_number + '\'' +
                ", b_name='" + b_name + '\'' +
                ", borrow_date='" + borrow_date + '\'' +
                ", statu=" + statu +
                '}';
    }
}
