package com.Chess;


interface Schachfigur {

    String getName();
    String getColor();
    public Boolean islegal(int x1, int y1, int x2, int y2);

}
