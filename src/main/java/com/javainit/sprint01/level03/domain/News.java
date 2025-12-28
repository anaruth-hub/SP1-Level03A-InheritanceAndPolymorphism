package com.javainit.sprint01.level03.domain;

public abstract class News {

    private  final String title;
    private String text;
    private int score;
    private double price;

    protected News(String title){
        this.title = title;
        this.text = "";
        this.score = 0;
        this.price = 0.0;

    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public int getScore() {
        return score;

    }

    public double getPrice() {
        return price;
    }
    public void setText(String text) {
        this.text = (text == null) ? "" : text;

    }

    public abstract double calculatePrice();

    public abstract int calculateScore();

    protected void setPrice(double price) {
        this.price = price;


    }

    protected void setScore(int score) {
        this.score = score;
    }
}
