package com.example.speedcar;

public class Car {
    private String type;
    private String engine;
    private String horse_power;
    private String torque;
    private String mph;
    private String top_speed;
    private String price;
    private String production;
    private int image_url;

    public Car( int image_url, String type, String engine, String horse_power, String torque, String mph, String top_speed, String price, String production) {
        this.type = type;
        this.engine = engine;
        this.horse_power = horse_power;
        this.torque = torque;
        this.mph = mph;
        this.top_speed = top_speed;
        this.price = price;
        this.production = production;
        this.image_url = image_url;
    }

    public Car (){}

    public String getTorque() {
        return torque;
    }

    public void setTorque(String torque) {
        this.torque = torque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getHorse_power() {
        return horse_power;
    }

    public void setHorse_power(String horse_power) {
        this.horse_power = horse_power;
    }

    public String getMph() {
        return mph;
    }

    public void setMph(String mph) {
        this.mph = mph;
    }

    public String getTop_speed() {
        return top_speed;
    }

    public void setTop_speed(String top_speed) {
        this.top_speed = top_speed;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public int getImage_url() {
        return image_url;
    }

    public void setImage_url(int image_url) {
        this.image_url = image_url;
    }
}
