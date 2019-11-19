package com.Assignment4;

import com.Assignment4.Commands.Command;

public class Phone {
    Command slot;

    public Phone(){}

    public void setCommand(Command c){
        slot = c;
    }

    public void pressButton(){
        slot.execute();
    }

}
