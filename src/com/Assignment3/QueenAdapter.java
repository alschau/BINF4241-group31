package com.Assignment3;

public class QueenAdapter implements Schachfigur {
    private SuperQueen queen;

    public QueenAdapter(SuperQueen queen){
        this.queen = queen;
    }

    @Override
    public String getName() {
        return this.queen.getName();
    }

    @Override
    public Boolean notMoved() {
        return this.queen.notMoved;
    }

    @Override
    public Boolean doublemoved() {
        return this.queen.doublemoved();
    }

    @Override
    public void setMoved() {
        this.queen.setMoved();
    }

    @Override
    public String getColor() {
        return this.queen.getColor();
    }

    @Override
    public String getCharacter() {
        return this.queen.getCharacter();
    }

    @Override
    public Boolean islegal(Board b, int x1, int y1, int x2, int y2, boolean muchosimportantes) {
        return this.queen.islegal(b, x1, y1, x2, y2, muchosimportantes);
    }
}
