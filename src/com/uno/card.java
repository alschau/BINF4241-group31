package com.uno;

public class card {
    private String color;
    private String sign;

    public card(String color, String sign){
        this.color = color;
        this.sign = sign;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
