package edu.uob.entity;

import edu.uob.GameVistor;

public class Furniture extends GameEntity{
    public Furniture(String name, String description) {
        super(name, description);
    }

    @Override
    public void accept(GameVistor vistor) {

    }
}
