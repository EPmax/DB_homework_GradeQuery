package com.example.library_System.domain;

public class reader {
    private int r_id; //读者id
    private String reader_name;//读者昵称
    private String account_number;//读者账号
    private String password;//读者账号密码
    private int admin;

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "reader{" +
                "r_id=" + r_id +
                ", reader_name='" + reader_name + '\'' +
                ", account_number='" + account_number + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }

}
