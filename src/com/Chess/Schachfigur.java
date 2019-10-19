package com.Chess;


interface Schachfigur {

    String getName();
    String getColor();
    String getCaracter();
    public Boolean islegal(int x1, int y1, int x2, int y2);
}
