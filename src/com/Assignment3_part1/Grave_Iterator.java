package com.Assignment3_part1;

import java.util.ArrayList;

public class Grave_Iterator implements Iterator {
    ArrayList<Schachfigur> grave;
    int position = 0;

    public Grave_Iterator(ArrayList grave){
        this.grave = grave;
    }

    public Object next(){
        Schachfigur current = grave.get(position);
        position++;
        return current;
    }

    public boolean hasNext(){
        if(position >= grave.size() || grave.get(position)==null){
            return false;
        } else {
            return true;
        }
    }

}
