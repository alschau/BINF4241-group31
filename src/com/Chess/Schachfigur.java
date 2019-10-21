package com.Chess;


interface Schachfigur {

    String getName();
    Boolean notMoved();
    void setMoved();
    String getColor();
    String getCharacter();
    public Boolean islegal(Board b, int x1, int y1, int x2, int y2);
}