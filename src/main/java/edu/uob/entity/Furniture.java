package edu.uob.entity;

import edu.uob.GameVisitor;

public class Furniture extends GameEntity{
    public Furniture(String name, String description) {
        super(name, description);
    }

    @Override
    public void accept(GameVisitor vistor) {
        vistor.interactWithEntity(this);
    }
}
