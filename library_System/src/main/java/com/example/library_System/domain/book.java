package com.example.library_System.domain;

import java.util.Date;

public class book {

    int b_id;//编号

    String b_name;//书名

    String b_author;//作者

    String call_nun;//索书号

    String classify;//分类

    String Time_to_enter_the_library;//入馆日期

    String press;//出版社

    String Publication_date;//出版时间

    int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setTime_to_enter_the_library(String time_to_enter_the_library) {
        Time_to_enter_the_library = time_to_enter_the_library;
    }

    public void setPublication_date(String publication_date) {
        Publication_date = publication_date;
    }

    public int getB_id() {
        return b_id;
    }

    public String getTime_to_enter_the_library() {
        return Time_to_enter_the_library;
    }

    public String getPublication_date() {
        return Publication_date;
    }

    @Override
    public String toString() {
        return "book{" +
                "b_id=" + b_id +
                ", b_name='" + b_name + '\'' +
                ", b_author='" + b_author + '\'' +
                ", call_nun='" + call_nun + '\'' +
                ", classify='" + classify + '\'' +
                ", Time_to_enter_the_library='" + Time_to_enter_the_library + '\'' +
                ", press='" + press + '\'' +
                ", Publication_date='" + Publication_date + '\'' +
                ", stock=" + stock +
                '}';
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_author() {
        return b_author;
    }

    public void setB_author(String b_author) {
        this.b_author = b_author;
    }

    public String getCall_nun() {
        return call_nun;
    }

    public void setCall_nun(String call_nun) {
        this.call_nun = call_nun;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

}
