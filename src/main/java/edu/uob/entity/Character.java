package edu.uob.entity;

import edu.uob.GameVisitor;

public class Character extends GameEntity{
    public Character(String name, String description) {
        super(name, description);
    }

    @Override
    public void accept(GameVisitor vistor) {
        vistor.interactWithEntity(this);
    }


}
