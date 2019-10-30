package com.Assignment3;

public class BishopAdapter implements Schachfigur {
    private ArchBishop bishop;

    public BishopAdapter(ArchBishop bishop){
        this.bishop = bishop;
    }

    @Override
    public String getName() {
        return this.bishop.getName();
    }

    @Override
    public Boolean notMoved() {
        return this.bishop.notMoved;
    }

    @Override
    public Boolean doublemoved() {
        return this.bishop.doublemoved();
    }

    @Override
    public void setMoved() {
        this.bishop.setMoved();
    }

    @Override
    public String getColor() {
        return this.bishop.getColor();
    }

    @Override
    public String getCharacter() {
        return this.bishop.getCharacter();
    }

    @Override
    public Boolean islegal(Board b, int x1, int y1, int x2, int y2, boolean muchosimportantes) {
        return this.bishop.islegal(b, x1, y1, x2, y2, muchosimportantes);
    }
}
